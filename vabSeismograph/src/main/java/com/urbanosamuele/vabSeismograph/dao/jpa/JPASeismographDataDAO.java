package com.urbanosamuele.vabSeismograph.dao.jpa;

import com.urbanosamuele.vabSeismograph.dao.DAOFactoryJPA;
import com.urbanosamuele.vabSeismograph.dao.SeismographDataDAO;
import com.urbanosamuele.vabSeismograph.model.SeismographData;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.RollbackException;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;

/**
 * DAO methods implementation.
 * @author Samuele Urbano
 */
public class JPASeismographDataDAO implements SeismographDataDAO {

    private static JPASeismographDataDAO instance;

    private JPASeismographDataDAO() {

    }

    public static JPASeismographDataDAO getInstance() {
        if (instance == null) {
            instance = new JPASeismographDataDAO();
        }
        return instance;
    }

    @Override
    public boolean insert(List<SeismographData> seismographData) {
        try {
            EntityManager manager = DAOFactoryJPA.getManager();
            EntityTransaction transaction = manager.getTransaction();

            Instant millis = Instant.ofEpochMilli(System.currentTimeMillis());
            LocalDateTime timeToSet = LocalDateTime.ofInstant(millis, ZoneId.of("Europe/Rome"));
            LocalDateTime timeToSub = timeToSet.minusSeconds(20L);

            for (SeismographData data : seismographData) {
                LocalDateTime temporany = timeToSub.plusNanos(50000000L);
                timeToSet = temporany;
                data.setDate(timeToSet.format(SeismographData.DATE_TIME_FORMATTER));

                transaction.begin();
                manager.persist(data);
                manager.flush();
                transaction.commit();

                timeToSub = temporany;
            }
        } catch (RollbackException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<SeismographData> selectAll() {
        return DAOFactoryJPA.getManager()
                .createNamedQuery("SeismographData.selectAll", SeismographData.class)
                .getResultList();
    }

    @Override
    public List<SeismographData> selectLastRow() {
        return DAOFactoryJPA.getManager()
                .createNativeQuery("SELECT * FROM seismograph_data ORDER BY date DESC LIMIT 400;", SeismographData.class)
                .getResultList();
    }
}
