package mercato;

import collezionabili.*;
import utenti.*;

import java.util.*;

public class Scambio implements Carrello {
	
	private Utente Utente1,Utente2;
	public Stato s;
	public int feed1,feed2;
	public int Ids;                     //Identificativo dello scambio
	public boolean Ok1,Ok2;

	
	//Costruttore
	public Scambio(Utente u1,Utente u2){
		
		Utente1=u1;
		Utente2=u2;
		feed1=0;
		feed2=0;
		Ok1=false;
		Ok2=false;
		s=Stato.NUOVO;
		
		//inserire gestione dell'ids
		//Programmare l'inserimento e classificazione degli utenti dello scambio (info varie)
		
	}
	
	//ritorna lo stato dello scambio
	public Stato getStatoScambio(){
		
		return s;
	}
	
	
	//Metodo che inserisce e calcola i feedback lasciati, uso esclusivo di Scambio e figli
	protected void setFeedback(){
		
		if(s==Stato.ACCETTATO && Ok1==true && Ok2==true){
			
			Utente1.FeedBack+=feed1;
			Utente2.FeedBack+=feed1;
			
		}
		
	}
	
	
	//Metodo che porta a termine lo scambio, uso esclusivo di Scambio e figli
	protected void concludiScambioPositivo(){
		
		Figurina ftemp;
		
		if(Ok1==true && Ok2==true){
			
			s=Stato.ACCETTATO;
			this.setFeedback();
			
			//Preleva le figurina di Utente 1 e le deposita in Utente 2
			for(int i=0;i<this.Utente1.getOffertaFigurine().size(); i++){
				
				ftemp=Utente1.getOffertaFigurine().get(i);
				Utente2.getCollezione().add(ftemp);
				Utente1.getOffertaFigurine().remove(i);
				
			}
			
			//Preleva le figurina di Utente 2 e le deposita in Utente 1
			
			for(int i=0;i<Utente2.getOffertaFigurine().size();i++){
				
				ftemp=Utente2.getOffertaFigurine().get(i);
				Utente1.getCollezione().add(ftemp);
				Utente2.getOffertaFigurine().remove(i);
				
				
			}
			
			
			
		}
		
		
	}
	
	
	
	//Un utente aggiunge una figurina alla sua offerta
	public boolean addFigurina(Utente u,Figurina f) {

		Figurina ftemp;

		//Verifica sulla possessione della figurina
		ftemp=u.getFigurinabyId(f.getId());

		if(ftemp==null) {
                    System.out.println("figurina non presente in utente");
                    return false;
                }
                else{
		//aggiunta della figurina all'offerta
                	
        u.getOffertaFigurine().add(f);
        if(s==Stato.NUOVO) {
            s=Stato.IN_CORSO;
<<<<<<< HEAD
=======
            System.out.println("qui");
>>>>>>> origin/master
        }
		return true;
	}}
	
	//Un utente rimuove una figurina dalla sua offerta
	public boolean removeFigurina(Utente u,int i) {

		if(u.getOffertaFigurine().get(i)==null) return false;		
		else {
			u.getOffertaFigurine().remove(i);
			return true;
		}
		
	
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
		
		if(u.getUser()==Utente1.getUser()) feed2=feed;
		else feed1=feed;
 
		
	}
	
	//Annula lo scambio attuale
	public void annullaScambio(){
		
		s=Stato.RIFIUTATO;
		
	}
	

}
