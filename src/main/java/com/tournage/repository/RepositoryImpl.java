package com.tournage.repository;

import com.tournage.models.Brother;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;

import java.io.Serializable;
import java.util.List;

public class RepositoryImpl<T> implements Repository<T>{
    protected SessionFactory sessionFactory;
    private Class<T> entityType;

    public RepositoryImpl() {
        System.out.println(this.getClass().getTypeParameters()[0]);
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<T> findAll() {
        Session session = sessionFactory.openSession();
//        Criteria criteria = session.createCriteria();

        return null;
    }

    @Override
    public T findById(Serializable id) {
        Session session = sessionFactory.openSession();
        T result = session.get(entityType, id);
        session.close();
        return result;
    }

    @Override
    public List<T> find(T entity) {
        Session session = this.sessionFactory.openSession();
        Example example = Example.create(entity);
        List<T> results = session.createCriteria(entity.getClass()).add(example).list();
        session.close();
        return results;
    }

    public static void main(String[] args) {
        RepositoryImpl<Brother> repository = new RepositoryImpl<>();
    }
}
