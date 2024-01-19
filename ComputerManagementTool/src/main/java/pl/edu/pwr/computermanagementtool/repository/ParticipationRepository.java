package pl.edu.pwr.computermanagementtool.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.edu.pwr.computermanagementtool.entity.Participation;

import java.util.List;

@Repository
public interface ParticipationRepository extends JpaRepository<Participation, Integer> {



    List<Participation> findAllByUserId(int userId);
    List<Participation> findAllByUserIdAndIsWinner(int userId, boolean isWinner);
    List<Participation> findAllByIsWinnerIsTrue();

    List<Participation> findAllByDeviceCoreId(int deviceId);
    boolean existsByDeviceCoreId(int deviceId);
    boolean existsByDeviceCoreIdAndUserId(int deviceId, int userId);

    Participation findByDeviceCoreIdAndUserId(int deviceId, int userId);
}