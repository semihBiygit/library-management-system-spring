package com.semih.librarymanagementsystem.service;

import com.semih.librarymanagementsystem.repository.entity.State;
import com.semih.librarymanagementsystem.repository.entity.StateInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public class ServiceManager<T extends StateInfo, ID> implements IServices<T, ID> {

    private final JpaRepository<T, ID> service;

    public ServiceManager(JpaRepository<T, ID> service) {
        this.service = service;
    }

    @Override
    public T save(T entity) {
        entity.setState(State.ACTIVE);
        return service.save(entity);
    }

    @Override
    public Iterable<T> saveAll(Iterable<T> entities) {
        return service.saveAll(entities);
    }

    @Override
    public T update(T entity) {
        return null;
    }

    @Override
    public void delete(T entity) {
        entity.setState(State.PASSIVE);
        service.save(entity);
    }

    @Override
    public void deleteById(ID id) {
        T entity = service.findById(id).get();
        entity.setState(State.PASSIVE);
        service.save(entity);

    }

    @Override
    public T findById(ID id) {
        return service.getReferenceById(id);
    }

    @Override
    public List<T> findAll() {
        return service.findAll();
    }
}
