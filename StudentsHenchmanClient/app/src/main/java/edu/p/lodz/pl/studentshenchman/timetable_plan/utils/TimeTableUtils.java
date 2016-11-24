package edu.p.lodz.pl.studentshenchman.timetable_plan.utils;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import edu.p.lodz.pl.studentshenchman.database.DatabaseHelper;
import edu.p.lodz.pl.studentshenchman.database.models.Course;
import edu.p.lodz.pl.studentshenchman.database.models.DeanGroup;
import edu.p.lodz.pl.studentshenchman.database.models.Note;
import edu.p.lodz.pl.studentshenchman.database.models.Teacher;
import edu.p.lodz.pl.studentshenchman.utils.SelectedCourseContext;

/**
 * Created by Michał on 2016-11-12.
 */

public class TimeTableUtils {

	public static SelectedCourseContext createCourseContext(Context context, long internalCourseId) {
		SQLiteDatabase db = DatabaseHelper.getInstance(context).getReadableDatabase();
		SelectedCourseContext selectedCourseContext = new SelectedCourseContext();
		Course course = new Course();
		Teacher teacher = new Teacher();
		DeanGroup deanGroup = new DeanGroup();

		Cursor c = db.query(Course.TABLE_NAME, null, Course._ID + "=?", new String[]{internalCourseId + ""}, null, null, null);
		if (c.moveToFirst()) {
			course = new Course(c);
		}
		/*c = db.query(Room.TABLE_NAME, null, Room.EXTERNAL_ROOM_ID + "=?", new String[]{course.getExternalRoomId() + ""}, null, null, null);
		Room room = Room.fromCursor2Room(c);*/

		/*c = db.query(Build.TABLE_NAME, null, Build.EXTERNAL_BUILD_ID + "=?", new String[]{room.getExternalBuildId() + ""}, null, null, null);
		Build build = Build.fromCursor2Build(c);*/

		c = db.query(Teacher.TABLE_NAME, null, Teacher.EXTERNAL_TEACHER_ID + "=?", new String[]{course.getExternalTeacherId() + ""}, null, null, null);
		if (c.moveToFirst()) {
			teacher = new Teacher(c);
		}
		c = db.query(DeanGroup.TABLE_NAME, null, DeanGroup.EXTERNAL_DEAN_GROUP_ID + "=?", new String[]{course.getExternalDeanGroupId() + ""}, null, null, null);
		if (c.moveToFirst()) {
			deanGroup = new DeanGroup(c);
		}

		c.close();

		selectedCourseContext.setCourseId(internalCourseId);
		selectedCourseContext.setCourseExternalId(course.getExternalId());
		selectedCourseContext.setCourseName(course.getName());
		selectedCourseContext.setCourseType("unknown");
		selectedCourseContext.setTeacher(teacher.getName());
		selectedCourseContext.setRoomName("unknown");
		selectedCourseContext.setBuildName("unknown");
		selectedCourseContext.setLatitude(0.0);
		selectedCourseContext.setLongitude(0.0);
		selectedCourseContext.setGroupName(deanGroup.getName());
		selectedCourseContext.setGroupAbbreviation(deanGroup.getAbbreviation());
		selectedCourseContext.setTime(course.getTime());

		return selectedCourseContext;
	}

	public static void addNoteToDB(Context context, long courseId, String content, long activationDate) {
		SQLiteDatabase db = DatabaseHelper.getInstance(context).getWritableDatabase();
		ContentValues cv = new ContentValues();
		cv.put(Note.COURSE_ID, courseId);
		cv.put(Note.EXTERNAL_COURSE_ID, getExternalCourseIdByInternalCourseId(context, courseId));
		cv.put(Note.CONTENT, content);
		cv.put(Note.ACTIVATION_DATE, activationDate);
		cv.put(Note.IS_SYNCH, 0);
		db.insert(Note.TABLE_NAME, null, cv);
	}

	public static List<Note> loadNotesForCourse(Context context, long internalCourseId) {
		SQLiteDatabase db = DatabaseHelper.getInstance(context).getReadableDatabase();
		List<Note> notes = new ArrayList<>();
		Cursor c = db.query(Note.TABLE_NAME, null, Note.COURSE_ID + "=?", new String[]{internalCourseId + ""}, null, null, Note.ACTIVATION_DATE + " ASC");
		while (c.moveToNext()) {
			Note note = new Note(c);
			notes.add(note);
		}
		c.close();

		return notes;
	}

	public static void deleteNoteById(Context context, long internalNoteId) {
		SQLiteDatabase db = DatabaseHelper.getInstance(context).getReadableDatabase();

		db.delete(Note.TABLE_NAME, Note._ID + "=?", new String[]{internalNoteId + ""});

	}

	public static long getExternalCourseIdByInternalCourseId(Context context, long internalCourseId) {
		SQLiteDatabase db = DatabaseHelper.getInstance(context).getReadableDatabase();
		long externalCourseId = Long.MIN_VALUE;

		Cursor c = db.query(Course.TABLE_NAME, null, Course._ID + "=?", new String[]{internalCourseId + ""}, null, null, null);
		if (c.moveToFirst()) {
			externalCourseId = c.getLong(c.getColumnIndexOrThrow(Course.EXTERNAL_COURSE_ID));
		}

		return externalCourseId;
	}
}
