package pl.pwr.edu.computermanagementtool.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.pwr.edu.computermanagementtool.entity.Participation;

import java.util.List;

@Repository
public interface ParticipationRepository extends JpaRepository<Participation, Integer> {


    boolean existsByLotteryIdAndUserId(int lotteryId, int userId);
    Participation findByUserIdAndLotteryId(int userId, int lotteryId);
    List<Participation> findAllByUserId(int userId);
    List<Participation> findAllByUserIdAndIsWinner(int userId, boolean isWinner);
    List<Participation> findAllByIsWinnerIsTrue();
    List<Participation> findAllByLotteryId(int lotteryId);

    int countAllByLotteryId(int lotteryId);


}