package com.tournage.repository;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

@org.springframework.stereotype.Repository
public class RepositoryImpl<T> implements Repository<T>{
    protected SessionFactory sessionFactory;
    private Class<T> entityType;

    public RepositoryImpl() {

    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public Class<T> getEntityType(){
        if (entityType == null){
            Type genericSuperclass = getClass().getGenericSuperclass();
            this.entityType = (Class<T>) ((ParameterizedType) genericSuperclass).getActualTypeArguments()[0];
        }
        return this.entityType;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<T> findAll() {
        Session session = sessionFactory.openSession();
        Criteria criteria = session.createCriteria(this.getEntityType());
        List<T> result = criteria.list();
        session.close();

        return result;
    }

    @Override
    public T findById(Serializable id) {
        Session session = sessionFactory.openSession();
        T result = session.get(this.getEntityType(), id);
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
        RepositoryImpl<String> repository = new RepositoryImpl<>();
    }
}
