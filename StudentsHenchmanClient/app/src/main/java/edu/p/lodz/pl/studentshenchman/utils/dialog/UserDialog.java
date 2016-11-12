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

/**
 * Created by Michał on 2016-11-11.
 */

public class UserDialog extends DialogFragment {
	private static final String TAG = UserDialog.class.getName();

	private static final String TITLE = TAG + ":title";
	private static final String MESSAGE = TAG + "message";
	private Button mOkButton;
	private TextView mTitle;
	private TextView mMessage;
	private ImageView mIcon;

	public static UserDialog getInstance(String title, String message) {
		UserDialog dialog = new UserDialog();
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

		android.animation.AnimatorSet animatorSet = new android.animation.AnimatorSet();
		android.animation.ObjectAnimator objectAnimator = android.animation.ObjectAnimator.ofFloat(decorView, "scaleX", 2, 1.5f, 1).setDuration(600);
		android.animation.ObjectAnimator objectAnimator2 = android.animation.ObjectAnimator.ofFloat(decorView, "scaleY", 2, 1.5f, 1).setDuration(600);
		android.animation.ObjectAnimator objectAnimator3 = android.animation.ObjectAnimator.ofFloat(decorView, "alpha", 0, 1).setDuration(600);
		animatorSet.playTogether(objectAnimator, objectAnimator2, objectAnimator3);

		animatorSet.start();

	}


	private class OkOnClickListener implements View.OnClickListener {
		@Override
		public void onClick(View v) {
			dismiss();
		}
	}
}
