package pl.pwr.edu.computermanagementtool.service.interfaces;

import pl.pwr.edu.computermanagementtool.entity.Role;

import java.util.List;

public interface iRoleService {

    Role getRoleById(int id);
    List<Role> getAllRoles();

}
