package pl.pwr.edu.computermanagementtool.service;
import org.springframework.expression.ExpressionException;
import org.springframework.stereotype.Service;
import pl.pwr.edu.computermanagementtool.entity.Role;
import pl.pwr.edu.computermanagementtool.entity.User;
import pl.pwr.edu.computermanagementtool.repository.RoleRepository;
import pl.pwr.edu.computermanagementtool.repository.UserRepository;


import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;


@Service
public class UserService{

    String ROLE_PREFIX = "ROLE_";
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    public UserService(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }
    public User getUserById(int id){
        Optional<User> userOptional = userRepository.findById(id);
        return userOptional.orElseThrow(()-> new RuntimeException("User not found with id: " + id));
    }
    public User getUserByUsernameOrEmail(String userNameOrEmail){
        Optional<User> userOptional = userRepository.findByUsernameOrEmail(userNameOrEmail, userNameOrEmail);
        return userOptional.orElseThrow(()-> new ExpressionException("User not found with username or email: " + userNameOrEmail));
    }
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public User registerUser(String username, String password, String name, String surname, String email){

        Role role = roleRepository.findByRoleName("User")
                .orElseThrow(()-> new RuntimeException("Role not found"));

        User user = new User(username, password, name, surname, email, role);
        return userRepository.save(user);
    }

}
