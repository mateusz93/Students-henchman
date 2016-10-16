package edu.p.lodz.pl.studentshenchman.database.models;

import android.provider.BaseColumns;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Michał on 2016-10-16.
 */

public class Department implements BaseColumns {
    private static final String TAG = Department.class.getName();

    public static final String TABLE_NAME = "department";


    public static final String _ID = "_id";
    public static final String EXTERNAL_DEPARTMENT_ID = "external_department_id";
    public static final String NAME = "name";
    public static final String CODE = "code";

    public static final Map<String, String> projectionColumns;

    static {
        projectionColumns = new HashMap<>();
        projectionColumns.put(_ID,
                _ID);
        projectionColumns.put(EXTERNAL_DEPARTMENT_ID,
                EXTERNAL_DEPARTMENT_ID);
        projectionColumns.put(NAME,
                NAME);
        projectionColumns.put(CODE,
                CODE);
    }

    public static final String[] COLUMN_NAMES = {_ID, EXTERNAL_DEPARTMENT_ID, NAME, CODE};


    public static final String[] COLUMN_TYPES = {
            "integer primary key autoincrement",    //DEPARTMENT_ID
            "integer",                              //EXTERNAL_DEPARTMENT_ID
            "text",                                 //NAME
            "text",                                 //CODE
    };

}
