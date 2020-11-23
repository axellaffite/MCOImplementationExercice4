package com.mco.groupe4;


public class Analyse implements Membre {
    
    private static IDGenerator generator = new IDGenerator();
    
    private Integer id = generator.getNextID();

    @Override
    public void traiterMessage(String message) {
        System.out.println("Message traité par Analyse");
    }
    
    @Override
    public int compareTo(Membre t) {
        if (t instanceof Analyse) {
            return id.compareTo(((Analyse) t).id);
        }
        
        return -1;
    }
    
    public boolean equals(Object other) {
        return other instanceof Analyse
                && ((Analyse) other).id.equals(id);
    }
    
}
