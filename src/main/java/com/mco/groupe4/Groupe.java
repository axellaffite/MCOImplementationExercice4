package com.mco.groupe4;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

// Similaire à Obsersvable
final class Groupe {
    
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
        
        if (membre != historique && membre != analyse) {
            Historique h = (Historique) historique;
            h.getMessages().forEach(membre::traiterMessage);
        }
    }
    
    public void retirerMembre(Membre membre) {
        membres.remove(membre);
    }
    
    public void posterMessage(String message) {
        membres.forEach(m -> m.traiterMessage(message));
    }
    
}
