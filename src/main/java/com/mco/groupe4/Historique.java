/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mco.groupe4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


/**
 *
 * @author axel
 */
public class Historique implements Membre {
    
    private static IDGenerator generator = new IDGenerator();
    
    private Integer id = generator.getNextID();

    private final List<String> messages = new ArrayList<>();
    
    @Override
    public void traiterMessage(String message) {
        messages.add(message);
    }
    
    public List<String> getMessages() {
        return Collections.unmodifiableList(messages);
    }

    @Override
    public int compareTo(Membre t) {
        if (t instanceof Historique) {
            return id.compareTo(((Historique) t).id);
        }
        
        return -1;
    }
    
    public boolean equals(Object other) {
        return other instanceof Historique
                && ((Historique) other).id.equals(id);
    }
}
