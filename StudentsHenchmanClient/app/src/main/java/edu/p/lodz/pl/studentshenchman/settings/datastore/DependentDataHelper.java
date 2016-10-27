package edu.p.lodz.pl.studentshenchman.settings.datastore;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import edu.p.lodz.pl.studentshenchman.database.models.Department;
import edu.p.lodz.pl.studentshenchman.database.models.Field;
import edu.p.lodz.pl.studentshenchman.database.models.Kind;
import edu.p.lodz.pl.studentshenchman.database.models.Specialization;
import edu.p.lodz.pl.studentshenchman.database.models.Type;

/**
 * @author Michal Warcholinski
 */
public class DependentDataHelper {
	private static final String TAG = DependentDataHelper.class.getName();

	public List<Kind> loadKinds(SQLiteDatabase db) {
		List<Kind> values = new ArrayList<>();

		Cursor c = db.query(Kind.TABLE_NAME, null, null, null, null, null, null);
		while (c.moveToNext()) {
			Kind kind = new Kind();
			kind.setId(c.getLong(c.getColumnIndexOrThrow(Kind._ID)));
			kind.setExternalId(c.getLong(c.getColumnIndexOrThrow(Kind.EXTERNAL_KIND_ID)));
			kind.setName(c.getString(c.getColumnIndexOrThrow(Kind.NAME)));
			values.add(kind);
		}
		c.close();

		return values;
	}

	public List<Type> loadTypes(SQLiteDatabase db) {
		List<Type> values = new ArrayList<>();

		Cursor c = db.query(Type.TABLE_NAME, null, null, null, null, null, null);
		while (c.moveToNext()) {
			Type type = new Type();
			type.setId(c.getLong(c.getColumnIndexOrThrow(Type._ID)));
			type.setExternalId(c.getLong(c.getColumnIndexOrThrow(Type.EXTERNAL_TYPE_ID)));
			type.setName(c.getString(c.getColumnIndexOrThrow(Type.NAME)));
			values.add(type);
		}
		c.close();

		return values;

	}

	public List<Specialization> loadSpecializations(SQLiteDatabase db, long id) {
		List<Specialization> values = new ArrayList<>();

		Cursor c = db.query(Specialization.TABLE_NAME, null, Specialization.EXTERNAL_FIELD_ID + "=?", new String[]{id + ""}, null, null, null);
		while (c.moveToNext()) {
			Specialization specialization = new Specialization();
			specialization.setId(c.getLong(c.getColumnIndexOrThrow(Specialization._ID)));
			specialization.setExternalId(c.getLong(c.getColumnIndexOrThrow(Specialization.EXTERNAL_SPECIALIZATION_ID)));
			specialization.setExternalFieldId(c.getLong(c.getColumnIndexOrThrow(Specialization.EXTERNAL_FIELD_ID)));
			specialization.setName(c.getString(c.getColumnIndexOrThrow(Specialization.NAME)));
			values.add(specialization);
		}
		c.close();

		return values;
	}

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
			department.setCode(c.getString(c.getColumnIndexOrThrow(Department.CODE)));
			department.setName(c.getString(c.getColumnIndexOrThrow(Department.NAME)));
			values.add(department);
		}
		c.close();

		return values;
	}
}
