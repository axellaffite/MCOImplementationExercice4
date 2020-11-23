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
public interface Membre extends Comparable<Membre> {
    
    abstract void traiterMessage(String message);
    
}
