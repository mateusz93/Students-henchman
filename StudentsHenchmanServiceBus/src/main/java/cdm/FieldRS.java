package cdm;

import model.Field;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Mateusz Wieczorek on 10/12/16.
 */
public class FieldRS {

    private List<Field> fields = new ArrayList<>();

    public List<Field> getFields() {
        return fields;
    }

    public void setFields(List<Field> fields) {
        this.fields = fields;
    }

    @Override
    public String toString() {
        return "FieldRS{" +
                "fields=" + fields +
                '}';
    }
}
