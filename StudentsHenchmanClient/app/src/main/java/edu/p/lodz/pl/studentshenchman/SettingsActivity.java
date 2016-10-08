package edu.p.lodz.pl.studentshenchman;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class SettingsActivity extends AppCompatActivity {

    /**
     * Metoda tworzy aktywnosc.
     */
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
