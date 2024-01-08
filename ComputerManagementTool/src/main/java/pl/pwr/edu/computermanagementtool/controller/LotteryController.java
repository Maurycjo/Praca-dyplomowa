package pl.pwr.edu.computermanagementtool.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.pwr.edu.computermanagementtool.entity.Lottery;
import pl.pwr.edu.computermanagementtool.service.LotteryService;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/lottery")
public class LotteryController {

    private final LotteryService lotteryService;


    public LotteryController(LotteryService lotteryService) {
        this.lotteryService = lotteryService;
    }

    @PostMapping("/add")
    public ResponseEntity<Lottery> addLottery(
            @RequestParam(required = true) Integer deviceId,
            @RequestParam(required = false) LocalDate lotteryDate,
            @RequestParam(required = false) LocalDate lotteryDateMin,
            @RequestParam(required = false) LocalDate lotteryDateMax,
            @RequestParam(required = false) Integer minParticipant,
            @RequestParam(required = false) Integer lotteryDaysAfterMin){


        try{
            Lottery newLottery = lotteryService.createLottery(deviceId, lotteryDate, lotteryDateMin,
                                                        lotteryDateMax, minParticipant, lotteryDaysAfterMin);
            return new ResponseEntity<>(newLottery, HttpStatus.CREATED);
        } catch (RuntimeException e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }

    @GetMapping("/all")
    public List<Lottery> getAllLotteries(){
        return lotteryService.getAllLotteries();
    }

    @GetMapping("/{id}")
    Lottery getLotteryById(@PathVariable int id){
        return lotteryService.getLotteryById(id);
    }

    @DeleteMapping("/{id}")
    void deleteLottery(@PathVariable int id){
        lotteryService.cancelLottery(id);
    }




}
