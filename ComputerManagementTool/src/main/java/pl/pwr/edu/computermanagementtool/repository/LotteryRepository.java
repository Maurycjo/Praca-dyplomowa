package pl.pwr.edu.computermanagementtool.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.pwr.edu.computermanagementtool.entity.Lottery;

public interface LotteryRepository extends JpaRepository<Lottery, Integer> {
}