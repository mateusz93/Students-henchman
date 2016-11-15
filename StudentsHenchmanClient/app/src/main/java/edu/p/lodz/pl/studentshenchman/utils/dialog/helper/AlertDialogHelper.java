package edu.p.lodz.pl.studentshenchman.utils.dialog.helper;

import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;
import android.util.Log;

import org.greenrobot.eventbus.EventBus;

import edu.p.lodz.pl.studentshenchman.utils.dialog.UserYesNoDialog;
import edu.p.lodz.pl.studentshenchman.utils.dialog.event.DialogEvent;
import edu.p.lodz.pl.studentshenchman.utils.dialog.factory.DialogFactory;
import edu.p.lodz.pl.studentshenchman.utils.dialog.interfaces.AlertDialogCallback;

import static edu.p.lodz.pl.studentshenchman.utils.dialog.helper.UniqueYesNoDialogTAG.DELETE_NOTE_TAG;

/**
 * Created by Michał on 2016-11-06.
 */

public class AlertDialogHelper {
	private static final String TAG = AlertDialogHelper.class.getName();

	public static void showErrorDialog(String title, String message) {
		DialogEvent event = new DialogEvent(title, message, TAG, null, DialogType.USER_ERROR);
		EventBus.getDefault().postSticky(event);
	}

	public static void showInfoDialog(String title, String message) {
		DialogEvent event = new DialogEvent(title, message, TAG, null, DialogType.USER_INFO);
		EventBus.getDefault().postSticky(event);
	}

	public static void showSuccessDialog(String title, String message) {
		DialogEvent event = new DialogEvent(title, message, TAG, null, DialogType.USER_SUCCESS);
		EventBus.getDefault().postSticky(event);
	}

	public static void showYesNoDialog(String title, String message, AlertDialogCallback callback, String dialogTAG) {
		DialogEvent event = new DialogEvent(title, message, dialogTAG, callback, DialogType.YES_NO);
		EventBus.getDefault().postSticky(event);
	}

	public static void showDialog(String title, String message, DialogType dialogType) {
		DialogEvent event = new DialogEvent(title, message, TAG, null, dialogType);
		EventBus.getDefault().postSticky(event);

	}

	public static void showDialog(FragmentManager fm, DialogEvent event) {
		DialogFragment dialog = DialogFactory.produceDialog(event.getTitle(), event.getMessage(), event.getDialogType(), event.getCallback());
		dialog.show(fm, event.getTAG());
	}


	public static void readjustYesNoCallback(FragmentManager fm, AlertDialogCallback callback, String dialogTAG) {
		UserYesNoDialog yesNoDialog = (UserYesNoDialog) fm.findFragmentByTag(DELETE_NOTE_TAG);
		if (null != yesNoDialog) {
			Log.i(TAG, "Ponowne ustawienie callbacka do UserYesNoDialog dla tagu: " + dialogTAG);
			yesNoDialog.readjustCallback(callback);
		}
	}
}
