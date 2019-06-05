package com.meitetsu.kosminci;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.meitetsu.kosminci.database.CosmeticBaseHelper;
import com.meitetsu.kosminci.database.CosmeticDbSchema.CosmeticTable;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class CosmeticLab {
    private static CosmeticLab sCosmeticLab;
    private List<Cosmetic> mCosmetics;

    private Context mContext;
    private SQLiteDatabase mDatabase;

    public static CosmeticLab get(Context context) {
        if (sCosmeticLab == null) {
            sCosmeticLab = new CosmeticLab(context);
        }
        return sCosmeticLab;
    }

    private CosmeticLab(Context context) {
//        mContext = context.getApplicationContext();
//        mDatabase = new CosmeticBaseHelper(mContext).getWritableDatabase();
        mCosmetics = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            Cosmetic cosmetic = new Cosmetic();
            cosmetic.setCompanyName("Firma #" + i);
            cosmetic.setCosmeticName("Kosmetyk #" + i);
            cosmetic.setCosmeticType("Rodzaj #" + i);
            cosmetic.setInci("Przykładowy skład INCI #" + i);
            mCosmetics.add(cosmetic);
        }
    }

    public void addCosmetic(Cosmetic c) {
        ContentValues values = getContentValues(c);
        mDatabase.insert(CosmeticTable.NAME, null, values);
       // mCosmetics.add(c);
    }

    public List<Cosmetic> getCosmetics() {
        List<Cosmetic> cosmetics = new ArrayList<>();

//        CosmeticCursorWrapper cursor = queryCosmetics(null, null);
//
//        try {
//            cursor.moveToFirst();
//            while (!cursor.isAfterLast()) {
//                cosmetics.add(cursor.getCosmetic());
//                cursor.moveToNext();
//            }
//        } finally {
//            cursor.close();
//        }
//        return cosmetics;
        return mCosmetics;
        //return new ArrayList<>();
    }

    public Cosmetic getCosmetic(UUID id) {
//        CosmeticCursorWrapper cursor = queryCosmetics(
//                CosmeticTable.Cols.UUID + " = ?",
//                new String[] { id.toString() }
//        );
//        try {
//            if (cursor.getCount() == 0) {
//                return null;
//            }
//            cursor.moveToFirst();
//            return cursor.getCosmetic();
//        } finally {
//            cursor.close();
//        }

        for (Cosmetic cosmetic : mCosmetics) {
            if (cosmetic.getId().equals(id)) {
                return cosmetic;
            }
        }
        return null;
    }

    public void updateCosmetic(Cosmetic c) {
        String uuidString = c.getId().toString();
        ContentValues values = getContentValues(c);

        mDatabase.update(CosmeticTable.NAME, values,
                CosmeticTable.Cols.UUID + " = ?",
                new String[] { uuidString });
    }

    private CosmeticCursorWrapper queryCosmetics(String whereClause, String[] whereArgs) {
        Cursor cursor = mDatabase.query(
                CosmeticTable.NAME,
                null,
                whereClause,
                whereArgs,
                null,
                null,
                null
        );

        return new CosmeticCursorWrapper(cursor);
    }

    private static ContentValues getContentValues(Cosmetic cosmetic) {
        ContentValues values = new ContentValues();
        values.put(CosmeticTable.Cols.UUID, cosmetic.getId().toString());
        values.put(CosmeticTable.Cols.COMPANY_NAME, cosmetic.getCompanyName());
        values.put(CosmeticTable.Cols.COSMETIC_NAME, cosmetic.getCosmeticName());
        values.put(CosmeticTable.Cols.COSMETIC_TYPE, cosmetic.getCosmeticType());
        values.put(CosmeticTable.Cols.INCI, cosmetic.getInci());

        return values;
    }
}
