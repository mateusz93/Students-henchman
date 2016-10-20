package edu.p.lodz.pl.studentshenchman;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
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
                    .setPositiveButton("Szczegóły", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            // tutaj logika do przejścia na nowe activity ze szczegółami
                        }
                    })
                    .setNegativeButton("Powrót", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog,	int which) {
                        }
                    }).create();
        }
}
