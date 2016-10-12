package cdm;

import model.Course;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Mateusz Wieczorek on 10/12/16.
 */
public class CourseRS {

    private List<Course> courses = new ArrayList<>();

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    @Override
    public String toString() {
        return "CourseRS{" +
                "courses=" + courses +
                '}';
    }
}
