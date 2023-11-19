package pl.pwr.edu.computermanagementtool.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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
    T getComponentById(@PathVariable int id){
        return componentService.getById(id);
    }

    @GetMapping("/all")
    List<T> getAllComponents(){
        return componentRepository.findAll();
    }

    @DeleteMapping("/{id}")
    void deleteComponent(@PathVariable int id){
        componentService.delete(id);
    }

    @PostMapping("/add")
    public ResponseEntity<T> addComponent(
            @RequestParam(required = true) String name,
            @RequestParam(required = false) Double price){

        try {
            T newT = componentService.add(name, price);
            return new ResponseEntity<>(newT, HttpStatus.CREATED);
        } catch(RuntimeException e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }
}
