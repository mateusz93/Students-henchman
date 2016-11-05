package new_model;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Michał on 2016-10-18.
 */
@Entity
@Table(name = "FIELD")
public class Field {

    private long id;
    private String name;
    private Department department;
    private Set<FieldSubjectRelation> fieldSubjectRelations;
    private Set<Specialization> specializations;

    public Field() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
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

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "DEPARTMENT_ID", nullable = false)
    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "pk.field", cascade = CascadeType.ALL)
    public Set<FieldSubjectRelation> getFieldSubjectRelations() {
        return fieldSubjectRelations;
    }

    public void setFieldSubjectRelations(Set<FieldSubjectRelation> fieldSubjectRelations) {
        this.fieldSubjectRelations = fieldSubjectRelations;
    }

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "field", cascade = CascadeType.ALL)
    public Set<Specialization> getSpecializations() {
        return specializations;
    }

    public void setSpecializations(Set<Specialization> specializations) {
        this.specializations = specializations;
    }
}
