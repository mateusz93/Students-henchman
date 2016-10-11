package model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @Author Mateusz Wieczorek on 10/6/16.
 */
@Entity
@Table(name = "ZAJECIA")
public class Course implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "nazwa_przedmiotu")
    private String name;

    @Column(name = "ilosc_zajec")
    private int quantity;

    @Column(name = "cykl")
    private int cycle;

    @Column(name = "pierwszy_tydzien_zajec")
    private int firstSubjectWeek;

    @Column(name = "dzien_tygodnia")
    private int weekDay;

    @Column(name = "godzina")
    private int time;

    @Column(name = "czas_trwania")
    private int duration;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_prowadzacego")
    private Teacher teacher;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_sali")
    private Room room;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_typu_zajec")
    private CourseType courseType;

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getCycle() {
        return cycle;
    }

    public void setCycle(int cycle) {
        this.cycle = cycle;
    }

    public int getFirstSubjectWeek() {
        return firstSubjectWeek;
    }

    public void setFirstSubjectWeek(int firstSubjectWeek) {
        this.firstSubjectWeek = firstSubjectWeek;
    }

    public int getWeekDay() {
        return weekDay;
    }

    public void setWeekDay(int weekDay) {
        this.weekDay = weekDay;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public CourseType getCourseType() {
        return courseType;
    }

    public void setCourseType(CourseType courseType) {
        this.courseType = courseType;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Course course = (Course) o;

        if (id != course.id) return false;
        if (quantity != course.quantity) return false;
        if (cycle != course.cycle) return false;
        if (firstSubjectWeek != course.firstSubjectWeek) return false;
        if (weekDay != course.weekDay) return false;
        if (time != course.time) return false;
        if (duration != course.duration) return false;
        if (!name.equals(course.name)) return false;
        if (!teacher.equals(course.teacher)) return false;
        if (!room.equals(course.room)) return false;
        return courseType.equals(course.courseType);

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + name.hashCode();
        result = 31 * result + quantity;
        result = 31 * result + cycle;
        result = 31 * result + firstSubjectWeek;
        result = 31 * result + weekDay;
        result = 31 * result + time;
        result = 31 * result + duration;
        result = 31 * result + teacher.hashCode();
        result = 31 * result + room.hashCode();
        result = 31 * result + courseType.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", quantity=" + quantity +
                ", cycle=" + cycle +
                ", firstSubjectWeek=" + firstSubjectWeek +
                ", weekDay=" + weekDay +
                ", time=" + time +
                ", duration=" + duration +
                ", teacher=" + teacher +
                ", room=" + room +
                ", courseType=" + courseType +
                '}';
    }
}
