package utenti;

import collezionabili.*;

import java.util.*;

public class Collezionista extends Utente {
	
	private ArrayList<Utente> PropScambio;
	
	//Overload Costruttore
	
	public Collezionista(String nom,String cogn,String indir,int e,int inicre){

	super(nom,cogn,indir,e,inicre);
	this.PropScambio=new ArrayList<>();
	
	
	}
	
	public Collezionista(String nom,String cogn,String indir,int e,int inicre,String u,String pass,String m){
		
		
		super(nom,cogn,indir,e,inicre,u,pass,m);
		this.PropScambio=new ArrayList<>();
		
	}
	
	
	
}
