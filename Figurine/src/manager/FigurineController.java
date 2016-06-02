package manager;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import gui.*;
import utenti.*;


public class FigurineController implements ActionListener {
	
	private Utente utente;  	   
	private String[] nomef; 
	private int i;
	
	public FigurineController(Utente u){
		
			utente=u;	
			nomef=new String[utente.getCollezione().size()];
			i=0;
		}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		while(i<utente.getCollezione().size()){
			aggiungiFig(e.getActionCommand());
			i++;
		}
		for(int j=0;j<i;j++) System.out.println(nomef[j]);
		coloraFig(e.getSource());
		
		}
	
	
	//aggiungo il nome della figurina all'array nomef
	public void aggiungiFig(String nome){
				
			nomef[i]=nome;
		}
	
	
	//coloro nome figurina di verde
	public void coloraFig(Object fig){
		
		JButton f=(JButton)fig;
		f.setBackground(Color.GREEN);
		
	}
}
