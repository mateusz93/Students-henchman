package edu.p.lodz.pl.studentshenchman.login.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import edu.p.lodz.pl.studentshenchman.R;
import edu.p.lodz.pl.studentshenchman.dashboard.DashboardActivity;
import edu.p.lodz.pl.studentshenchman.login.utils.LoginManager;

/**
 * @author Michal Warcholinski
 */
public class LoginActivity extends AppCompatActivity {
	private static final String TAG = LoginActivity.class.getName();

	private Button mLoginButton;
	private Button mClearButton;
	private EditText mLogin;
	private EditText mPassword;
	private CheckBox mRememberMe;

	private SharedPreferences mSharedPreferences;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_login);
		mSharedPreferences = getSharedPreferences(TAG, MODE_PRIVATE);

		mLogin = (EditText) findViewById(R.id.login);
		mLogin.addTextChangedListener(new LoginWatcher());
		mPassword = (EditText) findViewById(R.id.password);
		mPassword.addTextChangedListener(new PasswordWatcher());
		mRememberMe = (CheckBox) findViewById(R.id.remember_me);

		mLoginButton = (Button) findViewById(R.id.login_button);
		mLoginButton.setOnClickListener((view) ->
		{
//			if (mLogin.getText().toString().equals("mobile@") && mPassword.getText().toString().equals("mobile")) {
//				goToDashboard();
//			}
			if (mRememberMe.isChecked()) {
				LoginManager.getInstance().saveRememberMeChoose(true).saveUserEmail(mLogin.getText().toString());
			} else {
				LoginManager.getInstance().saveRememberMeChoose(false).saveUserEmail("");
			}
			goToDashboard();
		});

		mClearButton = (Button) findViewById(R.id.clear_button);
		mClearButton.setOnClickListener((view) -> {
			mLogin.setText("");
			mPassword.setText("");
		});

		boolean rememberMe = LoginManager.getInstance().getRememberMeChoose();
		if (rememberMe) {
			mRememberMe.setChecked(true);
			String email = LoginManager.getInstance().getUserEmail();
			mLogin.setText(email);
		}

	}

	private void goToDashboard() {
		Intent intent = new Intent(LoginActivity.this, DashboardActivity.class);
		finish();
		startActivity(intent);
	}

	private class LoginWatcher implements TextWatcher {
		@Override
		public void beforeTextChanged(CharSequence s, int start, int count, int after) {

		}

		@Override
		public void onTextChanged(CharSequence s, int start, int before, int count) {

		}

		@Override
		public void afterTextChanged(Editable s) {
			if (mLogin.getText().toString().trim().length() < 6)
				mLogin.setError(getString(R.string.login_at_least_six_sign));
			else if (!mLogin.getText().toString().trim().contains("@"))
				mLogin.setError("Niepoprawny format loginu");
		}
	}

	private class PasswordWatcher implements TextWatcher {
		@Override
		public void beforeTextChanged(CharSequence s, int start, int count, int after) {

		}

		@Override
		public void onTextChanged(CharSequence s, int start, int before, int count) {

		}

		@Override
		public void afterTextChanged(Editable s) {
			if (mPassword.getText().toString().trim().isEmpty())
				mPassword.setError(getString(R.string.password_required));
			else if (mPassword.getText().toString().trim().length() < 6)
				mPassword.setError(getString(R.string.login_at_least_six_sign));
		}
	}
}
