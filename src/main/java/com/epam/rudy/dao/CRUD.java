package com.epam.rudy.dao;

import java.io.IOException;
import java.util.List;

import com.epam.rudy.dao.exception.EntityNotFoundException;
import com.epam.rudy.entity.Vehicle;

public interface CRUD<T> {

    Vehicle create(T entity) throws Exception;

    Vehicle retrieve(String id) throws EntityNotFoundException, IOException;

    List<T> retrieveAll() throws Exception;

    T update(T entity) throws Exception;

    void delete(String id) throws EntityNotFoundException, IOException;

    void deleteAll() throws Exception;
}
