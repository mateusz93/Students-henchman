package edu.p.lodz.pl.studentshenchman.timetable_plan.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import edu.p.lodz.pl.studentshenchman.R;
import edu.p.lodz.pl.studentshenchman.abstract_ui.StudentShenchmanMainFragment;

/**
 * @author Michal Warcholinski
 */
public class SubjectDetailsEmptyFragment extends StudentShenchmanMainFragment {

	@Nullable
	@Override
	public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		View v = inflater.inflate(R.layout.subject_details_empty_fragment, container, false);

		return v;
	}
}
