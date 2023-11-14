package pl.pwr.edu.computermanagementtool.service.interfaces;

import pl.pwr.edu.computermanagementtool.entity.User;

import java.util.List;

public interface iUserService {

    User getUserById(int id);
    List<User> getAllUsers();

}
