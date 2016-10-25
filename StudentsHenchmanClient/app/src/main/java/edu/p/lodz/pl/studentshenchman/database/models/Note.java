package edu.p.lodz.pl.studentshenchman.database.models;

import android.provider.BaseColumns;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Michał on 2016-10-25.
 */

public class Note implements BaseColumns {
	private static final String TAG = Build.class.getName();

	public static final String TABLE_NAME = "note";

	public static final String _ID = "_id";
	public static final String CONTENT = "content";
	public static final String ADDED_DATE = "added_date";


	public static final Map<String, String> projectionColumns;

	static {
		projectionColumns = new HashMap<>();
		projectionColumns.put(_ID,
				_ID);
		projectionColumns.put(CONTENT,
				CONTENT);
		projectionColumns.put(ADDED_DATE,
				ADDED_DATE);
	}

	public static final String[] COLUMN_NAMES = {_ID, CONTENT, ADDED_DATE};


	public static final String[] COLUMN_TYPES = {
			"integer primary key autoincrement",    //BUILD_ID
			"text",                                  //CONTENT
			"long",                                  //ADDED_DATE
	};
}
