package edu.p.lodz.pl.studentshenchman.utils.dialog.event;

import edu.p.lodz.pl.studentshenchman.utils.dialog.helper.DialogType;
import edu.p.lodz.pl.studentshenchman.utils.dialog.interfaces.AlertDialogCallback;

/**
 * Created by Michał on 2016-11-15.
 */

public class DialogEvent {
	private String title;
	private String message;
	private String TAG;
	private AlertDialogCallback callback;
	private DialogType dialogType;

	public DialogEvent() {
	}

	public DialogEvent(String title, String message, String TAG, AlertDialogCallback callback, DialogType dialogType) {
		this.title = title;
		this.message = message;
		this.TAG = TAG;
		this.callback = callback;
		this.dialogType = dialogType;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getTAG() {
		return TAG;
	}

	public void setTAG(String TAG) {
		this.TAG = TAG;
	}

	public AlertDialogCallback getCallback() {
		return callback;
	}

	public void setCallback(AlertDialogCallback callback) {
		this.callback = callback;
	}

	public DialogType getDialogType() {
		return dialogType;
	}

	public void setDialogType(DialogType dialogType) {
		this.dialogType = dialogType;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		DialogEvent that = (DialogEvent) o;

		if (title != null ? !title.equals(that.title) : that.title != null) return false;
		if (message != null ? !message.equals(that.message) : that.message != null) return false;
		if (TAG != null ? !TAG.equals(that.TAG) : that.TAG != null) return false;
		if (callback != null ? !callback.equals(that.callback) : that.callback != null)
			return false;
		return dialogType == that.dialogType;

	}

	@Override
	public int hashCode() {
		int result = title != null ? title.hashCode() : 0;
		result = 31 * result + (message != null ? message.hashCode() : 0);
		result = 31 * result + (TAG != null ? TAG.hashCode() : 0);
		result = 31 * result + (callback != null ? callback.hashCode() : 0);
		result = 31 * result + (dialogType != null ? dialogType.hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return "DialogEvent{" +
				"title='" + title + '\'' +
				", message='" + message + '\'' +
				", TAG='" + TAG + '\'' +
				", callback=" + callback +
				", dialogType=" + dialogType +
				'}';
	}
}
