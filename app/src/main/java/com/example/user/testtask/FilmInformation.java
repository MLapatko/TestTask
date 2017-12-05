package com.example.user.testtask;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.user.testtask.model.Film;
import com.squareup.picasso.Picasso;

/**
 * Created by user on 03.12.2017.
 */

public class FilmInformation extends AppCompatActivity {
    TextView name;
    TextView nameEng;
    TextView premiere;
    TextView description;
    ImageView image;
    Film film;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.film_information);
        name=(TextView)findViewById(R.id.name_film);
        nameEng=(TextView)findViewById(R.id.name_film_eng);
        premiere=(TextView)findViewById(R.id.premiere);
        description=(TextView)findViewById(R.id.description);
        image=(ImageView)findViewById(R.id.image_film);
        film=getIntent().getParcelableExtra("films");
        name.setText(film.getName());
        nameEng.setText(film.getName_eng());
        premiere.setText(film.getPremiere());
        description.setText(film.getDescription());
        Picasso.with(getBaseContext())
                .load(film.getImage())
                .error(R.drawable.default_picture)
                .into(image);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
