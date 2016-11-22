package edu.p.lodz.pl.studentshenchman.utils.dialog.factory;

import android.support.v4.app.DialogFragment;
import android.util.Log;

import edu.p.lodz.pl.studentshenchman.utils.dialog.helper.DialogType;
import edu.p.lodz.pl.studentshenchman.utils.dialog.UserErrorDialog;
import edu.p.lodz.pl.studentshenchman.utils.dialog.UserInfoDialog;
import edu.p.lodz.pl.studentshenchman.utils.dialog.UserSuccessDialog;
import edu.p.lodz.pl.studentshenchman.utils.dialog.UserYesNoDialog;
import edu.p.lodz.pl.studentshenchman.utils.dialog.interfaces.AlertDialogCallback;

/**
 * Created by Michał on 2016-11-12.
 */

public class DialogFactory {
	private static final String TAG = DialogFactory.class.getName();

	public static DialogFragment produceDialog(String title, String message, DialogType dialogType, AlertDialogCallback callback) {
		Log.i(TAG, "Tworzenie dialog fragmentu: tytul: " + title + " wiadomosc: " + message + " typ: " + dialogType.name());
		switch (dialogType) {
			case USER_INFO:
				return UserInfoDialog.getInstance(title, message);
			case USER_ERROR:
				return UserErrorDialog.getInstance(title, message);
			case USER_SUCCESS:
				return UserSuccessDialog.getInstance(title, message);
			case YES_NO:
				return UserYesNoDialog.getInstance(callback, title, message);
			default:
				throw new IllegalArgumentException("Unknown dialog type");
		}
	}
}
