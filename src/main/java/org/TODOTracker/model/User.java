package org.TODOTracker.model;

import com.mysql.cj.x.protobuf.MysqlxDatatypes;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;

import javax.persistence.*;
import java.util.List;

@Entity
//@Getter
//@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "email_id")
    private String emailId;

    @Column(name = "name")
    private String name;

    @Column(name = "is_exist")
    private Boolean isExist = true;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Task> tasks;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getExist() {
        return isExist;
    }

    public void setExist(Boolean exist) {
        isExist = exist;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    public String toString() {
        return "User{" +
                "emailId='" + emailId + '\'' +
                ", name='" + name + '\'' +
                ", isExist=" + isExist +
                ", tasks=" + tasks +
                '}';
    }
}