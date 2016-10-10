package model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

/**
 * @Author Mateusz Wieczorek on 10/10/16.
 */
@Entity
@Table(name = "KIERUNKI")
public class Field {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "nazwa_kierunku")
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_wydzialu")
    private Department department;

    @JsonIgnore
    @OneToMany(mappedBy = "field", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Specialization> specializations;

    @JsonIgnore
    @OneToMany(mappedBy = "field", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<SubjectsBlock> subjectsBlocks;

    public int getId() {
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

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Set<Specialization> getSpecializations() {
        return specializations;
    }

    public void setSpecializations(Set<Specialization> specializations) {
        this.specializations = specializations;
    }

    public Set<SubjectsBlock> getSubjectsBlocks() {
        return subjectsBlocks;
    }

    public void setSubjectsBlocks(Set<SubjectsBlock> subjectsBlocks) {
        this.subjectsBlocks = subjectsBlocks;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Field field = (Field) o;

        if (id != field.id) return false;
        if (!name.equals(field.name)) return false;
        if (!department.equals(field.department)) return false;
        if (!specializations.equals(field.specializations)) return false;
        return subjectsBlocks.equals(field.subjectsBlocks);

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + name.hashCode();
        result = 31 * result + department.hashCode();
        result = 31 * result + specializations.hashCode();
        result = 31 * result + subjectsBlocks.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Field{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", department=" + department +
                ", specializations=" + specializations +
                ", subjectsBlocks=" + subjectsBlocks +
                '}';
    }
}
