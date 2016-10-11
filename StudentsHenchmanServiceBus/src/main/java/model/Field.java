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
    private long id;

    @Column(name = "nazwa_kierunku")
    private String name;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_wydzialu")
    private Department department;

    @JsonIgnore
    @OneToMany(mappedBy = "field", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<Specialization> specializations;

    @JsonIgnore
    @OneToMany(mappedBy = "field", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<SubjectsBlock> subjectsBlocks;

    @JsonIgnore
    @OneToMany(mappedBy = "field", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<User> users;

    @JsonIgnore
    @OneToMany(mappedBy = "field", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<Subject> subjects;

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

        Field field = (Field) o;

        if (id != field.id) return false;
        if (!name.equals(field.name)) return false;
        if (!department.equals(field.department)) return false;
        if (!specializations.equals(field.specializations)) return false;
        if (!subjectsBlocks.equals(field.subjectsBlocks)) return false;
        if (!users.equals(field.users)) return false;
        return subjects.equals(field.subjects);

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
