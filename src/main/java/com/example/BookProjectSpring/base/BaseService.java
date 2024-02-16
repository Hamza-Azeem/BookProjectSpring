package com.example.BookProjectSpring.base;
import jakarta.persistence.MappedSuperclass;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@MappedSuperclass
public class BaseService <T extends BaseEntity, ID>{
    @Autowired
    private BaseRepository<T, ID> baseRepository;
    public T findObjectById(ID id){
        return baseRepository.findById(id).get();
    }
    public List<T> findAllObjects(){
        return baseRepository.findAll();
    }
    public T insertObejct(T object){
        object.setStatusCode("created");
        return baseRepository.save(object);
    }
    public T updateObject(T object){
        return baseRepository.save(object);
    }
    public void deleteObject(ID id){
        baseRepository.deleteById(id);
    }
}
