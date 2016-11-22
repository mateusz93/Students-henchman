package edu.p.lodz.pl.studentshenchman.utils;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;

/**
 * Created by marcin on 20.10.16.
 */

public class AlertDialogActivity extends DialogFragment {
	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {
		return new AlertDialog.Builder(getActivity())
				.setTitle("Ogólne informacje")
				.setMessage(getArguments().getString("text"))
				.setPositiveButton("Szczegóły", (dialog, which) -> {

				})
				.setNegativeButton("Powrót", (dialog, which) -> {

				}).create();
	}
}
