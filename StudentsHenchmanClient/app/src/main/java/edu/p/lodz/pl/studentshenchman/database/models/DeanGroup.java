package edu.p.lodz.pl.studentshenchman.database.models;

import android.provider.BaseColumns;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Michał on 2016-11-08.
 */

public class DeanGroup implements BaseColumns {
	private static final String TAG = DeanGroup.class.getName();

	public static final String TABLE_NAME = "dean_group";


	public static final String _ID = "_id";
	public static final String EXTERNAL_DEAN_GROUP_ID = "external_department_id";
	public static final String EXTERNAL_FIELD_ID = "external_field_id";
	public static final String NAME = "name";
	public static final String ABBREVIATION = "abbreviation";
	public static final String TERM = "term";
	public static final String DEGREE = "degree";

	public static final Map<String, String> projectionColumns;

	static {
		projectionColumns = new HashMap<>();
		projectionColumns.put(_ID,
				_ID);
		projectionColumns.put(EXTERNAL_DEAN_GROUP_ID,
				EXTERNAL_DEAN_GROUP_ID);
		projectionColumns.put(EXTERNAL_FIELD_ID,
				EXTERNAL_FIELD_ID);
		projectionColumns.put(NAME,
				NAME);
		projectionColumns.put(ABBREVIATION,
				ABBREVIATION);
		projectionColumns.put(TERM,
				TERM);
		projectionColumns.put(DEGREE,
				DEGREE);
	}


	public static final String[] COLUMN_NAMES = {_ID, EXTERNAL_DEAN_GROUP_ID, EXTERNAL_FIELD_ID, NAME, ABBREVIATION, TERM, DEGREE};


	public static final String[] COLUMN_TYPES = {
			"integer primary key autoincrement",    // DEAN_GROUP_ID
			"integer",                              // EXTERNAL_DEAN_GROUP_ID
			"integer",                              // EXTERNAL_FIELD_ID
			"text",                                 // NAME
			"text",                                 // ABBREVIATION
			"integer",                              // TERM
			"integer"                               // DEGREE
	};


	private long id;
	private long externalGroupId;
	private long externalFieldId;
	private String name;
	private String abbreviation;
	private long term;
	private long degree;

	public DeanGroup() {
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getExternalGroupId() {
		return externalGroupId;
	}

	public void setExternalGroupId(long externalGroupId) {
		this.externalGroupId = externalGroupId;
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

	public String getAbbreviation() {
		return abbreviation;
	}

	public void setAbbreviation(String abbreviation) {
		this.abbreviation = abbreviation;
	}

	public long getTerm() {
		return term;
	}

	public void setTerm(long term) {
		this.term = term;
	}

	public long getDegree() {
		return degree;
	}

	public void setDegree(long degree) {
		this.degree = degree;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		DeanGroup deanGroup = (DeanGroup) o;

		if (id != deanGroup.id) return false;
		if (externalGroupId != deanGroup.externalGroupId) return false;
		if (externalFieldId != deanGroup.externalFieldId) return false;
		if (term != deanGroup.term) return false;
		if (degree != deanGroup.degree) return false;
		if (name != null ? !name.equals(deanGroup.name) : deanGroup.name != null) return false;
		return abbreviation != null ? abbreviation.equals(deanGroup.abbreviation) : deanGroup.abbreviation == null;

	}

	@Override
	public int hashCode() {
		int result = (int) (id ^ (id >>> 32));
		result = 31 * result + (int) (externalGroupId ^ (externalGroupId >>> 32));
		result = 31 * result + (int) (externalFieldId ^ (externalFieldId >>> 32));
		result = 31 * result + (name != null ? name.hashCode() : 0);
		result = 31 * result + (abbreviation != null ? abbreviation.hashCode() : 0);
		result = 31 * result + (int) (term ^ (term >>> 32));
		result = 31 * result + (int) (degree ^ (degree >>> 32));
		return result;
	}

	@Override
	public String toString() {
		return "DeanGroup{" +
				"id=" + id +
				", externalGroupId=" + externalGroupId +
				", externalFieldId=" + externalFieldId +
				", name='" + name + '\'' +
				", abbreviation='" + abbreviation + '\'' +
				", term=" + term +
				", degree=" + degree +
				'}';
	}
}

