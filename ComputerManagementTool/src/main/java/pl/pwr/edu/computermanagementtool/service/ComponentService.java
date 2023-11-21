package pl.pwr.edu.computermanagementtool.service;

import pl.pwr.edu.computermanagementtool.entity.Component;
import pl.pwr.edu.computermanagementtool.repository.ComponentRepository;

import java.util.Optional;

public abstract class ComponentService<T extends Component> {


    protected final ComponentRepository<T> componentRepository;

    protected ComponentService(ComponentRepository<T> componentRepository) {
        this.componentRepository = componentRepository;
    }


    public Component addOrGetComponentWithName(String name, Class<T> componentClass){

        T newComponent = null;

        if( name != null) {

            Optional<T> componentOptional = componentRepository.findFirstByNameContains(name);

            if (componentOptional.isPresent()) {
                newComponent = componentOptional.get();
            } else {

                try {
                    newComponent = componentClass.newInstance();
                    newComponent.setName(name);
                    componentRepository.save(newComponent);
                } catch (InstantiationException | IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return newComponent;
    }

    public T getById(int id){
        Optional<T> componentOptional = componentRepository.findById(id);
        T component = componentOptional.orElseThrow(()-> new RuntimeException("Component not found with id: " + id));

        return component;
    }

    public abstract T add(String name, Double price);
    public void delete(int id){
        componentRepository.deleteById(id);
    }

    public T updateComponent(int id, String name, Double price) throws Exception {


        T component = getById(id);
        Optional<T> checkIfExistComponent = componentRepository.findFirstByNameContains(name);

        if(checkIfExistComponent.isPresent()){
            T checkNameComponent = checkIfExistComponent.get();
            if(!name.equals(component.getName())){
                throw new Exception("Component with name: " + name + "already exist");
            }
        }

        if(name!= null) component.setName(name);
        if(price!=null) component.setPrice(price);

        return componentRepository.save(component);
    }


}
