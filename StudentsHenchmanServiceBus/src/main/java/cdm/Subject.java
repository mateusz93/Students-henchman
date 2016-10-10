package cdm;

import java.io.Serializable;

/**
 * @Author Mateusz Wieczorek on 10/6/16.
 */
public class Subject implements Serializable {

    private int id;
    private String name;
    private int quantity;
    private int cycle;
    private int firstSubjectWeek;
    private int weekDay;
    private int time;
    private int duration;
    private String teacherName;
    private Room room;
    private SubjectsBlock subjectsBlock;

    public SubjectsBlock getSubjectsBlock() {
        return subjectsBlock;
    }

    public void setSubjectsBlock(SubjectsBlock subjectsBlock) {
        this.subjectsBlock = subjectsBlock;
    }

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

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    @Override
    public String toString() {
        return "Subject{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", quantity=" + quantity +
                ", cycle=" + cycle +
                ", firstSubjectWeek=" + firstSubjectWeek +
                ", weekDay=" + weekDay +
                ", time=" + time +
                ", duration=" + duration +
                ", teacherName='" + teacherName + '\'' +
                ", room=" + room +
                ", subjectsBlock=" + subjectsBlock +
                '}';
    }
}
