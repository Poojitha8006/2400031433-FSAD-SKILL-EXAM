package com.klef.fsad.exam;

import java.util.Date;

public class Course {

    private int id;
    private String name;
    private String description;
    private Date date;
    private String status;
    private String instructor;
    private int duration; // in hours
    private String category;

    public Course() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getInstructor() {
        return instructor;
    }

    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Course [id=" + id + ", name=" + name + ", description=" + description
                + ", date=" + date + ", status=" + status + ", instructor=" + instructor
                + ", duration=" + duration + ", category=" + category + "]";
    }
}
