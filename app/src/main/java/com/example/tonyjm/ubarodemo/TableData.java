package com.example.tonyjm.ubarodemo;

import android.provider.BaseColumns;

/**
 * Created by tonyjm on 9/3/16.
 */
public class TableData {

    public TableData()
    {

    }

    public static abstract class TableInfo implements BaseColumns
    {
        public static final String USER_ID = "user_id";
        public static final String USER_NAME = "user_name";
        public static final String USER_PASSWORD = "user_password";
        public static final String USER_BALANCE = "user_balance";
        public static final String USER_PHONE = "user_phone";
        public static final String DATABASE_NAME = "ubaro_info";
        public static final String TABLE_NAME = "person";
    }

    public static abstract class TableTransactions implements BaseColumns
    {
        public static final String TRANSACTION_ID = "transaction_id";
        public static final String TRANSACTION_SENDER_ID = "transaction_sender_id";
        public static final String TRANSACTION_RECEIVER_PHONE = "transaction_receiver_phone";
        public static final String TRANSACTION_AMOUNT = "transaction_amount";
        public static final String TRANSACTION_DATE = "transaction_date";
        public static final String DATABASE_NAME = "ubaro_info";
        public static final String TABLE_NAME = "transaction";
    }
}
