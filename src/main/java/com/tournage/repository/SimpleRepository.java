package com.tournage.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.io.Serializable;
import java.util.List;

public class SimpleRepository{
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public <T> List<T> findAll(Class<T> classe) {
        return null;
    }

    public <T> T findById(Serializable id, Class<T> classe) {
        Session session = sessionFactory.openSession();
        T result = session.get(classe, id);
        session.close();
        return result;
    }

    public <T> List<T> find(T entity) {
        Session session = this.sessionFactory.openSession();
        Example example = Example.create(entity);
        List<T> results = session.createCriteria(entity.getClass()).add(example).list();
        session.close();
        return results;
    }
}
