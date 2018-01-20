package com.android.icow;

/**
 * Created by Maxet on 18.01.2018.
 */

        import android.content.ContentValues;
        import android.content.Context;
        import android.database.Cursor;
        import android.database.sqlite.SQLiteDatabase;
        import android.database.sqlite.SQLiteOpenHelper;
        import android.util.Log;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "notiz";
    private static final int DATABASE_VERSION = 14;
    public static final String TABLE_NAME = "NotizCard";
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
                ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                LAST_MODIFICATION + " TEXT, " +
                TITLE + " TEXT NOT NULL, " +
                CONTENT + " TEXT NOT NULL, " +
                LATITUDE + " TEXT, " +
                LONGITUDE + " TEXT, " +
                IMAGE + " TEXT)"
        );
        Log.d("TESTT","testDB");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        this.onCreate(db);
    }

    public void saveNewNotiz(NotizCard notiz) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(ID, notiz.getId());
        contentValues.put(LAST_MODIFICATION, notiz.getLast_modification());
        contentValues.put(TITLE, notiz.getTitle());
        contentValues.put(CONTENT, notiz.getContent());
        contentValues.put(LATITUDE, notiz.getLatitude());
        contentValues.put(LONGITUDE, notiz.getLongitude());
        contentValues.put(IMAGE, notiz.getImage());



        db.insert(TABLE_NAME, null, contentValues);
        db.close();


    }
    public Cursor getListContents(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor data = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);
        return data;
    }
}

