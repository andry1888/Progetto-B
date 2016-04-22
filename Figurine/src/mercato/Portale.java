

package mercato;

import collezionabili.*;
import utenti.*;
import java.util.*;






public class Portale {

	
	private static ArrayList<Utente> Utente;
	//implementare database user-password
	
	//imporre la staticità delle componenti della classe
	
	public  Portale(){
		
		Utente= new ArrayList<>();
		
		
		
	}
	
	public ArrayList<Utente> getUtenti(){
		
		return Utente;
		
	}
	
	
	//inizia lo scambio tra due utenti
	
/*	public Scambio startScambio(Utente u1,Utente u2){
		
		
		
		
	}
*/	
	
	//Ritorna un utente dato lo user, null se non esiste
	
	public Utente getUtentebyUser(String u){
				
		for(int i=0;i<this.Utente.size();i++){
			
			if(Utente.get(i).getUser()==u) return Utente.get(i);
			
			
		}
		
		return null;
		
		
	}
	
	//Ritorna la collezione di un utente dato lo user, null se non esiste lo user
	
	public ArrayList<Figurina> getFigurineByUser(String u){
		
		
		for(int i=0;i<Utente.size();i++){
			
			if(Utente.get(i).getUser()==u) return Utente.get(i).getCollezione();
		}
		
		return null;
	}
	
	//Ritorna l'insieme di utenti aventi figurine con l'id inserito
	public ArrayList<Utente> getUsersByFigurinaId(int id){
		
		ArrayList<Utente> ufin=new ArrayList<>();
		Utente utemp;
		
		for(int i=0;i<Utente.size();i++){
			
			utemp=Utente.get(i);
			for(int j=0;j<utemp.getCollezione().size();j++){
				
				if(id==utemp.getCollezione().get(j).getId()){
					ufin.add(utemp);
					break;
				}
				
			}
		
			
			
		}
		return ufin;
		
	}
	
	
	
	
	
	
	
	
}
