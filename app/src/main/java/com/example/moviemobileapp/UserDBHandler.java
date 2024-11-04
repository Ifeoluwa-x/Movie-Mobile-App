package com.example.moviemobileapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class UserDBHandler extends SQLiteOpenHelper {
    private static final String DB_NAME = "coursedb";

    // below int is our database version
    private static final int DB_VERSION = 1;

    // below variable is for our table name.
    private static final String TABLE_NAME = "user";
    // below variable is for our id column.
    private static final String ID_COL = "id";

    // below variable is for our course name column
    private static final String NAME_COL = "name";

    // below variable id for our course duration column.
    private static final String PASSWORD_COL = "password";

    // creating a constructor for our database handler.
    public UserDBHandler(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    // below method is for creating a database by running a sqlite query
    @Override
    public void onCreate(SQLiteDatabase db) {
        // on below line we are creating
        // an sqlite query and we are
        // setting our column names
        // along with their data types.
        String query = "CREATE TABLE " + TABLE_NAME + " ("
                + ID_COL + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + NAME_COL + " TEXT,"
                + PASSWORD_COL + " TEXT)";

        // at last we are calling a exec sql
        // method to execute above sql query
        db.execSQL(query);
    }

    // this method is use to add new course to our sqlite database.
    public void addNewUser(String username, String password) {

        // on below line we are creating a variable for
        // our sqlite database and calling writable method
        // as we are writing data in our database.
        SQLiteDatabase db = this.getWritableDatabase();

        // on below line we are creating a
        // variable for content values.
        ContentValues values = new ContentValues();

        // on below line we are passing all values
        // along with its key and value pair.
        values.put(NAME_COL, username);
        values.put(PASSWORD_COL, password);

        // after adding all values we are passing
        // content values to our table.
        db.insert(TABLE_NAME, null, values);

        // at last we are closing our
        // database after adding database.
        db.close();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // this method is called to check if the table exists already.
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
    public User findUserByNameAndPassword(User user){
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_NAME, new String[] { ID_COL,
                        NAME_COL, PASSWORD_COL }, NAME_COL + "=? and "+PASSWORD_COL+"=?,",
                new String[] { user.getUserNmae(),user.getPassword()}, null, null, null, null);
        if (cursor != null){
            cursor.moveToFirst();
            user = new User(Integer.parseInt(cursor.getString(0)),cursor.getString(1), cursor.getString(2));
            return user;
        }else {
            return null;
        }

        //User user = new User(Integer.parseInt(cursor.getString(0)),
        //      cursor.getString(1), cursor.getString(2));
        // return contact
    }

    public User findUserByID(int id){
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_NAME, new String[] { ID_COL,
                        NAME_COL, PASSWORD_COL }, ID_COL + "=?,",
                new String[] { String.valueOf(id)}, null, null, null, null);
        if (cursor != null){
            cursor.moveToFirst();
            User user = new User(Integer.parseInt(cursor.getString(0)),cursor.getString(1), cursor.getString(2));
            return user;
        }else {
            return null;
        }

        //User user = new User(Integer.parseInt(cursor.getString(0)),
        //      cursor.getString(1), cursor.getString(2));
        // return contact
    }

    public boolean findUserByName(String name){
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_NAME, new String[] { ID_COL,
                        NAME_COL, PASSWORD_COL }, NAME_COL + "=?",
                new String[] { name}, null, null, null, null);
        if (cursor != null){
//            cursor.moveToFirst();
            return true;
        }else {
            return false;
        }

        //User user = new User(Integer.parseInt(cursor.getString(0)),
          //      cursor.getString(1), cursor.getString(2));
        // return contact
    }
}
