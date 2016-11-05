package new_model;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Michał on 2016-10-30.
 */
@Entity
@Table(name = "DEAN_GROUP")
public class DeanGroup {
    private long id;
    private String name;
    private String abbreviation;
    private int term;
    private int degree;
    //private Set<Course> courses;


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", unique = true, nullable = false)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "NAME", nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "ABBREVIATION", unique = true, nullable = false)
    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
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

   /* @OneToMany(mappedBy = "deanGroup", fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
    public Set<Course> getCourses() {
        return courses;
    }

    public void setCourses(Set<Course> courses) {
        this.courses = courses;
    }*/
}
