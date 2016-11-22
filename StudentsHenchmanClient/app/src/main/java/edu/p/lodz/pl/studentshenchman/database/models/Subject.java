package edu.p.lodz.pl.studentshenchman.database.models;

import android.provider.BaseColumns;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Michał on 2016-10-25.
 */

public class Subject implements BaseColumns {
	private static final String TAG = Teacher.class.getName();

	public static final String TABLE_NAME = "subject";


	public static final String _ID = "_id";
	public static final String EXTERNAL_SUBJECT_ID = "external_subject_id";
	public static final String NAME = "name";
	public static final String CODE = "code";
	public static final String EXTERNAL_FIELD_ID = "external_field_id";
	public static final String EXTERNAL_SPECIALIZATION_ID = "external_specialization_id";
	public static final String EXTERNAL_SUBJECT_BLOCK_ID = "external_subject_block_id";

	public static final Map<String, String> projectionColumns;

	static {
		projectionColumns = new HashMap<>();
		projectionColumns.put(_ID,
				_ID);
		projectionColumns.put(EXTERNAL_SUBJECT_ID,
				EXTERNAL_SUBJECT_ID);
		projectionColumns.put(NAME,
				NAME);
		projectionColumns.put(CODE,
				CODE);
		projectionColumns.put(EXTERNAL_FIELD_ID,
				EXTERNAL_FIELD_ID);
		projectionColumns.put(EXTERNAL_SPECIALIZATION_ID,
				EXTERNAL_SPECIALIZATION_ID);
		projectionColumns.put(EXTERNAL_SUBJECT_BLOCK_ID,
				EXTERNAL_SUBJECT_BLOCK_ID);
	}

	public static final String[] COLUMN_NAMES = {_ID, EXTERNAL_SUBJECT_ID, NAME, CODE, EXTERNAL_FIELD_ID,
			EXTERNAL_SPECIALIZATION_ID, EXTERNAL_SUBJECT_BLOCK_ID};


	public static final String[] COLUMN_TYPES = {
			"integer primary key autoincrement",    //ROOM_ID
			"integer",                              //EXTERNAL_SUBJECT_ID
			"text",                                 //NAME
			"text",                                 //CODE
			"integer",                              //EXTERNAL_FIELD_ID
			"integer",                              //EXTERNAL_SPECIALIZATION_ID
			"integer",                              //EXTERNAL_SUBJECT_BLOCK_ID
	};
}
