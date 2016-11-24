package model;

import javax.persistence.*;

/**
 * Created by Michał on 2016-11-24.
 */
@Entity
@Table(name = "DEAN_GROUPS_RELATION")
public class DependentDeanGroup {

    private long id;
    private DeanGroup dependentDeanGroupId;
    private DeanGroup commonDeanGroupId;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", unique = true, nullable = false)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "DEPENDENT_GROUP_ID", nullable = false)
    public DeanGroup getDependentDeanGroupId() {
        return dependentDeanGroupId;
    }

    public void setDependentDeanGroupId(DeanGroup dependentDeanGroupId) {
        this.dependentDeanGroupId = dependentDeanGroupId;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "COMMON_GROUP_ID", nullable = false)
    public DeanGroup getCommonDeanGroupId() {
        return commonDeanGroupId;
    }

    public void setCommonDeanGroupId(DeanGroup commonDeanGroupId) {
        this.commonDeanGroupId = commonDeanGroupId;
    }

    @Override
    public String toString() {
        return "DependentDeanGroup{" +
                "id=" + id +
                ", dependentDeanGroupId=" + dependentDeanGroupId +
                ", commonDeanGroupId=" + commonDeanGroupId +
                '}';
    }
}
