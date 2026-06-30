package com.devfullstack_david.sendbox_server.model.dto;

import jakarta.validation.constraints.NotBlank;

public record LoginRequestDTO(
    @NotBlank String username,
    @NotBlank String password
) {}
