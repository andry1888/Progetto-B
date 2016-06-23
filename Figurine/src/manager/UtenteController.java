

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

	private Utente utente;   //utente di riferimento
	private UtenteGui gui;   //gui di riferimento
	private LoginGui  login;  //Gui login

	
	
	//Ottiene i parametri di utente e interfaccia
	
	public UtenteController(UtenteGui g,Utente u){
		

		utente=u;
		gui=g;	
		
	}
	
	//Esegue l'azione chiamata da un elemento dell'interfaccia
	
	public void actionPerformed(ActionEvent e) {
		
		//Trova il nome dell'elemento chiamante
		
		
       String tmp;       
       String infotmp;
       String[] split;
       
       boolean f;
       int map;
       Figurina ftmp;
       map=gui.componentMap.get(e.getSource());
       	   	   	   
		switch (map){
		
	
		//Aggiunge del credito
		
		case 6:{
			
			     tmp=gui.getCreditValue();
			     utente.addCredito(Double.parseDouble(tmp));
			     gui.updateCreditValue();
			     gui.clearCreditValue();
			     break;
			
			}
		
		//Esegue il riordino per numero Id
		
		case 5:{
			
			utente.sortId();
			gui.updateCollezione();
			break;
		}
		
		//Esegue riordino alfabetico
		
		case 4:{
			
			utente.sortAlfa();
			gui.updateCollezione();
			break;
			
			
		}
		
		//Esegue riordino per rarità
		
		case 3:{
			
			utente.sortRar();
			gui.updateCollezione();
			break;
			
		}
		
		//Aggiunge una figurina
		
		case 1: {
			
		
			
			tmp=gui.getFigurinaValue();
			

			
			infotmp=utente.port.verifyFigurinaByName(tmp);
			if(infotmp.equals("null")){
				System.out.println("Figurina non esistente, vedi registro figurine");
				break;
			}
			
			split=infotmp.split(" ");
			ftmp=new Figurina(Integer.parseInt(split[0]),split[1],Integer.parseInt(split[2]));		
			utente.addFigurina(ftmp);
			gui.updateCollezione();
			gui.clearFigurinaValue();
			break;
			
			
		}
				
		
		//Rimuove una figurina
		
		case 2:{
			
			tmp=gui.getFigurinaValue();
			f=utente.removeFigurinabyName(tmp);
			
			if(f==true) gui.updateCollezione();			
			else System.out.println("Figurina non esistente nella collezione");
			gui.clearFigurinaValue();
			
			break;
			
			
			
		}

		
		//L'utente esegue il login
		case 7: {
			
			login=new LoginGui(this);
			login.setUserText("");
			login.setPasswordText("");
			
			
			
		}
		
		
		//Viene aperto uno scambio
		
		case 12:{
			
			
			//....
			break;
			
			
		}
		
		
		}
		
     }
	
	
	public String login(String user,String passw){
		
		return "aa";
		
		
	}
}
	
	
	


