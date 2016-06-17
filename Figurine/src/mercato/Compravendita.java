package mercato;

import utenti.*;
import collezionabili.*;

import java.util.*;

public class Compravendita extends Scambio {

	private Negoziante Negoziante;
	private Utente Utente;
	
	public Compravendita(Negoziante n, Utente u) {
		
		super(n, u);
		Negoziante=n;
		Utente=u;
		Utente.OffertaCredito=0;
		Negoziante.OffertaCredito=0;
		

	}
	
	
	//aggiunge Credito all'offerta dell'utente
	
	public boolean addCredito(Utente u,double c){
		
		if(c<0) return false;
		if(c>u.getCredito()) return false;
		if(c+u.getOffertaCredito()>u.getCredito()) return false;
		if(s==Stato.NUOVO) s=Stato.IN_CORSO;
		
		u.OffertaCredito+=c;
		return true;
	}
	
	
	//rimuove credito all'offerta dell'utente
	
	public boolean removeCredito(Utente u,double c){
		
		if(c<0) return false;
		if(c>u.getOffertaCredito()){
			
			u.OffertaCredito=0;
			return true;
			
		}
		
		u.OffertaCredito-=c;
		return true;
		
	}
	
	public double getOffertaCreditoCompagno(Utente u){
		
		
		if(u.getUser()==Negoziante.getUser()) return Utente.getOffertaCredito();
		else return Negoziante.getOffertaCredito();
		
	}
	
	public void concludiScambioPositivo(){
		
		
	Figurina ftemp;
	double ctemp;
		
		if(Ok1==true && Ok2==true){
			
			s=Stato.ACCETTATO;
			this.setFeedback();
			
			//Preleva le figurina di Utente  e le deposita in Negoziante
			for(int i=0;i<this.Utente.getOffertaFigurine().size(); i++){
				
				ftemp=Utente.getOffertaFigurine().get(i);
				Negoziante.getCollezione().add(ftemp);
				Utente.getOffertaFigurine().remove(i);
				
			}
			
			//Preleva le figurina di Negoziante e le deposita in Utente 
			
			for(int i=0;i<Negoziante.getOffertaFigurine().size();i++){
				
				ftemp=Negoziante.getOffertaFigurine().get(i);
				Utente.getCollezione().add(ftemp);
				Negoziante.getOffertaFigurine().remove(i);
				
				
			}
			
			//Preleva il credito dall'utente e lo trasferisce a Negoziante
			
			ctemp=Utente.getOffertaCredito();
			Negoziante.addCredito(ctemp);
			Utente.removeCredito(ctemp);
			
       //Preleva il credito dal negoziante e lo trasferisce a utente
			
			ctemp=Negoziante.getOffertaCredito();
			Utente.addCredito(ctemp);
			Negoziante.removeCredito(ctemp);
			
			
			
		}
		
		
		
	}
	

	
	
	
	
}
