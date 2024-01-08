package pl.pwr.edu.computermanagementtool.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.pwr.edu.computermanagementtool.entity.Lottery;

@Repository
public interface LotteryRepository extends JpaRepository<Lottery, Integer> {

    boolean existsByDeviceId(int deviceId);

}