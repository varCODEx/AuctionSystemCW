package org.example;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.stream.Stream;

public class DAOLot implements DAOLotInterface, Serializable {
    @Override
    public Lot read(int id) {
        return storage.get(id);
    }

    @Override
    public void write(int id, Lot lot) {
        storage.set(id, lot);
    }

    @Override
    public void add(Lot obj) {
        obj.setId(LotStorage.lastId);
        storage.add(obj);
        LotStorage.lastId++;
    }

    @Override
    public Iterator<Lot> getIterator() {
        return storage.iterator();
    }

    public void save(Lot lot){
        this.write(lot.getId(), lot);
    }

    public void delete(Lot lot){
        lot.setLotStatus(Lot.status.DELETED);
        this.save(lot);
//        this.write(lot.getId(), null);
    }

    public Stream<Lot> getStream(){
        return storage.stream();
    }

    static ArrayList<Lot> storage = LotStorage.storage;

    public DAOLot() {
    }
}
