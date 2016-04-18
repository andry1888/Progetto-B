package mercato;

import collezionabili.*;
import utenti.*;





public interface Carrello {

	public boolean addFigurina(Figurina f);
	public boolean addCredito(double c);
	public boolean removeFigurina(Figurina f);
	public boolean removeCredito(double c);
	public void giveFeedback(int feed);
	
	
	
	
}
