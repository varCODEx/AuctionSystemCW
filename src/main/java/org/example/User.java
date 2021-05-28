package org.example;

import java.io.Serializable;
import java.util.ArrayList;

public class User implements Serializable {
    ArrayList<Lot> ownedLots = new ArrayList<>(); //created
    ArrayList<Lot> boughtLots = new ArrayList<>(); //placed final, lot closed
    ArrayList<Lot> participatingInLots = new ArrayList<>(); //placed bid, lot active
    String id;

    public User(String id) {
        this.id = id;
    }

    public ArrayList<Lot> getOwnedLots() {
        return ownedLots;
    }

    public void setOwnedLots(ArrayList<Lot> ownedLots) {
        this.ownedLots = ownedLots;
    }

    public ArrayList<Lot> getBoughtLots() {
        return boughtLots;
    }

    public void setBoughtLots(ArrayList<Lot> boughtLots) {
        this.boughtLots = boughtLots;
    }

    public ArrayList<Lot> getParticipatingInLots() {
        return participatingInLots;
    }

    public void setParticipatingInLots(ArrayList<Lot> participatingInLots) {
        this.participatingInLots = participatingInLots;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                '}';
    }
}
