package new_model;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Michał on 2016-10-18.
 */
@Entity
@Table(name = "DEPARTMENT")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private long id;

    @Column(name = "NAME", nullable = false)
    private String name;

    @OneToMany(mappedBy = "department", fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
    private Set<Field> fields;

    public Department() {

    }

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

    public Set<Field> getFields() {
        return fields;
    }

    public void setFields(Set<Field> fields) {
        this.fields = fields;
    }
}
