package org.rbnk.dealership.controller;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.rbnk.dealership.dto.AssignCarDto;
import org.rbnk.dealership.dto.CategoryDto;
import org.rbnk.dealership.dto.ClientDto;
import org.rbnk.dealership.service.CategoryService;
import org.rbnk.dealership.service.ClientService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/clients")
public class ClientController {
    private final ClientService clientService;

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ClientDto getById(@PathVariable("id") @NotNull Long id) {
        return clientService.findById(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ClientDto> getAll() {
        return clientService.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@RequestBody @Valid ClientDto clientDto) {
        clientService.save(clientDto);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void update(@RequestBody @Valid ClientDto clientDto) {
        clientService.update(clientDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") @NotNull Long id) {
        clientService.delete(id);
    }

    @PostMapping("assign")
    @ResponseStatus(HttpStatus.OK)
    public void save(@RequestBody @Valid AssignCarDto assignCarDto) {
        clientService.assignCarToClient(assignCarDto);
    }
}