package edu.p.lodz.pl.studentshenchman.login.utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Michał on 2016-11-21.
 */
public class LoginManager {
	private static final String TAG = LoginManager.class.getName();

	private static final String EMAIL_PREFERENCES_KEY = TAG + ":email";
	private static final String REMEMBER_ME_PREFERENCES_KEY = TAG + ":remember_me";

	private static LoginManager ourInstance;

	private Context mContext;
	private SharedPreferences mSharedPreferences;

	public static void initiate(Context context) {
		ourInstance = new LoginManager(context);
	}

	public static LoginManager getInstance() {
		return ourInstance;
	}

	private LoginManager(Context context) {
		mContext = context;
		mSharedPreferences = context.getSharedPreferences(TAG, Context.MODE_PRIVATE);
	}

	public String getUserEmail() {
		String email = mSharedPreferences.getString(EMAIL_PREFERENCES_KEY, "");

		return email;
	}

	public LoginManager saveUserEmail(String email) {
		mSharedPreferences.edit().putString(EMAIL_PREFERENCES_KEY, email).apply();

		return this;
	}

	public boolean getRememberMeChoose() {
		boolean rememberMeChoose = mSharedPreferences.getBoolean(REMEMBER_ME_PREFERENCES_KEY, false);

		return rememberMeChoose;
	}

	public LoginManager saveRememberMeChoose(boolean rememberMeChoose) {
		mSharedPreferences.edit().putBoolean(EMAIL_PREFERENCES_KEY, rememberMeChoose).apply();

		return this;
	}
}
