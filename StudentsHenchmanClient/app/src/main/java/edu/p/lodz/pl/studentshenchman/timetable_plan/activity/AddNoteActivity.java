package edu.p.lodz.pl.studentshenchman.timetable_plan.activity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import java.util.Date;

import edu.p.lodz.pl.studentshenchman.R;
import edu.p.lodz.pl.studentshenchman.abstract_ui.StudentShenchmanMainActivity;
import edu.p.lodz.pl.studentshenchman.timetable_plan.utils.TimeTableUtils;
import edu.p.lodz.pl.studentshenchman.utils.animation.AnimationHelper;

/**
 * Created by Michał on 2016-11-20.
 */

public class AddNoteActivity extends StudentShenchmanMainActivity {
	private static final String TAG = AddNoteActivity.class.getName();

	private Button mExapandableDataPicker;
	private DatePicker mActivationDate;
	private EditText mNoteContent;
	private Button mOkButton;
	private Button mCancelButton;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_add_note);

		mExapandableDataPicker = (Button) findViewById(R.id.add_activation_date);
		mExapandableDataPicker.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				AnimationHelper.startFallAnimation(mActivationDate);
				mActivationDate.setVisibility(mActivationDate.isShown() ? View.GONE : View.VISIBLE);
			}
		});
		mActivationDate = (DatePicker) findViewById(R.id.note_activation_date);
		mActivationDate.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				mActivationDate.setVisibility(View.GONE);
			}
		});
		mNoteContent = (EditText) findViewById(R.id.content);
		mOkButton = (Button) findViewById(R.id.ok_button);
		mOkButton.setOnClickListener(new OkOnClickListener());
		mCancelButton = (Button) findViewById(R.id.cancel_button);
		mCancelButton.setOnClickListener(new CancelOnClickListener());
	}

	private class OkOnClickListener implements View.OnClickListener {
		@Override
		public void onClick(View v) {
			Date date = new Date(mActivationDate.getYear() - 1900, mActivationDate.getMonth(), mActivationDate.getDayOfMonth());
			String content = mNoteContent.getText().toString().trim();
			long activationDate = date.getTime();
			Log.i(TAG, "Tresc notatki: " + content + " data aktywacji: " + activationDate);
			if (!content.isEmpty())
				TimeTableUtils.addNoteToDB(getApplicationContext(), 1, 1, content, activationDate);
			finish();
		}
	}

	private class CancelOnClickListener implements View.OnClickListener {
		@Override
		public void onClick(View v) {
			finish();
		}
	}

}
