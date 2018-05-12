package com.company.model;

import java.lang.*;

/**
 * Created by Libcoo on 11.05.2018.
 */
public class Part {
    private int id;
    private String name;
    private float weight;
    private String model;
    private Car car;
    private Pallet pallet;
    private java.lang.Package aPackage;

    public java.lang.Package getaPackage() {
        return aPackage;
    }

    public void setaPackage(java.lang.Package aPackage) {
        this.aPackage = aPackage;
    }

    public Pallet getPallet() {
        return pallet;
    }

    public void setPallet(Pallet pallet) {
        this.pallet = pallet;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Part(float weight,String name, int id){
        this.weight = weight;
        this.name = name;
        this.id = id;
    }

    @Override
    public String toString() {
        return "Part{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", weight=" + weight +
                '}';
    }
}
