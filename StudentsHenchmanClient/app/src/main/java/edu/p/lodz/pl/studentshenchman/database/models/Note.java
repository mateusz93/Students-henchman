package edu.p.lodz.pl.studentshenchman.database.models;

import android.database.Cursor;
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
	public static final String COURSE_ID = "course_id";
	public static final String EXTERNAL_COURSE_ID = "external_course_id";
	public static final String CONTENT = "content";
	public static final String ACTIVATION_DATE = "activation_date";


	public static final Map<String, String> projectionColumns;

	static {
		projectionColumns = new HashMap<>();
		projectionColumns.put(_ID,
				_ID);
		projectionColumns.put(COURSE_ID,
				COURSE_ID);
		projectionColumns.put(EXTERNAL_COURSE_ID,
				EXTERNAL_COURSE_ID);
		projectionColumns.put(CONTENT,
				CONTENT);
		projectionColumns.put(ACTIVATION_DATE,
				ACTIVATION_DATE);
	}

	public static final String[] COLUMN_NAMES = {_ID, COURSE_ID, EXTERNAL_COURSE_ID, CONTENT, ACTIVATION_DATE};


	public static final String[] COLUMN_TYPES = {
			"integer primary key autoincrement",     //NOTE_ID
			"integer",                               //COURSE_ID
			"integer",                               //EXTERNAL_COURSE_ID
			"text",                                  //CONTENT
			"long",                                  //ACTIVATION_DATE
	};


	private long id;
	private long courseId;
	private long externalCourseId;
	private String content;
	private long activationDate;

	public Note() {
	}

	public Note(Cursor cursor) {
		id = cursor.getLong(cursor.getColumnIndexOrThrow(_ID));
		courseId = cursor.getLong(cursor.getColumnIndexOrThrow(COURSE_ID));
		externalCourseId = cursor.getLong(cursor.getColumnIndexOrThrow(EXTERNAL_COURSE_ID));
		content = cursor.getString(cursor.getColumnIndexOrThrow(CONTENT));
		activationDate = cursor.getLong(cursor.getColumnIndexOrThrow(ACTIVATION_DATE));
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getCourseId() {
		return courseId;
	}

	public void setCourseId(long courseId) {
		this.courseId = courseId;
	}

	public long getExternalCourseId() {
		return externalCourseId;
	}

	public void setExternalCourseId(long externalCourseId) {
		this.externalCourseId = externalCourseId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public long getActivationDate() {
		return activationDate;
	}

	public void setActivationDate(long activationDate) {
		this.activationDate = activationDate;
	}

	@Override
	public String toString() {
		return "Note{" +
				"id=" + id +
				", courseId=" + courseId +
				", externalCourseId=" + externalCourseId +
				", content='" + content + '\'' +
				", activationDate=" + activationDate +
				'}';
	}
}
