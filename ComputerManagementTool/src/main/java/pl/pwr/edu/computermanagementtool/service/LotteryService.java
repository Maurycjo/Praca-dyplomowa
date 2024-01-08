package pl.pwr.edu.computermanagementtool.service;
import org.springframework.stereotype.Service;
import pl.pwr.edu.computermanagementtool.entity.Computer;
import pl.pwr.edu.computermanagementtool.entity.DeviceCore;
import pl.pwr.edu.computermanagementtool.entity.Lottery;
import pl.pwr.edu.computermanagementtool.repository.LotteryRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;


@Service
public class LotteryService{

    private final LotteryRepository lotteryRepository;
    private final ComputerService deviceCoreService;

    public LotteryService(LotteryRepository lotteryRepository, ComputerService deviceCoreService) {
        this.lotteryRepository = lotteryRepository;
        this.deviceCoreService = deviceCoreService;
    }
    public Lottery getLotteryById(Integer id){

        Optional <Lottery> lotteryOptional = lotteryRepository.findById(id);
        return lotteryOptional.orElseThrow(()-> new RuntimeException("Lottery not found with id: " + id));

    }
    public List<Lottery> getAllLotteries(){
        return lotteryRepository.findAll();
    }

    public Lottery createLottery(Integer deviceId, LocalDate lotteryDate, LocalDate lotteryDateMin,
                                 LocalDate lotteryDateMax, Integer minParticipants, Integer lotteryDaysAfterMin) throws Exception{


        if(lotteryRepository.existsByDeviceId(deviceId)){
            throw new Exception("lottery with device_id: " + deviceId + " already exists!");
        }

        Lottery lottery = new Lottery();

        Computer deviceCore = deviceCoreService.getDeviceById(deviceId);

        lottery.setDevice(deviceCore);
        lottery.setLotteryDate(lotteryDate);
        lottery.setLotteryDateMin(lotteryDateMin);
        lottery.setLotteryDateMax(lotteryDateMax);
        lottery.setMinNumberOfParticipation(minParticipants);
        lottery.setLotteryDaysAfterMin(lotteryDaysAfterMin);

        return lotteryRepository.save(lottery);
    }

    public void cancelLottery(int id){
        lotteryRepository.deleteById(id);
    }


}
