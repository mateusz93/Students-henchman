package model;

import javax.persistence.*;

/**
 * Created by Michał on 2016-10-30.
 */
@Entity
@Table(name = "DATE")
public class Date {

    private Long id;
    private String dayOfWeek;
    private java.sql.Date date;
    private Long weekNo;
    private Long cycle;

    public Date() {}

    public Date(String dayOfWeek, java.sql.Date date, Long weekNo, Long cycle) {
        this.dayOfWeek = dayOfWeek;
        this.date = date;
        this.weekNo = weekNo;
        this.cycle = cycle;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", unique = true, nullable = false)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "DAY_OF_WEEK", nullable = false)
    public String getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(String dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "DATE", unique = true, nullable = false)
    public java.util.Date getDate() {
        return date;
    }

    public void setDate(java.sql.Date date) {
        this.date = date;
    }

    @Column(name = "WEEK_NO", nullable = false)
    public Long getWeekNo() {
        return weekNo;
    }

    public void setWeekNo(Long weekNo) {
        this.weekNo = weekNo;
    }

    @Column(name = "CYCLE", nullable = false)
    public Long getCycle() {
        return cycle;
    }

    public void setCycle(Long cycle) {
        this.cycle = cycle;
    }
}
