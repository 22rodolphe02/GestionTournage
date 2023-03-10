package com.tournage.repository;

import java.io.Serializable;
import java.util.List;

public interface Repository<T> {
    List<T> findAll();
    T findById(Serializable id);
    List<T> find(T example);
//    List<T> find();
}
