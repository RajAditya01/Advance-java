package com.mmengineering.model;

public class Result {
    private int resultId;
    private int eventId;
    private int studentId;
    private int marks;

    // Constructors, getters, and setters

    public Result() {
    }

    public Result(int resultId, int eventId, int studentId, int marks) {
        this.resultId = resultId;
        this.eventId = eventId;
        this.studentId = studentId;
        this.marks = marks;
    }

    // Getters and Setters

    public int getResultId() {
        return resultId;
    }

    public void setResultId(int resultId) {
        this.resultId = resultId;
    }

    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getMarks() {
        return marks;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }
}
