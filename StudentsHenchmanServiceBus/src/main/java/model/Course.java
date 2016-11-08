package model;

import javax.persistence.*;
import java.sql.Time;

/**
 * Created by Michał on 2016-10-18.
 */
@Entity
@Table(name = "COURSE")
public class Course {

    private long id;
    private long externalId;
    private String name;
    //private DeanGroup deanGroup;
    private String weekDay;
    //private Room room;
    //private Teacher teacher;
    private String teacherName;
    //private CourseType subjectType;
    //private Date date;
    private String weeks;
    //private Subject subject;
    private Time time;
    //private Time endTime;
    private String abbreviation;
    private String groupName;


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", unique = true, nullable = false)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "EXTERNAL_ID", nullable = false)
    public long getExternalId() {
        return externalId;
    }

    public void setExternalId(long externalId) {
        this.externalId = externalId;
    }

    @Column(name = "NAME", nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

   /* @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "DEAN_GROUP_ID", nullable = false)
    public DeanGroup getDeanGroup() {
        return deanGroup;
    }

    public void setDeanGroup(DeanGroup deanGroup) {
        this.deanGroup = deanGroup;
    }*/

    @Column(name = "DAY")
    public String getWeekDay() {
        return weekDay;
    }

    public void setWeekDay(String weekDay) {
        this.weekDay = weekDay;
    }

    @Column(name = "TEACHER_NAME")
    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    /* @ManyToOne(fetch = FetchType.EAGER)
             @JoinColumn(name = "ROOM_ID", nullable = false)
             public Room getRoom() {
                 return room;
             }

             public void setRoom(Room room) {
                 this.room = room;
             }

             @ManyToOne(fetch = FetchType.EAGER)
             @JoinColumn(name = "TEACHER_ID", nullable = false)
             public Teacher getTeacher() {
                 return teacher;
             }

             public void setTeacher(Teacher teacher) {
                 this.teacher = teacher;
             }
         */
   /* @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "SUBJECT_TYPE_ID", nullable = false)
    public CourseType getSubjectType() {
        return subjectType;
    }

    public void setSubjectType(CourseType subjectType) {
        this.subjectType = subjectType;
    }*/

    /*@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "DATE_ID", nullable = false)
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }*/

    @Column(name = "WEEKS", nullable = false)
    public String getWeeks() {
        return weeks;
    }

    public void setWeeks(String weeks) {
        this.weeks = weeks;
    }

    /*@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "SUBJECT_ID", nullable = false)
    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }*/

    @Column(name = "TIME", nullable = false)
    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

  /*  @Column(name = "END_TIME", nullable = false)
    public Time getEndTime() {
        return endTime;
    }

    public void setEndTime(Time endTime) {
        this.endTime = endTime;
    }
*/

    @Column(name = "ABBREVIATION")
    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    @Column(name = "GROUP_NAME")
    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }
}
