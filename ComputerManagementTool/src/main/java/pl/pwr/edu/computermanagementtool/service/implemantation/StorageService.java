package pl.pwr.edu.computermanagementtool.service.implemantation;
import org.springframework.stereotype.Service;
import pl.pwr.edu.computermanagementtool.entity.Storage;
import pl.pwr.edu.computermanagementtool.repository.StorageRepository;
import pl.pwr.edu.computermanagementtool.service.interfaces.iStorageService;

import java.util.List;

@Service
public class StorageService implements iStorageService{
    private final StorageRepository storageRepository;

    public StorageService(StorageRepository storageRepository) {
        this.storageRepository = storageRepository;
    }

    @Override
    public Storage getStorageById(int id) {
        return null;
    }

    @Override
    public List<Storage> getAllStorages() {
        return null;
    }
}
