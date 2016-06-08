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


public ScambioController(ScambioGui g, Utente u1, Utente u2){

		gui=g;	
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
    
	case   3:{
					
			tmp=gui.getUser1Message();
			if(tmp.equals("")) break;
		    gui.getChat().setText(gui.getChatText()+utente1.getUser()+": "+tmp+"\n");
		    gui.clearUser1Message();		     
		    break;
		
		}
	
	//Utente 2 invia messaggio
	
	case 7:{
		
		tmp=gui.getUser2Message();
		if(tmp.equals("")) break;
		gui.getChat().setText(gui.getChatText()+utente2.getUser()+": "+tmp+"\n");
		gui.clearUser2Message();
		break;
		
		
	}
   
   
	}
  } 
}


