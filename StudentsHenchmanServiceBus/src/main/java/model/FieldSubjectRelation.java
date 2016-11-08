package model;

import javax.persistence.*;

/**
 * Created by Michał on 2016-10-18.
 */
@Entity
@Table(name = "FIELD_SUBJECT")
@AssociationOverrides({
        @AssociationOverride(name = "pk.field", joinColumns = @JoinColumn(name = "FIELD_ID")),
        @AssociationOverride(name = "pk.subject", joinColumns = @JoinColumn(name = "SUBJECT_ID"))
})
public class FieldSubjectRelation {

    private FieldSubjectId pk = new FieldSubjectId();

    public FieldSubjectRelation() {
    }

    @EmbeddedId
    public FieldSubjectId getPk() {
        return pk;
    }

    public void setPk(FieldSubjectId pk) {
        this.pk = pk;
    }

    @Transient
    public Field getField() {
        return getPk().getField();
    }

    public void setField(Field field) {
        this.getPk().setField(field);
    }

    @Transient
    public Subject getSubject() {
        return getPk().getSubject();
    }

    public void setSubject(Subject subject) {
        this.getPk().setSubject(subject);
    }


}
