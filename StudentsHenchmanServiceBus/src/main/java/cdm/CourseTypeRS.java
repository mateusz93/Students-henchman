package cdm;

import model.CourseType;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Mateusz Wieczorek on 10/13/16.
 */
public class CourseTypeRS {

    private List<CourseType> courseTypes = new ArrayList<>();

    public List<CourseType> getCourseTypes() {
        return courseTypes;
    }

    public void setCourseTypes(List<CourseType> courseTypes) {
        this.courseTypes = courseTypes;
    }

    @Override
    public String toString() {
        return "CourseTypeRS{" +
                "courseTypes=" + courseTypes +
                '}';
    }
}
