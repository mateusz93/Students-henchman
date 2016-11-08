package edu.p.lodz.pl.studentshenchman.database.models;

import android.provider.BaseColumns;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Michał on 2016-10-16.
 */

public class Department implements BaseColumns {
	private static final String TAG = Department.class.getName();

	public static final String TABLE_NAME = "department";


	public static final String _ID = "_id";
	public static final String EXTERNAL_DEPARTMENT_ID = "external_department_id";
	public static final String NAME = "name";

	public static final Map<String, String> projectionColumns;

	static {
		projectionColumns = new HashMap<>();
		projectionColumns.put(_ID,
				_ID);
		projectionColumns.put(EXTERNAL_DEPARTMENT_ID,
				EXTERNAL_DEPARTMENT_ID);
		projectionColumns.put(NAME,
				NAME);
	}

	public static final String[] COLUMN_NAMES = {_ID, EXTERNAL_DEPARTMENT_ID, NAME};


	public static final String[] COLUMN_TYPES = {
			"integer primary key autoincrement",    //DEPARTMENT_ID
			"integer",                              //EXTERNAL_DEPARTMENT_ID
			"text"                                  //NAME
	};

	private long id;
	private long externalId;
	private String name;

	public Department() {
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

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Department that = (Department) o;

		if (id != that.id) return false;
		if (externalId != that.externalId) return false;
		return name != null ? name.equals(that.name) : that.name == null;

	}

	@Override
	public int hashCode() {
		int result = (int) (id ^ (id >>> 32));
		result = 31 * result + (int) (externalId ^ (externalId >>> 32));
		result = 31 * result + (name != null ? name.hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return "Department{" +
				"id=" + id +
				", externalId=" + externalId +
				", name='" + name + '\'' +
				'}';
	}
}
