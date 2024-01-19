package pl.pwr.edu.computermanagementtool.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.pwr.edu.computermanagementtool.dto.components.ComponentRequestDTO;
import pl.pwr.edu.computermanagementtool.entity.Component;
import pl.pwr.edu.computermanagementtool.repository.ComponentRepository;
import pl.pwr.edu.computermanagementtool.service.ComponentService;

import java.util.List;

public abstract class ComponentController<T extends Component> {

    protected final ComponentService<T> componentService;
    protected final ComponentRepository<T> componentRepository;

    protected ComponentController(ComponentService<T> componentService, ComponentRepository<T> componentRepository) {
        this.componentService = componentService;
        this.componentRepository = componentRepository;
    }
    @GetMapping("/{id}")
    @CrossOrigin(origins = "*")
    T getComponentById(@PathVariable int id){
        return componentService.getById(id);
    }

    @GetMapping("/all")
    @CrossOrigin(origins = "*")
    List<T> getAllComponents(){
        return componentRepository.findAll();
    }

    @DeleteMapping("/{id}")
    @CrossOrigin(origins = "*")
    void deleteComponent(@PathVariable int id){
        componentService.delete(id);
    }

    @PostMapping("/add")
    @CrossOrigin(origins = "*")
    public ResponseEntity<T> addComponent(@RequestBody ComponentRequestDTO componentRequestDTO){

        try {
            T newT = componentService.add(componentRequestDTO.getName(), componentRequestDTO.getPrice());
            return new ResponseEntity<>(newT, HttpStatus.CREATED);
        } catch(RuntimeException e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/update/{id}")
    @CrossOrigin(origins = "*")
    public ResponseEntity<T> updateComponent(
            @PathVariable Integer id,
            @RequestBody ComponentRequestDTO componentRequestDTO){

        try{
            T updatedComponent = componentService.updateComponent(id, componentRequestDTO.getName(), componentRequestDTO.getPrice());
            return new ResponseEntity<>(updatedComponent, HttpStatus.OK);
        } catch (RuntimeException e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }

    }

}
