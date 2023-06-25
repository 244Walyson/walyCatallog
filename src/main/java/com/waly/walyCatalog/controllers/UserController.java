package com.waly.walyCatalog.controllers;

import com.waly.walyCatalog.dto.UserDTO;
import com.waly.walyCatalog.dto.UserInsertDTO;
import com.waly.walyCatalog.dto.UserUpdateDTO;
import com.waly.walyCatalog.services.UserService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping
    public ResponseEntity<Page<UserDTO>> findAll(Pageable pageable){
        Page<UserDTO> dto = service.findAll(pageable);
        return ResponseEntity.ok().body(dto);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<UserDTO> findById(@PathVariable Long id){
        UserDTO dto = service.findById(id);
        return ResponseEntity.ok(dto);
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_OPERATOR')")
    @PostMapping
    public ResponseEntity<UserDTO> insert(@Valid @RequestBody UserInsertDTO dto){
        UserDTO newdto = service.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(newdto.getId()).toUri();
        return ResponseEntity.created(uri).body(newdto);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<UserDTO> update(@Valid @RequestBody UserUpdateDTO dto, @PathVariable Long id){
        try {
            UserDTO newdto = service.update(dto, id);
            return ResponseEntity.ok(newdto);
        }
        catch (EntityNotFoundException e){
            return ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
