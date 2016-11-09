package edu.p.lodz.pl.studentshenchman.settings.datastore;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * @author Michal Warcholinski
 */
public class SettingsDataStoreHelper {
	private static final String TAG = SettingsDataStoreHelper.class.getName();

	private SharedPreferences mSharedPreferences;
	private long mDepartmentId;
	private long mFieldId;
	private long mTypeId;
	private long mKindId;

	enum PREFERENCES_KEYS {
		DEPARTMENT, FIELD, SPECIALIZATION, TYPE, KIND
	}

	public SettingsDataStoreHelper(Context context) {
		mSharedPreferences = context.getSharedPreferences(TAG, Context.MODE_PRIVATE);
		load();
	}

	public void save() {
		mSharedPreferences.edit()
				.putLong(PREFERENCES_KEYS.DEPARTMENT.name(), mDepartmentId)
				.putLong(PREFERENCES_KEYS.FIELD.name(), mFieldId)
				.putLong(PREFERENCES_KEYS.TYPE.name(), mTypeId)
				.putLong(PREFERENCES_KEYS.KIND.name(), mKindId)
				.apply();
	}

	public void load() {
		mDepartmentId = mSharedPreferences.getLong(PREFERENCES_KEYS.DEPARTMENT.name(), Long.MIN_VALUE);
		mFieldId = mSharedPreferences.getLong(PREFERENCES_KEYS.FIELD.name(), Long.MIN_VALUE);
		mTypeId = mSharedPreferences.getLong(PREFERENCES_KEYS.TYPE.name(), Long.MIN_VALUE);
		mKindId = mSharedPreferences.getLong(PREFERENCES_KEYS.KIND.name(), Long.MIN_VALUE);
	}

	public void setDefault() {
		mDepartmentId = Long.MIN_VALUE;
		mFieldId = Long.MIN_VALUE;
		mTypeId = Long.MIN_VALUE;
		mKindId = Long.MIN_VALUE;
	}

	public long getKindId() {
		return mKindId;
	}

	public SettingsDataStoreHelper setKindId(long kindId) {
		this.mKindId = kindId;
		return this;
	}

	public long getDepartmentId() {
		return mDepartmentId;
	}

	public SettingsDataStoreHelper setDepartmentId(long departmentId) {
		this.mDepartmentId = departmentId;
		return this;
	}

	public long getFieldId() {
		return mFieldId;
	}

	public SettingsDataStoreHelper setFieldId(long fieldId) {
		this.mFieldId = fieldId;
		return this;
	}

	public long getTypeId() {
		return mTypeId;
	}

	public SettingsDataStoreHelper setTypeId(long typeId) {
		this.mTypeId = typeId;
		return this;
	}

	@Override
	public String toString() {
		return "SettingsController{" +
				"mKind=" + mKindId +
				", mType=" + mTypeId +
				", mField=" + mFieldId +
				", mDepartment=" + mDepartmentId +
				'}';
	}
}


