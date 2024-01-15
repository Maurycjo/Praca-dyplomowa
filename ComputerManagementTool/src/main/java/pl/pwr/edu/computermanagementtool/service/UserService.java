package pl.pwr.edu.computermanagementtool.service;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.springframework.expression.ExpressionException;
import org.springframework.stereotype.Service;
import pl.pwr.edu.computermanagementtool.PasswordEncoderUtil;
import pl.pwr.edu.computermanagementtool.entity.Role;
import pl.pwr.edu.computermanagementtool.entity.User;
import pl.pwr.edu.computermanagementtool.repository.RoleRepository;
import pl.pwr.edu.computermanagementtool.repository.UserRepository;


import java.util.*;
import java.util.stream.Collectors;


@Service
public class UserService{

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

        String hashedPassword = PasswordEncoderUtil.encodePassword(password);

        User user = new User(username, hashedPassword, name, surname, email, role);
        return userRepository.save(user);
    }

    public Map<String, Object> authenticateUser(String usernameOrEmail, String password){

        Map<String, Object> response = new HashMap<>();
        response.put("authenticated", false);

        Optional<User> userOptional = userRepository.findByUsernameOrEmail(usernameOrEmail, usernameOrEmail);


        if(userOptional.isPresent()){
            User user = userOptional.orElseThrow(()-> new RuntimeException("User not found with username or email: " + usernameOrEmail));
            String hashedPassword = PasswordEncoderUtil.encodePassword(password);
            if(PasswordEncoderUtil.matches(password, user.getPassword())){
                response.put("authenticated", true);
                response.put("userId", user.getId());
                response.put("role", user.getRole().getRoleName());
            }
        }

        return response;
    }

}
