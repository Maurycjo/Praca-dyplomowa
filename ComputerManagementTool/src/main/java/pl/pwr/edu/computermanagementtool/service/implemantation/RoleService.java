package pl.pwr.edu.computermanagementtool.service.implemantation;
import org.springframework.stereotype.Service;
import pl.pwr.edu.computermanagementtool.entity.Role;
import pl.pwr.edu.computermanagementtool.repository.RoleRepository;
import pl.pwr.edu.computermanagementtool.service.interfaces.iRoleService;

import java.util.List;

@Service
public class RoleService implements iRoleService{
    private final RoleRepository roleRepository;

    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public Role getRoleById(int id) {
        return null;
    }

    @Override
    public List<Role> getAllRoles() {
        return null;
    }
}
