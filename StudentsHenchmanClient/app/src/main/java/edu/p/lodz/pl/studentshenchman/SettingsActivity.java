package edu.p.lodz.pl.studentshenchman;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SettingsActivity extends AppCompatActivity {

    /**
     * Metoda tworzy aktywnosc.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
    }

    /**
     * Metoda niszczy aktywnosc.
     */
    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    /**
     * Metoda dzialajaca w trakcie aplikacji.
     */
    @Override
    protected void onPause() {
        super.onPause();
    }

    /**
     * Metoda dzialajaca w trakcie aplikacji.
     */
    @Override
    protected void onResume() {
        super.onResume();
    }

    /**
     * Metoda przywracajace procesi i czynnosci, ktore zostaly zatrzymane przez wywolanie onStop().
     */
    @Override
    protected void onStart() {
        super.onStart();
    }

    /**
     * Metoda dzialajaca w trakcie aplikacji.
     */
    @Override
    protected void onRestart() {
        super.onRestart();
    }

    /**
     * Metoda zatrzymuje kazda aktywnosc, dotyczy to interfejsu, animacji, watkow i serwisow.
     */
    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    public void onBackPressed()
    {
        Intent previousActivity = new Intent(SettingsActivity.this, MainActivity.class);
        finish();
        startActivity(previousActivity);
    }
}
