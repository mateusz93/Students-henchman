package edu.p.lodz.pl.studentshenchman.database.models;

import android.database.Cursor;
import android.provider.BaseColumns;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Michał on 2016-10-25.
 */

public class Course implements BaseColumns {
	private static final String TAG = Teacher.class.getName();

	public static final String TABLE_NAME = "course";


	public static final String _ID = "_id";
	public static final String EXTERNAL_COURSE_ID = "external_course_id";
	public static final String NAME = "name";
	public static final String TIME = "time";
	public static final String DAY = "day";
	public static final String WEEKS = "weeks";
	public static final String EXTERNAL_DEAN_GROUP_ID = "external_dean_group_id";
	public static final String EXTERNAL_TEACHER_ID = "external_teacher_id";

	public static final Map<String, String> projectionColumns;

	static {
		projectionColumns = new HashMap<>();
		projectionColumns.put(_ID,
				_ID);
		projectionColumns.put(EXTERNAL_COURSE_ID,
				EXTERNAL_COURSE_ID);
		projectionColumns.put(NAME,
				NAME);
		projectionColumns.put(TIME,
				TIME);
		projectionColumns.put(DAY,
				DAY);
		projectionColumns.put(WEEKS,
				WEEKS);
		projectionColumns.put(EXTERNAL_DEAN_GROUP_ID,
				EXTERNAL_DEAN_GROUP_ID);
		projectionColumns.put(EXTERNAL_TEACHER_ID,
				EXTERNAL_TEACHER_ID);
	}

	public static final String[] COLUMN_NAMES = {_ID, EXTERNAL_COURSE_ID, NAME, TIME, DAY, WEEKS,
			EXTERNAL_DEAN_GROUP_ID, EXTERNAL_TEACHER_ID};


	public static final String[] COLUMN_TYPES = {
			"integer primary key autoincrement",    //ROOM_ID
			"long",                                 //EXTERNAL_COURSE_ID
			"text",                                 //NAME
			"text",                                 //TIME
			"text",                                 //DAY
			"text",                                 //WEEKS
			"long",                                 //EXTERNAL_DEAN_GROUP_ID
			"long",                                 //EXTERNAL_TEACHER_ID
	};

	public static Course fromCursor2Course(Cursor cursor) {
		Course course = new Course();

		if (cursor.moveToFirst()) {
			course.setId(cursor.getLong(cursor.getColumnIndexOrThrow(Course._ID)));
			course.setExternalId(cursor.getLong(cursor.getColumnIndexOrThrow(Course.EXTERNAL_COURSE_ID)));
			course.setName(cursor.getString(cursor.getColumnIndexOrThrow(Course.NAME)));
			course.setTime(cursor.getString(cursor.getColumnIndexOrThrow(Course.TIME)));
			course.setDay(cursor.getString(cursor.getColumnIndexOrThrow(Course.DAY)));
			course.setWeeks(cursor.getString(cursor.getColumnIndexOrThrow(Course.WEEKS)));
			course.setExternalDeanGroupId(cursor.getLong(cursor.getColumnIndexOrThrow(Course.EXTERNAL_DEAN_GROUP_ID)));
			course.setExternalTeacherId(cursor.getLong(cursor.getColumnIndexOrThrow(Course.EXTERNAL_TEACHER_ID)));
		}
		return course;
	}

	private long id;
	private long externalId;
	private String name;
	private String time;
	private String day;
	private String weeks;
	private long externalDeanGroupId;
	private long externalTeacherId;

	public Course() {

	}

	public Course(Cursor cursor) {
		if (cursor.moveToFirst()) {
			id = cursor.getLong(cursor.getColumnIndexOrThrow(Course._ID));
			externalId = cursor.getLong(cursor.getColumnIndexOrThrow(Course.EXTERNAL_COURSE_ID));
			name = cursor.getString(cursor.getColumnIndexOrThrow(Course.NAME));
			time = cursor.getString(cursor.getColumnIndexOrThrow(Course.TIME));
			day = cursor.getString(cursor.getColumnIndexOrThrow(Course.DAY));
			weeks = cursor.getString(cursor.getColumnIndexOrThrow(Course.WEEKS));
			externalDeanGroupId = cursor.getLong(cursor.getColumnIndexOrThrow(Course.EXTERNAL_DEAN_GROUP_ID));
			externalTeacherId = cursor.getLong(cursor.getColumnIndexOrThrow(Course.EXTERNAL_TEACHER_ID));
		}
	}

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

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public String getWeeks() {
		return weeks;
	}

	public void setWeeks(String weeks) {
		this.weeks = weeks;
	}

	public long getExternalDeanGroupId() {
		return externalDeanGroupId;
	}

	public void setExternalDeanGroupId(long externalDeanGroupId) {
		this.externalDeanGroupId = externalDeanGroupId;
	}

	public long getExternalTeacherId() {
		return externalTeacherId;
	}

	public void setExternalTeacherId(long externalTeacherId) {
		this.externalTeacherId = externalTeacherId;
	}

	@Override
	public String toString() {
		return "Course{" +
				"id=" + id +
				", externalId=" + externalId +
				", name='" + name + '\'' +
				", time='" + time + '\'' +
				", day='" + day + '\'' +
				", weeks='" + weeks + '\'' +
				", externalDeanGroupId=" + externalDeanGroupId +
				", externalTeacherId=" + externalTeacherId +
				'}';
	}
}
