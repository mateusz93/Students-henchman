package edu.p.lodz.pl.studentshenchman.database.models;

import android.database.Cursor;
import android.provider.BaseColumns;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Michał on 2016-10-16.
 */

public class Room implements BaseColumns {
	private static final String TAG = Teacher.class.getName();

	public static final String TABLE_NAME = "room";


	public static final String _ID = "_id";
	public static final String EXTERNAL_ROOM_ID = "external_room_id";
	public static final String EXTERNAL_BUILD_ID = "external_build_id";
	public static final String NAME = "name";
	public static final String CODE = "code";

	public static final Map<String, String> projectionColumns;

	static {
		projectionColumns = new HashMap<>();
		projectionColumns.put(_ID,
				_ID);
		projectionColumns.put(EXTERNAL_ROOM_ID,
				EXTERNAL_ROOM_ID);
		projectionColumns.put(EXTERNAL_BUILD_ID,
				EXTERNAL_BUILD_ID);
		projectionColumns.put(NAME,
				NAME);
		projectionColumns.put(CODE,
				CODE);
	}

	public static final String[] COLUMN_NAMES = {_ID, EXTERNAL_ROOM_ID, EXTERNAL_BUILD_ID, NAME, CODE};


	public static final String[] COLUMN_TYPES = {
			"integer primary key autoincrement",    //ROOM_ID
			"integer",                              //EXTERNAL_ROOM_ID
			"integer",                              //EXTERNAL_BUILD_ID
			"text",                                 //NAME
			"text",                                 //CODE
	};

	public static Room fromCursor2Room(Cursor cursor) {
		Room room = new Room();

		if (cursor.moveToFirst()) {
			room.setId(cursor.getLong(cursor.getColumnIndexOrThrow(Room._ID)));
			room.setExternalId(cursor.getLong(cursor.getColumnIndexOrThrow(Room.EXTERNAL_ROOM_ID)));
			room.setExternalBuildId(cursor.getLong(cursor.getColumnIndexOrThrow(Room.EXTERNAL_BUILD_ID)));
			room.setName(cursor.getString(cursor.getColumnIndexOrThrow(Room.NAME)));
			room.setCode(cursor.getString(cursor.getColumnIndexOrThrow(Room.CODE)));
		}
		return room;
	}

	private long id;
	private long externalId;
	private long externalBuildId;
	private String name;
	private String code;

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

	public long getExternalBuildId() {
		return externalBuildId;
	}

	public void setExternalBuildId(long externalBuildId) {
		this.externalBuildId = externalBuildId;
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

	@Override
	public String toString() {
		return "Room{" +
				"id=" + id +
				", externalId=" + externalId +
				", externalBuildId=" + externalBuildId +
				", name='" + name + '\'' +
				", code='" + code + '\'' +
				'}';
	}
}
