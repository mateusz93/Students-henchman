package edu.p.lodz.pl.studentshenchman.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Michał on 2016-10-12.
 */
public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String TAG = DatabaseHelper.class.getName();

    private static DatabaseHelper databaseHelper;

    private static final String DATABASE_NAME = "StudentShenchman";
    private static final int DATABASE_VERSION = 0x01;

    private static final String DROP_TABLE = "drop table if exists ";
    private static final String CREATE_TABLE = "create table ";
    private static final String DROP_INDEX = "drop index if exists ";
    private static final String CREATE_INDEX = "create index ";


    private Map<String, String> tables = new HashMap<String, String>() {
        {

        }
    };

    private String createTableQuery(String tableName, String[] columnNames, String[] columnTypes) {
        if (!isSameSize(columnNames, columnTypes)) {
            Log.e(TAG, "ColumnNames and ColumnTypes must have the same size. Table:  " + tableName + ", " +
                    columnNames.length + " columnTypes length: " + columnTypes.length);
            return " ";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < columnNames.length; i++) {
            if (i != 0)
                sb.append(",");
            sb.append(columnNames[i]).append(" ").append(columnTypes[i]);
        }
        return sb.toString();
    }


    public static DatabaseHelper getInstance(Context context) {
        if (null == databaseHelper)
            databaseHelper = new DatabaseHelper(context);
        return databaseHelper;
    }

    private DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        for (Map.Entry<String, String> entry : tables.entrySet())
            createTable(db, entry.getKey(), entry.getValue());
    }

    private void createTable(SQLiteDatabase db, String tableName, String query) {
        StringBuilder createTableQuery = new StringBuilder();

        createTableQuery.append(CREATE_TABLE).append(tableName).append(" ( ").append(query).append(" );");
        Log.i(TAG, "Created table with query: " + createTableQuery.toString());
        db.execSQL(createTableQuery.toString());
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        for (Map.Entry<String, String> entry : tables.entrySet()) {
            db.execSQL(DROP_TABLE + entry.getKey());
        }
        onCreate(db);
    }


    private boolean isSameSize(String[] columnNames, String[] columnTypes) {
        if (null != columnNames && null != columnTypes && columnNames.length == columnTypes.length)
            return true;
        return false;
    }

}
