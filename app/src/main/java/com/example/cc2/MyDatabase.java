package com.example.cc2;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class MyDatabase extends SQLiteOpenHelper {

    public static String DB_NAME="Entreprise.db";
    public static String TABLE_NAME="Entreprise";
    public static int COL1= Integer.parseInt("Id");
    public static String COL2="RaisonSoc";
    public static String COL3="Adresse";
    public static double COL4= Double.parseDouble("Capital");


    public MyDatabase(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }


}
