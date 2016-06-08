/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import utenti.*;
import manager.*;
import mercato.*;

import java.awt.*;
import java.util.*;

import javax.swing.*;





public class ScambioGui extends JFrame{
	
	//Componenti dell'interfaccia
	
	private Utente utente1,utente2;                                                        //Utenti di riferimento
	private ScambioController controller;
	private FigurineController controllerFig1,controllerFig2;

	private ArrayList<JButton> visualOfferta1;
	private ArrayList<JButton> visualOfferta2;
	
	private JPanel figPanel1,figPanel2,commandPanel1,commandPanel2;     //Sotto-pannelli utente 
	private JPanel scambioPanel;                                                                    //Pannello principale
	private JPanel utente1Panel,utente2Panel,userPanel;                                            //Pannelli utente principali
	private JPanel infoPanel;
	private JPanel chatPanel;
	private JPanel infoPanel1,infoPanel2;

	
	private JTextField userText1,userText2;
	private JTextArea chat;


	private JScrollPane scrollFig1,scrollFig2;


    private  JButton   confermaButton1,confermaButton2;
    private  JButton   messageButton1,messageButton2;
    
    private  JLabel nameLabel1,nameLabel2;
    private  JLabel surnameLabel1,surnameLabel2;
    private  JLabel usernameLabel1,usernameLabel2;
    private  JLabel feedbackLabel1,feedbackLabel2;  
    
    public  HashMap<JComponent,Integer> componentMap;                       //Hashmap dei componenti
    
    public ScambioGui(Scambio s,Utente u1,Utente u2) {
    	
    	   super(u1.getUser()+" scambia con "+u2.getUser());
    	   
    	   utente1=u1;
    	   utente2=u2;  
    	   controller=new ScambioController(this,s,utente1,utente2);
    	   
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
	  	  
	  
	   controllerFig1=new FigurineController(utente1);
	   controllerFig2=new FigurineController(utente2);
	   
	   visualOfferta1=new ArrayList<JButton>();
	   visualOfferta2=new ArrayList<JButton>();


	   scambioPanel=new JPanel();	
	   utente1Panel=new JPanel();
	   utente2Panel=new JPanel();
	   figPanel1=new JPanel();
	   figPanel2=new JPanel();
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

	   confermaButton1=new JButton("In attesa di conferma da "+utente1.getUser());
	   confermaButton2=new JButton("In attesa di conferma da "+utente2.getUser());
	   messageButton1=new JButton(utente1.getUser()+" invia messaggio");
	   messageButton2=new JButton(utente2.getUser()+" invia messaggio");

	   componentMap=new HashMap<JComponent,Integer>();
   }
   
   private void formatComponents(){
	   
	   //Property and Layout Setup
	   
	   this.setSize(800,650);
	   this.setVisible(true);
       this.setResizable(false);
       this.confermaButton1.setBackground(Color.RED);
       this.confermaButton2.setBackground(Color.RED);
       this.utente1Panel.setSize(400,400);
       this.utente2Panel.setSize(400,400);
       this.setDefaultCloseOperation(EXIT_ON_CLOSE);

       
       this.chat.setEditable(false);
       
       scambioPanel.setLayout(new GridLayout(3,1));
       utente1Panel.setLayout(new BorderLayout());
       utente2Panel.setLayout(new BorderLayout());
       commandPanel1.setLayout(new GridLayout(3,1));
       commandPanel2.setLayout(new GridLayout(3,1));
       infoPanel.setLayout(new BorderLayout());
       infoPanel1.setLayout(new GridLayout(4,1));
       infoPanel2.setLayout(new GridLayout(4,1));       
       userPanel.setLayout(new GridLayout(2,2));
       
       
         //Inizializza la collezione utenti
       
       initCollezione();
  
       //Aggiunge i componenti

       //Pannelli utente e sotto-pannelli
                  
       utente1Panel.add(figPanel1,BorderLayout.CENTER);
       utente2Panel.add(figPanel2,BorderLayout.CENTER);

       commandPanel1.add(userText1);
       commandPanel1.add(messageButton1);
       commandPanel1.add(confermaButton1); 
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
	   

	   componentMap.put(this.messageButton1,1);
	   componentMap.put(this.confermaButton1,2);
	   componentMap.put(this.messageButton2,3);
	   componentMap.put(this.confermaButton2,4);
	   
	   
	   
   }
   
   //Aggiunge actionListener ai componenti
   
   private void actionComponents(){
	   
	   this.messageButton1.addActionListener(controller);
	   this.messageButton2.addActionListener(controller);
	   this.confermaButton1.addActionListener(controller);
	   this.confermaButton2.addActionListener(controller);
	   
	   
   }
   
   //inizializza le collezioni degli utenti
   
   private void initCollezione(){
	   
	   
	   int i;
	 
	   
	   for(i=0;i<utente1.getCollezione().size();i++){
		   
		   visualOfferta1.add(new JButton(utente1.getCollezione().get(i).toString()));
		   visualOfferta1.get(i).addActionListener(controllerFig1);
		   figPanel1.add(visualOfferta1.get(i));
		   

		   
	   }
	   
	   for(i=0;i<utente2.getCollezione().size();i++){
		   
		   visualOfferta2.add(new JButton(utente2.getCollezione().get(i).toString()));
		   visualOfferta2.get(i).addActionListener(controllerFig2);
		   figPanel2.add(visualOfferta2.get(i));
		  
		   
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
   
   public JButton getConfermaButton1(){
	   
	   return this.confermaButton1;
   }
   
   public JButton getConfermaButton2(){
	   
	   return this.confermaButton2;
   }
   
   
   
   
   
}



