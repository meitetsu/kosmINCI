package com.meitetsu.kosminci;

import android.database.Cursor;
import android.database.CursorWrapper;
import com.meitetsu.kosminci.database.CosmeticDbSchema.CosmeticTable;

import java.util.UUID;

public class CosmeticCursorWrapper extends CursorWrapper {

    public CosmeticCursorWrapper(Cursor cursor) {
        super(cursor);
    }

    public Cosmetic getCosmetic() {
        String uuidString = getString(getColumnIndex(CosmeticTable.Cols.UUID));
        String companyName = getString(getColumnIndex(CosmeticTable.Cols.COMPANY_NAME));
        String cosmeticName = getString(getColumnIndex(CosmeticTable.Cols.COSMETIC_NAME));
        String cosmeticType = getString(getColumnIndex(CosmeticTable.Cols.COSMETIC_TYPE));
        String inci = getString(getColumnIndex(CosmeticTable.Cols.INCI));

        Cosmetic c = new Cosmetic(UUID.fromString(uuidString));
        c.setCompanyName(companyName);
        c.setCosmeticName(cosmeticName);
        c.setCosmeticType(cosmeticType);
        c.setInci(inci);

        return c;
    }
}
