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
		
		toString();
		
		}
	
	
	//aggiungo il nome della figurina all'array nomef
	public void aggiungiFig(String nome){
		while(i<utente.getCollezione().size() && !presente(nome)){
			nomef[i]=nome;
			i++;
			}	
		}
	
	//esce vero se è presente
	public boolean presente(String nome){
		boolean f=false;
		for(int j=0;j<utente.getCollezione().size();j++){
			if(nome.equals(nomef[j]))  f=true;
		}
		return f;
	}
	
	public String toString(){
		return nomef.toString();
	}
	
}
