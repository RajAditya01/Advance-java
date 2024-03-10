package com.mmengineering.dao;

import com.mmengineering.model.Student;
import com.mmengineering.util.DatabaseUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentDAO {
    private static final String INSERT_STUDENT_SQL = "INSERT INTO students (student_name, student_email, event_id) VALUES (?, ?, ?)";

    public boolean registerStudent(Student student) {
        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_STUDENT_SQL)) {
            preparedStatement.setString(1, student.getStudentName());
            preparedStatement.setString(2, student.getStudentEmail());
            preparedStatement.setInt(3, student.getEventId());
            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
