package manager;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import gui.*;
import utenti.*;


public class FigurineController implements ActionListener {
	
	private Utente utente;  	    
	
	public FigurineController(Utente u){
		
			utente=u;	
	
		}
	
	
	@Override
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
			
		
		}
	
	
	public void aggiungiFig(String nome){

			for(int i=0;i<utente.getCollezione().size();i++){
			if(nome.equals(utente.getCollezione().get(i).toString())){
			utente.getOffertaFigurine().add(utente.getCollezione().get(i));			
			break;
			}
			}	
			System.out.println(utente.getOffertaFigurine().toString());
		}
	
	public void rimuoviFig(String nome){

		for(int i=0;i<utente.getCollezione().size();i++){
		if(nome.equals(utente.getOffertaFigurine().get(i).toString())){
		utente.getOffertaFigurine().remove(i);	
		break;
		}
		}	
		System.out.println(utente.getOffertaFigurine().toString());
		}

	
}
