package model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @Author Mateusz Wieczorek on 10/6/16.
 */
@Entity
@Table(name = "UZYTKOWNICY")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "imie")
    private String firstName;

    @Column(name = "nazwisko")
    private String lastName;

    @Column(name = "email")
    private String email;

    @Column(name = "hash_preferencji")
    private String lessonPlanVersion;

    @Column(name = "id_przedmiotow")
    private String subjectIds;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_kierunku")
    private Field field;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_specjalizacji")
    private Specialization specialization;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_bloku_obieralnego")
    private SubjectsBlock subjectsBlock;

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

    public Field getField() {
        return field;
    }

    public void setField(Field field) {
        this.field = field;
    }

    public Specialization getSpecialization() {
        return specialization;
    }

    public void setSpecialization(Specialization specialization) {
        this.specialization = specialization;
    }

    public SubjectsBlock getSubjectsBlock() {
        return subjectsBlock;
    }

    public void setSubjectsBlock(SubjectsBlock subjectsBlock) {
        this.subjectsBlock = subjectsBlock;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (id != user.id) return false;
        if (!firstName.equals(user.firstName)) return false;
        if (!lastName.equals(user.lastName)) return false;
        if (!email.equals(user.email)) return false;
        if (!lessonPlanVersion.equals(user.lessonPlanVersion)) return false;
        if (!subjectIds.equals(user.subjectIds)) return false;
        if (!field.equals(user.field)) return false;
        if (!specialization.equals(user.specialization)) return false;
        return subjectsBlock.equals(user.subjectsBlock);

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + firstName.hashCode();
        result = 31 * result + lastName.hashCode();
        result = 31 * result + email.hashCode();
        result = 31 * result + lessonPlanVersion.hashCode();
        result = 31 * result + subjectIds.hashCode();
        result = 31 * result + field.hashCode();
        result = 31 * result + specialization.hashCode();
        result = 31 * result + subjectsBlock.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", lessonPlanVersion='" + lessonPlanVersion + '\'' +
                ", subjectIds='" + subjectIds + '\'' +
                ", field=" + field +
                ", specialization=" + specialization +
                ", subjectsBlock=" + subjectsBlock +
                '}';
    }
}
