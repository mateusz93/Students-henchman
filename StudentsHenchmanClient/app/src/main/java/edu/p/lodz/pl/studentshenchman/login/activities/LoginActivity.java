package edu.p.lodz.pl.studentshenchman.login.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;

import edu.p.lodz.pl.studentshenchman.R;
import edu.p.lodz.pl.studentshenchman.dashboard.DashboardActivity;

/**
 * @author Michal Warcholinski
 */
public class LoginActivity extends AppCompatActivity {
	private static final String TAG = LoginActivity.class.getName();

	private Button mLoginButton;
	private Button mClearButton;
	private EditText mLogin;
	private EditText mPassword;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_login);

		mLogin = (EditText) findViewById(R.id.login);
		mPassword = (EditText) findViewById(R.id.password);

		mLoginButton = (Button) findViewById(R.id.login_button);
		mLoginButton.setOnClickListener((view) ->
				goToDashboard()
		);

		mClearButton = (Button) findViewById(R.id.clear_button);
		mClearButton.setOnClickListener((view) -> {
			mLogin.setText("");
			mPassword.setText("");
		});
	}

	private void goToDashboard() {
		Intent intent = new Intent(LoginActivity.this, DashboardActivity.class);
		finish();
		startActivity(intent);
	}
}
