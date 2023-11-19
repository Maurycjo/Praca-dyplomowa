package pl.pwr.edu.computermanagementtool.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import pl.pwr.edu.computermanagementtool.entity.Component;
import pl.pwr.edu.computermanagementtool.entity.Cpu;

import java.util.Optional;

@NoRepositoryBean
public interface ComponentRepository<T extends Component> extends JpaRepository<T, Integer> {
    Optional<T> findFirstByNameContains(String name);
}
