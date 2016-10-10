package cdm;

import java.io.Serializable;

/**
 * @Author Mateusz Wieczorek on 10/6/16.
 */
public class SubjectsBlock implements Serializable {

    private int id;
    private String name;
    private Field field;

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

    public Field getField() {
        return field;
    }

    public void setField(Field field) {
        this.field = field;
    }

    @Override
    public String toString() {
        return "SubjectsBlock{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", field=" + field +
                '}';
    }
}
