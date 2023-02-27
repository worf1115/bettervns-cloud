package com.bettervns.adminapi.dao;

import com.bettervns.adminapi.models.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class StudentDAO {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public StudentDAO(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Student> index() {
      return jdbcTemplate.query("SELECT * FROM Student", new StudentMapper());
    }

    public Student show(int id) {
        return jdbcTemplate.query("SELECT * FROM student WHERE id=?", new Object[]{id},
                new StudentMapper()).stream().findAny().orElse(null);
    }

    public void addStudent(Student student) {
        jdbcTemplate.update("INSERT INTO student VALUES(?, ?, ?, ?)",
                student.getId(), student.getName(), student.getAdmissionDate(), student.getEmail());
    }

    public void update(int id, Student student) {
        jdbcTemplate.update("UPDATE student SET student_name=?, admission_date=?, email=? WHERE id=?",
                student.getName(), student.getAdmissionDate(), student.getEmail(), id);
    }

    public void delete(int id) {
        jdbcTemplate.update("DELETE FROM student WHERE id = ?", id);
    }
}