package com.android.icow;

/**
 * Created by Maxet on 18.01.2018.
 */

        import android.content.ContentValues;
        import android.content.Context;
        import android.database.Cursor;
        import android.database.sqlite.SQLiteDatabase;
        import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "notiz.db";
    private static final int DATABASE_VERSION = 1 ;
    public static final String TABLE_NAME = "NotizCard";
  /*public static final String COL1 = "ID";
    public static final String COL2 = "ITEM1";*/

    public static final String ID = "id";
    public static final String LAST_MODIFICATION = "last_modification";
    public static final String TITLE = "title";
    public static final String CONTENT = "content";
    public static final String LATITUDE = "latitude";
    public static final String LONGITUDE = "longitude";
    public static final String IMAGE = "image";
    /*public static final String KEY_ADDRESS = "address";*/


    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(" CREATE TABLE " + TABLE_NAME + " (" +
                ID + " TEXT NOT NULL, " +
                LAST_MODIFICATION + " TEXT NOT NULL, " +
                TITLE + " TEXT NOT NULL, " +
                CONTENT + " TEXT NOT NULL, " +
                LATITUDE + " TEXT NOT NULL, " +
                LONGITUDE + " TEXT NOT NULL, " +
                IMAGE + " TEXT NOT NULL);"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        this.onCreate(db);
    }

    public void saveNewNotiz(NotizCard notiz) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(ID, notiz.getTitle());
        contentValues.put(LAST_MODIFICATION, notiz.getLast_modification());
        contentValues.put(TITLE, notiz.getTitle());
        contentValues.put(CONTENT, notiz.getContent());
        contentValues.put(LATITUDE, notiz.getLatitude());
        contentValues.put(LONGITUDE, notiz.getLongitude());
        contentValues.put(IMAGE, notiz.getTitle());



        db.insert(TABLE_NAME, null, contentValues);
        db.close();


    }
    public Cursor getListContents(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor data = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);
        return data;
    }
}

