package edu.p.lodz.pl.studentshenchman.settings.dialog_fragment;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import java.util.List;

import edu.p.lodz.pl.studentshenchman.R;
import edu.p.lodz.pl.studentshenchman.database.DatabaseHelper;
import edu.p.lodz.pl.studentshenchman.database.models.DeanGroup;
import edu.p.lodz.pl.studentshenchman.settings.adapters.GroupsAdapter;
import edu.p.lodz.pl.studentshenchman.settings.datastore.DependentDataHelper;
import edu.p.lodz.pl.studentshenchman.settings.datastore.SettingsDataStoreHelper;

/**
 * Created by Michał on 2016-11-10.
 */

public class GroupsDialogFragment extends DialogFragment {
	private static final String TAG = GroupsDialogFragment.class.getName();

	private static final String FIELD = TAG + ":field";
	private static final String TERM = TAG + ":term";
	private static final String DEGREE = TAG + ":degree";
	private static final String SELECTED_DEAN_GROUPS = ":selected_dean_groups";

	private ChosenDeanGroupsInterface mChosenGroupsCallback;
	List<DeanGroup> mDeanGroups;
	private SettingsDataStoreHelper mSettingsHelper;

	private Button mOkButton;
	private Button mCancelButton;
	private ListView mList;

	private GroupsAdapter mGroupsAdapter;

	public static GroupsDialogFragment getInstance(long fieldId, long term, int degree, String deanGroups) {
		GroupsDialogFragment dialogFragment = new GroupsDialogFragment();
		Bundle bundle = new Bundle();
		bundle.putLong(FIELD, fieldId);
		bundle.putLong(TERM, term);
		bundle.putInt(DEGREE, degree);
		bundle.putString(SELECTED_DEAN_GROUPS, deanGroups);
		dialogFragment.setArguments(bundle);

		return dialogFragment;
	}

	@Override
	public void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		mSettingsHelper = new SettingsDataStoreHelper(getContext());
		mChosenGroupsCallback = (ChosenDeanGroupsInterface) getActivity();

	}

	@Nullable
	@Override
	public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		getDialog().requestWindowFeature(STYLE_NO_TITLE);
		return inflater.inflate(R.layout.groups_dialog_fragment, container);

	}

	@Override
	public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);

		mOkButton = (Button) view.findViewById(R.id.ok_button);
		mOkButton.setOnClickListener(new OkOnClickListener());

		mCancelButton = (Button) view.findViewById(R.id.cancel_button);
		mCancelButton.setOnClickListener(new CancelOnClickListener());

		mList = (ListView) view.findViewById(R.id.groups_list);
		mList.setOnItemClickListener(new ListOnItemClickListener());
		mList.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);

		mDeanGroups = loadDeanGroups();
		mGroupsAdapter = new GroupsAdapter(getContext(), mDeanGroups);
		mList.setAdapter(mGroupsAdapter);

		initCacheData();
	}

	private void initCacheData() {
		String groups = getArguments().getString(SELECTED_DEAN_GROUPS);
		mSettingsHelper.setGroups(groups);
		for (Long groupId : mSettingsHelper.getGroupsAsList(groups)) {
			mList.setItemChecked(mGroupsAdapter.getPosForId(groupId), true);
		}
	}

	private List<DeanGroup> loadDeanGroups() {
		Bundle args = getArguments();
		List<DeanGroup> values;
		SQLiteDatabase db = DatabaseHelper.getInstance(getContext()).getReadableDatabase();
		DependentDataHelper dependentDataHelper = new DependentDataHelper();
		values = dependentDataHelper.loadGroups(db, args.getLong(FIELD), args.getInt(DEGREE), args.getLong(TERM));
		return values;
	}

	private class OkOnClickListener implements View.OnClickListener {
		@Override
		public void onClick(View v) {
			Log.i(TAG, "Wybrane grupy w dialog fragmencie: " + mSettingsHelper.getGroups() + " ilosc wybranych grup: " + mList.getCheckedItemCount());
			mChosenGroupsCallback.chosenDeanGroups(mSettingsHelper.getGroups());
			dismiss();
		}
	}

	private class CancelOnClickListener implements View.OnClickListener {
		@Override
		public void onClick(View v) {
			dismiss();
		}
	}

	private class ListOnItemClickListener implements android.widget.AdapterView.OnItemClickListener {
		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

			if (mSettingsHelper.getGroupsAsList(mSettingsHelper.getGroups()).contains(id))
				mSettingsHelper.removeGroupId(id);
			else
				mSettingsHelper.addGroupId(id);
		}
	}

	public interface ChosenDeanGroupsInterface {
		void chosenDeanGroups(String groupsIds);
	}
}
