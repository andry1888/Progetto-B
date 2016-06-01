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
   String s=e.getActionCommand();
   System.out.println(s);
   
   switch (s){
	
	
	case "Invia messaggio":{
			// controllo chi ha schiacciato bottone invio e scrivo su panel
		    String text, chat,s1;
		    JButton b=gui.getMessage();
		    if(e.getSource()==b){
		    	text=gui.getMessageUt1();
		    	s1="utente 1 scrive: "+text+"\n";
		    	System.out.println(s1);
		    	chat=gui.getChat();
		    	chat=chat+s1;
		    	gui.setChat(chat);
			}
		    else {
		    	text=gui.getMessageUt2();
		    	s1="utente 2 scrive: "+text+"\n";
		    	System.out.println(s1);
		    	chat=gui.getChat();
		    	chat=chat+s1;
		    	gui.setChat(chat);
		    }
		     
		     break;
		
		}
   
   
	}

}
}
