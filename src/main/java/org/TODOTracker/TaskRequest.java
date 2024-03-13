package org.TODOTracker;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class TaskRequest {
    private String title;
    private String description;
    private Date deadline;
    private Date CreatedDate;
    private Long userId;
}
