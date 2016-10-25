package edu.p.lodz.pl.studentshenchman.utils;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Michał on 2016-10-25.
 */

public class SelectedCourseContext implements Parcelable {

	private long courseId;
	private long courseExternalId;
	private String courseName;
	private String courseType;
	private String teacher;
	private String roomName;
	private String buildName;
	private double latitude;
	private double longitude;

	public SelectedCourseContext() {
	}

	public SelectedCourseContext(long courseId, long courseExternalId, String courseName, String courseType, String teacher,
	                             String roomName, String buildName, double latitude, double longitude) {
		this.courseId = courseId;
		this.courseExternalId = courseExternalId;
		this.courseName = courseName;
		this.courseType = courseType;
		this.teacher = teacher;
		this.roomName = roomName;
		this.buildName = buildName;
		this.latitude = latitude;
		this.longitude = longitude;
	}

	protected SelectedCourseContext(Parcel in) {
		courseId = in.readLong();
		courseExternalId = in.readLong();
		courseName = in.readString();
		courseType = in.readString();
		teacher = in.readString();
		roomName = in.readString();
		buildName = in.readString();
		latitude = in.readDouble();
		longitude = in.readDouble();
	}

	public static final Creator<SelectedCourseContext> CREATOR = new Creator<SelectedCourseContext>() {
		@Override
		public SelectedCourseContext createFromParcel(Parcel in) {
			return new SelectedCourseContext(in);
		}

		@Override
		public SelectedCourseContext[] newArray(int size) {
			return new SelectedCourseContext[size];
		}
	};

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeLong(courseId);
		dest.writeLong(courseExternalId);
		dest.writeString(courseName);
		dest.writeString(courseType);
		dest.writeString(teacher);
		dest.writeString(roomName);
		dest.writeString(buildName);
		dest.writeDouble(latitude);
		dest.writeDouble(longitude);
	}
}
