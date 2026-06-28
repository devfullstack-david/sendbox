package com.devfullstack_david.sendbox_server.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.devfullstack_david.sendbox_server.model.enums.Severity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "alerts")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Alert {
    @Id
    private String id;
    private String channelId;
    private List<String> client = new ArrayList<>();
    private Severity severity;
    private String message;
    private LocalDateTime sentAt = LocalDateTime.now();
}
