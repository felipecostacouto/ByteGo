package com.gpti.bytego.model;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class EntityManagerFactorySingleton
{
    private static final String persistenceUnitName = "PERSISTENCE";
    private static EntityManagerFactory entityManagerFactory;

    private EntityManagerFactorySingleton() {}

    public static EntityManagerFactory getInstance()
    {
        if (entityManagerFactory == null)
        {
            entityManagerFactory = Persistence.createEntityManagerFactory(persistenceUnitName);
        }

        return entityManagerFactory;
    }
}
