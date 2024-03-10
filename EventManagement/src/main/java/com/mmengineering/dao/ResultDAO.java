package com.mmengineering.dao;

import com.mmengineering.model.Result;
import com.mmengineering.util.DatabaseUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ResultDAO {
    private static final String INSERT_RESULT_SQL = "INSERT INTO results (event_id, student_id, marks) VALUES (?, ?, ?)";

    public boolean publishResult(Result result) {
        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_RESULT_SQL)) {
            preparedStatement.setInt(1, result.getEventId());
            preparedStatement.setInt(2, result.getStudentId());
            preparedStatement.setInt(3, result.getMarks());
            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
