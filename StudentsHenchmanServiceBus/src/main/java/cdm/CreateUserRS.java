package cdm;

/**
 * @Author Mateusz Wieczorek on 10/10/16.
 */
public class CreateUserRS {

    private long id;
    private String lessonPlanVersion;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLessonPlanVersion() {
        return lessonPlanVersion;
    }

    public void setLessonPlanVersion(String lessonPlanVersion) {
        this.lessonPlanVersion = lessonPlanVersion;
    }

    @Override
    public String toString() {
        return "CreateUserRS{" +
                "id='" + id + '\'' +
                ", lessonPlanVersion='" + lessonPlanVersion + '\'' +
                '}';
    }
}
