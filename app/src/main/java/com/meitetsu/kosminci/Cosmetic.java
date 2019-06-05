package com.meitetsu.kosminci;

import java.util.UUID;

public class Cosmetic {
    private UUID mId;
    private String mCompanyName;
    private String mCosmeticName;
    private String mCosmeticType;
    private String mInci;


    public Cosmetic() {
        this(UUID.randomUUID());
    }

    public Cosmetic(UUID id) {
        mId = id;
    }

    public UUID getId() {
        return mId;
    }

    public String getCompanyName() {
        return mCompanyName;
    }

    public void setCompanyName(String companyName) {
        mCompanyName = companyName;
    }

    public String getCosmeticName() {
        return mCosmeticName;
    }

    public void setCosmeticName(String cosmeticName) {
        mCosmeticName = cosmeticName;
    }

    public String getCosmeticType() {
        return mCosmeticType;
    }

    public void setCosmeticType(String cosmeticType) {
        mCosmeticType = cosmeticType;
    }

    public String getInci() {
        return mInci;
    }

    public void setInci(String inci) {
        mInci = inci;
    }
}
