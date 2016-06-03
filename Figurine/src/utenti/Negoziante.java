package utenti;

import mercato.*;
import collezionabili.*;

public class Negoziante extends Collezionista {
	
	private String NomeNegozio,PartitaIva;
	
	
	
	//OverLoad Costruttore
	
	public Negoziante(String nom,String cogn,String indir,int e,int inicre,Portale p,String nn,String pi){
		
		
		super(nom,cogn,indir,e,inicre,p);
		this.NomeNegozio=nn;
		this.PartitaIva=pi;
		
		
	}
	
	public Negoziante(String nom,String cogn,String indir,int e,int inicre,Portale p,String u,String pass,String m,String nn,String pi){
		
		
		super(nom,cogn,indir,e,inicre,p,u,pass,m);
		this.NomeNegozio=nn;
		this.PartitaIva=pi;
	}

}
