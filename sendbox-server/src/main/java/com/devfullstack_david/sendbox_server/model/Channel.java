package com.devfullstack_david.sendbox_server.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "channels")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Channel {
    @Id
    private String id;
    private String channelCode;
    private String adminId;
    private LocalDateTime createdAt = LocalDateTime.now();
    private List<Client> clients = new ArrayList<>();
}
