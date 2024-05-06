package com.example.persistence;

class DatabaseTables {

    static class ChewingGum {

        static final String TABLE_NAME = "chewingGums";
        static final String COLUMN_NAME_ID = "id";
        static final String COLUMN_NAME_TASTE = "taste";
        static final String COLUMN_NAME_CHEWINESS = "chewiness";

    }

    static final String SQL_CREATE_TABLE_CHEWINGUM =
            "CREATE TABLE " + ChewingGum.TABLE_NAME + " (" +
                    ChewingGum.COLUMN_NAME_ID + " INTEGER PRIMARY KEY," +
                    ChewingGum.COLUMN_NAME_TASTE + " TEXT," +
                    ChewingGum.COLUMN_NAME_CHEWINESS + " INT)";

    static final String SQL_DELETE_TABLE_CHEWINGGUM =
            "DROP TABLE IF EXISTS " + ChewingGum.TABLE_NAME;

}