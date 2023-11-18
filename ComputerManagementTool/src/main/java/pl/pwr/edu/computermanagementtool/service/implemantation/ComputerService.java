package pl.pwr.edu.computermanagementtool.service.implemantation;
import org.springframework.stereotype.Service;
import pl.pwr.edu.computermanagementtool.entity.*;
import pl.pwr.edu.computermanagementtool.repository.*;
import pl.pwr.edu.computermanagementtool.service.interfaces.iComputerService;

import java.util.Optional;

@Service
public class ComputerService extends GenericDeviceService<Computer>  {

    private final CpuRepository cpuRepository;
    private final StorageRepository storageRepository;
    private final RamRepository ramRepository;
    public ComputerService(ComputerRepository computerRepository, LotteryRepository lotteryRepository,
                                        OfficeRepository officeRepository, CpuRepository cpuRepository,
                                        StorageRepository storageRepository, RamRepository ramRepository) {

        super(computerRepository, lotteryRepository, officeRepository);
        this.cpuRepository = cpuRepository;
        this.storageRepository = storageRepository;
        this.ramRepository = ramRepository;
    }


    public Computer addComputer(String deviceName, Double price, String description,
                                    Integer age, Boolean readyToSell, Integer officeId, String serialNumber,
                                String model, String operatingSystem,String batteryLife, Integer cpuId, Integer storageId, Integer ramId) {

        Computer computer = (Computer) addDevice(Computer.class, deviceName, price, description, age, readyToSell, officeId);
        computer.setSerialNumber(serialNumber);
        computer.setModel(model);
        computer.setOperatingSystem(operatingSystem);
        computer.setDeviceType(Computer.DEVICE_TYPE);
        computer.setBatteryLife(batteryLife);

        Optional<Cpu> cpuOptional = cpuRepository.findById(cpuId);
        Cpu cpu = cpuOptional.orElseThrow(()->new RuntimeException("Cpu not found with id: " + cpuId));
        computer.setCpu(cpu);

        Optional<Storage> storageOptional = storageRepository.findById(cpuId);
        Storage storage = storageOptional.orElseThrow(()->new RuntimeException("Storage not found with id: " + storageId));
        computer.setStorage(storage);

        Optional<Ram> ramOptional = ramRepository.findById(cpuId);
        Ram ram = ramOptional.orElseThrow(()->new RuntimeException("Ram not found with id: " + ramId));
        computer.setRam(ram);

        return genericRepository.save(computer);
    }

}
