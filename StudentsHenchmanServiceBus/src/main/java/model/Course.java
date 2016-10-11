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
    private long id;

    @Column(name = "nazwa_przedmiotu")
    private String name;

    @Column(name = "ilosc_zajec")
    private long quantity;

    @Column(name = "cykl")
    private long cycle;

    @Column(name = "pierwszy_tydzien_zajec")
    private long firstSubjectWeek;

    @Column(name = "dzien_tygodnia")
    private long weekDay;

    @Column(name = "godzina_rozpoczecia")
    private long startTime;

    @Column(name = "godzina_zakonczenia")
    private long finishTime;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_prowadzacego")
    private Teacher teacher;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_sali")
    private Room room;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_typu_zajec")
    private CourseType courseType;

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public long getQuantity() {
        return quantity;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }

    public long getCycle() {
        return cycle;
    }

    public void setCycle(long cycle) {
        this.cycle = cycle;
    }

    public long getFirstSubjectWeek() {
        return firstSubjectWeek;
    }

    public void setFirstSubjectWeek(long firstSubjectWeek) {
        this.firstSubjectWeek = firstSubjectWeek;
    }

    public long getWeekDay() {
        return weekDay;
    }

    public void setWeekDay(int weekDay) {
        this.weekDay = weekDay;
    }

    public long getStartTime() {
        return startTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public long getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(long finishTime) {
        this.finishTime = finishTime;
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
        if (startTime != course.startTime) return false;
        if (finishTime != course.finishTime) return false;
        if (!name.equals(course.name)) return false;
        if (!teacher.equals(course.teacher)) return false;
        if (!room.equals(course.room)) return false;
        return courseType.equals(course.courseType);

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
                ", startTime=" + startTime +
                ", finishTime=" + finishTime +
                ", teacher=" + teacher +
                ", room=" + room +
                ", courseType=" + courseType +
                '}';
    }
}
