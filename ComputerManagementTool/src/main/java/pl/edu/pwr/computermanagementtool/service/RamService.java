package pl.pwr.edu.computermanagementtool.service;
import org.springframework.stereotype.Service;
import pl.pwr.edu.computermanagementtool.entity.Ram;
import pl.pwr.edu.computermanagementtool.repository.RamRepository;

import java.util.Optional;


@Service
public class RamService extends ComponentService<Ram>{

    private final RamRepository ramRepository;

    public RamService(RamRepository ramRepository) {
        super(ramRepository);
        this.ramRepository = ramRepository;
    }

    @Override
    public Ram add(String name, Double price) {
        Optional<Ram> ramOptional = ramRepository.findFirstByNameContains(name);
        Ram ram;
        if(ramOptional.isPresent()){
            ram = ramOptional.get();
            ram.setPrice(price);
            return ram;
        }else{
            ram = new Ram();
            ram.setName(name);
            ram.setPrice(price);
            return ramRepository.save(ram);
        }


    }
}
