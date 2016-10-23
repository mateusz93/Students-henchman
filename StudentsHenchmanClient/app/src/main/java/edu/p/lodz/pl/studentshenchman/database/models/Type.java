package edu.p.lodz.pl.studentshenchman.database.models;

import android.provider.BaseColumns;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Michał on 2016-10-23.
 */

public class Type implements BaseColumns {
    private static final String TAG = Type.class.getName();

    public static final String TABLE_NAME = "type";


    public static final String _ID = "_id";
    public static final String EXTERNAL_TYPE_ID = "external_type_id";
    public static final String NAME = "name";


    public static final Map<String, String> projectionColumns;

    static {
        projectionColumns = new HashMap<>();
        projectionColumns.put(_ID,
                _ID);
        projectionColumns.put(EXTERNAL_TYPE_ID,
                EXTERNAL_TYPE_ID);
        projectionColumns.put(NAME,
                NAME);
    }

    public static final String[] COLUMN_NAMES = {_ID, EXTERNAL_TYPE_ID, NAME};


    public static final String[] COLUMN_TYPES = {
            "integer primary key autoincrement",    //TYPE_ID
            "integer",                              //EXTERNAL_TYPE_ID
            "text",                                 //NAME
    };
}
