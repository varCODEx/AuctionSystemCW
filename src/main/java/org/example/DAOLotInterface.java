package org.example;

import java.util.Iterator;

interface DAOLotInterface {
    Lot read(int id);
    void write(int id, Lot obj);
    void add(Lot obj);
    Iterator<Lot> getIterator();
}
