package cdm;

import model.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Mateusz Wieczorek on 10/20/16.
 */
public class SettingsRS {

    private List<Subject> subjects = new ArrayList<>();
    private List<SubjectsBlock> subjectsBlocks = new ArrayList<>();
    private List<Specialization> specializations = new ArrayList<>();
    private List<Field> fields = new ArrayList<>();
    private List<Department> departments = new ArrayList<>();

    public List<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }

    public List<SubjectsBlock> getSubjectsBlocks() {
        return subjectsBlocks;
    }

    public void setSubjectsBlocks(List<SubjectsBlock> subjectsBlocks) {
        this.subjectsBlocks = subjectsBlocks;
    }

    public List<Specialization> getSpecializations() {
        return specializations;
    }

    public void setSpecializations(List<Specialization> specializations) {
        this.specializations = specializations;
    }

    public List<Field> getFields() {
        return fields;
    }

    public void setFields(List<Field> fields) {
        this.fields = fields;
    }

    public List<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(List<Department> departments) {
        this.departments = departments;
    }
}
