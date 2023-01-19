package com.bilgeadam.Repository;

public interface ICrud <T>{
    void save(T t);
    void getAll();
    void update(T t);
    void delete(T t);
    void getAllByFilmName(String filmAdi);
}
