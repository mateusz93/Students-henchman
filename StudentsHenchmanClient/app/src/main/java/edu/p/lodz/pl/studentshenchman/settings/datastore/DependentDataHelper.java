package edu.p.lodz.pl.studentshenchman.settings.datastore;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import edu.p.lodz.pl.studentshenchman.database.models.DeanGroup;
import edu.p.lodz.pl.studentshenchman.database.models.Department;
import edu.p.lodz.pl.studentshenchman.database.models.Field;

/**
 * @author Michal Warcholinski
 */
public class DependentDataHelper {
	private static final String TAG = DependentDataHelper.class.getName();

	public List<Field> loadFields(SQLiteDatabase db, long id) {
		List<Field> values = new ArrayList<>();

		Cursor c = db.query(Field.TABLE_NAME, null, Field.EXTERNAL_DEPARTMENT_ID + "=?", new String[]{id + ""}, null, null, null);
		while (c.moveToNext()) {
			Field field = new Field();
			field.setId(c.getLong(c.getColumnIndexOrThrow(Field._ID)));
			field.setExternalId(c.getLong(c.getColumnIndexOrThrow(Field.EXTERNAL_FIELD_ID)));
			field.setExternalDepartmentId(c.getLong(c.getColumnIndexOrThrow(Field.EXTERNAL_DEPARTMENT_ID)));
			field.setName(c.getString(c.getColumnIndexOrThrow(Field.NAME)));
			values.add(field);
		}
		c.close();

		return values;
	}

	public List<Department> loadDepartments(SQLiteDatabase db) {
		List<Department> values = new ArrayList<>();

		Cursor c = db.query(Department.TABLE_NAME, null, null, null, null, null, null);
		while (c.moveToNext()) {
			Department department = new Department();
			department.setId(c.getLong(c.getColumnIndexOrThrow(Department._ID)));
			department.setExternalId(c.getLong(c.getColumnIndexOrThrow(Department.EXTERNAL_DEPARTMENT_ID)));
			department.setName(c.getString(c.getColumnIndexOrThrow(Department.NAME)));
			values.add(department);
		}
		c.close();

		return values;
	}

	public List<DeanGroup> loadGroups(SQLiteDatabase db, long fieldId, int degree, long term) {
		List<DeanGroup> values = new ArrayList<>();
		String selection = DeanGroup.EXTERNAL_FIELD_ID + "=? and " + DeanGroup.DEGREE + "=? and " + DeanGroup.TERM + "=?";
		String[] selectionArgs = new String[]{fieldId + "", degree + "", term + ""};
		Cursor c = db.query(DeanGroup.TABLE_NAME, null, selection, selectionArgs, null, null, null);
		while (c.moveToNext()) {
			DeanGroup deanGroup = new DeanGroup(c);
			values.add(deanGroup);
		}
		c.close();

		return values;
	}
}
