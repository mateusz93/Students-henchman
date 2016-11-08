package edu.p.lodz.pl.studentshenchman.database.models;

import android.provider.BaseColumns;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Michał on 2016-11-08.
 */

public class DeanGroup implements BaseColumns {
	private static final String TAG = DeanGroup.class.getName();

	public static final String TABLE_NAME = "dean_group";


	public static final String _ID = "_id";
	public static final String EXTERNAL_DEAN_GROUP_ID = "external_department_id";
	public static final String EXTERNAL_FIELD_ID = "external_field_id";
	public static final String NAME = "name";
	public static final String ABBREVIATION = "abbreviation";
	public static final String TERM = "term";
	public static final String DEGREE = "degree";

	public static final Map<String, String> projectionColumns;

	static {
		projectionColumns = new HashMap<>();
		projectionColumns.put(_ID,
				_ID);
		projectionColumns.put(EXTERNAL_DEAN_GROUP_ID,
				EXTERNAL_DEAN_GROUP_ID);
		projectionColumns.put(EXTERNAL_FIELD_ID,
				EXTERNAL_FIELD_ID);
		projectionColumns.put(NAME,
				NAME);
		projectionColumns.put(ABBREVIATION,
				ABBREVIATION);
		projectionColumns.put(TERM,
				TERM);
		projectionColumns.put(DEGREE,
				DEGREE);
	}


	public static final String[] COLUMN_NAMES = {_ID, EXTERNAL_DEAN_GROUP_ID, EXTERNAL_FIELD_ID, NAME, ABBREVIATION, TERM, DEGREE};


	public static final String[] COLUMN_TYPES = {
			"integer primary key autoincrement",    // DEAN_GROUP_ID
			"integer",                              // EXTERNAL_DEAN_GROUP_ID
			"integer",                              // EXTERNAL_FIELD_ID
			"text",                                 // NAME
			"text",                                 // ABBREVIATION
			"integer",                              // TERM
			"integer"                               // DEGREE
	};

	
}
