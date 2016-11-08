package model;

import javax.persistence.*;

/**
 * Created by Michał on 2016-10-18.
 */
@Entity
@Table(name = "SUBJECT_TYPE")
public class CourseType {

    private long id;
    private String type;
    //private Set<Course> courseSet;

    public CourseType() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", unique = true, nullable = false)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "TYPE", unique = true, nullable = false)
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    /*@OneToMany(mappedBy = "subjectType", fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
    public Set<Course> getCourseSet() {
        return courseSet;
    }

    public void setCourseSet(Set<Course> courseSet) {
        this.courseSet = courseSet;
    }*/
}
