package pl.pwr.edu.computermanagementtool.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.pwr.edu.computermanagementtool.entity.Participation;
import pl.pwr.edu.computermanagementtool.enums.LotteryState;
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
            @RequestParam(required = true) Integer lotteryId,
            @RequestParam(required = true) Integer userId){

        try{

            Participation newParticipation = participationService.createParticipation(lotteryId, userId);
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

    @GetMapping("/user/{id}")
    List<Participation> getAllParticipationByUserId(@PathVariable int id){
        return participationService.getAllParticipantsByUserId(id);
    }

    @GetMapping("/lottery/{id}")
    List<Participation> getAllParticipationByLotteryId(@PathVariable int id){
        return participationService.getAllParticipantsByLotteryId(id);
    }

    @GetMapping("/lottery/win")
    List<Participation> getAllWonParticipants(){
        return participationService.getAllWonParticipants();
    }

    @GetMapping("/lottery/win/{user_id}")
    List<Participation> getUserWinsHistory(@PathVariable int user_id){
        return participationService.getAllParticipantsByUserIdWhereWin(user_id);
    }

    @GetMapping("/lottery/lose/{user_id}")
    List<Participation> getUserLoseHistory(@PathVariable int user_id){
        return participationService.getAllParticipantsByUserIdWhereLose(user_id);
    }

    @GetMapping("/state/{id}")
    LotteryState getLotteryStateById(@PathVariable int id){
        return participationService.getLotteryStatus(id);
    }

}
