package edu.p.lodz.pl.studentshenchman.settings.controller;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * @author Michal Warcholinski
 */
public class SettingsController {
	private static final String TAG = SettingsController.class.getName();

	private static SettingsController mInstance;
	private SharedPreferences mSharedPreferences;
	private long mDepartmentId;
	private long mFieldId;
	private long mSpecializationId;
	private long mTypeId;
	private long mKindId;

	enum PREFERENCES_KEYS {
		DEPARTMENT, FIELD, SPECIALIZATION, TYPE, KIND
	}

	public static SettingsController getInstance(Context context) {
		if (null == mInstance)
			mInstance = new SettingsController(context);

		return mInstance;
	}

	private SettingsController(Context context) {
		mSharedPreferences = context.getSharedPreferences(TAG, Context.MODE_PRIVATE);
		load();
	}

	public void save() {
		mSharedPreferences.edit()
				.putLong(PREFERENCES_KEYS.DEPARTMENT.name(), mDepartmentId)
				.putLong(PREFERENCES_KEYS.FIELD.name(), mFieldId)
				.putLong(PREFERENCES_KEYS.SPECIALIZATION.name(), mSpecializationId)
				.putLong(PREFERENCES_KEYS.TYPE.name(), mTypeId)
				.putLong(PREFERENCES_KEYS.KIND.name(), mKindId)
				.apply();
	}

	public void load() {
		mDepartmentId = mSharedPreferences.getLong(PREFERENCES_KEYS.DEPARTMENT.name(), Long.MIN_VALUE);
		mFieldId = mSharedPreferences.getLong(PREFERENCES_KEYS.FIELD.name(), Long.MIN_VALUE);
		mSpecializationId = mSharedPreferences.getLong(PREFERENCES_KEYS.SPECIALIZATION.name(), Long.MIN_VALUE);
		mTypeId = mSharedPreferences.getLong(PREFERENCES_KEYS.TYPE.name(), Long.MIN_VALUE);
		mKindId = mSharedPreferences.getLong(PREFERENCES_KEYS.KIND.name(), Long.MIN_VALUE);
	}

	public void setDefault() {
		mDepartmentId = Long.MIN_VALUE;
		mFieldId = Long.MIN_VALUE;
		mSpecializationId = Long.MIN_VALUE;
		mTypeId = Long.MIN_VALUE;
		mKindId = Long.MIN_VALUE;
	}

	public long getKindId() {
		return mKindId;
	}

	public SettingsController setKindId(long kindId) {
		this.mKindId = kindId;
		return this;
	}

	public long getDepartmentId() {
		return mDepartmentId;
	}

	public SettingsController setDepartmentId(long departmentId) {
		this.mDepartmentId = departmentId;
		return this;
	}

	public long getFieldId() {
		return mFieldId;
	}

	public SettingsController setFieldId(long fieldId) {
		this.mFieldId = fieldId;
		return this;
	}

	public long getSpecializationId() {
		return mSpecializationId;
	}

	public SettingsController setSpecializationId(long specializationId) {
		this.mSpecializationId = specializationId;
		return this;
	}

	public long getTypeId() {
		return mTypeId;
	}

	public SettingsController setTypeId(long typeId) {
		this.mTypeId = typeId;
		return this;
	}

	@Override
	public String toString() {
		return "SettingsController{" +
				"mKind=" + mKindId +
				", mType=" + mTypeId +
				", mSpecialization=" + mSpecializationId +
				", mField=" + mFieldId +
				", mDepartment=" + mDepartmentId +
				'}';
	}
}


