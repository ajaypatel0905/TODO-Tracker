package org.TODOTracker.model;

import lombok.Data;
import org.hibernate.type.DateType;

import java.util.Date;

@Data
public class AddTask {
    private String title;
    private String description;

    private Date deadline;

    private Date createdDate;
    private Long userId;
}
