package com.meitetsu.kosminci.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.meitetsu.kosminci.Cosmetic;
import com.meitetsu.kosminci.database.CosmeticDbSchema.CosmeticTable;

public class CosmeticBaseHelper extends SQLiteOpenHelper {
    private static final int VERSION = 1;
    private static final String DATABASE_NAME = "cosmeticBase.db";

    public CosmeticBaseHelper(Context context) {
        super (context, DATABASE_NAME, null, VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + CosmeticTable.NAME + "(" +
                "_id integer primary key autoincrement, " +
                CosmeticTable.Cols.UUID + ", " +
                CosmeticTable.Cols.COMPANY_NAME + ", " +
                CosmeticTable.Cols.COSMETIC_NAME + ", " +
                CosmeticTable.Cols.COSMETIC_TYPE + ", " +
                CosmeticTable.Cols.INCI +
                ")"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
