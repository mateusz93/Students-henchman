package edu.p.lodz.pl.studentshenchman.database.models;

import android.provider.BaseColumns;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Michał on 2016-10-23.
 */

public class Specialization implements BaseColumns {
    private static final String TAG = Field.class.getName();

    public static final String TABLE_NAME = "specialization";


    public static final String _ID = "_id";
    public static final String EXTERNAL_SPECIALIZATION_ID = "external_specialization_id";
    public static final String FIELD_ID = "field_id";
    public static final String NAME = "name";


    public static final Map<String, String> projectionColumns;

    static {
        projectionColumns = new HashMap<>();
        projectionColumns.put(_ID,
                _ID);
        projectionColumns.put(EXTERNAL_SPECIALIZATION_ID,
                EXTERNAL_SPECIALIZATION_ID);
        projectionColumns.put(FIELD_ID,
                FIELD_ID);
        projectionColumns.put(NAME,
                NAME);
    }

    public static final String[] COLUMN_NAMES = {_ID, EXTERNAL_SPECIALIZATION_ID, FIELD_ID, NAME};


    public static final String[] COLUMN_TYPES = {
            "integer primary key autoincrement",    //SPECIALIZATION_ID
            "integer",                              //EXTERNAL_SPECIALIZATION_ID
            "integer",                              //FIELD_ID
            "text",                                 //NAME
    };
}
