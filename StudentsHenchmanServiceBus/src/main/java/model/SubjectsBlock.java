package model;

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

    @OneToMany(mappedBy = "subjectsBlock", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Subject> subjects;

    public Set<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(Set<Subject> subjects) {
        this.subjects = subjects;
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SubjectsBlock that = (SubjectsBlock) o;

        if (id != that.id) return false;
        if (!name.equals(that.name)) return false;
        return subjects.equals(that.subjects);

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + name.hashCode();
        result = 31 * result + subjects.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "SubjectsBlock{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", subjects=" + subjects +
                '}';
    }
}
