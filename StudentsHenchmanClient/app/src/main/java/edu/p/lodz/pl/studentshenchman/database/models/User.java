package edu.p.lodz.pl.studentshenchman.database.models;

import android.provider.BaseColumns;

/**
 * Created by Michał on 2016-10-12.
 */

public class User implements BaseColumns {
    private static final String TAG = User.class.getName();

    public static final String TABLE_NAME = "user";

    public static final String USER_ID = "external_user_id";
    public static final String EMAIL = "email";
    public static final String TOKEN = "token";
    public static final String PLAN_VERSION = "plan_version";


    public static final String[] COLUMN_NAMES = {_ID, USER_ID, EMAIL, TOKEN, PLAN_VERSION};

    public static final String[] COLUMN_TYPES = {
            "integer primary key autoincrement",    //USER_ID
            "integer",                              //EXTERNAL_USER_ID
            "text",                                 //EMAIL
            "text",                                 //TOKEN
            "text",                                 //PLAN_VERSION
    };
}
