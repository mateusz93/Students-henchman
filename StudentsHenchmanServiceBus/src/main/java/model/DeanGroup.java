package model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Michał on 2016-10-30.
 */
@Entity
@Table(name = "DEAN_GROUP")
public class DeanGroup {

    private Long id;
    private String name;
    private String abbreviation;
    private Long term;
    private Long degree;
    private Field field;
    private Set<Course> courses;
    private Set<DependentDeanGroup> dependentDeanGroups;
    private Set<DependentDeanGroup> commonDeanGroups;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", unique = true, nullable = false)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
    public Long getTerm() {
        return term;
    }

    public void setTerm(Long term) {
        this.term = term;
    }

    @Column(name = "DEGREE", nullable = false)
    public Long getDegree() {
        return degree;
    }

    public void setDegree(Long degree) {
        this.degree = degree;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "FIELD_ID", nullable = false)
    public Field getField() {
        return field;
    }

    public void setField(Field field) {
        this.field = field;
    }

    @JsonIgnore
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "deanGroup", cascade = CascadeType.ALL)
    public Set<Course> getCourses() {
        return courses;
    }

    public void setCourses(Set<Course> courses) {
        this.courses = courses;
    }

    @JsonIgnore
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "dependentDeanGroupId", cascade = CascadeType.ALL)
    public Set<DependentDeanGroup> getDependentDeanGroups() {
        return dependentDeanGroups;
    }

    public void setDependentDeanGroups(Set<DependentDeanGroup> dependentDeanGroups) {
        this.dependentDeanGroups = dependentDeanGroups;
    }

    @JsonIgnore
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "commonDeanGroupId", cascade = CascadeType.ALL)
    public Set<DependentDeanGroup> getCommonDeanGroups() {
        return commonDeanGroups;
    }

    public void setCommonDeanGroups(Set<DependentDeanGroup> commonDeanGroups) {
        this.commonDeanGroups = commonDeanGroups;
    }

    @Override
    public String toString() {
        return "DeanGroup{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", abbreviation='" + abbreviation + '\'' +
                ", term=" + term +
                ", degree=" + degree +
                ", field=" + field +
                '}';
    }
}
