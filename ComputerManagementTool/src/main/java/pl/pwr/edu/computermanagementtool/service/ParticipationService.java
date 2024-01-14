package pl.pwr.edu.computermanagementtool.service;
import org.springframework.stereotype.Service;
import pl.pwr.edu.computermanagementtool.entity.DeviceCore;
import pl.pwr.edu.computermanagementtool.entity.Participation;
import pl.pwr.edu.computermanagementtool.entity.User;
import pl.pwr.edu.computermanagementtool.repository.ParticipationRepository;

import java.util.ArrayList;
import java.util.List;


@Service
public class ParticipationService{

    private final ParticipationRepository participationRepository;
    private final DeviceCoreService deviceCoreService;
    private final UserService userService;

    public ParticipationService(ParticipationRepository participationRepository, DeviceCoreService deviceCoreService, DeviceCoreService deviceCoreService1, UserService userService) {
        this.participationRepository = participationRepository;
        this.deviceCoreService = deviceCoreService1;
        this.userService = userService;
    }


    public Participation createParticipation(int deviceId, int userId){


        try{
            Participation participation = new Participation();

            DeviceCore device = deviceCoreService.getDeviceById(deviceId);
            User user = userService.getUserById(userId);

            boolean exist = participationRepository.existsByDeviceCoreId(deviceId);

            if(exist){
                throw new Exception("Participant already take part in lottery with device_id: " +  deviceId);
            }

            participation.setUser(user);
            participation.setDeviceCore(device);
            participation.setWinner(false);

            return participationRepository.save(participation);
        } catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException("Failed to create participation.", e);
        }


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


    public void deleteParticipation(int participationId){

        participationRepository.deleteById(participationId);
    }

    public List<Participation> getAllParticipantsForDeviceWithId(int deviceId){
        return participationRepository.findAllByDeviceCoreId(deviceId);
    }


    //all pending lottery for user
    public List<Participation> getAllParticipantsByUserIdWhereLotteryDateIsNull(int userId){

        List<Participation> participationList = participationRepository.findAllByUserId(userId);

        List<Participation> pendingList = new ArrayList<>();

        for(var p : participationList){
            if(p.getDeviceCore().getLotteryDate()==null){
                pendingList.add(p);
            }
        }

        return pendingList;

    }


}
