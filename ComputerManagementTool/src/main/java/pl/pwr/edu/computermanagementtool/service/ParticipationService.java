package pl.pwr.edu.computermanagementtool.service;
import org.springframework.stereotype.Service;
import pl.pwr.edu.computermanagementtool.entity.Lottery;
import pl.pwr.edu.computermanagementtool.entity.Participation;
import pl.pwr.edu.computermanagementtool.entity.User;
import pl.pwr.edu.computermanagementtool.repository.ParticipationRepository;

import java.util.ArrayList;
import java.util.List;


@Service
public class ParticipationService{

    private final ParticipationRepository participationRepository;
    private final LotteryService lotteryService;
    private final UserService userService;

    public ParticipationService(ParticipationRepository participationRepository, LotteryService lotteryService, UserService userService) {
        this.participationRepository = participationRepository;
        this.lotteryService = lotteryService;
        this.userService = userService;
    }


    public Participation createParticipation(int lotteryId, int userId) throws Exception{

        Participation participation = new Participation();
        Lottery lottery = lotteryService.getLotteryById(lotteryId);
        User user = userService.getUserById(userId);

        if(participationRepository.existsByLotteryIdAndUserId(lotteryId, userId)){

            throw new RuntimeException("Participant with id: "+userId+" already take part in lottery with id: "+lotteryId);
        }

        participation.setLottery(lottery);
        participation.setUser(user);
        participation.setIsWinner(false);

        return participationRepository.save(participation);
    }


    public List<Participation> getAllParticipants(){
        return participationRepository.findAll();
    }

    public List<Participation> getAllParticipantsByUserId(int userId){

        return participationRepository.findAllByUserId(userId);
    }

    public List<Participation> getAllParticipantsByUserIdWhereWin(int userId){

        return participationRepository.findAllByUserIdAndIsWinner(userId, true);
    }

    public List<Participation> getAllParticipantsByUserIdWhereLose(int userId){

        return participationRepository.findAllByUserIdAndIsWinner(userId, false);
    }

    public List<Participation> getAllWonParticipants(){

        return participationRepository.findAllByIsWinnerIsTrue();
    }

    public List<Participation> getAllParticipantsByLotteryId(int lotteryId){
        return participationRepository.findAllByLotteryId(lotteryId);
    }

    public void deleteParticipation(int participationId){

        participationRepository.deleteById(participationId);
    }


}
