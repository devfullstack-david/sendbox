package com.devfullstack_david.sendbox_server.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devfullstack_david.sendbox_server.model.Administrator;
import com.devfullstack_david.sendbox_server.model.dto.SaveAdministratorDTO;
import com.devfullstack_david.sendbox_server.service.AdministratorService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/administrators")
@RequiredArgsConstructor
public class AdministratorController {
    private final AdministratorService administratorService;

    @PostMapping
    public ResponseEntity<Void> create(@Valid @RequestBody SaveAdministratorDTO request) {
        administratorService.createAdministrator(request);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping
    public ResponseEntity<List<Administrator>> getAdministrators() {
        return ResponseEntity.ok(administratorService.getAdministrators());
    }
}
