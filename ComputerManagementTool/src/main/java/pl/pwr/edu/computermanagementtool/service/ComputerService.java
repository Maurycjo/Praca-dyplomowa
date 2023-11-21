package pl.pwr.edu.computermanagementtool.service;
import org.springframework.stereotype.Service;
import pl.pwr.edu.computermanagementtool.entity.*;
import pl.pwr.edu.computermanagementtool.repository.*;


import java.util.Optional;

@Service
public class ComputerService extends GenericDeviceService<Computer>  {

    private final CpuService cpuService;
    private final StorageService storageService;
    private final RamService ramService;
    public ComputerService(ComputerRepository computerRepository, LotteryRepository lotteryRepository,
                                        OfficeRepository officeRepository,CpuService cpuService,
                                            StorageService storageService, RamService ramService) {

        super(computerRepository, lotteryRepository, officeRepository);
        this.cpuService = cpuService;
        this.storageService = storageService;
        this.ramService = ramService;
    }


    public Computer addComputer(String deviceName, Double price, String description,
                                Integer age, Boolean readyToSell, Integer officeId, String serialNumber,
                                String model, String operatingSystem,String batteryLife, String cpuName, String storageName, String ramName){


        Integer cpuId = null, storageId = null, ramId = null;

        Cpu cpu = (Cpu) cpuService.addOrGetComponentWithName(cpuName, Cpu.class);
        Storage storage = (Storage) storageService.addOrGetComponentWithName(storageName, Storage.class);
        Ram ram = (Ram) ramService.addOrGetComponentWithName(ramName, Ram.class);

        if(cpu != null){
            cpuId = cpu.getId();
        }
        if(storage != null){
            storageId = storage.getId();
        }
        if(ram != null){
            ramId = ram.getId();
        }

        return addComputer(deviceName, price, description, age, readyToSell, officeId,
                                                serialNumber, model, operatingSystem, batteryLife,
                                                                        cpuId, storageId, ramId);
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

        if(cpuId!=null){
            Cpu cpu = cpuService.getById(cpuId);
            computer.setCpu(cpu);
        }
        if(storageId!=null){
            Storage storage = storageService.getById(storageId);
            computer.setStorage(storage);
        }
        if(ramId!=null){
            Ram ram = ramService.getById(ramId);
            computer.setRam(ram);
        }

        return genericDeviceRepository.save(computer);
    }

    public Computer updateComputer(int id, String deviceName, Double price, String description,
                                Integer age, Boolean readyToSell, Integer officeId, String serialNumber,
                                String model, String operatingSystem,String batteryLife, String cpuName, String storageName, String ramName) {


        Computer computer = updateDevice(id, deviceName, price, description, age, readyToSell, officeId);

        if(serialNumber!=null)  computer.setSerialNumber(serialNumber);
        if(model!=null)         computer.setModel(model);
        if(operatingSystem!=null)computer.setOperatingSystem(operatingSystem);
        if(batteryLife!=null)   computer.setBatteryLife(batteryLife);

        if (officeId != null){
            Optional<Office> officeOptional = officeRepository.findById(officeId);
            Office office = officeOptional.orElseThrow(()-> new RuntimeException("Office not found with id: " + officeId));
            computer.setOffice(office);
        }

        if(cpuName!=null){
            Cpu cpu = (Cpu) cpuService.addOrGetComponentWithName(cpuName, Cpu.class);
            computer.setCpu(cpu);
        }
        if(storageName!=null){
            Storage storage = (Storage) storageService.addOrGetComponentWithName(storageName, Storage.class);
            computer.setStorage(storage);
        }

        if(ramName!=null){
            Ram ram = (Ram) ramService.addOrGetComponentWithName(ramName, Ram.class);
            computer.setRam(ram);
        }

        return genericDeviceRepository.save(computer);
    }


}
