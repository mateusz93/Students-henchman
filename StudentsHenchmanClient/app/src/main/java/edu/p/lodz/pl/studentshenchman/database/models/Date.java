package edu.p.lodz.pl.studentshenchman.database.models;

import android.content.ContentValues;
import android.database.Cursor;
import android.provider.BaseColumns;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Michał on 2016-11-12.
 */

public class Date implements BaseColumns {
	private static final String TAG = Date.class.getName();

	public static final String TABLE_NAME = "date";

	public static final String _ID = "_id";
	public static final String EXTERNAL_DATE_ID = "external_date_id";
	public static final String DAY_OF_WEEK = "day_of_week";
	public static final String DATE = "date";
	public static final String WEEK_NO = "week_no";
	public static final String CYCLE = "cycle";

	public static final Map<String, String> projectionColumns;

	static {
		projectionColumns = new HashMap<>();
		projectionColumns.put(_ID,
				_ID);
		projectionColumns.put(EXTERNAL_DATE_ID,
				EXTERNAL_DATE_ID);
		projectionColumns.put(DAY_OF_WEEK,
				DAY_OF_WEEK);
		projectionColumns.put(DATE,
				DATE);
		projectionColumns.put(WEEK_NO,
				WEEK_NO);
		projectionColumns.put(CYCLE,
				CYCLE);
	}

	public static final String[] COLUMN_NAMES = {_ID, EXTERNAL_DATE_ID, DAY_OF_WEEK, DATE, WEEK_NO, CYCLE};


	public static final String[] COLUMN_TYPES = {
			"integer primary key autoincrement",    //DATE_ID
			"integer",                              //EXTERNAL_DATE_ID
			"text",                                 //DAY_OF_WEEK
			"date",                                 //DATE
			"integer",                              //WEEK_NO
			"integer"                               //CYCLE
	};

	public static ContentValues fromDTO2CV(model.Date dateDto) {
		ContentValues cv = new ContentValues();
		cv.put(EXTERNAL_DATE_ID, dateDto.getId());
		cv.put(DAY_OF_WEEK, dateDto.getDayOfWeek());
		cv.put(DATE, dateDto.getDate().toString());
		cv.put(WEEK_NO, dateDto.getWeekNo());
		cv.put(CYCLE, dateDto.getCycle());

		return cv;
	}

	private long id;
	private long externalId;
	private String dayOfWeek;
	private String date;
	private int weekNo;
	private int cycle;

	public Date() {
	}

	public Date(Cursor cursor) {
		if (cursor.moveToFirst()) {
			id = cursor.getLong(cursor.getColumnIndexOrThrow(Build._ID));
			externalId = cursor.getLong(cursor.getColumnIndexOrThrow(Build.EXTERNAL_BUILD_ID));
			dayOfWeek = cursor.getString(cursor.getColumnIndexOrThrow(Build.NAME));
			date = cursor.getString(cursor.getColumnIndexOrThrow(Build.CODE));
			weekNo = cursor.getInt(cursor.getColumnIndexOrThrow(Build.LATITUDE));
			cycle = cursor.getInt(cursor.getColumnIndexOrThrow(Build.LONGITUDE));
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

	public String getDayOfWeek() {
		return dayOfWeek;
	}

	public void setDayOfWeek(String dayOfWeek) {
		this.dayOfWeek = dayOfWeek;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getWeekNo() {
		return weekNo;
	}

	public void setWeekNo(int weekNo) {
		this.weekNo = weekNo;
	}

	public int getCycle() {
		return cycle;
	}

	public void setCycle(int cycle) {
		this.cycle = cycle;
	}

	@Override
	public String toString() {
		return "Date{" +
				"id=" + id +
				", externalId=" + externalId +
				", dayOfWeek='" + dayOfWeek + '\'' +
				", date='" + date + '\'' +
				", weekNo=" + weekNo +
				", cycle=" + cycle +
				'}';
	}
}
