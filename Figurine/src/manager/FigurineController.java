package manager;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import gui.*;
import utenti.*;


public class FigurineController implements ActionListener {
	
	private Utente utente;  	   
	private String[] nomef; 
	private int i=0;

	public FigurineController(Utente u){

			utente=u;	
			nomef=new String[utente.getCollezione().size()];
	
		}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		aggiungiFig(e.getActionCommand());
		}
	
	
	//aggiungo il nome della figurina all'array nomef
	public void aggiungiFig(String nome){
		while(i<utente.getCollezione().size()){
			nomef[i]=nome;
			i++;
		}
		for(int j=0;j<i;j++) System.out.println(nomef[j]);
		}		
	
}
