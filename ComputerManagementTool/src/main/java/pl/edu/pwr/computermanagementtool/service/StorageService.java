package pl.pwr.edu.computermanagementtool.service;
import org.springframework.stereotype.Service;
import pl.pwr.edu.computermanagementtool.entity.Cpu;
import pl.pwr.edu.computermanagementtool.entity.Storage;
import pl.pwr.edu.computermanagementtool.repository.StorageRepository;

import java.util.Optional;


@Service
public class StorageService extends ComponentService<Storage> {

    private final StorageRepository storageRepository;


    public StorageService(StorageRepository storageRepository) {
        super(storageRepository);
        this.storageRepository = storageRepository;
    }

    @Override
    public Storage add(String name, Double price) {
        Optional<Storage> storageOptional = storageRepository.findFirstByNameContains(name);
        Storage storage;
        if (storageOptional.isPresent()) {
            storage = storageOptional.get();
            storage.setPrice(price);
            return storage;
        } else {
            storage = new Storage();
            storage.setName(name);
            storage.setPrice(price);
            return storageRepository.save(storage);
        }
    }


}
