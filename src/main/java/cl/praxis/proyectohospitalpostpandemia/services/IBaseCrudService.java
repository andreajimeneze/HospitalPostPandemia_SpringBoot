package cl.praxis.proyectohospitalpostpandemia.services;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IBaseCrudService<T> {
    List<T> getAll();
    T getById(int id);
    T create(T t);
    T update(T t);
    void delete(int id);
}
