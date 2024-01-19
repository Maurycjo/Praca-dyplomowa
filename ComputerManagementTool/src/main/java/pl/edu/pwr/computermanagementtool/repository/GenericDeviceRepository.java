package pl.edu.pwr.computermanagementtool.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import pl.edu.pwr.computermanagementtool.entity.DeviceCore;

import java.util.List;

@NoRepositoryBean
public interface GenericDeviceRepository<T extends DeviceCore> extends JpaRepository<T, Integer> {

    List<T> findAllByReadyToLotteryIsTrueAndOffice(int officeId);
    List<T> findAllByReadyToLotteryIsTrue();
    List<T> findAllByOfficeId(int officeId);
}
