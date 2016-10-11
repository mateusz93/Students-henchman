package edu.p.lodz.pl.studentshenchman;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import edu.p.lodz.pl.studentshenchman.abstract_ui.StudentShenchmanMainActivity;

public class SaveDataActivity extends StudentShenchmanMainActivity {
    private static final String TAG = SaveDataActivity.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_save_data);
    }

    @Override
    public void onBackPressed() {
        goToDashBoard();
    }

    private void goToDashBoard() {
        Intent previousActivity = new Intent(SaveDataActivity.this, MainActivity.class);
        finish();
        startActivity(previousActivity);
    }

}
