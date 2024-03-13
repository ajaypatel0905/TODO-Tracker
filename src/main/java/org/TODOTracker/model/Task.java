package org.TODOTracker.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.type.DateType;
import org.springframework.beans.factory.annotation.Value;

import java.lang.*;
import javax.persistence.*;

@Entity
//@Getter
//@Setter
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;

    private DateType deadline;

    private DateType createdDate;

    @Value("${my.property:false}")
    private Boolean isExist;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public DateType getDeadline() {
        return deadline;
    }

    public void setDeadline(DateType deadline) {
        this.deadline = deadline;
    }

    public DateType getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(DateType createdDate) {
        this.createdDate = createdDate;
    }

    public Boolean getExist() {
        return isExist;
    }

    public void setExist(Boolean exist) {
        isExist = exist;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

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