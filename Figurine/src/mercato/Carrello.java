package mercato;

import collezionabili.*;
import utenti.*;





public interface Carrello {

	public void addFigurina(Utente u,int i);
	public boolean addCredito(Utente u,double c);
	public void removeFigurina(Utente u,int i);
	public boolean removeCredito(Utente u,double c);
	public void giveFeedback(Utente u,int feed);

	
	
	
	
}
