package pl.pwr.edu.computermanagementtool.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.pwr.edu.computermanagementtool.entity.Tablet;

import java.util.List;

@Repository
public interface TabletRepository extends GenericDeviceRepository<Tablet>{


}