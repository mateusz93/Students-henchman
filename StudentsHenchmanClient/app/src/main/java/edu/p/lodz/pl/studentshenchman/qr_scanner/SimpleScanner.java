package edu.p.lodz.pl.studentshenchman.qr_scanner;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.widget.Toast;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.zxing.Result;

import java.io.IOException;

import edu.p.lodz.pl.studentshenchman.qr_scanner.classes.Information;
import edu.p.lodz.pl.studentshenchman.dashboard.DashboardActivity;
import edu.p.lodz.pl.studentshenchman.utils.AlertDialogActivity;
import edu.p.lodz.pl.studentshenchman.utils.dialog.helper.AlertDialogHelper;
import me.dm7.barcodescanner.zxing.ZXingScannerView;

public class SimpleScanner extends FragmentActivity implements ZXingScannerView.ResultHandler {
	private static final String TAG = SimpleScanner.class.getName();

	private ZXingScannerView mScannerView;
	FragmentManager fm = getSupportFragmentManager();

	@Override
	public void onCreate(Bundle state) {
		super.onCreate(state);
		mScannerView = new ZXingScannerView(this);
		setContentView(mScannerView);
	}

	@Override
	public void onResume() {
		super.onResume();
		mScannerView.setResultHandler(this);
		mScannerView.startCamera();
	}

	@Override
	public void onPause() {
		super.onPause();
		mScannerView.stopCamera();
	}

	@Override
	public void handleResult(Result rawResult) {
		Log.v(TAG, rawResult.getText());
		Log.v(TAG, rawResult.getBarcodeFormat().toString());
		ObjectMapper mapper = new ObjectMapper();
		try {
			Information information = mapper.readValue(rawResult.getText(), Information.class);
			String formattedText = Information.getFormattedFields(information);
			AlertDialogActivity alertDialogActivity = new AlertDialogActivity();
			Bundle args = new Bundle();
			args.putString("text", formattedText);
			alertDialogActivity.setArguments(args);
			alertDialogActivity.show(fm, formattedText);
		} catch (IOException e) {
			Log.i(TAG, e.toString());
			AlertDialogHelper.showErrorDialog("QR error", "Wystapil blad podczas skanowania QR kodu");

		}
		mScannerView.resumeCameraPreview(this);
	}

	@Override
	public void onBackPressed() {
		goToDashboard();
	}

	private void goToDashboard() {
		Intent previousActivity = new Intent(SimpleScanner.this, DashboardActivity.class);
		finish();
		startActivity(previousActivity);
	}
}
