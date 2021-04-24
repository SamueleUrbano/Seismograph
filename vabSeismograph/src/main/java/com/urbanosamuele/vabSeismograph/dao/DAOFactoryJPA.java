package com.urbanosamuele.vabSeismograph.dao;

import com.urbanosamuele.vabSeismograph.dao.jpa.JPASeismographDataDAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * The DAO Factory methods getter.
 * @author Samuele Urbano
 */
public class DAOFactoryJPA extends DAOFactory {

    /**
     * Returns the database connection.
     * @return - the entity manager.
     */
    public static EntityManager getManager() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        }
        catch(ClassNotFoundException e) {
            e.printStackTrace();
        }
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("seismograph");
        factory.getCache().evictAll();
        EntityManager manager = factory.createEntityManager();
        return manager;
    }


    @Override
    public SeismographDataDAO getSeismographDataDAO() {
        return JPASeismographDataDAO.getInstance();
    }
}
