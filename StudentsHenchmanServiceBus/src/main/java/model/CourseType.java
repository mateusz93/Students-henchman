package model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

/**
 * @Author Mateusz Wieczorek on 10/11/16.
 */
@Entity
@Table(name = "TYPY_ZAJEC")
public class CourseType {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "typ")
    private String type;

    @JsonIgnore
    @OneToMany(mappedBy = "courseType", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<Course> courses;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Set<Course> getCourses() {
        return courses;
    }

    public void setCourses(Set<Course> courses) {
        this.courses = courses;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CourseType that = (CourseType) o;

        if (id != that.id) return false;
        if (!type.equals(that.type)) return false;
        return courses.equals(that.courses);

    }

    @Override
    public String toString() {
        return "CourseType{" +
                "id=" + id +
                ", type='" + type + '\'' +
                '}';
    }
}
