package br.com.venustech.service;


import br.com.venustech.model.AbstractModel;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;

public abstract class AbstractService<T extends AbstractModel<Long>, Long extends Serializable> {

    private static final int PAGE_SIZE = 5;

    protected abstract JpaRepository<T, Long> getRepository();

    public Page<T> getList(Integer pageNumber) {
        PageRequest pageRequest = new PageRequest(pageNumber - 1, PAGE_SIZE, Sort.Direction.ASC, "id");

        return getRepository().findAll(pageRequest);
    }

    public T save(T entity) {
        return getRepository().save(entity);
    }

    public T get(Long id) {
        T entity = getRepository().findOne(id);
        return entity;
    }

    public void delete(Long id) {
        try {
            getRepository().delete(id);
        } catch (EmptyResultDataAccessException e) {
        }
    }

    public void update(T entity) {
        T getEntity = getRepository().findOne(entity.getId());
        getRepository().save(entity);
    }

}