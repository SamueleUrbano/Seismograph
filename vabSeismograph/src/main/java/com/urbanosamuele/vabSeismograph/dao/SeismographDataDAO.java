package com.urbanosamuele.vabSeismograph.dao;

import com.urbanosamuele.vabSeismograph.model.SeismographData;

import java.util.List;

/**
 * SeismographData .class DAO methods, (SQL Query).
 * @author Samuele Urbano
 */
public interface SeismographDataDAO {

    /**
     * Insert data into the database.
     * @param seismographData - The data list.
     * @return - true or false.
     */
    public boolean insert(List<SeismographData> seismographData);

    /**
     * Select all data from the database.
     * @return - The data list.
     */
    public List<SeismographData> selectAll();

    /**
     * Select the last 200 row data from the database.
     * @return - The data list.
     */
    public List<SeismographData> selectLastRow();
}
