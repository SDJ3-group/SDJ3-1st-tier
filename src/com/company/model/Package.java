package com.company.model;

import java.util.ArrayList;

/**
 * Created by Libcoo on 11.05.2018.
 */
public class Package {
    private int ID;
    private boolean repacking;
    private ArrayList<Part> parts;

    public Package(int ID) {
        this.ID = ID;
        this.parts = new ArrayList<>();
    }

    public int getID() {
        return ID;
    }

    public boolean isRepacking() {
        return repacking;
    }

    public void setID(int ID) {

        this.ID = ID;
    }

    public void setRepacking(boolean repacking) {
        this.repacking = repacking;
    }

    public void setParts(ArrayList<Part> parts) {
        this.parts = parts;
    }

    public ArrayList<Part> getParts() {

        return parts;
    }
}
