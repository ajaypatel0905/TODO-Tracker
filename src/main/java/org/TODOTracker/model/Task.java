package org.TODOTracker.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.type.DateType;
import org.springframework.beans.factory.annotation.Value;

import java.lang.*;
import javax.persistence.*;

@Entity
@Getter
@Setter
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long taskId;

    private String title;
    private String description;

    private DateType deadline;

    private DateType createdDate;

    @Value("${my.property:false}")
    private Boolean isExist;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;


    public String toString() {
        return "Task{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", deadline=" + deadline +
                ", createdDate=" + createdDate +
                ", isExist=" + isExist +
                ", user=" + user +
                '}';
    }

}