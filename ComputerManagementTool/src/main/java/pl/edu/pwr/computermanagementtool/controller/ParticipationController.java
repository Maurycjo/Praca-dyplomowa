package pl.edu.pwr.computermanagementtool.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.edu.pwr.computermanagementtool.dto.participation.ParticipationRequestDTO;
import pl.edu.pwr.computermanagementtool.entity.Participation;
import pl.edu.pwr.computermanagementtool.repository.ParticipationRepository;
import pl.edu.pwr.computermanagementtool.service.DeviceCoreService;
import pl.edu.pwr.computermanagementtool.service.ParticipationService;

import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/participation")
@CrossOrigin(origins = "*")
public class ParticipationController {

    private final ParticipationService participationService;
    private final ParticipationRepository participationRepository;
    private final DeviceCoreService deviceCoreService;

    public ParticipationController(ParticipationService participationService,
                                   ParticipationRepository participationRepository, DeviceCoreService deviceCoreService) {
        this.participationService = participationService;
        this.participationRepository = participationRepository;
        this.deviceCoreService = deviceCoreService;
    }

    @PostMapping("/add")
    public ResponseEntity<Participation> addParticipation(@RequestBody ParticipationRequestDTO participationRequestDTO){

        try{
            Participation newParticipation = participationService.createParticipation(participationRequestDTO.getDeviceId(), participationRequestDTO.getUserId());
            return new ResponseEntity<>(newParticipation, HttpStatus.CREATED);
        } catch (RuntimeException e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }

    @GetMapping("/all")
    List<Participation> getAllParticipants(){
        return participationService.getAllParticipants();
    }
    @DeleteMapping("/{id}")
    void deleteParticipation(@PathVariable int id){
        participationService.deleteParticipation(id);
    }

    @DeleteMapping("/delete-by-user_id-and-device_id")
    void deleteParticipantFromLotteryByUserIdAndDeviceId(
            @RequestParam int userId,
            @RequestParam int deviceId){

        Participation participation = participationRepository.findByDeviceCoreIdAndUserId(deviceId, userId);

        participationRepository.deleteById(participation.getId());
    }

    @GetMapping("/all-wins")
    List<Participation> getAllWonParticipants(){
        return participationService.getAllWonParticipants();
    }

    @GetMapping("/user-lottery-history/{id}")
    List<Participation> getAllParticipationByUserId(@PathVariable int id){
        return participationService.getAllParticipantsByUserId(id);
    }
    @GetMapping("/user-win-history/{user_id}")
    List<Participation> getUserWinsHistory(@PathVariable int user_id){
        return participationService.getAllParticipantsByUserIdWhereWin(user_id);
    }

    @GetMapping("/user-lose-history/{user_id}")
    List<Participation> getUserLoseHistory(@PathVariable int user_id){
        return participationService.getAllParticipantsByUserIdWhereLose(user_id);
    }

    @GetMapping("/user-pending-lottery/{user_id}")
    List<Participation> getUserPendingLottery(@PathVariable int user_id){
        return participationService.getAllParticipantsByUserIdWhereLotteryDateIsNull(user_id);
    }

    @GetMapping("/device-participation/{device_id}")
    List<Participation> getUsersForDevice(@PathVariable int device_id){
        return participationService.getAllParticipantsForDeviceWithId(device_id);
    }

    @GetMapping("/check-if-user-in-lottery")
    boolean checkIfUserIsInLottery(
            @RequestParam int userId,
            @RequestParam int deviceId) {

        return participationRepository.existsByDeviceCoreIdAndUserId(deviceId, userId);
    }

    @GetMapping("/select-random-winner/{deviceId}")
    ResponseEntity<Participation> getRandomWinner(@PathVariable int deviceId){

        List<Participation> participationList = participationService.getAllParticipantsForDeviceWithId(deviceId);


            if(participationList.isEmpty()){

                return  new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            Random rand = new Random();
            Participation randomParticipant = participationList.get(rand.nextInt(participationList.size()));

            randomParticipant.setWinner(true);
            deviceCoreService.setLotteryDateToToday(deviceId);
            participationRepository.save(randomParticipant);


            return new ResponseEntity(randomParticipant, HttpStatus.FOUND);
            
    }



}
