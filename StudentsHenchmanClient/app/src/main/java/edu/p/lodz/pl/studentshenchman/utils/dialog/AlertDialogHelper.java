package edu.p.lodz.pl.studentshenchman.utils.dialog;

import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;

import edu.p.lodz.pl.studentshenchman.utils.dialog.factory.DialogFactory;

/**
 * Created by Michał on 2016-11-06.
 */

public class AlertDialogHelper {
	private static final String TAG = AlertDialogHelper.class.getName();

	public static void showErrorDialog(FragmentManager fm, String title, String message) {
		showDialog(fm, title, message, DialogType.USER_ERROR);
	}

	public static void showInfoDialog(FragmentManager fm, String title, String message) {
		showDialog(fm, title, message, DialogType.USER_INFO);
	}

	public static void showSuccessDialog(FragmentManager fm, String title, String message) {
		showDialog(fm, title, message, DialogType.USER_SUCCESS);
	}

	public static void showDialog(FragmentManager fm, String title, String message, DialogType dialogType) {
		DialogFragment dialog = DialogFactory.produceDialog(title, message, dialogType);
		dialog.show(fm, TAG);
	}
}
