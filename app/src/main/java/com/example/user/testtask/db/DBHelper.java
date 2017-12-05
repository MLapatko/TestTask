package com.example.user.testtask.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by user on 03.12.2017.
 */

public class DBHelper extends SQLiteOpenHelper{

    private static final int DB_VERSION=1;
    private static final String DB_NAME="cinema";
    public static final String CREATE_QUERY="create table "+ DBScheme.TABLE_FILMS+"("
            +DBScheme.ID_FILM+" integer primary key autoincrement,"
            +DBScheme.NAME+" text,"
            +DBScheme.NAME_ENG+" text,"
            +DBScheme.IMAGE+" text,"
            +DBScheme.PREMIERE+" text,"
            +DBScheme.DESCRIPTION+" text);";

    public DBHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_QUERY);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+ DBScheme.TABLE_FILMS);
        onCreate(sqLiteDatabase);
    }
}
