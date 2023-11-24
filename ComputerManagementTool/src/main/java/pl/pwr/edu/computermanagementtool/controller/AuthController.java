package pl.pwr.edu.computermanagementtool.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.pwr.edu.computermanagementtool.entity.User;
import pl.pwr.edu.computermanagementtool.service.UserService;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "*")
public class AuthController {

    private final UserService userService;


    @PostMapping("/login")
    public ResponseEntity<?> loginUser(
            @RequestParam String usernameOrEmail,
            @RequestParam String password){

        User user = userService.getUserByUsernameOrEmail(usernameOrEmail);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/register")
    public ResponseEntity<User> registerUser(
            @RequestParam String username,
            @RequestParam String password,
            @RequestParam String name,
            @RequestParam String surname,
            @RequestParam String email){

        try{
            User newUser = userService.registerUser(username, password, name, surname, email);
            return new ResponseEntity<>(newUser, HttpStatus.CREATED);
        } catch (RuntimeException e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }


    public AuthController(UserService userService) {
        this.userService = userService;
    }


}
