/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import utenti.*;
import manager.*;


import java.awt.*;
import static java.awt.Component.CENTER_ALIGNMENT;
import javax.swing.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;




public class ScambioGui extends JFrame{
	
	//Componenti dell'interfaccia
	

	private Utente utente1,utente2;
	
	private JPanel figPanel1,figPanel2,offertaPanel1,offertaPanel2;
	private JPanel scambioPanel;
	private JPanel utente1Panel,utente2Panel;
	private JPanel infoPanel;
	
	private JTextField userText1,userText2;
	private JTextArea chat;

	private JScrollPane scrollFig1,scrollFig2;
	private JScrollPane scrollOfferta1,scrollOfferta2;

	
    private  JButton   addFigButton1,addFigButton2;
    private  JButton   remFigButton1,remFigButton2;
    private  JButton   confermaButton1,confermaButton2;
    
    
    
    
    public ScambioGui(Utente u1,Utente u2) {
    	
    	   super(u1.getUser()+" scambia con "+u2.getUser());
    	   
    	   utente1=u1;
    	   utente2=u2;    	   
    	   this.initComponents();
           this.formatComponents();
           this.initCollezione();
           
           //Disabilita le gui utente
           
           utente1.disableUtente();
           utente2.disableUtente();
           
        }
    
    
   private void initComponents() {
	   
	
	   //Crea gli oggetti
	  	   

	   scambioPanel=new JPanel();	
	   utente1Panel=new JPanel();
	   utente2Panel=new JPanel();
	   figPanel1=new JPanel();
	   figPanel2=new JPanel();
	   offertaPanel1=new JPanel();
	   offertaPanel2=new JPanel();
	   infoPanel=new JPanel();

       userText1=new JTextField("Messagi chat utente 1");  
       userText2=new JTextField("Messaggi chat utente 2");
	   
	   scrollFig1=new JScrollPane(figPanel1,scrollFig1.VERTICAL_SCROLLBAR_AS_NEEDED,scrollFig1.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	   scrollFig2=new JScrollPane(figPanel2,scrollFig2.VERTICAL_SCROLLBAR_AS_NEEDED,scrollFig2.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	   scrollOfferta1=new JScrollPane(offertaPanel2,scrollOfferta2.VERTICAL_SCROLLBAR_AS_NEEDED,scrollOfferta2.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	   scrollOfferta1=new JScrollPane(offertaPanel2,scrollOfferta2.VERTICAL_SCROLLBAR_AS_NEEDED,scrollOfferta2.HORIZONTAL_SCROLLBAR_AS_NEEDED);



	   addFigButton1=new JButton("Aggiungi Figurina all'offerta di "+utente1.getUser());
	   remFigButton1=new JButton("Rimuovi Figurina dall'offerta di "+utente1.getUser());
	   addFigButton2=new JButton("Aggiungi Figurina all'offerta di "+utente2.getUser());
	   remFigButton2=new JButton("Rimuovi Figurina dall'offerta di "+utente2.getUser());
	   confermaButton1=new JButton("Conferma scelte di "+utente1.getUser());
	   confermaButton2=new JButton("Conferma scelte di "+utente2.getUser());
	   
   }
   
   private void formatComponents(){
	   
	   //Property and Layout Setup
	   
	   this.setSize(800,650);
	   this.setVisible(true);
       this.setResizable(false);
       this.setDefaultCloseOperation(EXIT_ON_CLOSE);
       
       scambioPanel.setLayout(new GridLayout(3,1));
       
    
       
      }
   
   //inizializza le collezione degli utenti
   
   private void initCollezione(){
	   
	   
	   int i;
	   JButton btmp;
	   
	   for(i=0;i<utente1.getCollezione().size();i++){
		   
		   btmp=new JButton(utente1.getCollezione().get(i).getNome());
		   figPanel1.add(btmp);
		   
	   }
	   
	   for(i=0;i<utente1.getCollezione().size();i++){
		   
		   btmp=new JButton(utente2.getCollezione().get(i).getNome());
		   figPanel2.add(btmp);
	   }
   }
   
   
   
   
}



