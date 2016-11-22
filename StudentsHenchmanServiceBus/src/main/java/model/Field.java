package model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Michał on 2016-10-18.
 */
@Entity
@Table(name = "FIELD")
public class Field {

    private Long id;
    private String name;
    private Department department;
    private Set<FieldSubjectRelation> fieldSubjectRelations;
    private Set<Specialization> specializations;
    private Set<DeanGroup> deanGroups;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
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

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "DEPARTMENT_ID", nullable = false)
    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @JsonIgnore
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "pk.field", cascade = CascadeType.ALL)
    public Set<FieldSubjectRelation> getFieldSubjectRelations() {
        return fieldSubjectRelations;
    }

    public void setFieldSubjectRelations(Set<FieldSubjectRelation> fieldSubjectRelations) {
        this.fieldSubjectRelations = fieldSubjectRelations;
    }

    @JsonIgnore
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "field", cascade = CascadeType.ALL)
    public Set<Specialization> getSpecializations() {
        return specializations;
    }

    public void setSpecializations(Set<Specialization> specializations) {
        this.specializations = specializations;
    }

    @JsonIgnore
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "field", cascade = CascadeType.ALL)
    public Set<DeanGroup> getDeanGroups() {
        return deanGroups;
    }

    public void setDeanGroups(Set<DeanGroup> deanGroups) {
        this.deanGroups = deanGroups;
    }

    @Override
    public String toString() {
        return "Field{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", department=" + department +
                '}';
    }
}
