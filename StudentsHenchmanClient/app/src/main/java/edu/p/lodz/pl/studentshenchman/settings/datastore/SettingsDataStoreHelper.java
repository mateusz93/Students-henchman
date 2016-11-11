package edu.p.lodz.pl.studentshenchman.settings.datastore;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Michal Warcholinski
 */
public class SettingsDataStoreHelper {
	private static final String TAG = SettingsDataStoreHelper.class.getName();

	private SharedPreferences mSharedPreferences;
	private long mDepartmentId;
	private long mFieldId;
	private long mTypeValue;
	private long mDegreeValue;
	private long mTermValue;
	private String mGroups;

	private enum PREFERENCES_KEYS {
		DEPARTMENT, FIELD, TYPE, KIND, TERM, GROUPS
	}

	public SettingsDataStoreHelper(Context context) {
		mSharedPreferences = context.getSharedPreferences(TAG, Context.MODE_PRIVATE);
		load();
	}

	public void save() {
		mSharedPreferences.edit()
				.putLong(PREFERENCES_KEYS.DEPARTMENT.name(), mDepartmentId)
				.putLong(PREFERENCES_KEYS.FIELD.name(), mFieldId)
				.putLong(PREFERENCES_KEYS.TYPE.name(), mTypeValue)
				.putLong(PREFERENCES_KEYS.KIND.name(), mDegreeValue)
				.putLong(PREFERENCES_KEYS.TERM.name(), mTermValue)
				.putString(PREFERENCES_KEYS.GROUPS.name(), mGroups)
				.apply();
	}

	public void load() {
		mDepartmentId = mSharedPreferences.getLong(PREFERENCES_KEYS.DEPARTMENT.name(), Long.MIN_VALUE);
		mFieldId = mSharedPreferences.getLong(PREFERENCES_KEYS.FIELD.name(), Long.MIN_VALUE);
		mTypeValue = mSharedPreferences.getLong(PREFERENCES_KEYS.TYPE.name(), Long.MIN_VALUE);
		mDegreeValue = mSharedPreferences.getLong(PREFERENCES_KEYS.KIND.name(), Long.MIN_VALUE);
		mTermValue = mSharedPreferences.getLong(PREFERENCES_KEYS.TERM.name(), Long.MIN_VALUE);
		mGroups = mSharedPreferences.getString(PREFERENCES_KEYS.GROUPS.name(), "");
	}

	public SettingsDataStoreHelper setDefault() {
		mDepartmentId = Long.MIN_VALUE;
		mFieldId = Long.MIN_VALUE;
		mTypeValue = Long.MIN_VALUE;
		mDegreeValue = Long.MIN_VALUE;
		mTermValue = Long.MIN_VALUE;
		mGroups = "";

		return this;
	}

	public long getDegreeValue() {
		return mDegreeValue;
	}

	public SettingsDataStoreHelper setDegreeValue(long degreeValue) {
		this.mDegreeValue = degreeValue;
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

	public long getTypeValue() {
		return mTypeValue;
	}

	public SettingsDataStoreHelper setTypeValue(long typeValue) {
		this.mTypeValue = typeValue;
		return this;
	}

	public long getTermValue() {
		return mTermValue;
	}

	public SettingsDataStoreHelper setTermValue(long termValue) {
		this.mTermValue = termValue;
		return this;
	}

	public String getGroups() {
		return mGroups;
	}

	public SettingsDataStoreHelper setGroups(String groups) {
		this.mGroups = groups;
		return this;
	}

	public SettingsDataStoreHelper addGroupId(long groupId) {
		if (mGroups.isEmpty())
			mGroups += groupId;
		else
			mGroups = mGroups + ";" + groupId;

		Log.i(TAG, "Dodana grupa o id: " + groupId);
		return this;
	}

	public SettingsDataStoreHelper removeGroupId(long groupId) {
		if (!mGroups.isEmpty()) {
			Log.i(TAG, "Usunieta grupa o id: " + groupId);
			List<Long> ids = getGroupsAsList(mGroups);
			ids.remove(groupId);
			saveListIdsAsString(ids);
		}
		return this;
	}

	public List<Long> getGroupsAsList(String groups) {
		List<Long> groupIds = new ArrayList<>();

		for (String id : groups.split(";")) {
			if (!id.isEmpty())
				groupIds.add(Long.valueOf(id));
		}

		return groupIds;
	}

	private void saveListIdsAsString(List<Long> ids) {
		String groups = "";
		for (Long id : ids) {
			if (groups.isEmpty())
				groups += id;
			else
				groups = groups + ";" + id;
		}
		setGroups(groups);
	}

	public boolean areCurrentAndSavedOptionsSame() {
		if (mDepartmentId != mSharedPreferences.getLong(PREFERENCES_KEYS.DEPARTMENT.name(), Long.MIN_VALUE))
			return false;
		if (mFieldId != mSharedPreferences.getLong(PREFERENCES_KEYS.FIELD.name(), Long.MIN_VALUE))
			return false;
		if (mTermValue != mSharedPreferences.getLong(PREFERENCES_KEYS.TERM.name(), Long.MIN_VALUE))
			return false;
		if (mDegreeValue != mSharedPreferences.getLong(PREFERENCES_KEYS.KIND.name(), Long.MIN_VALUE))
			return false;

		return true;
	}

	@Override
	public String toString() {
		return "SettingsDataStoreHelper{" +
				"mSharedPreferences=" + mSharedPreferences +
				", mDepartmentId=" + mDepartmentId +
				", mFieldId=" + mFieldId +
				", mTypeValue=" + mTypeValue +
				", mDegreeValue=" + mDegreeValue +
				", mTermValue=" + mTermValue +
				", mGroups='" + mGroups + '\'' +
				'}';
	}
}


