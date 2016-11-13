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
	public static final String CONTENT = "content";
	public static final String ADDED_DATE = "added_date";


	public static final Map<String, String> projectionColumns;

	static {
		projectionColumns = new HashMap<>();
		projectionColumns.put(_ID,
				_ID);
		projectionColumns.put(COURSE_ID,
				COURSE_ID);
		projectionColumns.put(CONTENT,
				CONTENT);
		projectionColumns.put(ADDED_DATE,
				ADDED_DATE);
	}

	public static final String[] COLUMN_NAMES = {_ID, COURSE_ID, CONTENT, ADDED_DATE};


	public static final String[] COLUMN_TYPES = {
			"integer primary key autoincrement",     //NOTE_ID
			"integer",                               //COURSE_ID
			"text",                                  //CONTENT
			"long",                                  //ADDED_DATE
	};


	private long id;
	private long courseId;
	private String content;
	private long addedDate;

	public Note() {
	}

	public Note(Cursor cursor) {
		id = cursor.getLong(cursor.getColumnIndexOrThrow(Note._ID));
		courseId = cursor.getLong(cursor.getColumnIndexOrThrow(Note.COURSE_ID));
		content = cursor.getString(cursor.getColumnIndexOrThrow(Note.CONTENT));
		addedDate = cursor.getLong(cursor.getColumnIndexOrThrow(Note.ADDED_DATE));
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

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public long getAddedDate() {
		return addedDate;
	}

	public void setAddedDate(long addedDate) {
		this.addedDate = addedDate;
	}

	@Override
	public String toString() {
		return "Note{" +
				"id=" + id +
				", courseId=" + courseId +
				", content='" + content + '\'' +
				", addedDate=" + addedDate +
				'}';
	}
}
