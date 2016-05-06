package mercato;

import collezionabili.*;
import utenti.*;





public interface Carrello {

	public boolean addFigurina(Utente u,Figurina f);
	public boolean addCredito(Utente u,double c);
	public boolean removeFigurina(Utente u,int i);
	public boolean removeCredito(Utente u,double c);
	public void giveFeedback(Utente u,int feed);

	
	
	
	
}
