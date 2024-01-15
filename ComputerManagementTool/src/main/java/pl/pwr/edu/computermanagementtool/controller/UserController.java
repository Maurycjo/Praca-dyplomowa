package pl.pwr.edu.computermanagementtool.controller;


import org.springframework.web.bind.annotation.*;
import pl.pwr.edu.computermanagementtool.entity.User;
import pl.pwr.edu.computermanagementtool.repository.UserRepository;
import pl.pwr.edu.computermanagementtool.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "*")
public class UserController {

    private final UserService userService;
    private final UserRepository userRepository;

    public UserController(UserService userService,
                          UserRepository userRepository) {
        this.userService = userService;
        this.userRepository = userRepository;
    }
    @RequestMapping("/all")
    @CrossOrigin(origins = "*")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @RequestMapping("/all-standard")
    @CrossOrigin(origins = "*")
    public List<User> getAllStandardUsers(){
        return userService.getAllStandardUser();
    }

    @RequestMapping("/{id}")
    @CrossOrigin(origins = "*")
    public User getUserById(@PathVariable int id){
        return userService.getUserById(id);
    }

    @DeleteMapping("/{id}")
    @CrossOrigin(origins = "*")
    public void deleteUserById(@PathVariable int id){
        userRepository.deleteById(id);
    }


}
