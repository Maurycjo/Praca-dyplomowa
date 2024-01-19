package pl.edu.pwr.computermanagementtool.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import pl.edu.pwr.computermanagementtool.entity.Component;

import java.util.Optional;

@NoRepositoryBean
public interface ComponentRepository<T extends Component> extends JpaRepository<T, Integer> {
    Optional<T> findFirstByNameContains(String name);
}
