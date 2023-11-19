package pl.pwr.edu.computermanagementtool.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.pwr.edu.computermanagementtool.entity.Storage;
import pl.pwr.edu.computermanagementtool.repository.StorageRepository;
import pl.pwr.edu.computermanagementtool.service.StorageService;

@RestController
@RequestMapping("/storages")
public class StorageController extends ComponentController<Storage> {

    private final StorageService storageService;
    private final StorageRepository storageRepository;

    public StorageController(StorageService storageService, StorageRepository storageRepository) {
        super(storageService, storageRepository);
        this.storageService = storageService;
        this.storageRepository = storageRepository;
    }
}
