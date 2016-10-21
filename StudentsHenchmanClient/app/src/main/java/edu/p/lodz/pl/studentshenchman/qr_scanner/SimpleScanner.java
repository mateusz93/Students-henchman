package edu.p.lodz.pl.studentshenchman.qr_scanner;

import android.os.Bundle;
import android.util.Log;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.widget.Toast;
import com.google.zxing.Result;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;

import edu.p.lodz.pl.studentshenchman.utils.AlertDialogActivity;
import edu.p.lodz.pl.studentshenchman.classes.Information;
import me.dm7.barcodescanner.zxing.ZXingScannerView;

import static edu.p.lodz.pl.studentshenchman.workers.IdleWorker.TAG;

public class SimpleScanner extends FragmentActivity implements ZXingScannerView.ResultHandler {
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
        Log.v(TAG, "onResume");
        mScannerView.setResultHandler(this);
        mScannerView.startCamera();
    }

    @Override
    public void onPause() {
        Log.v(TAG, "onPause");
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
            args.putString("text",formattedText);
            alertDialogActivity.setArguments(args);
            alertDialogActivity.show(fm, formattedText);
        } catch (IOException e) {
            Toast.makeText(getApplicationContext(), "Nieobsługiwany komunikat!", Toast.LENGTH_SHORT).show();
        }
        mScannerView.resumeCameraPreview(this);
    }
}
