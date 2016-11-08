package model;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import java.io.Serializable;

/**
 * Created by Michał on 2016-10-28.
 */
@Embeddable
public class FieldSubjectId implements Serializable {

    private Field field;
    private Subject subject;

    @ManyToOne
    public Field getField() {
        return field;
    }

    public void setField(Field field) {
        this.field = field;
    }

    @ManyToOne
    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FieldSubjectId that = (FieldSubjectId) o;

        if (field != null ? !field.equals(that.field) : that.field != null) return false;
        return subject != null ? subject.equals(that.subject) : that.subject == null;

    }

    @Override
    public int hashCode() {
        int result = field != null ? field.hashCode() : 0;
        result = 31 * result + (subject != null ? subject.hashCode() : 0);
        return result;
    }
}
