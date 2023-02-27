package com.bettervns.adminapi.dao;

import com.bettervns.adminapi.models.Student;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentMapper implements RowMapper<Student> {
    @Override
    public Student mapRow(ResultSet resultSet, int i) throws SQLException {
        return new Student(resultSet.getInt("id"), resultSet.getString("student_name"),
                resultSet.getDate("admission_date"), resultSet.getString("email"));
    }
}