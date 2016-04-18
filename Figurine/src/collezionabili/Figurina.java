package collezionabili;

import java.util.*;
import utenti.*;



public class Figurina {
	
	private String Nome;
	private int Id,Rarità;
	
	public Figurina(int i,String n,int r){
		
		
		this.Id=i;
		this.Nome=n;
		this.Rarità=r;
	}
	
	//Metodi getter
	
	public String getNome(){
		
		return this.Nome;
	}
	
public int getId(){
		
		return this.Id;
	}

public int getRarità(){
	
	return this.Rarità;
}
	
	public String toString(){
		
		return (String)(this.getId()+" "+this.getNome()+" "+this.getRarità());
	}
	

}
