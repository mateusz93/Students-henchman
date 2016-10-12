package edu.p.lodz.pl.studentshenchman;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import edu.p.lodz.pl.studentshenchman.abstract_ui.StudentShenchmanMainActivity;

public class QRCodeScanActivity extends StudentShenchmanMainActivity {
    private static final String TAG = QRCodeScanActivity.class.getName();

    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qrcode_scan);

        toolbar = (Toolbar) findViewById(R.id.tool_bar);
        prepareToolbar();
    }

    private void prepareToolbar() {
        setSupportActionBar(toolbar);
        if (null != getSupportActionBar()) {
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            getSupportActionBar().setDisplayUseLogoEnabled(true);
            getSupportActionBar().setHomeButtonEnabled(true);
        }
    }

    @Override
    public void onBackPressed() {
        goToDashboard();
    }

    private void goToDashboard() {
        Intent previousActivity = new Intent(QRCodeScanActivity.this, MainActivity.class);
        finish();
        startActivity(previousActivity);
    }
}
