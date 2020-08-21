package com.phuongnam.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int month;
    private double powerNumber;
    private double waterNumber;

    public Orders() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public double getPowerNumber() {
        return powerNumber;
    }

    public void setPowerNumber(double powerNumber) {
        this.powerNumber = powerNumber;
    }

    public double getWaterNumber() {
        return waterNumber;
    }

    public void setWaterNumber(double waterNumber) {
        this.waterNumber = waterNumber;
    }
}
