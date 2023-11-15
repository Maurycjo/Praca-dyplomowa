package pl.pwr.edu.computermanagementtool.repository;

import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Repository;
import pl.pwr.edu.computermanagementtool.entity.BasicDevice;
import pl.pwr.edu.computermanagementtool.entity.iDevice;

import java.util.List;


@NoRepositoryBean
public interface GenericDeviceRepository<T extends iDevice> extends JpaRepository<T, Integer>{

    List<T> findAllByReadyToSellIsTrue();
    List<T> findAllByReadyToSellIsFalse();
    List<T> findAllByOfficeId(int officeId);

}
