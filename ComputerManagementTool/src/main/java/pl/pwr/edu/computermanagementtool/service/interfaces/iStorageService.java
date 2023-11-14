package pl.pwr.edu.computermanagementtool.service.interfaces;

import pl.pwr.edu.computermanagementtool.entity.Storage;

import java.util.List;

public interface iStorageService {

    Storage getStorageById(int id);
    List<Storage> getAllStorages();
}
