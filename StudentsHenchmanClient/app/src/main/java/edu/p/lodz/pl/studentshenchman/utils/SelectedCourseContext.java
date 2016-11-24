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
	private String groupName;
	private String groupAbbreviation;
	private String time;

	public SelectedCourseContext() {
	}

	public SelectedCourseContext(long courseId, long courseExternalId, String courseName, String courseType, String teacher,
	                             String roomName, String buildName, double latitude, double longitude, String groupName, String groupAbbreviation, String time) {
		this.courseId = courseId;
		this.courseExternalId = courseExternalId;
		this.courseName = courseName;
		this.courseType = courseType;
		this.teacher = teacher;
		this.roomName = roomName;
		this.buildName = buildName;
		this.latitude = latitude;
		this.longitude = longitude;
		this.groupName = groupName;
		this.groupAbbreviation = groupAbbreviation;
		this.time = time;
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
		groupName = in.readString();
		groupAbbreviation = in.readString();
		time = in.readString();
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
		dest.writeString(groupName);
		dest.writeString(groupAbbreviation);
		dest.writeString(time);
	}

	public long getCourseId() {
		return courseId;
	}

	public void setCourseId(long courseId) {
		this.courseId = courseId;
	}

	public long getCourseExternalId() {
		return courseExternalId;
	}

	public void setCourseExternalId(long courseExternalId) {
		this.courseExternalId = courseExternalId;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getCourseType() {
		return courseType;
	}

	public void setCourseType(String courseType) {
		this.courseType = courseType;
	}

	public String getTeacher() {
		return teacher;
	}

	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}

	public String getRoomName() {
		return roomName;
	}

	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}

	public String getBuildName() {
		return buildName;
	}

	public void setBuildName(String buildName) {
		this.buildName = buildName;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public String getGroupAbbreviation() {
		return groupAbbreviation;
	}

	public void setGroupAbbreviation(String groupAbbreviation) {
		this.groupAbbreviation = groupAbbreviation;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		SelectedCourseContext that = (SelectedCourseContext) o;

		if (courseId != that.courseId) return false;
		if (courseExternalId != that.courseExternalId) return false;
		if (Double.compare(that.latitude, latitude) != 0) return false;
		if (Double.compare(that.longitude, longitude) != 0) return false;
		if (courseName != null ? !courseName.equals(that.courseName) : that.courseName != null)
			return false;
		if (courseType != null ? !courseType.equals(that.courseType) : that.courseType != null)
			return false;
		if (teacher != null ? !teacher.equals(that.teacher) : that.teacher != null) return false;
		if (roomName != null ? !roomName.equals(that.roomName) : that.roomName != null)
			return false;
		if (buildName != null ? !buildName.equals(that.buildName) : that.buildName != null)
			return false;
		if (groupName != null ? !groupName.equals(that.groupName) : that.groupName != null)
			return false;
		if (groupAbbreviation != null ? !groupAbbreviation.equals(that.groupAbbreviation) : that.groupAbbreviation != null)
			return false;
		return time != null ? time.equals(that.time) : that.time == null;

	}

	@Override
	public int hashCode() {
		int result;
		long temp;
		result = (int) (courseId ^ (courseId >>> 32));
		result = 31 * result + (int) (courseExternalId ^ (courseExternalId >>> 32));
		result = 31 * result + (courseName != null ? courseName.hashCode() : 0);
		result = 31 * result + (courseType != null ? courseType.hashCode() : 0);
		result = 31 * result + (teacher != null ? teacher.hashCode() : 0);
		result = 31 * result + (roomName != null ? roomName.hashCode() : 0);
		result = 31 * result + (buildName != null ? buildName.hashCode() : 0);
		temp = Double.doubleToLongBits(latitude);
		result = 31 * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(longitude);
		result = 31 * result + (int) (temp ^ (temp >>> 32));
		result = 31 * result + (groupName != null ? groupName.hashCode() : 0);
		result = 31 * result + (groupAbbreviation != null ? groupAbbreviation.hashCode() : 0);
		result = 31 * result + (time != null ? time.hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return "SelectedCourseContext{" +
				"courseId=" + courseId +
				", courseExternalId=" + courseExternalId +
				", courseName='" + courseName + '\'' +
				", courseType='" + courseType + '\'' +
				", teacher='" + teacher + '\'' +
				", roomName='" + roomName + '\'' +
				", buildName='" + buildName + '\'' +
				", latitude=" + latitude +
				", longitude=" + longitude +
				", groupName='" + groupName + '\'' +
				", groupAbbreviation='" + groupAbbreviation + '\'' +
				'}';
	}
}
