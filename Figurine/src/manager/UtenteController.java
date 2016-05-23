

package manager;

import collezionabili.*;
import mercato.*;
import utenti.*;
import gui.*;

import java.util.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

//Vengono gestiti per ora solo oggetti di tipo JButton

public class UtenteController implements ActionListener {

	private Utente utente;
	private UtenteGui gui;
	
	
	//Ottiene i parametri di utente e interfaccia
	
	public UtenteController(UtenteGui g,Utente u){
		
		utente=u;
		gui=g;
		
	}
	
	//Esegue l'azione chiamata da un elemento dell'interfaccia
	
	public void actionPerformed(ActionEvent e) {
		
       String tmp;		
	   String s=e.getActionCommand();
	   
	   //Trova il nome dell'elemento chiamante

		switch (s){
		
		//da testare
		
		case "Carica Credito":{
			
			     tmp=gui.getCreditValue();
			     utente.addCredito(Double.parseDouble(tmp));
			     gui.clearCreditValue();
			     break;
			
			}
		
		case "Ordine Alfabetico":{
			
			utente.sortAlfa();
			break;
			
			//Update vista gui
			
		}
		
		case "Ordine Rarità":{
			
			utente.sortRar();
			//Update vista gui
			break;
			
		}
		
		
		
		}
		
     }
}
	
	
	


