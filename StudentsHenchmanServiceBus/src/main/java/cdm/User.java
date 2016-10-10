package cdm;

import java.io.Serializable;

/**
 * @Author Mateusz Wieczorek on 10/6/16.
 */
public class User implements Serializable {

    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String subjectIds;
    private String lessonPlanVersion;

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLessonPlanVersion() {
        return lessonPlanVersion;
    }

    public void setLessonPlanVersion(String lessonPlanVersion) {
        this.lessonPlanVersion = lessonPlanVersion;
    }

    public String getSubjectIds() {
        return subjectIds;
    }

    public void setSubjectIds(String subjectIds) {
        this.subjectIds = subjectIds;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", subjectIds='" + subjectIds + '\'' +
                ", lessonPlanVersion='" + lessonPlanVersion + '\'' +
                '}';
    }
}
