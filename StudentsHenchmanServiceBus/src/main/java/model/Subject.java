package model;

import javax.persistence.*;

/**
 * @Author Mateusz Wieczorek on 10/11/16.
 */
@Entity
@Table(name = "PRZEDMIOTY")
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "nazwa")
    private String name;

    @Column(name = "kod")
    private String code;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_kierunku")
    private Field field;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_specjalizacji")
    private Specialization specialization;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_bloku_obieralnego")
    private SubjectsBlock subjectsBlock;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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

        Subject subject = (Subject) o;

        if (id != subject.id) return false;
        if (!name.equals(subject.name)) return false;
        if (!code.equals(subject.code)) return false;
        if (!field.equals(subject.field)) return false;
        if (!specialization.equals(subject.specialization)) return false;
        return subjectsBlock.equals(subject.subjectsBlock);

    }

    @Override
    public String toString() {
        return "Subject{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", field=" + field +
                ", specialization=" + specialization +
                ", subjectsBlock=" + subjectsBlock +
                '}';
    }
}
