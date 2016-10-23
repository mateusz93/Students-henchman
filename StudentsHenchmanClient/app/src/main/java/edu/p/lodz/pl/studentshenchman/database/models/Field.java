package edu.p.lodz.pl.studentshenchman.database.models;

import android.provider.BaseColumns;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Michał on 2016-10-23.
 */

public class Field implements BaseColumns {
    private static final String TAG = Field.class.getName();

    public static final String TABLE_NAME = "field";


    public static final String _ID = "_id";
    public static final String EXTERNAL_FIELD_ID = "external_field_id";
    public static final String EXTERNAL_DEPARTMENT_ID = "external_department_id";
    public static final String NAME = "name";


    public static final Map<String, String> projectionColumns;

    static {
        projectionColumns = new HashMap<>();
        projectionColumns.put(_ID,
                _ID);
        projectionColumns.put(EXTERNAL_FIELD_ID,
                EXTERNAL_FIELD_ID);
        projectionColumns.put(EXTERNAL_DEPARTMENT_ID,
                EXTERNAL_DEPARTMENT_ID);
        projectionColumns.put(NAME,
                NAME);
    }

    public static final String[] COLUMN_NAMES = {_ID, EXTERNAL_FIELD_ID, EXTERNAL_DEPARTMENT_ID, NAME};


    public static final String[] COLUMN_TYPES = {
            "integer primary key autoincrement",    //FIELD_ID
            "integer",                              //EXTERNAL_FIELD_ID
            "integer",                              //EXTERNAL_DEPARTMENT_ID
            "text",                                 //NAME
    };

    private long id;
    private long externalId;
    private long externalDepartmentId;
    private String name;

    public Field() {
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

    public long getExternalDepartmentId() {
        return externalDepartmentId;
    }

    public void setExternalDepartmentId(long externalDepartmentId) {
        this.externalDepartmentId = externalDepartmentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Field{" +
                "id=" + id +
                ", externalId=" + externalId +
                ", externalDepartmentId=" + externalDepartmentId +
                ", name='" + name + '\'' +
                '}';
    }
}
