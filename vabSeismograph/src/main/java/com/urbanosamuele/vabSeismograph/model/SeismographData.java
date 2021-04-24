package com.urbanosamuele.vabSeismograph.model;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * The class that represents the "seismograph_data" entity.
 * @author Samuele Urbano
 */
@Entity
@Table(name = "seismograph_data")
@NamedQuery(name="SeismographData.selectAll", query="select s from SeismographData s")
public class SeismographData {

    @Transient
    public static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS");

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "x_axis", nullable = false)
    private double xAxis;

    @Column(name = "y_axis", nullable = false)
    private double yAxis;

    @Column(name = "z_axis", nullable = false)
    private double zAxis;

    @Column(name = "date", nullable = false)
    private LocalDateTime date;

    public SeismographData() {

    }

    public SeismographData(double xAxis, double yAxis, double zAxis, String date) {
        this.xAxis = xAxis;
        this.yAxis = yAxis;
        this.zAxis = zAxis;
        this.date = LocalDateTime.parse(date, DATE_TIME_FORMATTER);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getxAxis() {
        return xAxis;
    }

    public void setxAxis(double xAxis) {
        this.xAxis = xAxis;
    }

    public double getyAxis() {
        return yAxis;
    }

    public void setyAxis(double yAxis) {
        this.yAxis = yAxis;
    }

    public double getzAxis() {
        return zAxis;
    }

    public void setzAxis(double zAxis) {
        this.zAxis = zAxis;
    }

    public String getDate() {
        return date.format(DATE_TIME_FORMATTER);
    }

    public void setDate(String date) {
        this.date = LocalDateTime.parse(date, DATE_TIME_FORMATTER);
    }

    @Override
    public String toString() {
        return "SeismographData{" +
                "id=" + id +
                ", xAsix=" + xAxis +
                ", yAsix=" + yAxis +
                ", zAsix=" + zAxis +
                ", date=" + date +
                '}';
    }
}