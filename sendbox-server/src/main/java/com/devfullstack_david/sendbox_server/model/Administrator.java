package com.devfullstack_david.sendbox_server.model;

import java.time.LocalDateTime;

import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "administrators")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Administrator {
    private String id;

    @NotBlank(message = "The username is required.")
    @Size(min = 4, message = "The username must be at least 4 characters long.")
    private String username;

    @NotBlank(message = "The password is required.")
    @Size(min = 6, message = "The password must be at least 6 characters long.")
    private String password;

    private LocalDateTime createdAt = LocalDateTime.now();
}