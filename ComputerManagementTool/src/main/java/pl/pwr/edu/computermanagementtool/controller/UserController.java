package pl.pwr.edu.computermanagementtool.controller;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.pwr.edu.computermanagementtool.entity.User;
import pl.pwr.edu.computermanagementtool.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "*")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
    @RequestMapping("/all")
    @CrossOrigin(origins = "*")
    public List<User> getAllUser(){
        return userService.getAllUsers();
    }

    @RequestMapping("/{id}")
    public User getUserById(@PathVariable int id){
        return userService.getUserById(id);
    }


}
