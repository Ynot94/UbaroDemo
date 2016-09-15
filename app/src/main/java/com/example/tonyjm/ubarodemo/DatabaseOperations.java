package com.example.tonyjm.ubarodemo;

/**
 * Created by tonyjm on 9/3/16.
 */

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.Date;

public class DatabaseOperations extends SQLiteOpenHelper
{
    public static final int database_version = 1;
    public String CREATE_QUERY = "CREATE TABLE " + TableData.TableInfo.TABLE_NAME + "("+ TableData.TableInfo.USER_NAME + " TEXT," + TableData.TableInfo.USER_ID + " TEXT," + TableData.TableInfo.USER_PASSWORD + " TEXT,"+ TableData.TableInfo.USER_PHONE + " TEXT,"+ TableData.TableInfo.USER_BALANCE + " TEXT);";
    public String CREATE_QUERY2 = "CREATE TABLE" + TableData.TableTransactions.TABLE_NAME + "(" + TableData.TableTransactions.TRANSACTION_ID + " TEXT," + TableData.TableTransactions.TRANSACTION_SENDER_ID + " TEXT," + TableData.TableTransactions.TRANSACTION_RECEIVER_PHONE + " TEXT," + TableData.TableTransactions.TRANSACTION_AMOUNT + " TEXT," + TableData.TableTransactions.TRANSACTION_DATE + " TEXT);";
    public DatabaseOperations(Context context) {
        super(context, TableData.TableInfo.DATABASE_NAME, null, database_version);
        Log.d("Database Operations", "Data succesfully created");
    }

    @Override
    public void onCreate(SQLiteDatabase sdb) {
        sdb.execSQL(CREATE_QUERY);
        sdb.execSQL(CREATE_QUERY2);
        Log.d("Database Operations", "Tables Created");
    }

    @Override
    public void onUpgrade(SQLiteDatabase arg0, int intarg1, int arg2) {

    }

    public void putInformation(DatabaseOperations dop, String phone, String password)
    {
        SQLiteDatabase sqlDb = dop.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(TableData.TableInfo.USER_NAME, phone);
        cv.put(TableData.TableInfo.USER_PASSWORD, password);
        long k = sqlDb.insert(TableData.TableInfo.TABLE_NAME, null, cv);
        Log.d("Database Operations", "One row inserted");
    }

    public void CreateDummieUsers(DatabaseOperations dop)
    {
        SQLiteDatabase sqlDb = dop.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(TableData.TableInfo.USER_ID , "1");
        cv.put(TableData.TableInfo.USER_BALANCE , "500");
        cv.put(TableData.TableInfo.USER_NAME , "Tony");
        cv.put(TableData.TableInfo.USER_PASSWORD, "123");
        cv.put(TableData.TableInfo.USER_PHONE, "4777294500");
        long k = sqlDb.insert(TableData.TableInfo.TABLE_NAME, null, cv);

        ContentValues cv2 = new ContentValues();
        cv2.put(TableData.TableInfo.USER_ID , "2");
        cv2.put(TableData.TableInfo.USER_BALANCE , "500");
        cv2.put(TableData.TableInfo.USER_NAME , "Alejandro");
        cv2.put(TableData.TableInfo.USER_PASSWORD, "123");
        cv2.put(TableData.TableInfo.USER_PHONE, "4777294577");
        sqlDb.insert(TableData.TableInfo.TABLE_NAME, null, cv2);

        Log.d("Database Operations", "Dummie users inserted " + String.valueOf(k));
    }

    public Cursor getBalanceById(DatabaseOperations dbop, String user_id)
    {
        SQLiteDatabase SQ = dbop.getReadableDatabase();
        String[] tableColumns = new String[] {TableData.TableInfo.USER_BALANCE};
        String whereClause = TableData.TableInfo.USER_ID + " = ?";
        String[] whereArgs = new String[] {user_id};
        Cursor cr = SQ.query(TableData.TableInfo.TABLE_NAME, tableColumns, whereClause, whereArgs, null, null, null);
        Log.d("Database Operations", "There goes the balance:");
        return cr;
    }

    public void updateBalanceById(DatabaseOperations dbop, String user_id, String new_balance)
    {
        SQLiteDatabase sq = dbop.getWritableDatabase();
        String selection = TableData.TableInfo.USER_ID + " = ?";
        String args[] = {user_id};
        ContentValues values = new ContentValues();
        values.put(TableData.TableInfo.USER_BALANCE, new_balance);
        sq.update(TableData.TableInfo.TABLE_NAME, values, selection, args);
        Log.d("Database Operations", "Balance succesfully updated");
    }

    public void makeTransaction(DatabaseOperations dbop, String idSender, String phoneReceiver, String amount)
    {
        SQLiteDatabase sql = dbop.getWritableDatabase();
        ContentValues cv= new ContentValues();
        cv.put(TableData.TableTransactions.TRANSACTION_SENDER_ID, idSender);
        cv.put(TableData.TableTransactions.TRANSACTION_RECEIVER_PHONE, phoneReceiver);
        cv.put(TableData.TableTransactions.TRANSACTION_AMOUNT, amount);
        String now = new Date().toString();
        cv.put(TableData.TableTransactions.TRANSACTION_DATE, now);
    }
}




