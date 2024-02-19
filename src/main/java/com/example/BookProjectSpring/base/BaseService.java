package com.example.BookProjectSpring.base;
import com.example.BookProjectSpring.exception.RecordNotFoundException;
import jakarta.persistence.MappedSuperclass;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

@MappedSuperclass
public class BaseService <T extends BaseEntity, ID>{
    @Autowired
    private BaseRepository<T, ID> baseRepository;
    public T findObjectById(ID id){
        Optional<T> entity = baseRepository.findById(id);
        if(entity.isEmpty()){
            throw new RecordNotFoundException("There is no record with id=" + id+ " in our database.");
        }
        return entity.get();
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
