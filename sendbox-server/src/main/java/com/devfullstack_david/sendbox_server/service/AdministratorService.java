package com.devfullstack_david.sendbox_server.service;

import java.util.List;
import java.util.UUID;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.devfullstack_david.sendbox_server.model.Administrator;
import com.devfullstack_david.sendbox_server.model.dto.SaveAdministratorDTO;
import com.devfullstack_david.sendbox_server.repository.AdministratorRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AdministratorService {
    private final AdministratorRepository administratorRepository;
    private final PasswordEncoder passwordEncoder;

    public void createAdministrator(SaveAdministratorDTO administratorDTO) {
        Administrator administrator = new Administrator();
        UUID uuid = UUID.randomUUID();
        administrator.setId(uuid.toString());
        administrator.setUsername(administratorDTO.username());
        administrator.setPassword(passwordEncoder.encode(administratorDTO.password()));

        administratorRepository.save(administrator);
    }

    public List<Administrator> getAdministrators() {
        return administratorRepository.findAll();
    }
}
