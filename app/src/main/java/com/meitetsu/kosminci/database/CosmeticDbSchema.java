package com.meitetsu.kosminci.database;

public class CosmeticDbSchema {
    public static final class CosmeticTable {
        public static final String NAME = "cosmetics";

        public static final class Cols {
            public static final String UUID = "uuid";
            public static final String COMPANY_NAME = "company_name";
            public static final String COSMETIC_NAME = "cosmetic_name";
            public static final String COSMETIC_TYPE = "cosmetic_type";
            public static final String INCI = "inci";
        }
    }
}
