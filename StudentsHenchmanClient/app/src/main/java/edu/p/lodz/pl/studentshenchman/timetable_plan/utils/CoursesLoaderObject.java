package edu.p.lodz.pl.studentshenchman.timetable_plan.utils;

/**
 * Created by Michał on 2016-11-20.
 */

public class CoursesLoaderObject {

	private long courseId;
	private long externalCourseId;
	private String CourseName;
	private String time;
	private String teacherName;
	private String deanGroupName;

	public long getCourseId() {
		return courseId;
	}

	public void setCourseId(long courseId) {
		this.courseId = courseId;
	}

	public long getExternalCourseId() {
		return externalCourseId;
	}

	public void setExternalCourseId(long externalCourseId) {
		this.externalCourseId = externalCourseId;
	}

	public String getCourseName() {
		return CourseName;
	}

	public void setCourseName(String courseName) {
		CourseName = courseName;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getTeacherName() {
		return teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}

	public String getDeanGroupName() {
		return deanGroupName;
	}

	public void setDeanGroupName(String deanGroupName) {
		this.deanGroupName = deanGroupName;
	}
}
