package collezionabili;

import java.util.*;
import utenti.*;



public class Figurina {
    /*
        Autoincremento id figurina
    */
        private static int count;

	private final String Nome;
	private final int Id;
        private int Rarità;
	
        
	public Figurina(String n,int r){
		this.Nome=n;
		this.Rarità=r;
                this.Id=++count;
	}
	

        
	public String getNome(){
		return this.Nome;
	}
	
        public int getId(){
		return this.Id;
	}

        public int getRarità(){
            return this.Rarità;
        }
	
        public boolean changeRar(int newP){
            if (newP >0){
                this.Rarità=newP;
                return true;
            }
            else {
                System.out.println("Valore di rarità non permessa");
                return false;
            }
            
        }
        @Override
	public String toString(){
		return (String)(this.getId()+" "+this.getNome()+" "+this.getRarità());
                
        }
        
}
