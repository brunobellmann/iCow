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

        import java.util.ArrayList;
        import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static DatabaseHelper INSTANCE = null;
    public static final String DATABASE_NAME = "notiz";
    private static final int DATABASE_VERSION = 16;
    public static final String TABLE_NAME = "NotizCard";
    public static final String ID = "id";
    public static final String LAST_MODIFICATION = "last_modification";
    public static final String TITLE = "title";
    public static final String CONTENT = "content";
    public static final String LATITUDE = "latitude";
    public static final String LONGITUDE = "longitude";
    public static final String IMAGE = "image";
    /*public static final String KEY_ADDRESS = "address";*/


    public static DatabaseHelper getInstance(final Context context) {
        if (INSTANCE == null) {
            INSTANCE = new DatabaseHelper(context);
        }

        return INSTANCE;
    }

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


    public NotizCard createEntry(final NotizCard notizCard) {
        SQLiteDatabase database = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(LAST_MODIFICATION, 0);
        values.put(TITLE, notizCard.getTitle());

        values.put(CONTENT, notizCard.getContent());

        values.put(LATITUDE, 0);
        values.put(LONGITUDE, 0);

        long newID = database.insert(TABLE_NAME, null, values);

        database.close();

        return readEntry(newID);

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
    public List<NotizCard> readAllEntries() {
        List<NotizCard> todos = new ArrayList<>();
        SQLiteDatabase database = this.getReadableDatabase();

        Cursor cursor = database.rawQuery("SELECT * FROM " + TABLE_NAME, null);

        if (cursor.moveToFirst()) {
            do {
                NotizCard notizCard = readEntry(cursor.getLong(cursor.getColumnIndex(ID)));
                if (notizCard != null) {
                    todos.add(notizCard);
                }
            } while (cursor.moveToNext());
        }

        database.close();

        return todos;
    }

    public NotizCard readEntry(final long id) {
        SQLiteDatabase database = this.getReadableDatabase();
        Cursor cursor = database.query(TABLE_NAME, new String[]{ID, TITLE, CONTENT, LATITUDE, LONGITUDE, IMAGE}, ID + " = ?", new String[]{String.valueOf(id)}, null, null, null);

        NotizCard notizCard = null;

        if (cursor != null && cursor.getCount() > 0) {
            cursor.moveToFirst();
            notizCard = new NotizCard(cursor.getString(cursor.getColumnIndex(TITLE)));
            notizCard.setId(cursor.getLong(cursor.getColumnIndex(ID)));

            notizCard.setContent(cursor.getString(cursor.getColumnIndex(CONTENT)));
            notizCard.setContent(cursor.getString(cursor.getColumnIndex(LATITUDE)));
            notizCard.setContent(cursor.getString(cursor.getColumnIndex(LONGITUDE)));
            notizCard.setContent(cursor.getString(cursor.getColumnIndex(IMAGE)));

        }

        database.close();

        return notizCard;
    }
}

