package edu.p.lodz.pl.studentshenchman;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TableRow;

import edu.p.lodz.pl.studentshenchman.abstract_ui.StudentShenchmanMainActivity;

public class ReadDataActivity extends StudentShenchmanMainActivity {
    private static final String TAG = ReadDataActivity.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_data);

        final TableRow tokenValueTableRow = (TableRow) findViewById(R.id.tokenValueTableRow);

        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.tokenRadioGroup);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.tokenAvailable) {
                    tokenValueTableRow.setVisibility(View.VISIBLE);
                } else if (checkedId == R.id.tokenNotAvailable) {
                    tokenValueTableRow.setVisibility(View.GONE);
                }
            }
        });

    }

    @Override
    public void onBackPressed() {
        goToDashBoard();
    }

    private void goToDashBoard() {
        Intent previousActivity = new Intent(ReadDataActivity.this, MainActivity.class);
        finish();
        startActivity(previousActivity);
    }

}
