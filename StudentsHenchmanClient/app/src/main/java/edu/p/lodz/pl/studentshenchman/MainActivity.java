package edu.p.lodz.pl.studentshenchman;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    /**
     * Metoda tworzy aktywnosc.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        Intent anotherActivity;

        switch (item.getItemId())
        {
            case R.id.action_settings:
                anotherActivity = new Intent(MainActivity.this, SettingsActivity.class);
                finish();

                startActivity(anotherActivity);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
