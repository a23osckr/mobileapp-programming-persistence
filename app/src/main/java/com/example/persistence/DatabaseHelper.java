package com.example.persistence;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 2; // If this is incremented onUpgrade() will be executed
    private static final String DATABASE_NAME = "ChewingGum.db"; // The file name of our database

    DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // This method is executed only if there is not already a database in the file `ChewingGum.db`
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(DatabaseTables.SQL_CREATE_TABLE_CHEWINGGUM);
    }

    // This method is executed only if the database version has changed, e.g. from 1 to 2
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        sqLiteDatabase.execSQL(DatabaseTables.SQL_DELETE_TABLE_CHEWINGGUM);
        onCreate(sqLiteDatabase);
    }

    public long addChewingGum(String taste, int chewiness, String color) {
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(DatabaseTables.ChewingGum.COLUMN_NAME_TASTE, taste);
        values.put(DatabaseTables.ChewingGum.COLUMN_NAME_CHEWINESS, chewiness);
        values.put(DatabaseTables.ChewingGum.COLUMN_NAME_COLOR, color);
        //database.close();
        return database.insert(DatabaseTables.ChewingGum.TABLE_NAME, null, values);
    }

    public List<ChewingGum> getChewingGum() {
        SQLiteDatabase database = this.getWritableDatabase();
        Cursor cursor = database.query(DatabaseTables.ChewingGum.TABLE_NAME, null, null, null, null, null, null);
        List<ChewingGum> chewingGums = new ArrayList<>();
        while (cursor.moveToNext()) {
            ChewingGum chewingGum = new ChewingGum(
                    cursor.getLong(cursor.getColumnIndexOrThrow(DatabaseTables.ChewingGum.COLUMN_NAME_ID)),
                    cursor.getString(cursor.getColumnIndexOrThrow(DatabaseTables.ChewingGum.COLUMN_NAME_TASTE)),
                    cursor.getString(cursor.getColumnIndexOrThrow(DatabaseTables.ChewingGum.COLUMN_NAME_CHEWINESS)),
                    cursor.getString(cursor.getColumnIndexOrThrow(DatabaseTables.ChewingGum.COLUMN_NAME_COLOR))
            );
            chewingGums.add(chewingGum);
        }
        cursor.close();
        return chewingGums;
    }
}
