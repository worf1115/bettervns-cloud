package com.bettervns.studentsservice.requests;

public record NewUserRequest(
        String name,
        String surname,
        String fatherName,
        String admissionDate,
        String email
) {
}