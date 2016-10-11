package model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
 * @Author Mateusz Wieczorek on 10/6/16.
 */
@Entity
@Table(name = "BLOKI_OBIERALNE")
public class SubjectsBlock implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "nazwa_bloku")
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_kierunku")
    private Field field;

    @JsonIgnore
    @OneToMany(mappedBy = "subjectsBlock", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Subject> subjects;

    @JsonIgnore
    @OneToMany(mappedBy = "subjectsBlock", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<User> users;

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

        SubjectsBlock that = (SubjectsBlock) o;

        if (id != that.id) return false;
        if (!name.equals(that.name)) return false;
        if (!field.equals(that.field)) return false;
        if (!subjects.equals(that.subjects)) return false;
        return users.equals(that.users);

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + name.hashCode();
        result = 31 * result + field.hashCode();
        result = 31 * result + subjects.hashCode();
        result = 31 * result + users.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "SubjectsBlock{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", field=" + field +
                ", subjects=" + subjects +
                ", users=" + users +
                '}';
    }
}
