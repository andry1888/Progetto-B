

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
		
		//Trova il nome dell'elemento chiamante
		
		
       String tmp;
       Figurina ftmp;
       boolean f;
	   String s=e.getActionCommand();
	   System.out.println(s);
	   
	   

		switch (s){
		
		//da testare
		
		case "Carica Credito":{
			
			     tmp=gui.getCreditValue();
			     utente.addCredito(Double.parseDouble(tmp));
			     gui.updateCreditValue();
			     gui.clearCreditValue();
			     break;
			
			}
		
		case "Ordine Alfabetico":{
			
			utente.sortAlfa();
			gui.updateCollezione();
			break;
			
			
		}
		
		case "Ordine Rarità":{
			
			utente.sortRar();
			gui.updateCollezione();
			break;
			
		}
		
		case "Aggiungi Figurina": {
			
			//Modificare per avere consistenza sul registro figurine
			
			tmp=gui.getFigurinaValue();
			ftmp=new Figurina(1,tmp,10);
			utente.addFigurina(ftmp);
			gui.updateCollezione();
			gui.clearFigurinaValue();
			break;
			
			
		}
		
		case "Rimuovi Figurina":{
			
			tmp=gui.getFigurinaValue();
			f=utente.removeFigurinabyName(tmp);
			if(f==true) gui.updateCollezione();
			else System.out.println("Figurina non esistente");
			break;
			
			
			
		}
		
		
		}
		
     }
}
	
	
	


