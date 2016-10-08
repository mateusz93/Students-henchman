package edu.p.lodz.pl.studentshenchman;

import android.content.Intent;
import android.os.Bundle;

import edu.p.lodz.pl.studentshenchman.abstract_ui.StudentShenchmanMainActivity;

public class SettingsActivity extends StudentShenchmanMainActivity {
    private static final String TAG = SettingsActivity.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
    }

    @Override
    public void onBackPressed() {
        goToDashBoard();
    }

    private void goToDashBoard() {
        Intent previousActivity = new Intent(SettingsActivity.this, MainActivity.class);
        finish();
        startActivity(previousActivity);
    }

}
