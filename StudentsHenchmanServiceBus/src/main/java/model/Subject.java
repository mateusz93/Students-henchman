package model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Michał on 2016-10-18.
 */
@Entity
@Table(name = "SUBJECT")
public class Subject {

    private long id;
    private String name;
    private String code;
    private Set<FieldSubjectRelation> fieldSubjectRelations;

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

    @Column(name = "CODE", unique = true, nullable = false)
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @JsonIgnore
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "pk.subject")
    public Set<FieldSubjectRelation> getFieldSubjectRelations() {
        return fieldSubjectRelations;
    }

    public void setFieldSubjectRelations(Set<FieldSubjectRelation> fieldSubjectRelations) {
        this.fieldSubjectRelations = fieldSubjectRelations;
    }

}
