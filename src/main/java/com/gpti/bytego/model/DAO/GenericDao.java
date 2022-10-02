package com.gpti.bytego.model.DAO;

import com.gpti.bytego.model.EntityManagerFactorySingleton;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;

import java.util.List;

public abstract class GenericDao<T>
{
    protected final EntityManager entityManager = EntityManagerFactorySingleton.getInstance().createEntityManager();

    protected void create(Object register)
    {
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        entityManager.persist(register);
        entityManager.getTransaction().commit();
        entityManager.clear();
    }

    protected void remove(Class<T> entityClass, Object primaryKey)
    {
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        T entityFound = entityManager.find(entityClass, primaryKey);
        if (entityFound != null) {
            entityManager.remove(entityFound);
        }
        else {
            System.out.println("Tried to remove entity " + entityClass.toString() + " but row doesn't exist.");
        }
        entityManager.getTransaction().commit();
        entityManager.clear();
    }

    protected T find(Class<T> entityClass, Object primaryKey)
    {
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        T entityFound = entityManager.find(entityClass, primaryKey);
        entityManager.getTransaction().commit();
        entityManager.clear();
        return entityFound;
    }

    protected List<?> findAll(String sqlQuery, Class<T> entityClass)
    {
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        Query query = entityManager.createNativeQuery(sqlQuery, entityClass);
        entityManager.getTransaction().commit();
        entityManager.clear();
        return query.getResultList();
    }

    protected void update(String updateQuery)
    {
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        entityManager.createNativeQuery(updateQuery).executeUpdate();
        entityManager.getTransaction().commit();
        entityManager.clear();
    }

    protected boolean isDuplicatePrimaryKey(Class<T> entityClass, Object primaryKey)
    {
        if (find(entityClass, primaryKey) != null)
        {
            System.out.println("An instance of " + entityClass.toString() + " with primary key "
                    + primaryKey.toString() + " is already exist.");
            return true;
        }
        return false;
    }
}
