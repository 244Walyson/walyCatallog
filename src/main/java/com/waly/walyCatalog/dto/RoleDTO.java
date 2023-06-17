package com.waly.walyCatalog.dto;

import com.waly.walyCatalog.entities.Role;

import java.util.HashSet;
import java.util.Set;

public class RoleDTO {

    private Long id;
    private String authority;

    public RoleDTO(){}

    public RoleDTO(Long id, String authority) {
        this.id = id;
        this.authority = authority;
    }

    public RoleDTO(Role entity) {
        this.id = entity.getId();
        this.authority = entity.getAuthority();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

}
