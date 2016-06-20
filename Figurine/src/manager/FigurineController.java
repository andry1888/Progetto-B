package manager;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import gui.*;
import utenti.*;
import mercato.*;


public class FigurineController implements ActionListener {
	
	private Utente utente;  
	private Scambio scambio;
	private ScambioGui gui;
	
	public FigurineController(Utente u,Scambio s,ScambioGui g){
		
			utente=u;	
			scambio=s;
			gui=g;
	
		}
	

	public void actionPerformed(ActionEvent e) {
		
		JButton tmp=(JButton) e.getSource();
		
		if(!tmp.getForeground().equals(Color.green)){
			aggiungiFig(e.getActionCommand());
			tmp.setForeground(Color.green);
		}
		else{
			rimuoviFig(e.getActionCommand());
			tmp.setForeground(Color.black);
		}
			
		gui.updateStatoScambio();
		
		}
	
	//Le figurine vengono spostate dalla collezione all'offerta
	
	public void aggiungiFig(String nome){

		//Trova la figurina corrispondente
			for(int i=0;i<=utente.getCollezione().size();i++){
				
			if(nome.equals(utente.getCollezione().get(i).toString())){
		
		    scambio.addFigurina(utente,i);
			break;
			}
			
			}
	//debug
			System.out.println("Collezione utente\n");
			System.out.println(utente.getCollezione().toString());
			System.out.println("Offerta utente");
			System.out.println(utente.getOffertaFigurine().toString());
		}
	
	//Le figurine vengono spostate dalla offerta alla collezione
	
	public void rimuoviFig(String nome){

		for(int i=0;i<=utente.getOffertaFigurine().size();i++){
			
			if(nome.equals(utente.getOffertaFigurine().get(i).toString())){
				
				scambio.removeFigurina(utente,i);
				break;
				
			}
	    		
		}
		
		//debug
		System.out.println("Collezione utente\n");
		System.out.println(utente.getCollezione().toString());
		System.out.println("Offerta utente");
		System.out.println(utente.getOffertaFigurine().toString());
		}

	
}
