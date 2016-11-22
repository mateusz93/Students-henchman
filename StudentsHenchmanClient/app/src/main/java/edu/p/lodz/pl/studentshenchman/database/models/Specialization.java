package edu.p.lodz.pl.studentshenchman.database.models;

import android.provider.BaseColumns;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Michał on 2016-10-23.
 */

public class Specialization implements BaseColumns {
	private static final String TAG = Specialization.class.getName();

	public static final String TABLE_NAME = "specialization";


	public static final String _ID = "_id";
	public static final String EXTERNAL_SPECIALIZATION_ID = "external_specialization_id";
	public static final String EXTERNAL_FIELD_ID = "external_field_id";
	public static final String NAME = "name";


	public static final Map<String, String> projectionColumns;

	static {
		projectionColumns = new HashMap<>();
		projectionColumns.put(_ID,
				_ID);
		projectionColumns.put(EXTERNAL_SPECIALIZATION_ID,
				EXTERNAL_SPECIALIZATION_ID);
		projectionColumns.put(EXTERNAL_FIELD_ID,
				EXTERNAL_FIELD_ID);
		projectionColumns.put(NAME,
				NAME);
	}

	public static final String[] COLUMN_NAMES = {_ID, EXTERNAL_SPECIALIZATION_ID, EXTERNAL_FIELD_ID, NAME};


	public static final String[] COLUMN_TYPES = {
			"integer primary key autoincrement",    //SPECIALIZATION_ID
			"integer",                              //EXTERNAL_SPECIALIZATION_ID
			"integer",                              //EXTERNAL_FIELD_ID
			"text",                                 //NAME
	};


	private long id;
	private long externalId;
	private long externalFieldId;
	private String name;

	public Specialization() {
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

	public long getExternalFieldId() {
		return externalFieldId;
	}

	public void setExternalFieldId(long externalFieldId) {
		this.externalFieldId = externalFieldId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Specialization{" +
				"id=" + id +
				", externalId=" + externalId +
				", externalFieldId=" + externalFieldId +
				", name='" + name + '\'' +
				'}';
	}
}

