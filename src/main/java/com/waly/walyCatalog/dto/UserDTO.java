package com.waly.walyCatalog.dto;

import com.waly.walyCatalog.entities.User;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

import java.util.HashSet;
import java.util.Set;

public class UserDTO {
    private Long id;
    @NotBlank(message = "campo obrigatório")
    private String firstName;
    @NotBlank(message = "campo obrigatório")
    private String lastName;
    @Email(message = "email inválido")
    private String email;

    Set<RoleDTO> roles = new HashSet<>();

    public  UserDTO(){}

    public UserDTO(Long id, String firstName, String lastName, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public UserDTO(User entity) {
        this.id = entity.getId();
        this.firstName = entity.getEmail();
        this.lastName = entity.getLastName();
        this.email = entity.getEmail();
        entity.getRoles().forEach(role -> this.roles.add(new RoleDTO(role)));
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<RoleDTO> getRoles() {
        return roles;
    }
}

