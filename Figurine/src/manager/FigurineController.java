package manager;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import gui.*;
import utenti.*;


public class FigurineController implements ActionListener {
	
	private Utente utente;  	   
	private String[] nomef =new String[utente.getCollezione().size()];	
	
	public FigurineController(Utente u){		
			utente=u;		
		}
	
	@Override
	public void actionPerformed(ActionEvent e) {		
		//aggiungo il nome della figurina all'array nomef		
		for(int i=0;i<utente.getCollezione().size();i++){			
			nomef[i]=e.getActionCommand();
			}
		}
	
}
