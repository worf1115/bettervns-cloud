package com.bettervns.adminservice.requests;

public record NewUserRequest(
        String name,
        String surname,
        String fatherName,
        String admissionDate,
        String email
) {
}