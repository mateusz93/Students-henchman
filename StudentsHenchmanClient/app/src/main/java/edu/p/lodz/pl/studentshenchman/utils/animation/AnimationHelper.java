package edu.p.lodz.pl.studentshenchman.utils.animation;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.View;

/**
 * Created by Michał on 2016-11-12.
 */

public class AnimationHelper {

	public static void startFallAnimation(View target) {
		AnimatorSet animatorSet = new AnimatorSet();

		animatorSet.playTogether(
				ObjectAnimator.ofFloat(target, "scaleX", 2, 1.5f, 1).setDuration(600),
				ObjectAnimator.ofFloat(target, "scaleY", 2, 1.5f, 1).setDuration(600),
				ObjectAnimator.ofFloat(target, "alpha", 0, 1).setDuration(600));

		animatorSet.start();
	}

	public static void startSlideBottomAnimation(View target) {
		AnimatorSet animatorSet = new AnimatorSet();

		animatorSet.playTogether(
				ObjectAnimator.ofFloat(target, "translationY", 300, 0).setDuration(600),
				ObjectAnimator.ofFloat(target, "alpha", 0, 1).setDuration(600 * 3 / 2));

		animatorSet.start();
	}


	public static void startSlideTopAnimation(View target) {
		AnimatorSet animatorSet = new AnimatorSet();

		animatorSet.playTogether(
				ObjectAnimator.ofFloat(target, "translationY", -300, 0).setDuration(600),
				ObjectAnimator.ofFloat(target, "alpha", 0, 1).setDuration(600 * 3 / 2));

		animatorSet.start();
	}

	public static void startShockAnimation(View target) {
		AnimatorSet animatorSet = new AnimatorSet();

		animatorSet.playTogether(
				ObjectAnimator.ofFloat(target, "translationX", 0, .10f, -25, .26f, 25, .42f, -25, .58f, 25, .74f, -25, .90f, 1, 0).setDuration(600));

		animatorSet.start();
	}
}
