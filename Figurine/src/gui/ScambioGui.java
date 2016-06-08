/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import utenti.*;
import manager.*;

import java.awt.*;
import java.util.*;

import javax.swing.*;





public class ScambioGui extends JFrame{
	
	//Componenti dell'interfaccia
	
	private Utente utente1,utente2;                        //Utenti di riferimento
	private ScambioController controller;
	
	
	private JPanel figPanel1,figPanel2,offertaPanel1,offertaPanel2,commandPanel1,commandPanel2;     //Sotto-pannelli utente 
	private JPanel scambioPanel;                 //Pannello principale
	private JPanel utente1Panel,utente2Panel,userPanel;                          //Pannelli utente principali
	private JPanel infoPanel;
	private JPanel chatPanel;
	private JPanel infoPanel1,infoPanel2;

	
	private JTextField userText1,userText2;
	private JTextArea chat;


	private JScrollPane scrollFig1,scrollFig2;
	private JScrollPane scrollOfferta1,scrollOfferta2;


    private  JButton   addFigButton1,addFigButton2;
    private  JButton   remFigButton1,remFigButton2;
    private  JButton   confermaButton1,confermaButton2;
    private  JButton   messageButton1,messageButton2;
    
    private  JLabel nameLabel1,nameLabel2;
    private  JLabel surnameLabel1,surnameLabel2;
    private  JLabel usernameLabel1,usernameLabel2;
    private  JLabel feedbackLabel1,feedbackLabel2;  
    
    private FigurineController controller1;
    private FigurineController controller2;
    public  HashMap<JComponent,Integer> componentMap;                       //Hashmap dei componenti
    
    public ScambioGui(Utente u1,Utente u2) {
    	
    	   super(u1.getUser()+" scambia con "+u2.getUser());
    	   
    	   utente1=u1;
    	   utente2=u2;    	   
    	   this.initComponents();
           this.formatComponents();
           this.mapComponents();
           this.actionComponents();
           
           //Disabilita le gui utente
           
           utente1.disableUtente();
           utente2.disableUtente();
           
        }
    
    
   private void initComponents() {
	   
	
	   //Crea gli oggetti
	  	  
	   controller=new ScambioController(this,utente1,utente2);

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
	   infoPanel1=new JPanel();
	   infoPanel2=new JPanel();
	   
	   nameLabel1=new JLabel("Nome: "+utente1.getNome());
	   nameLabel2=new JLabel("Nome:"+utente2.getNome());
	   surnameLabel1=new JLabel("Cognome: "+utente1.getCognome());
	   surnameLabel2=new JLabel("Cognome: "+utente2.getCognome());
	   usernameLabel1=new JLabel("Username: "+utente1.getUser());
	   usernameLabel2=new JLabel("Username: "+utente2.getUser());
	   feedbackLabel1=new JLabel("Feedback: "+String.valueOf(utente1.getFeedback()));
	   feedbackLabel2=new JLabel("Feedback: "+String.valueOf(utente2.getFeedback()));
	   
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
	   messageButton1=new JButton(utente1.getUser()+" invia messaggio");
	   messageButton2=new JButton(utente2.getUser()+" invia messaggio");
	   
	   
	   
	   controller1=new FigurineController(utente1);
	   controller2=new FigurineController(utente2);
	   componentMap=new HashMap<JComponent,Integer>();
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
       infoPanel1.setLayout(new GridLayout(4,1));
       infoPanel2.setLayout(new GridLayout(4,1));       
       userPanel.setLayout(new GridLayout(2,2));
       
       
         //Inizializza la collezione utenti
       
       initCollezione();
  
       //Aggiunge i componenti

       //Pannelli utente e sotto-pannelli
                  
       utente1Panel.add(figPanel1,BorderLayout.WEST);
       utente1Panel.add(offertaPanel1,BorderLayout.EAST);
       utente2Panel.add(figPanel2,BorderLayout.EAST);
       utente2Panel.add(offertaPanel2,BorderLayout.WEST);
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
       
       infoPanel1.add(nameLabel1);
       infoPanel1.add(surnameLabel1);
       infoPanel1.add(usernameLabel1);
       infoPanel1.add(feedbackLabel1);
       
       infoPanel2.add(nameLabel2);
       infoPanel2.add(surnameLabel2);
       infoPanel2.add(usernameLabel2);
       infoPanel2.add(feedbackLabel2);
       
       chatPanel.add(chat,BorderLayout.CENTER);
       infoPanel.add(infoPanel1,BorderLayout.WEST);
	   infoPanel.add(infoPanel2,BorderLayout.EAST);
       
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
   
   //Mappa i componenti su una hashmap
   
   private void mapComponents(){
	   
	   componentMap.put(this.addFigButton1,1);
	   componentMap.put(this.remFigButton1,2);
	   componentMap.put(this.messageButton1,3);
	   componentMap.put(this.confermaButton1,4);
	   componentMap.put(this.addFigButton2,5);
	   componentMap.put(this.remFigButton2,6);
	   componentMap.put(this.messageButton2,7);
	   componentMap.put(this.confermaButton2,8);
	   
	   
	   
   }
   
   //Aggiunge actionListener ai componenti
   
   private void actionComponents(){
	   
	   this.messageButton1.addActionListener(controller);
	   this.messageButton2.addActionListener(controller);
	   
	   
   }
   
   //inizializza le collezioni degli utenti
   
   private void initCollezione(){
	   
	   
	   int i;
	   JButton btmp;
	   
	   for(i=0;i<utente1.getCollezione().size();i++){
		   
		   btmp=new JButton(utente1.getCollezione().get(i).getNome()+" "+utente1.getCollezione().get(i).getRarità());
		   figPanel1.add(btmp);
		   btmp.addActionListener(controller1);
		   
	   }
	   
	   for(i=0;i<utente2.getCollezione().size();i++){
		   
		   btmp=new JButton(utente2.getCollezione().get(i).getNome()+" "+utente2.getCollezione().get(i).getRarità());
		   figPanel2.add(btmp);
		   btmp.addActionListener(controller2);
	   }
   }
   
   
   
   
   
   
   //Metodi interattivi
   
   public JTextArea getChat(){
	   
	   
	   return this.chat;
   }
   
   public String getChatText(){
	   
	   
	   return this.chat.getText();
   }
   
   public void clearChat(){
	   
	   
	   this.chat.setText("");
   }
   
   public void clearUser1Message(){
	   
	   this.userText1.setText("");
   }
   
   public void clearUser2Message(){
	   
	   this.userText2.setText("");
   }
   
   public String getUser1Message(){
	   
	   
	   return this.userText1.getText();
   }
   
   public String getUser2Message(){
	   
	   return this.userText2.getText();
	   
   }
   
   
   
   
   
   
}



