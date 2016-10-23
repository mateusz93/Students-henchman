package edu.p.lodz.pl.studentshenchman.database.models;

import android.provider.BaseColumns;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Michał on 2016-10-23.
 */

public class Kind implements BaseColumns {
    private static final String TAG = Kind.class.getName();

    public static final String TABLE_NAME = "kind";


    public static final String _ID = "_id";
    public static final String EXTERNAL_KIND_ID = "external_kind_id";
    public static final String NAME = "name";


    public static final Map<String, String> projectionColumns;

    static {
        projectionColumns = new HashMap<>();
        projectionColumns.put(_ID,
                _ID);
        projectionColumns.put(EXTERNAL_KIND_ID,
                EXTERNAL_KIND_ID);
        projectionColumns.put(NAME,
                NAME);
    }

    public static final String[] COLUMN_NAMES = {_ID, EXTERNAL_KIND_ID, NAME};


    public static final String[] COLUMN_TYPES = {
            "integer primary key autoincrement",    //KIND_ID
            "integer",                              //EXTERNAL_KIND_ID
            "text",                                 //NAME
    };
}
