package pl.pwr.edu.computermanagementtool.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.pwr.edu.computermanagementtool.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {
}