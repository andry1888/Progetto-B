
//Interfaccia per gestire le operazioni su insiemi di figurine

package collezionabili;

import utenti.*;
import mercato.*;
import java.util.*;


public interface Figurina_Interface {

    /*
        Edit collezione
    */
    public boolean addFigurina(String n,int r);
    public boolean addFigurina(Figurina f);
    public boolean removeFigurinabyId(int i);
    public boolean removeFigurina(Figurina f);
    public boolean removeFigurinabyName(String n);
        
    public int countFigurina();
        
    /*
        Ordinamento
    */
    public void sortAlfa();
    public void sortRar();
       
    /*
        Search
    */
    public Figurina getFigurina(Figurina f);
    public Figurina getFigurinabyId(int i);
    public Figurina getFigurinabyNome(String n);
        
    public boolean compareFigurine(Figurina f1,Figurina f2);
        	
}
