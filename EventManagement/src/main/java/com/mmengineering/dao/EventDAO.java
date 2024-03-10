package com.mmengineering.dao;

import com.mmengineering.model.Event;
import com.mmengineering.util.DatabaseUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EventDAO {
    private static final String INSERT_EVENT_SQL = "INSERT INTO events (event_name, event_date) VALUES (?, ?)";
    private static final String SELECT_ALL_EVENTS_SQL = "SELECT * FROM events";

    public boolean addEvent(Event event) {
        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_EVENT_SQL)) {
            preparedStatement.setString(1, event.getEventName());
            preparedStatement.setDate(2, event.getEventDate());
            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Event> getAllEvents() {
        List<Event> events = new ArrayList<>();
        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_EVENTS_SQL)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Event event = new Event();
                event.setEventId(resultSet.getInt("event_id"));
                event.setEventName(resultSet.getString("event_name"));
                event.setEventDate(resultSet.getDate("event_date"));
                events.add(event);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return events;
    }

	public List<Event> getEventsByCoordinatorId1(int coordinatorId) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Event> getEventsByCoordinatorId(int coordinatorId) {
		// TODO Auto-generated method stub
		return null;
	}
}
