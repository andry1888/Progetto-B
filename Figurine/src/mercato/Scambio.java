package mercato;

import collezionabili.*;
import utenti.*;
import gui.*;

import java.util.*;

public class Scambio implements Carrello {
	
	private Utente Utente1,Utente2;
	private ScambioGui gui;
	public Stato status;
	public int feed1,feed2;
	public int Ids;                     //Identificativo dello scambio
	public boolean Ok1,Ok2;

	
	//Costruttore
	public Scambio(Utente u1,Utente u2){
		
		Utente1=u1;
		Utente2=u2;
		
		gui=new ScambioGui(this,u1,u2);
		
		feed1=0;
		feed2=0;
		Ok1=false;
		Ok2=false;
	    status=status.NUOVO; 
		
		
		//inserire gestione dell'ids
		
		
	}
	
	//ritorna lo stato dello scambio
	public Stato getStatoScambio(){
		
		return status;
	}
	
	
	//Metodo che inserisce e calcola i feedback lasciati, uso esclusivo di Scambio e figli
	protected void setFeedback(){
		
		if(status==status.ACCETTATO && Ok1==true && Ok2==true){
			
			Utente1.FeedBack+=feed1;
			Utente2.FeedBack+=feed1;
			
		}
		
	}
	
	
	//Metodo che porta a termine lo scambio, uso esclusivo di Scambio e figli
	public void concludiScambioPositivo(){
		
		Figurina ftemp;
		
		if(Ok1==true && Ok2==true){
			
			status=status.ACCETTATO;
			this.setFeedback();
			
					
			//Esegue lo scambio
			
			//Preleva le figurina di Utente 1 e le deposita in Utente 2, rimuove le figurine da Offerta Utente 1
		
				

				Utente2.getCollezione().addAll(Utente1.getOffertaFigurine());								
				Utente1.getOffertaFigurine().removeAll(Utente1.getOffertaFigurine());
				
			//Preleva le figurina di Utente 2 e le deposita in Utente 1,Rimuove le figurine da Offerta utente 2
	
				Utente1.getCollezione().addAll(Utente2.getOffertaFigurine());
			    Utente2.getOffertaFigurine().removeAll(Utente2.getOffertaFigurine());
			}
		
		
	}
	
	
		//Un utente aggiunge una figurina alla sua offerta
	public void addFigurina(Utente u,int i) {

	      u.getOffertaFigurine().add(u.getCollezione().get(i));
	      u.getCollezione().remove(i);
        
        
	      if(status==status.NUOVO) status=status.IN_CORSO;
        
	}
	
	//Un utente rimuove una figurina dalla sua offerta
	
	public void removeFigurina(Utente u,int i) {

			u.getCollezione().add(u.getOffertaFigurine().get(i));
			u.getOffertaFigurine().remove(i);
			
			 if(status==status.NUOVO) status=status.IN_CORSO;
		        
			 

		}
	
	//Ritorna l'offerta corrente del compagno di scambio
	public ArrayList<Figurina> getOffertaCompagno(Utente u){
		
		if(u.getUser()==Utente1.getUser()) return Utente2.getOffertaFigurine();
		else return Utente1.getOffertaFigurine();
	}
	
	//Imposta su true il valore di conferma dello scambio
	public void confermaScambio(Utente u){
		
		if(u.getUser()==Utente1.getUser()) Ok1=true;
		else Ok2=true;
		
	}

	
    //Aggiunge il credito a una offerta
	public boolean addCredito(Utente u,double c) {
	
		//Non ammesso in uno scambio
		
		return false;  
	}


	public boolean removeCredito(Utente u,double c) {
		// Non ammesso in uno scambio
		
		return false;
	}
	

	//Lascia un feedback a scambio terminato
	public void giveFeedback(Utente u,int feed) {
		
		u.FeedBack+=feed;
 
		
	}
	
	
	//Annula lo scambio attuale
	public void annullaScambio(){
		
		status=Stato.RIFIUTATO;
		
		//Reinserisce le figurine dall'offerta alla collezione, svuota l'offerta
		
		Utente1.getCollezione().addAll(Utente1.getOffertaFigurine());
		Utente1.getOffertaFigurine().removeAll(Utente1.getOffertaFigurine());
		
		Utente2.getCollezione().addAll(Utente2.getOffertaFigurine());
		Utente2.getOffertaFigurine().removeAll(Utente2.getOffertaFigurine());
		
	}
	

}
