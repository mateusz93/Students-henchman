package model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Michał on 2016-11-17.
 */
@Entity
@Table(name = "USER")
public class User {

    private long id;
    private String email;
    private Department department;
    private Field field;
    private String deanGroups;
    private String courses;
    private int term;
    private int degree;
    private Set<Note> notes;


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "EMAIL", nullable = false)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "DEPARTMENT_ID", nullable = false)
    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department departments) {
        this.department = departments;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "FIELD_ID", nullable = false)
    public Field getField() {
        return field;
    }

    public void setField(Field fields) {
        this.field = fields;
    }

    @Column(name = "DEAN_GROUPS", nullable = false)
    public String getDeanGroups() {
        return deanGroups;
    }

    public void setDeanGroups(String deanGroups) {
        this.deanGroups = deanGroups;
    }

    @Column(name = "COURSES", nullable = false)
    public String getCourses() {
        return courses;
    }

    public void setCourses(String courses) {
        this.courses = courses;
    }

    @Column(name = "TERM", nullable = false)
    public int getTerm() {
        return term;
    }

    public void setTerm(int term) {
        this.term = term;
    }

    @Column(name = "DEGREE", nullable = false)
    public int getDegree() {
        return degree;
    }

    public void setDegree(int degree) {
        this.degree = degree;
    }

    @JsonIgnore
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "user", cascade = CascadeType.ALL)
    public Set<Note> getNotes() {
        return notes;
    }


    public void setNotes(Set<Note> notes) {
        this.notes = notes;
    }


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", departments=" + department +
                ", fields=" + field +
                ", deanGroups=" + deanGroups +
                ", notes=" + notes +
                ", courses=" + courses +
                '}';
    }
}
