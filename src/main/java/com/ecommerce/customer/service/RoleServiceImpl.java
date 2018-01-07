package com.ecommerce.customer.service;

import com.ecommerce.customer.dao.RoleDao;
import com.ecommerce.customer.domain.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    RoleDao roleDao;

    @Override
    public void createRolesFromList(List<Role> roleList) {
        for (Role role : roleList) {
            roleDao.createRole(role);
        }

    }

    @Override
    public boolean isSetRole(String name) {

        Role role =roleDao.getRoleByName(name);

        if(role != null) {
            return true;
        }
        else return false;
    }

    @Override
    public void createRole(Role role) {
        roleDao.createRole(role);
    }

    @Override
    public List<Role> findAllRoles() {
        return roleDao.findAllRole();
    }
}
