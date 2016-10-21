package edu.p.lodz.pl.studentshenchman.settings.controller;

import android.content.Context;

/**
 * @author Michal Warcholinski
 */
public class SettingsController {
	private static final String TAG = SettingsController.class.getName();

	private static SettingsController mInstance;

	private final Context mContext;

	public static SettingsController getInstance(Context context) {
		if (null == mInstance)
			mInstance = new SettingsController(context);

		return mInstance;
	}

	private SettingsController(Context context) {
		mContext = context;
	}
}
