package cdm;

import java.io.Serializable;
import java.util.Set;

/**
 * @Author Mateusz Wieczorek on 10/4/16.
 */
public class Department implements Serializable {

    private int id;
    private String name;

    public long getId() {
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

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
