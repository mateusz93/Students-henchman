package edu.p.lodz.pl.studentshenchman.database.models;

import android.provider.BaseColumns;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Michał on 2016-11-17.
 */

public class ErrorReport implements BaseColumns {
	private static final String TAG = ErrorReport.class.getName();

	public static final String TABLE_NAME = "error_report";

	public static final String _ID = "_id";
	public static final String CONTENT = "content";
	public static final String DATE = "date";

	public static final Map<String, String> projectionColumns;

	static {
		projectionColumns = new HashMap<>();
		projectionColumns.put(_ID,
				_ID);
		projectionColumns.put(CONTENT,
				CONTENT);
		projectionColumns.put(DATE,
				DATE);

	}

	public static final String[] COLUMN_NAMES = {_ID, CONTENT, DATE};


	public static final String[] COLUMN_TYPES = {
			"integer primary key autoincrement",    //BUILD_ID
			"text",                                 //CONTENT
			"long"                                  //DATE
	};
}
