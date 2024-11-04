package com.example.moviemobileapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class UserDBHandler extends SQLiteOpenHelper {
    private static final String DB_NAME = "movie_app";

    // below int is our database version
    private static final int DB_VERSION = 1;

    // below variable is for our table name.
    private static final String TABLE_NAME_USER = "user";
    private static final String TABLE_NAME_ORDER = "orders";
    private static final String TABLE_NAME_SESSION = "session";
    // below variable is for our id column.
    private static final String ID_COL = "id";

    private static final String NAME_COL = "name";

    private static final String PASSWORD_COL = "password";


    //Movie
    private static final String USERID = "userId";
    private static final String TIME = "time";
    private static final String MOVIEID = "movieId";
    private static final String SCREENID = "screeningId";

    //Session

    private static final String PRICE = "price";

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
        String query = "CREATE TABLE " + TABLE_NAME_USER + " ("
                + ID_COL + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + NAME_COL + " TEXT,"
                + PASSWORD_COL + " TEXT)";

        // at last we are calling a exec sql
        // method to execute above sql query
        db.execSQL(query);

        query = "CREATE TABLE " + TABLE_NAME_ORDER + " ("
                + ID_COL + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + USERID + " INTEGER,"
                + TIME + " TEXT,"
                + MOVIEID + " INTEGER,"
                + SCREENID + " INTEGER)";

        // at last we are calling a exec sql
        // method to execute above sql query
        db.execSQL(query);

        query = "CREATE TABLE " + TABLE_NAME_SESSION + " ("
                + ID_COL + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + MOVIEID + " INTEGER,"
                + TIME + " TEXT,"
                + SCREENID + " INTEGER,"
                + PRICE + " TEXT)";
        db.execSQL(query);
    }



    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // this method is called to check if the table exists already.
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME_USER);
        onCreate(db);
    }
    //User methods
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
        db.insert(TABLE_NAME_USER, null, values);

        // at last we are closing our
        // database after adding database.
        db.close();
    }

    public User findUserByNameAndPassword(User user){
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_NAME_USER, new String[] { ID_COL,
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

        Cursor cursor = db.query(TABLE_NAME_USER, new String[] { ID_COL,
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

        Cursor cursor = db.query(TABLE_NAME_USER, new String[] { ID_COL,
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
    //Order methods
    public void addNewOrder(Order order) {

        // on below line we are creating a variable for
        // our sqlite database and calling writable method
        // as we are writing data in our database.
        SQLiteDatabase db = this.getWritableDatabase();

        // on below line we are creating a
        // variable for content values.
        ContentValues values = new ContentValues();

        // on below line we are passing all values
        // along with its key and value pair.
        values.put(USERID, order.getUserId());
        values.put(TIME, order.getTime());
        values.put(MOVIEID, order.getMovieId());
        values.put(SCREENID, order.getScreeningId());

        // after adding all values we are passing
        // content values to our table.
        db.insert(TABLE_NAME_ORDER, null, values);

        // at last we are closing our
        // database after adding database.
        db.close();
    }


    public Order findOrderByUserID(int id){
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_NAME_ORDER, new String[] { ID_COL,
                        USERID, TIME,MOVIEID,SCREENID }, USERID + "=?,",
                new String[] { String.valueOf(id)}, null, null, null, null);
        if (cursor != null){
            cursor.moveToFirst();
            Order order= new Order(Integer.parseInt(cursor.getString(0)),Integer.parseInt(cursor.getString(1)), cursor.getString(2), Integer.parseInt(cursor.getString(3)), Integer.parseInt(cursor.getString(4)));
            return order;
        }else {
            return null;
        }

        //User user = new User(Integer.parseInt(cursor.getString(0)),
        //      cursor.getString(1), cursor.getString(2));
        // return contact
    }

    public void addNewSession(String movie_id, String time,String screen_id,String price) {

        // on below line we are creating a variable for
        // our sqlite database and calling writable method
        // as we are writing data in our database.
        SQLiteDatabase db = this.getWritableDatabase();

        // on below line we are creating a
        // variable for content values.
        ContentValues values = new ContentValues();

        // on below line we are passing all values
        // along with its key and value pair.
        values.put(MOVIEID, movie_id);
        values.put(TIME, time);
        values.put(SCREENID, screen_id);
        values.put(PRICE, price);

        // after adding all values we are passing
        // content values to our table.
        db.insert(TABLE_NAME_SESSION, null, values);

        // at last we are closing our
        // database after adding database.
        db.close();
    }

}
