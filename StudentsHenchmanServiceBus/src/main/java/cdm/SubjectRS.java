package cdm;

import model.Subject;

import java.util.List;

/**
 * @Author Mateusz Wieczorek on 10/12/16.
 */
public class SubjectRS {

    private List<Subject> subjects;

    public List<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }

    @Override
    public String toString() {
        return "SubjectRS{" +
                "subjects=" + subjects +
                '}';
    }
}
