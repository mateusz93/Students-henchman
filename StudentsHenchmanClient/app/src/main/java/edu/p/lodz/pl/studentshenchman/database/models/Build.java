package edu.p.lodz.pl.studentshenchman.database.models;

import android.database.Cursor;
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

	public static Build fromCursor2Build(Cursor cursor) {
		Build build = new Build();

		if (cursor.moveToFirst()) {
			build.setId(cursor.getLong(cursor.getColumnIndexOrThrow(Build._ID)));
			build.setExternalId(cursor.getLong(cursor.getColumnIndexOrThrow(Build.EXTERNAL_BUILD_ID)));
			build.setName(cursor.getString(cursor.getColumnIndexOrThrow(Build.NAME)));
			build.setCode(cursor.getString(cursor.getColumnIndexOrThrow(Build.CODE)));
			build.setLatitude(cursor.getDouble(cursor.getColumnIndexOrThrow(Build.LATITUDE)));
			build.setLongitude(cursor.getDouble(cursor.getColumnIndexOrThrow(Build.LONGITUDE)));
		}

		return build;
	}

	private long id;
	private long externalId;
	private String name;
	private String code;
	private double latitude;
	private double longitude;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getExternalId() {
		return externalId;
	}

	public void setExternalId(long externalId) {
		this.externalId = externalId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
}
