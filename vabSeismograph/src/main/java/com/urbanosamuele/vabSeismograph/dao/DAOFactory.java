package com.urbanosamuele.vabSeismograph.dao;

/**
 * DAO Factory class.
 * @author Samuele Urbano
 */
public abstract class DAOFactory {

    /**
     * The connector type.
     */
    public enum Type {
        JPA;
    }

    public static DAOFactory getDaoFactory(Type type) {
        switch(type) {
            default:
                return new DAOFactoryJPA();
        }
    }

    public abstract SeismographDataDAO getSeismographDataDAO();
}
