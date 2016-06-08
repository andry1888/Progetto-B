package manager;

import collezionabili.*;
import mercato.*;
import utenti.*;
import gui.*;
import gui.ScambioGui;

import java.util.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class ScambioController implements ActionListener {

	private Utente utente1, utente2;   //utente di riferimento
	private ScambioGui gui;   //gui di riferimento
	private Scambio scambio;  //oggetto scambio di riferimento


public ScambioController(ScambioGui g,Scambio s, Utente u1, Utente u2){

		gui=g;	
		scambio=s;
		utente1=u1;
		utente2=u2;

	}

public void actionPerformed(ActionEvent e) {
	
	//Trova il nome dell'elemento chiamante

   String tmp;
   Figurina ftmp;
   boolean f;
   int map;
   
   map=gui.componentMap.get(e.getSource());
   System.out.println(String.valueOf(map));
  
   
    switch (map){
	
	
    //Utente 1 invia messaggio
    
	case   1:{
					
			tmp=gui.getUser1Message();
			if(tmp.equals("")) break;
		    gui.getChat().setText(gui.getChatText()+utente1.getUser()+": "+tmp+"\n");
		    gui.clearUser1Message();		     
		    break;
		
		}
	
	//Utente 1 conferma le scelte
	
	case 2:{
		
		if(gui.getConfermaButton1().getBackground().equals(Color.RED)){
			
			gui.getConfermaButton1().setBackground(Color.GREEN);
			gui.getConfermaButton1().setText(utente1.getUser()+" ha confermato");
			
			scambio.Ok1=true;
			
			//Aggiungere lo scambio di figurine
			
			
		}
		
		break;
		
	}
	
	//Utente 2 invia messaggio
	
	case 3:{
		
		tmp=gui.getUser2Message();
		if(tmp.equals("")) break;
		gui.getChat().setText(gui.getChatText()+utente2.getUser()+": "+tmp+"\n");
		gui.clearUser2Message();
		break;
		
		
	}
	
	
	//Utente2 conferma le s
	case 4:{
		
	if(gui.getConfermaButton2().getBackground().equals(Color.RED)){
			
			gui.getConfermaButton2().setBackground(Color.GREEN);
			gui.getConfermaButton2().setText(utente2.getUser()+" ha confermato");
			
			scambio.Ok2=true;
			
			//Aggiungere lo scambio di figurine
			
			
		}
		
		break;
		
	}
   
   
	}
  } 
}

