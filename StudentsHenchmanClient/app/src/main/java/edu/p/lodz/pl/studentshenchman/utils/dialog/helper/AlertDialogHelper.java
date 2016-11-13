package edu.p.lodz.pl.studentshenchman.utils.dialog.helper;

import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;
import android.util.Log;

import edu.p.lodz.pl.studentshenchman.utils.dialog.UserYesNoDialog;
import edu.p.lodz.pl.studentshenchman.utils.dialog.factory.DialogFactory;
import edu.p.lodz.pl.studentshenchman.utils.dialog.interfaces.AlertDialogCallback;

import static edu.p.lodz.pl.studentshenchman.utils.dialog.helper.UniqueYesNoDialogTAG.DELETE_NOTE_TAG;

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

	public static void showYesNoDialog(FragmentManager fm, String title, String message, AlertDialogCallback callback, String dialogTAG) {
		showDialog(fm, title, message, DialogType.YES_NO, callback, dialogTAG);
	}

	public static void showDialog(FragmentManager fm, String title, String message, DialogType dialogType) {
		showDialog(fm, title, message, dialogType, null, TAG);

	}

	public static void showDialog(FragmentManager fm, String title, String message, DialogType dialogType, AlertDialogCallback callback, String dialogTAG) {
		DialogFragment dialog = DialogFactory.produceDialog(title, message, dialogType, callback);
		dialog.show(fm, dialogTAG);
	}


	public static void readjustYesNoCallback(FragmentManager fm, AlertDialogCallback callback, String dialogTAG) {
		UserYesNoDialog yesNoDialog = (UserYesNoDialog) fm.findFragmentByTag(DELETE_NOTE_TAG);
		if (null != yesNoDialog) {
			Log.i(TAG, "Ponowne ustawienie callbacka do UserYesNoDialog dla tagu: " + dialogTAG);
			yesNoDialog.readjustCallback(callback);
		}
	}
}
