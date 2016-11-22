package edu.p.lodz.pl.studentshenchman.database.models;

import android.provider.BaseColumns;

/**
 * Created by Michał on 2016-10-12.
 */

public class User implements BaseColumns {
	private static final String TAG = User.class.getName();

	public static final String TABLE_NAME = "user";

	public static final String _ID = "user_id";
	public static final String EMAIL = "email";
	public static final String EXTERNAL_DEPARTMENT_ID = "external_department_id";
	public static final String EXTERNAL_FIELD_ID = "external_field_id";
	public static final String EXTERNAL_DEAN_GROUPS_IDS = "external_dean_group_ids";
	public static final String TERM = "term";
	public static final String DEGREE = "degree";


	public static final String[] COLUMN_NAMES = {_ID, EMAIL, EXTERNAL_DEPARTMENT_ID, EXTERNAL_FIELD_ID, EXTERNAL_DEAN_GROUPS_IDS, TERM, DEGREE};

	public static final String[] COLUMN_TYPES = {
			"integer primary key autoincrement",    //ID
			"text",                                 //EMAIL
			"long",                                 //EXTERNAL_DEPARTMENT_ID
			"long",                                 //EXTERNAL_FIELD_ID
			"text",                                 //EXTERNAL_DEAN_GROUPS_IDS
			"integer",                              //TERM
			"integer",                              //DEGREE
	};


}
