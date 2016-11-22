package edu.p.lodz.pl.studentshenchman.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.HashMap;
import java.util.Map;

import edu.p.lodz.pl.studentshenchman.database.models.Build;
import edu.p.lodz.pl.studentshenchman.database.models.Course;
import edu.p.lodz.pl.studentshenchman.database.models.Date;
import edu.p.lodz.pl.studentshenchman.database.models.DeanGroup;
import edu.p.lodz.pl.studentshenchman.database.models.Department;
import edu.p.lodz.pl.studentshenchman.database.models.ErrorReport;
import edu.p.lodz.pl.studentshenchman.database.models.Field;
import edu.p.lodz.pl.studentshenchman.database.models.Note;
import edu.p.lodz.pl.studentshenchman.database.models.Room;
import edu.p.lodz.pl.studentshenchman.database.models.Specialization;
import edu.p.lodz.pl.studentshenchman.database.models.Teacher;
import edu.p.lodz.pl.studentshenchman.database.models.User;


/**
 * Created by Michał on 2016-10-12.
 */
public class DatabaseHelper extends SQLiteOpenHelper {

	private static final String TAG = DatabaseHelper.class.getName();

	private static DatabaseHelper databaseHelper;

	private static final String DATABASE_NAME = "StudentShenchman";
	private static final int DATABASE_VERSION = 16;

	private static final String DROP_TABLE = "drop table if exists ";
	private static final String CREATE_TABLE = "create table ";
	private static final String DROP_INDEX = "drop index if exists ";
	private static final String CREATE_INDEX = "create index ";


	private Map<String, String> tables = new HashMap<String, String>() {
		{
			put(User.TABLE_NAME, createTableQuery(User.TABLE_NAME, User.COLUMN_NAMES, User.COLUMN_TYPES));
			put(Teacher.TABLE_NAME, createTableQuery(Teacher.TABLE_NAME, Teacher.COLUMN_NAMES, Teacher.COLUMN_TYPES));
			put(Build.TABLE_NAME, createTableQuery(Build.TABLE_NAME, Build.COLUMN_NAMES, Build.COLUMN_TYPES));
			put(Room.TABLE_NAME, createTableQuery(Room.TABLE_NAME, Room.COLUMN_NAMES, Room.COLUMN_TYPES));
			put(Department.TABLE_NAME, createTableQuery(Department.TABLE_NAME, Department.COLUMN_NAMES, Department.COLUMN_TYPES));
			put(Field.TABLE_NAME, createTableQuery(Field.TABLE_NAME, Field.COLUMN_NAMES, Field.COLUMN_TYPES));
			put(Specialization.TABLE_NAME, createTableQuery(Specialization.TABLE_NAME, Specialization.COLUMN_NAMES, Specialization.COLUMN_TYPES));
			put(DeanGroup.TABLE_NAME, createTableQuery(DeanGroup.TABLE_NAME, DeanGroup.COLUMN_NAMES, DeanGroup.COLUMN_TYPES));
			put(Date.TABLE_NAME, createTableQuery(Date.TABLE_NAME, Date.COLUMN_NAMES, Date.COLUMN_TYPES));
			put(Note.TABLE_NAME, createTableQuery(Note.TABLE_NAME, Note.COLUMN_NAMES, Note.COLUMN_TYPES));
			put(ErrorReport.TABLE_NAME, createTableQuery(ErrorReport.TABLE_NAME, ErrorReport.COLUMN_NAMES, ErrorReport.COLUMN_TYPES));
			put(Course.TABLE_NAME, createTableQuery(Course.TABLE_NAME, Course.COLUMN_NAMES, Course.COLUMN_TYPES));
		}
	};

	private String createTableQuery(String tableName, String[] columnNames, String[] columnTypes) {
		if (!isSameSize(columnNames, columnTypes)) {
			Log.e(TAG, "ColumnNames and ColumnTypes must have the same size. Table:  " + tableName + ", " +
					columnNames.length + " columnTypes length: " + columnTypes.length);
			throw new IllegalArgumentException("Mismatch values and types during table: " + tableName + " creating");
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < columnNames.length; i++) {
			if (i != 0)
				sb.append(",");
			sb.append(columnNames[i]).append(" ").append(columnTypes[i]);
		}
		return sb.toString();
	}


	public static DatabaseHelper getInstance(Context context) {
		if (null == databaseHelper)
			databaseHelper = new DatabaseHelper(context);
		return databaseHelper;
	}

	private DatabaseHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		for (Map.Entry<String, String> entry : tables.entrySet())
			createTable(db, entry.getKey(), entry.getValue());
	}

	private void createTable(SQLiteDatabase db, String tableName, String query) {
		StringBuilder createTableQuery = new StringBuilder();

		createTableQuery.append(CREATE_TABLE).append(tableName).append(" ( ").append(query).append(" );");
		Log.i(TAG, "Created table " + tableName + " with query: " + createTableQuery.toString());
		db.execSQL(createTableQuery.toString());
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		for (Map.Entry<String, String> entry : tables.entrySet()) {
			db.execSQL(DROP_TABLE + entry.getKey());
		}
		onCreate(db);
	}


	private boolean isSameSize(String[] columnNames, String[] columnTypes) {
		if (null != columnNames && null != columnTypes && columnNames.length == columnTypes.length)
			return true;
		return false;
	}


}
