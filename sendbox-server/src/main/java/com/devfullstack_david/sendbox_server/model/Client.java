package com.devfullstack_david.sendbox_server.model;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Client {
    private String clientId;
    private String clientName;
    private String status;
    private LocalDateTime lastConnectedAt;
}
