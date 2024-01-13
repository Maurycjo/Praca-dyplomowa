package pl.pwr.edu.computermanagementtool.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.pwr.edu.computermanagementtool.entity.Participation;
import pl.pwr.edu.computermanagementtool.service.ParticipationService;

import java.util.List;

@RestController
@RequestMapping("/participation")
@CrossOrigin(origins = "*")
public class ParticipationController {

    private final ParticipationService participationService;

    public ParticipationController(ParticipationService participationService) {
        this.participationService = participationService;
    }

    @PostMapping("/add")
    public ResponseEntity<Participation> addParticipation(
            @RequestParam(required = true) Integer deviceId,
            @RequestParam(required = true) Integer userId){

        try{

            Participation newParticipation = participationService.createParticipation(deviceId, userId);
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
    @GetMapping("/device-participation/{device_id}")
    List<Participation> getUsersForDevice(@PathVariable int device_id){
        return participationService.getAllParticipantsByUserIdWhereLose(device_id);
    }


}
