package pl.pwr.edu.computermanagementtool.repository;

import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.pwr.edu.computermanagementtool.entity.BasicDevice;

import java.util.List;

@Repository
@Primary
public interface BasicDeviceRepository extends GenericDeviceRepository<BasicDevice>{

}