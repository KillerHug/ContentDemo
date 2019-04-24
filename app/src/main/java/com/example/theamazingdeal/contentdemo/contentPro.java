package com.example.theamazingdeal.contentdemo;
import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;
import java.util.HashMap;

public class contentPro extends ContentProvider {
    static final String PROVIDER_NAME = "com.example.theamazingdeal.contentdemo.contentPro";
    public static final String DB_Name = "DemoDB";
    public static final String Table_Name = "users";
    public static final int version = 1;
    static final String URL = "content://" + PROVIDER_NAME + "/users";
    static final Uri CONTENT_URI = Uri.parse(URL);
    static final String _ID = "_id";
    static final String NAME = "NAME";
    static final String PASS = "PASSWORD";
    private static HashMap<String, String> STUDENTS_PROJECTION_MAP;
    static final int USERS = 1;
    static final int USER_ID = 2;

    static final UriMatcher uriMatcher;
    static{
        uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
        uriMatcher.addURI(PROVIDER_NAME, "users", USERS);
        uriMatcher.addURI(PROVIDER_NAME, "users/#", USER_ID);
    }

    /**
     * Database specific constant declarations
     */
    private SQLiteDatabase db;
    public static class DBHelper extends SQLiteOpenHelper {
        public DBHelper(Context context) {
            super(context, DB_Name, null, version);
        }

        public void onCreate(SQLiteDatabase db) {
            db.execSQL("CREATE TABLE " + Table_Name + "(_id INTEGER PRIMARY KEY AUTOINCREMENT,NAME TEXT,PASSWORD TEXT)");
        }
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        }
    }
    /*  public long storeUser(Users u) {
        ContentValues cv = new ContentValues();
        cv.put("NAME", u.getName());
        cv.put("PASSWORD", u.getPass());
        return db.insertOrThrow(Table_Name, null, cv);
    }*/
    @Override
    public boolean onCreate() {
        return false;
    }
    @Override
    public Cursor query(Uri uri,  String[] projection,  String selection, String[] selectionArgs,  String sortOrder) {
        return null;
    }
    @Override
    public String getType( Uri uri) {
        return null;
    }


    @Override
    public Uri insert( Uri uri,  ContentValues values) {
        long row=db.insert(Table_Name,null,values);
        if(row>0)
        {
            Uri newUri=ContentUris.withAppendedId(CONTENT_URI,row);
            getContext().getContentResolver().notifyChange(newUri,null);
            return  newUri;
        }
        throw new SQLException("FAILED");
    }
    @Override
    public int delete(Uri uri, String selection,  String[] selectionArgs) {
        return 0;
    }

    @Override
    public int update( Uri uri,  ContentValues values,  String selection, String[] selectionArgs) {
        return 0;
    }
}