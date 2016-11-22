package model;

import javax.persistence.*;

/**
 * Created by Michał on 2016-11-17.
 */
@Entity
@Table(name = "ERROR_REPORT")
public class ErrorReport {

    private Long id;
    private String content;
    private Long occurredDate;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", unique = true, nullable = false)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "CONTENT", nullable = false)
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Column(name = "OCCURED_DATE", nullable = false)
    public Long getOccurredDate() {
        return occurredDate;
    }

    public void setOccurredDate(Long occurredDate) {
        this.occurredDate = occurredDate;
    }

    @Override
    public String toString() {
        return "ErrorReport{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", occurredDate=" + occurredDate +
                '}';
    }
}
