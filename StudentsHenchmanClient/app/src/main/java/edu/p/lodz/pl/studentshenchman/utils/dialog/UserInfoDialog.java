package edu.p.lodz.pl.studentshenchman.utils.dialog;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import edu.p.lodz.pl.studentshenchman.R;
import edu.p.lodz.pl.studentshenchman.utils.animation.AnimationHelper;

/**
 * Created by Michał on 2016-11-11.
 */

public class UserInfoDialog extends DialogFragment {
	private static final String TAG = UserInfoDialog.class.getName();

	private static final String TITLE = TAG + ":title";
	private static final String MESSAGE = TAG + "message";
	private Button mOkButton;
	private TextView mTitle;
	private TextView mMessage;
	private ImageView mIcon;

	public static UserInfoDialog getInstance(String title, String message) {
		UserInfoDialog dialog = new UserInfoDialog();
		Bundle bundle = new Bundle();
		bundle.putString(TITLE, title);
		bundle.putString(MESSAGE, message);
		dialog.setArguments(bundle);
		return dialog;
	}

	@Nullable
	@Override
	public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		getDialog().requestWindowFeature(STYLE_NO_TITLE);
		return inflater.inflate(R.layout.user_dialog_fragment, container);
	}

	@Override
	public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);

		mOkButton = (Button) view.findViewById(R.id.button);
		mOkButton.setOnClickListener(new OkOnClickListener());

		mIcon = (ImageView) view.findViewById(R.id.icon);
		mTitle = (TextView) view.findViewById(R.id.title);
		mMessage = (TextView) view.findViewById(R.id.message);

		Bundle b = getArguments();
		mTitle.setText(b.getString(TITLE));
		mMessage.setText(b.getString(MESSAGE));
		mIcon.setImageResource(R.drawable.about_app_icon);

	}

	@Override
	public void onStart() {
		super.onStart();

		final View decorView = getDialog()
				.getWindow()
				.getDecorView();

		AnimationHelper.startFallAnimation(decorView);
	}


	private class OkOnClickListener implements View.OnClickListener {
		@Override
		public void onClick(View v) {
			dismiss();
		}
	}
}
