package edu.p.lodz.pl.studentshenchman.database.models;

import android.provider.BaseColumns;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Michał on 2016-10-16.
 */

public class Build implements BaseColumns {
    private static final String TAG = Build.class.getName();

    public static final String TABLE_NAME = "build";

    public static final String _ID = "_id";
    public static final String EXTERNAL_BUILD_ID = "external_build_id";
    public static final String NAME = "name";
    public static final String CODE = "code";
    public static final String LATITUDE = "latitude";
    public static final String LONGITUDE = "longitude";

    public static final Map<String, String> projectionColumns;

    static {
        projectionColumns = new HashMap<>();
        projectionColumns.put(_ID,
                _ID);
        projectionColumns.put(EXTERNAL_BUILD_ID,
                EXTERNAL_BUILD_ID);
        projectionColumns.put(NAME,
                NAME);
        projectionColumns.put(CODE,
                CODE);
        projectionColumns.put(LATITUDE,
                LATITUDE);
        projectionColumns.put(LONGITUDE,
                LONGITUDE);
    }

    public static final String[] COLUMN_NAMES = {_ID, EXTERNAL_BUILD_ID, NAME, CODE, LATITUDE, LONGITUDE};


    public static final String[] COLUMN_TYPES = {
            "integer primary key autoincrement",    //BUILD_ID
            "integer",                              //EXTERNAL_BUILD_ID
            "text",                                 //NAME
            "text",                                 //CODE
            "real",                                 //LATITUDE
            "real"                                  //LONGITUDE
    };
}
