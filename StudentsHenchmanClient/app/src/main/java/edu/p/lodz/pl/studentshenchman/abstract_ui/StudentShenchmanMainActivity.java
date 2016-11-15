package edu.p.lodz.pl.studentshenchman.abstract_ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import edu.p.lodz.pl.studentshenchman.utils.dialog.event.DialogEvent;
import edu.p.lodz.pl.studentshenchman.utils.dialog.helper.AlertDialogHelper;

/**
 * Created by Michał on 2016-10-09.
 */
public class StudentShenchmanMainActivity extends AppCompatActivity {
	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		EventBus.getDefault().register(this);
	}

	@Subscribe
	public void onEvent(DialogEvent event) {
		AlertDialogHelper.showDialog(getSupportFragmentManager(), event);
	}

	@Override
	protected void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
		EventBus.getDefault().unregister(this);
	}
}
