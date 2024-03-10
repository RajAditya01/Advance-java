package com.mmengineering.model;

import java.sql.Date;

public class Event {
    private int eventId;
    private String eventName;
    private Date eventDate;

    // Constructors, getters, and setters

    public Event() {
    }

    public Event(int eventId, String eventName, Date eventDate) {
        this.eventId = eventId;
        this.eventName = eventName;
        this.eventDate = eventDate;
    }

    // Getters and Setters

    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public Date getEventDate() {
        return eventDate;
    }

    public void setEventDate(Date eventDate) {
        this.eventDate = eventDate;
    }

	public void setCoordinatorId(int coordinatorId) {
		// TODO Auto-generated method stub
		
	}
}
