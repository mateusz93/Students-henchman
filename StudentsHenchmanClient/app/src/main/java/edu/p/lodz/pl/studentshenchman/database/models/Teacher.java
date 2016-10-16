package edu.p.lodz.pl.studentshenchman.database.models;

import android.provider.BaseColumns;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Michał on 2016-10-16.
 */

public class Teacher implements BaseColumns {
    private static final String TAG = Teacher.class.getName();

    public static final String TABLE_NAME = "teacher";


    public static final String _ID = "_id";
    public static final String EXTERNAL_TEACHER_ID = "external_teacher_id";
    public static final String FIRST_NAME = "first_name";
    public static final String LAST_NAME = "last_name";
    public static final String EMAIL = "email";

    public static final Map<String, String> projectionColumns;

    static {
        projectionColumns = new HashMap<>();
        projectionColumns.put(_ID,
                _ID);
        projectionColumns.put(EXTERNAL_TEACHER_ID,
                EXTERNAL_TEACHER_ID);
        projectionColumns.put(FIRST_NAME,
                FIRST_NAME);
        projectionColumns.put(LAST_NAME,
                LAST_NAME);
        projectionColumns.put(EMAIL,
                EMAIL);
    }

    public static final String[] COLUMN_NAMES = {_ID, EXTERNAL_TEACHER_ID, FIRST_NAME, LAST_NAME, EMAIL};


    public static final String[] COLUMN_TYPES = {
            "integer primary key autoincrement",    //TEACHER_ID
            "integer",                              //EXTERNAL_TEACHER_ID
            "text",                                 //FIRST_NAME
            "text",                                 //LAST_NAME
            "text",                                 //EMAIL
    };
}
