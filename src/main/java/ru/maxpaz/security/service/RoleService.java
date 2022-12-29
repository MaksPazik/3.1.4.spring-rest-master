package ru.maxpaz.security.service;

import ru.maxpaz.security.model.Role;

import java.util.List;

public interface RoleService {
    List<Role> getRoles();
    void saveRole(Role role);
}
