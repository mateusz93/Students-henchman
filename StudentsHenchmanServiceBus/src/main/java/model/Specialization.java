package model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
 * @Author Mateusz Wieczorek on 10/6/16.
 */
@Entity
@Table(name = "SPECJALIZACJE")
public class Specialization implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "nazwa_specjalizacji")
    private String name;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_przedmiotu")
    private Course Course;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_kierunku")
    private Field field;

    @JsonIgnore
    @OneToMany(mappedBy = "specialization", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<Subject> subjects;

    @JsonIgnore
    @OneToMany(mappedBy = "specialization", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<User> users;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Course getCourse() {
        return Course;
    }

    public void setCourse(Course course) {
        this.Course = course;
    }

    public Field getField() {
        return field;
    }

    public void setField(Field field) {
        this.field = field;
    }


    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public Set<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(Set<Subject> subjects) {
        this.subjects = subjects;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Specialization that = (Specialization) o;

        if (id != that.id) return false;
        if (!name.equals(that.name)) return false;
        if (!Course.equals(that.Course)) return false;
        if (!field.equals(that.field)) return false;
        if (!subjects.equals(that.subjects)) return false;
        return users.equals(that.users);

    }

    @Override
    public String toString() {
        return "Specialization{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", Course=" + Course +
                ", field=" + field +
                '}';
    }
}
