package ru.maxpaz.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.maxpaz.security.model.Role;
import ru.maxpaz.security.repository.RoleRepository;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class RoleServiceImpl implements RoleService {
    private final RoleRepository rolesRepository;

    @Autowired
    public RoleServiceImpl(RoleRepository rolesRepository) {
        this.rolesRepository = rolesRepository;
    }

    @Override
    public List<Role> getRoles() {
        return rolesRepository.findAll();
    }

    @Transactional
    @Override
    public void saveRole(Role role) {
        rolesRepository.save(role);
    }
}
