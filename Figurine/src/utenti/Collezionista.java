package utenti;

import collezionabili.*;
import mercato.*;

import java.util.*;

public class Collezionista extends Utente {
	
	private ArrayList<Utente> PropScambio;

	
	//Overload Costruttore
	
	public Collezionista(String nom,String cogn,String indir,int e,int inicre,Portale p){

	super(nom,cogn,indir,e,inicre,p);
	this.PropScambio=new ArrayList<>();

	
	
	}
	
	public Collezionista(String nom,String cogn,String indir,int e,int inicre,Portale p,String u,String pass,String m){
		
		
		super(nom,cogn,indir,e,inicre,p,u,pass,m);
		this.PropScambio=new ArrayList<>();

		
	}
	
	
	
}
