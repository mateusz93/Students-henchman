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
	public static final String QUANTITY = "quantity";
	public static final String CYCLE = "cycle";
	public static final String FIRST_WEEK = "first_week";
	public static final String START_TIME = "start_time";
	public static final String END_TIME = "end_time";
	public static final String EXTERNAL_ROOM_ID = "external_room_id";
	public static final String EXTERNAL_TEACHER_ID = "external_teacher_id";
	public static final String COURSE_TYPE = "course_type";

	public static final Map<String, String> projectionColumns;

	static {
		projectionColumns = new HashMap<>();
		projectionColumns.put(_ID,
				_ID);
		projectionColumns.put(EXTERNAL_COURSE_ID,
				EXTERNAL_COURSE_ID);
		projectionColumns.put(NAME,
				NAME);
		projectionColumns.put(QUANTITY,
				QUANTITY);
		projectionColumns.put(CYCLE,
				CYCLE);
		projectionColumns.put(FIRST_WEEK,
				FIRST_WEEK);
		projectionColumns.put(START_TIME,
				START_TIME);
		projectionColumns.put(END_TIME,
				END_TIME);
		projectionColumns.put(EXTERNAL_ROOM_ID,
				EXTERNAL_ROOM_ID);
		projectionColumns.put(EXTERNAL_TEACHER_ID,
				EXTERNAL_TEACHER_ID);
		projectionColumns.put(COURSE_TYPE,
				COURSE_TYPE);
	}

	public static final String[] COLUMN_NAMES = {_ID, EXTERNAL_COURSE_ID, NAME, QUANTITY, CYCLE, FIRST_WEEK,
			START_TIME, END_TIME, EXTERNAL_ROOM_ID, EXTERNAL_TEACHER_ID, COURSE_TYPE};


	public static final String[] COLUMN_TYPES = {
			"integer primary key autoincrement",    //ROOM_ID
			"integer",                              //EXTERNAL_COURSE_ID
			"text",                                 //NAME
			"integer",                              //QUANTITY
			"integer",                              //CYCLE
			"integer",                              //FIRST_WEEK
			"long",                                 //START_TIME
			"long",                                 //END_TIME
			"integer",                              //EXTERNAL_ROOM_ID
			"integer",                              //EXTERNAL_TEACHER_ID
			"text",                                 //COURSE_TYPE
	};

	public static Course fromCursor2Course(Cursor cursor) {
		Course course = new Course();

		if (cursor.moveToFirst()) {
			course.setId(cursor.getLong(cursor.getColumnIndexOrThrow(Course._ID)));
			course.setExternalId(cursor.getLong(cursor.getColumnIndexOrThrow(Course.EXTERNAL_COURSE_ID)));
			course.setName(cursor.getString(cursor.getColumnIndexOrThrow(Course.NAME)));
			course.setQuantity(cursor.getLong(cursor.getColumnIndexOrThrow(Course.QUANTITY)));
			course.setCycle(cursor.getLong(cursor.getColumnIndexOrThrow(Course.CYCLE)));
			course.setFirstWeek(cursor.getLong(cursor.getColumnIndexOrThrow(Course.FIRST_WEEK)));
			course.setStartTime(cursor.getLong(cursor.getColumnIndexOrThrow(Course.START_TIME)));
			course.setEndTime(cursor.getLong(cursor.getColumnIndexOrThrow(Course.END_TIME)));
			course.setExternalRoomId(cursor.getLong(cursor.getColumnIndexOrThrow(Course.EXTERNAL_ROOM_ID)));
			course.setExternalTeacherId(cursor.getLong(cursor.getColumnIndexOrThrow(Course.EXTERNAL_TEACHER_ID)));
			course.setCourseType(cursor.getString(cursor.getColumnIndexOrThrow(Course.COURSE_TYPE)));
		}
		return course;
	}

	private long id;
	private long externalId;
	private String name;
	private long quantity;
	private long cycle;
	private long firstWeek;
	private long startTime;
	private long endTime;
	private long externalRoomId;
	private long externalTeacherId;
	private String courseType;

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

	public long getQuantity() {
		return quantity;
	}

	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}

	public long getCycle() {
		return cycle;
	}

	public void setCycle(long cycle) {
		this.cycle = cycle;
	}

	public long getFirstWeek() {
		return firstWeek;
	}

	public void setFirstWeek(long firstWeek) {
		this.firstWeek = firstWeek;
	}

	public long getStartTime() {
		return startTime;
	}

	public void setStartTime(long startTime) {
		this.startTime = startTime;
	}

	public long getEndTime() {
		return endTime;
	}

	public void setEndTime(long endTime) {
		this.endTime = endTime;
	}

	public long getExternalRoomId() {
		return externalRoomId;
	}

	public void setExternalRoomId(long externalRoomId) {
		this.externalRoomId = externalRoomId;
	}

	public long getExternalTeacherId() {
		return externalTeacherId;
	}

	public void setExternalTeacherId(long externalTeacherId) {
		this.externalTeacherId = externalTeacherId;
	}

	public String getCourseType() {
		return courseType;
	}

	public void setCourseType(String courseType) {
		this.courseType = courseType;
	}

	@Override
	public String toString() {
		return "Course{" +
				"id=" + id +
				", externalId=" + externalId +
				", name='" + name + '\'' +
				", quantity=" + quantity +
				", cycle=" + cycle +
				", firstWeek=" + firstWeek +
				", startTime=" + startTime +
				", endTime=" + endTime +
				", externalRoomId=" + externalRoomId +
				", externalTeacherId=" + externalTeacherId +
				", courseType='" + courseType + '\'' +
				'}';
	}
}
