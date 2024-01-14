package pl.pwr.edu.computermanagementtool.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.pwr.edu.computermanagementtool.entity.Participation;

import java.util.List;

@Repository
public interface ParticipationRepository extends JpaRepository<Participation, Integer> {



    List<Participation> findAllByUserId(int userId);
    List<Participation> findAllByUserIdAndIsWinner(int userId, boolean isWinner);
    List<Participation> findAllByIsWinnerIsTrue();

    List<Participation> findAllByDeviceCoreId(int deviceId);
    boolean existsByDeviceCoreId(int deviceId);

}