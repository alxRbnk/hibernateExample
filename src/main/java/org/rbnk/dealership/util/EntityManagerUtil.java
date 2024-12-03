package org.rbnk.dealership.util;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class EntityManagerUtil {
    private final EntityManagerFactory entityManagerFactory;

    public EntityManagerUtil(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    public EntityManager createEntityManager() {
        return entityManagerFactory.createEntityManager();
    }

    public void close() {
        entityManagerFactory.close();
    }
}