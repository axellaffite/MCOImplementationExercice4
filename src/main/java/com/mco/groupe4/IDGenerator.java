/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mco.groupe4;

/**
 *
 * @author axel
 */
public class IDGenerator {
    private int id = 0;
    public synchronized int getNextID() {
        return id ++;
    }
}
