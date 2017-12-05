package com.example.user.testtask;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.user.testtask.db.DBHelper;
import com.example.user.testtask.db.DBScheme;
import com.example.user.testtask.model.Film;
import com.example.user.testtask.model.FilmRequestModel;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private DBHelper dbHelper;
    private SQLiteDatabase db;
    private RecyclerView recyclerViewFilms;
    private RecyclerView.LayoutManager layoutManager;
    private List<Film> films;
    final static String POSITION="POSITION";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerViewFilms=(RecyclerView) findViewById(R.id.films_recycler_view);
        layoutManager=new LinearLayoutManager(this);
        recyclerViewFilms.setLayoutManager(layoutManager);
        if(!isInternet()){
            showFilmsFromDB();
        }
        else {
            App.getFilmsApi().getFilms().enqueue(new Callback<FilmRequestModel>() {
                @Override
                public void onResponse(Call<FilmRequestModel> call,
                                       Response<FilmRequestModel> response) {
                    insertFilmsIntoDB(response.body());
                }
                @Override
                public void onFailure(Call<FilmRequestModel> call, Throwable t) {
                    showFilmsFromDB();
                }
            });
        }
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        if (savedInstanceState!=null)
            layoutManager.scrollToPosition(savedInstanceState.getInt(POSITION));
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        if (layoutManager!=null && layoutManager instanceof LinearLayoutManager)
        outState.putInt(POSITION,((LinearLayoutManager)layoutManager).findFirstVisibleItemPosition());
        super.onSaveInstanceState(outState);
    }

    private void insertFilmsIntoDB(FilmRequestModel request) {

        dbHelper=new DBHelper(this);
        db=dbHelper.getWritableDatabase();
        db.delete(DBScheme.TABLE_FILMS,null,null);
        films=request.getList();
        for (int i = 0; i <films.size(); i++) {
            ContentValues values = new ContentValues();
            values.put(DBScheme.NAME, films.get(i).getName());
            values.put(DBScheme.NAME_ENG, films.get(i).getName_eng());
            values.put(DBScheme.IMAGE, films.get(i).getImage());
            values.put(DBScheme.PREMIERE, films.get(i).getPremiere());
            values.put(DBScheme.DESCRIPTION, films.get(i).getDescription());
            db.insert(DBScheme.TABLE_FILMS,null,values);
        }
        recyclerViewFilms.setAdapter(new FilmsAdapter(films,this));
    }

    private void showFilmsFromDB() {
        films=new ArrayList<>();
        String colums[] = new String[] {
                DBScheme.ID_FILM,
                DBScheme.NAME,
                DBScheme.NAME_ENG,
                DBScheme.IMAGE,
                DBScheme.PREMIERE,
                DBScheme.DESCRIPTION
        };

        dbHelper=new DBHelper(this);
        db=dbHelper.getReadableDatabase();
        Cursor cursor = db.query(DBScheme.TABLE_FILMS,colums,null,null, null, null, null);

        if (!cursor.isAfterLast()) {
            cursor.moveToFirst();
            while(!cursor.isAfterLast()) {

                Film film = new Film();
                film.setName(cursor.getString(cursor.getColumnIndex(DBScheme.NAME)));
                film.setName_eng(cursor.getString(cursor.getColumnIndex(DBScheme.NAME_ENG)));
                film.setImage(cursor.getString(cursor.getColumnIndex(DBScheme.IMAGE)));
                film.setPremiere(cursor.getString(cursor.getColumnIndex(DBScheme.PREMIERE)));
                film.setDescription(cursor.getString(cursor.getColumnIndex(DBScheme.DESCRIPTION)));

                films.add(film);
                cursor.moveToNext();
            }
        }

        cursor.close();
        recyclerViewFilms.setAdapter(new FilmsAdapter(films,this));
    }
    private boolean isInternet() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(getBaseContext()
                .CONNECTIVITY_SERVICE);
        return cm.getActiveNetworkInfo() != null;
    }
}
