package pl.pwr.edu.computermanagementtool.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.pwr.edu.computermanagementtool.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
}