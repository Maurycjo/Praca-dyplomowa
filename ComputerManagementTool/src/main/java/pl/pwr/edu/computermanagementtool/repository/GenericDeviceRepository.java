package pl.pwr.edu.computermanagementtool.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import pl.pwr.edu.computermanagementtool.entity.Computer;
import pl.pwr.edu.computermanagementtool.entity.DeviceCore;

import java.util.List;

@NoRepositoryBean
public interface GenericDeviceRepository<T extends DeviceCore> extends JpaRepository<T, Integer> {

    List<T> findAllByReadyToLotteryIsTrueAndOffice(int officeId);
    List<T> findAllByReadyToLotteryIsTrue();
    List<T> findAllByOfficeId(int officeId);
}
