package pl.pwr.edu.computermanagementtool.service;
import org.springframework.stereotype.Service;
import pl.pwr.edu.computermanagementtool.entity.DeviceCore;
import pl.pwr.edu.computermanagementtool.entity.Lottery;
import pl.pwr.edu.computermanagementtool.entity.Participation;
import pl.pwr.edu.computermanagementtool.enums.LotteryState;
import pl.pwr.edu.computermanagementtool.repository.LotteryRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;


@Service
public class LotteryService{

    private final LotteryRepository lotteryRepository;
    private final DeviceCoreService deviceCoreService;

    public LotteryService(LotteryRepository lotteryRepository, DeviceCoreService deviceCoreService) {
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

    public Lottery createLottery(Integer deviceId, LocalDate lotteryDate, Integer minParticipants) throws Exception{

        Lottery lottery = new Lottery();

        if(lotteryRepository.existsByDeviceCoreId(deviceId)){
            throw new Exception("Lottery with device_id: "+ deviceId+" already exists");
        }

        DeviceCore deviceCore = deviceCoreService.getDeviceById(deviceId);

        lottery.setLotteryDate(lotteryDate);
        lottery.setMinNumberOfParticipation(minParticipants);
        lottery.setDeviceCore(deviceCore);

        return lotteryRepository.save(lottery);
    }

    public void cancelLottery(int id){
        lotteryRepository.deleteById(id);
    }

    public Lottery getLotteryByDeviceId(int deviceId){
        return lotteryRepository.findByDeviceCoreId(deviceId);
    }

    public Lottery updateLotteryDate(int id, LocalDate lotteryDate){

        Lottery lottery = this.getLotteryById(id);
        lottery.setLotteryDate(lotteryDate);
        return lotteryRepository.save(lottery);
    }

    public Lottery changeMinNumberOfParticipants(int id, int minNumberOfParticipants){

        Lottery lottery = this.getLotteryById(id);
        lottery.setMinParticipant(minNumberOfParticipants);
        return lotteryRepository.save(lottery);

    }

    boolean existsByDeviceCoreId(Integer deviceId){
        return lotteryRepository.existsByDeviceCoreId(deviceId);
    }


}
