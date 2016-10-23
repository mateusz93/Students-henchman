package edu.p.lodz.pl.studentshenchman.database.models;

import android.provider.BaseColumns;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Michał on 2016-10-23.
 */

public class Field implements BaseColumns {
    private static final String TAG = Field.class.getName();

    public static final String TABLE_NAME = "field";


    public static final String _ID = "_id";
    public static final String EXTERNAL_DEPARTMENT_ID = "external_field_id";
    public static final String DEPARTMENT_ID = "department_id";
    public static final String NAME = "name";


    public static final Map<String, String> projectionColumns;

    static {
        projectionColumns = new HashMap<>();
        projectionColumns.put(_ID,
                _ID);
        projectionColumns.put(EXTERNAL_DEPARTMENT_ID,
                EXTERNAL_DEPARTMENT_ID);
        projectionColumns.put(DEPARTMENT_ID,
                DEPARTMENT_ID);
        projectionColumns.put(NAME,
                NAME);
    }

    public static final String[] COLUMN_NAMES = {_ID, EXTERNAL_DEPARTMENT_ID, DEPARTMENT_ID, NAME};


    public static final String[] COLUMN_TYPES = {
            "integer primary key autoincrement",    //FIELD_ID
            "integer",                              //EXTERNAL_FIELD_ID
            "integer",                              //DEPARTMENT_ID
            "text",                                 //NAME
    };

}
