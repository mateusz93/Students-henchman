package edu.p.lodz.pl.studentshenchman.database.models;

import android.provider.BaseColumns;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Michał on 2016-10-16.
 */

public class Room implements BaseColumns {
	private static final String TAG = Teacher.class.getName();

	public static final String TABLE_NAME = "teacher";


	public static final String _ID = "_id";
	public static final String EXTERNAL_ROOM_ID = "external_room_id";
	public static final String BUILD_ID = "build_id";
	public static final String NAME = "name";
	public static final String CODE = "code";

	public static final Map<String, String> projectionColumns;

	static {
		projectionColumns = new HashMap<>();
		projectionColumns.put(_ID,
				_ID);
		projectionColumns.put(EXTERNAL_ROOM_ID,
				EXTERNAL_ROOM_ID);
		projectionColumns.put(BUILD_ID,
				BUILD_ID);
		projectionColumns.put(NAME,
				NAME);
		projectionColumns.put(CODE,
				CODE);
	}

	public static final String[] COLUMN_NAMES = {_ID, EXTERNAL_ROOM_ID, BUILD_ID, NAME, CODE};


	public static final String[] COLUMN_TYPES = {
			"integer primary key autoincrement",    //ROOM_ID
			"integer",                              //EXTERNAL_ROOM_ID
			"integer",                              //BUILD_ID
			"text",                                 //NAME
			"text",                                 //CODE
	};
}
