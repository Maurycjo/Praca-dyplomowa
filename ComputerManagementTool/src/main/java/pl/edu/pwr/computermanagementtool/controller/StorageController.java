package pl.edu.pwr.computermanagementtool.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.edu.pwr.computermanagementtool.entity.Storage;
import pl.edu.pwr.computermanagementtool.repository.StorageRepository;
import pl.edu.pwr.computermanagementtool.service.StorageService;

@RestController
@RequestMapping("/storages")
@CrossOrigin(origins = "*")
public class StorageController extends ComponentController<Storage> {

    private final StorageService storageService;
    private final StorageRepository storageRepository;

    public StorageController(StorageService storageService, StorageRepository storageRepository) {
        super(storageService, storageRepository);
        this.storageService = storageService;
        this.storageRepository = storageRepository;
    }
}
