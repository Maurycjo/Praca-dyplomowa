package pl.pwr.edu.computermanagementtool.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.pwr.edu.computermanagementtool.dto.auth.LoginRequestDTO;
import pl.pwr.edu.computermanagementtool.dto.auth.RegisterRequestDTO;
import pl.pwr.edu.computermanagementtool.entity.User;
import pl.pwr.edu.computermanagementtool.service.UserService;

import java.util.Map;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "*")
public class AuthController {

    private final UserService userService;


    @PostMapping("/login")
    public ResponseEntity<Map<String, Object>> loginUser(@RequestBody LoginRequestDTO loginRequestDTO) {
        Map<String, Object> response = userService.authenticateUser(loginRequestDTO.getUsernameOrEmail(), loginRequestDTO.getPassword());

        boolean authenticated = (boolean) response.get("authenticated");

        if (authenticated) {
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
        }
    }

    @PostMapping("/register")
    public ResponseEntity<User> registerUser(
            @RequestBody RegisterRequestDTO registerRequestDTO){

        try{
            User newUser = userService.registerUser(
                    registerRequestDTO.getUsername(),
                    registerRequestDTO.getPassword(),
                    registerRequestDTO.getName(),
                    registerRequestDTO.getSurname(),
                    registerRequestDTO.getEmail()
            );
            return new ResponseEntity<>(newUser, HttpStatus.CREATED);
        } catch (RuntimeException e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }


    public AuthController(UserService userService) {
        this.userService = userService;
    }


}
