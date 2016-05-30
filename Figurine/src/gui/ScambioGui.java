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
	
	private JPanel figPanel1,figPanel2,offertaPanel1,offertaPanel2,commandPanel1,commandPanel2;     //Sotto-pannelli utente 
	private JPanel scambioPanel;                                       //Pannello principale
	private JPanel utente1Panel,utente2Panel,userPanel;                          //Pannelli utente principali
	private JPanel infoPanel;
	private JPanel chatPanel;
	
	private JTextField userText1,userText2;
	private JTextArea chat;

	private JScrollPane scrollFig1,scrollFig2;
	private JScrollPane scrollOfferta1,scrollOfferta2;

	
    private  JButton   addFigButton1,addFigButton2;
    private  JButton   remFigButton1,remFigButton2;
    private  JButton   confermaButton1,confermaButton2;
    private  JButton   messageButton1,messageButton2;
    
    
    
    
    public ScambioGui(Utente u1,Utente u2) {
    	
    	   super(u1.getUser()+" scambia con "+u2.getUser());
    	   
    	   utente1=u1;
    	   utente2=u2;    	   
    	   this.initComponents();
           this.formatComponents();
           
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
	   userPanel=new JPanel();
	   commandPanel1=new JPanel();
	   commandPanel2=new JPanel();
	   chatPanel=new JPanel();

       userText1=new JTextField("Messagi chat utente 1");  
       userText2=new JTextField("Messaggi chat utente 2");
       chat=new JTextArea();
	   
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
	   messageButton1=new JButton("Invia messaggio");
	   messageButton2=new JButton("Invia messaggio");
	   
   }
   
   private void formatComponents(){
	   
	   //Property and Layout Setup
	   
	   this.setSize(800,650);
	   this.setVisible(true);
       this.setResizable(false);
       this.setDefaultCloseOperation(EXIT_ON_CLOSE);
       
       this.chat.setEditable(false);
       
       scambioPanel.setLayout(new GridLayout(3,1));
       utente1Panel.setLayout(new BorderLayout());
       utente2Panel.setLayout(new BorderLayout());
       commandPanel1.setLayout(new GridLayout(5,1));
       commandPanel2.setLayout(new GridLayout(5,1));
       infoPanel.setLayout(new BorderLayout());
       userPanel.setLayout(new GridLayout(2,2));
        
       
       //Decidere il metodo di inserimento dell'offerta
       
       initUserInfo();
       initCollezione();
       
       
       //Aggiunge i componenti
             
       
       //Pannelli utente e sotto-pannelli
                  
       utente1Panel.add(figPanel1,BorderLayout.WEST);
       utente1Panel.add(offertaPanel1,BorderLayout.EAST);
       utente2Panel.add(figPanel2,BorderLayout.WEST);
       utente2Panel.add(offertaPanel2,BorderLayout.EAST);
       commandPanel1.add(addFigButton1);
       commandPanel1.add(remFigButton1);
       commandPanel1.add(userText1);
       commandPanel1.add(messageButton1);
       commandPanel1.add(confermaButton1);
       commandPanel2.add(addFigButton2);
       commandPanel2.add(remFigButton2); 
       commandPanel2.add(userText2);
       commandPanel2.add(messageButton2);
       commandPanel2.add(confermaButton2);
       chatPanel.add(chat,BorderLayout.CENTER);
       
       //Pannneli della frame
       
       userPanel.add(utente1Panel);
       userPanel.add(utente2Panel);
       userPanel.add(commandPanel1);
       userPanel.add(commandPanel2);
       
       scambioPanel.add(infoPanel);
       scambioPanel.add(userPanel);
       scambioPanel.add(chatPanel);
       
       
       this.add(scambioPanel);
       
      }
   
   
   //Inizializza le informazioni degli utenti
   
   public void initUserInfo(){
	   
	   infoPanel.add(utente1.getUserInfoPanel(),BorderLayout.WEST);
	   infoPanel.add(utente2.getUserInfoPanel(),BorderLayout.EAST);
	   
   }
   
   //inizializza le collezioni degli utenti
   
   private void initCollezione(){
	   
	   
	   int i;
	   JButton btmp;
	   
	   for(i=0;i<utente1.getCollezione().size();i++){
		   
		   btmp=new JButton(utente1.getCollezione().get(i).getNome()+" "+utente1.getCollezione().get(i).getRarità());
		   figPanel1.add(btmp);
		   
	   }
	   
	   for(i=0;i<utente1.getCollezione().size();i++){
		   
		   btmp=new JButton(utente2.getCollezione().get(i).getNome()+" "+utente2.getCollezione().get(i).getRarità());
		   figPanel2.add(btmp);
	   }
   }
   
   
   
   
}



