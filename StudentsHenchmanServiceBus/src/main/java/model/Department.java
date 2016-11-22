package model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Michał on 2016-10-18.
 */
@Entity
@Table(name = "DEPARTMENT")
public class Department {

    private Long id;
    private String name;
    private Set<Field> fields;
    private Set<User> users;

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

    @JsonIgnore
    @OneToMany(mappedBy = "department", fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
    public Set<Field> getFields() {
        return fields;
    }

    public void setFields(Set<Field> fields) {
        this.fields = fields;
    }

    @JsonIgnore
    @OneToMany(mappedBy = "department", fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }
}
