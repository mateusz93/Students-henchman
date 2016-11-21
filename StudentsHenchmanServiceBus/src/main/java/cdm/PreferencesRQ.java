package cdm;

import java.util.List;

/**
 * @Author Mateusz Wieczorek on 20.11.2016.
 */
public class PreferencesRQ {

    private long departmentId;
    private long fieldId;
    private int term;
    private int degree;
    private List<Long> deanGroupIds;

    public long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(long departmentId) {
        this.departmentId = departmentId;
    }

    public long getFieldId() {
        return fieldId;
    }

    public void setFieldId(long fieldId) {
        this.fieldId = fieldId;
    }

    public int getTerm() {
        return term;
    }

    public void setTerm(int term) {
        this.term = term;
    }

    public int getDegree() {
        return degree;
    }

    public void setDegree(int degree) {
        this.degree = degree;
    }

    public List<Long> getDeanGroupIds() {
        return deanGroupIds;
    }

    public void setDeanGroupIds(List<Long> deanGroupIds) {
        this.deanGroupIds = deanGroupIds;
    }

    @Override
    public String toString() {
        return "PreferencesRQ{" +
                "departmentId=" + departmentId +
                ", fieldId=" + fieldId +
                ", term=" + term +
                ", degree=" + degree +
                ", deanGroupIds=" + deanGroupIds +
                '}';
    }
}
