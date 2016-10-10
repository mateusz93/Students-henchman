package model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @Author Mateusz Wieczorek on 10/6/16.
 */
@Entity
@Table(name = "PRZEDMIOTY")
public class Subject implements Serializable {

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

    @Column(name = "prowadzacy")
    private String teacherName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_sali")
    private Room room;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_bloku_obieralnego")
    private SubjectsBlock subjectsBlock;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_specjalizacji")
    private Specialization specialization;

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

    public Specialization getSpecialization() {
        return specialization;
    }

    public void setSpecialization(Specialization specialization) {
        this.specialization = specialization;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Subject subject = (Subject) o;

        if (id != subject.id) return false;
        if (quantity != subject.quantity) return false;
        if (cycle != subject.cycle) return false;
        if (firstSubjectWeek != subject.firstSubjectWeek) return false;
        if (weekDay != subject.weekDay) return false;
        if (time != subject.time) return false;
        if (duration != subject.duration) return false;
        if (!name.equals(subject.name)) return false;
        if (!teacherName.equals(subject.teacherName)) return false;
        if (!room.equals(subject.room)) return false;
        if (!subjectsBlock.equals(subject.subjectsBlock)) return false;
        return specialization.equals(subject.specialization);

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
        result = 31 * result + teacherName.hashCode();
        result = 31 * result + room.hashCode();
        result = 31 * result + subjectsBlock.hashCode();
        result = 31 * result + specialization.hashCode();
        return result;
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
                ", specialization=" + specialization +
                '}';
    }
}
