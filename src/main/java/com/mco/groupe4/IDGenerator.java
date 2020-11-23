package com.mco.groupe4;


public class IDGenerator {
    private int id = 0;
    public synchronized int getNextID() {
        return id ++;
    }
}
