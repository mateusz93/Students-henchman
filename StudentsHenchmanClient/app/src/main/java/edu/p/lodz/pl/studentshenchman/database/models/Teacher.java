package edu.p.lodz.pl.studentshenchman.database.models;

import android.database.Cursor;
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

	public static Teacher fromCursor2Teacher(Cursor cursor) {
		Teacher teacher = new Teacher();

		if (cursor.moveToFirst()) {
			teacher.setId(cursor.getLong(cursor.getColumnIndexOrThrow(Teacher._ID)));
			teacher.setExternalId(cursor.getLong(cursor.getColumnIndexOrThrow(Teacher.EXTERNAL_TEACHER_ID)));
			teacher.setFirstName(cursor.getString(cursor.getColumnIndexOrThrow(Teacher.FIRST_NAME)));
			teacher.setLastName(cursor.getString(cursor.getColumnIndexOrThrow(Teacher.LAST_NAME)));
			teacher.setEmail(cursor.getString(cursor.getColumnIndexOrThrow(Teacher.EMAIL)));

		}

		return teacher;
	}

	private long id;
	private long externalId;
	private String firstName;
	private String lastName;
	private String email;

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

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
