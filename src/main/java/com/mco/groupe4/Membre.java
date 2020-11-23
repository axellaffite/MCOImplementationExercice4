package com.mco.groupe4;


// Similaire à Observer
public interface Membre extends Comparable<Membre> {
    
    void traiterMessage(String message);
    
}
