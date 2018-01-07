package com.ecommerce.customer.service;

import com.ecommerce.customer.domain.Role;

import java.util.List;

public interface RoleService {

    /**
     * Creating Roles from List<String></>
     * @param roleList
     */
    public void createRolesFromList(List<Role> roleList);

    /**
     * Check Role is Set in Database
     * If Role exist then return True else return False
     * @param name
     * @return
     */
    public boolean isSetRole(String name);

    /**
     * Creating new Role
     * @param role
     */
    public  void createRole(Role role);

    /**
     * Find all Roles in System
     * @return
     */
    public List<Role> findAllRoles();
}
