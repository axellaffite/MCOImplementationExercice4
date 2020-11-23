/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mco.groupe4;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author axel
 */
class Groupe {
    
    private Set<Membre> membres = new TreeSet<Membre>();
    private Membre historique, analyse;
    
    public Groupe(Membre historique, Membre analyse) {
        this.historique = historique;
        this.analyse = analyse;
        
        ajouterMembre(this.historique);
        ajouterMembre(this.analyse);
    }
    
    public void ajouterMembre(Membre membre) {
        membres.add(membre);
        
        if (membre != historique) {
            for (String message: ((Historique) historique).getMessages()) {
                membre.traiterMessage(message);
            }
        }
    }
    
    public void retirerMembre(Membre membre) {
        membres.remove(membre);
    }
    
    public void posterMessage(String message) {
        membres.forEach(m -> m.traiterMessage(message));
    }
    
}
