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
	private Scambio scambio;                                                               //Scambio di riferimento
	private ScambioController controller;
	private FigurineController controllerFig1,controllerFig2;                           //Controller interfaccia

	private ArrayList<JButton> visualOfferta1;
	private ArrayList<JButton> visualOfferta2;
	
	private JPanel figPanel1,figPanel2,commandPanel1,commandPanel2;     //Sotto-pannelli utente 
	private JPanel scambioPanel;                                                                    //Pannello principale
	private JPanel utente1Panel,utente2Panel,userPanel;                                            //Pannelli utente principali
	private JPanel infoPanel;
	private JPanel chatPanel;
	private JPanel infoPanel1,infoPanel2;
	private JPanel bottomPanel;
	private JPanel sliderPanel1,sliderPanel2;
	
	private JSlider feedSlider1,feedSlider2;    
	private JLabel  sliderLabel1,sliderLabel2;

	
	private JTextField userText1,userText2;
	private JTextArea chat;


	private JScrollPane scrollFig1,scrollFig2,scrollChat;


    private  JButton   confermaButton1,confermaButton2;
    private  JButton   messageButton1,messageButton2;
    private  JButton   eseguiScambioButton;
    
    private  JLabel nameLabel1,nameLabel2;
    private  JLabel surnameLabel1,surnameLabel2;
    private  JLabel usernameLabel1,usernameLabel2;
    private  JLabel feedbackLabel1,feedbackLabel2;  
    private JLabel  statusLabel;
    
    public  HashMap<JComponent,Integer> componentMap;                       //Hashmap dei componenti
    
    public ScambioGui(Scambio s,Utente u1,Utente u2) {
    	
    	   super(u1.getUser()+" scambia con "+u2.getUser());
    	   
    	   utente1=u1;
    	   utente2=u2;  
    	   scambio=s;
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
	  	  
	   controllerFig1=new FigurineController(utente1,scambio,this);
	   controllerFig2=new FigurineController(utente2,scambio,this);
	   
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
	   bottomPanel=new JPanel();
	   sliderPanel1=new JPanel();
	   sliderPanel2=new JPanel();

	   
	   nameLabel1=new JLabel("Nome: "+utente1.getNome());
	   nameLabel2=new JLabel("Nome:"+utente2.getNome());
	   surnameLabel1=new JLabel("Cognome: "+utente1.getCognome());
	   surnameLabel2=new JLabel("Cognome: "+utente2.getCognome());
	   usernameLabel1=new JLabel("Username: "+utente1.getUser());
	   usernameLabel2=new JLabel("Username: "+utente2.getUser());
	   statusLabel=new JLabel("Stato dello scambio: "+"NUOVO");
	   feedbackLabel1=new JLabel("Feedback: "+String.valueOf(utente1.getFeedback()));
	   feedbackLabel2=new JLabel("Feedback: "+String.valueOf(utente2.getFeedback()));
	   sliderLabel1=new JLabel("Feedback: "+utente2.getUser());
	   sliderLabel2=new JLabel("Feedback: "+utente1.getUser());
	   
	   feedSlider1=new JSlider(-5,5);
	   feedSlider2=new JSlider(-5,5);
	   
	   
       userText1=new JTextField("Messagi chat utente 1");  
       userText2=new JTextField("Messaggi chat utente 2");
       chat=new JTextArea();
	   

	   scrollFig1=new JScrollPane(figPanel1,scrollFig1.VERTICAL_SCROLLBAR_AS_NEEDED,scrollFig1.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	   scrollFig2=new JScrollPane(figPanel2,scrollFig2.VERTICAL_SCROLLBAR_AS_NEEDED,scrollFig2.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	   scrollChat=new JScrollPane(chatPanel,scrollChat.VERTICAL_SCROLLBAR_AS_NEEDED,scrollChat.HORIZONTAL_SCROLLBAR_NEVER);

	   confermaButton1=new JButton("In attesa di conferma da "+utente1.getUser());
	   confermaButton2=new JButton("In attesa di conferma da "+utente2.getUser());
	   messageButton1=new JButton(utente1.getUser()+" invia messaggio");
	   messageButton2=new JButton(utente2.getUser()+" invia messaggio");
	   eseguiScambioButton=new JButton("Concludi scambio");

	   componentMap=new HashMap<JComponent,Integer>();
   }
   
   private void formatComponents(){
	   
	   //Property and Layout Setup
	   
	   this.setSize(800,650);
	   this.setVisible(true);
       this.setResizable(false);
       this.confermaButton1.setBackground(Color.RED);
       this.confermaButton2.setBackground(Color.RED);
       this.eseguiScambioButton.setEnabled(false);
       this.eseguiScambioButton.setBackground(Color.GRAY);
       this.utente1Panel.setSize(400,400);
       this.utente2Panel.setSize(400,400);
       this.statusLabel.setHorizontalAlignment(SwingConstants.CENTER);
       this.chat.setOpaque(true);
       this.chat.setBackground(Color.WHITE);
       
       this.feedSlider1.setMinorTickSpacing(1);
       this.feedSlider1.setMajorTickSpacing(5);
       this.feedSlider1.setPaintTicks(true);
       this.feedSlider1.setPaintLabels(true);
       this.feedSlider2.setMinorTickSpacing(1);
       this.feedSlider2.setMajorTickSpacing(5);
       this.feedSlider2.setPaintTicks(true);
       this.feedSlider2.setPaintLabels(true);
       
       this.chat.setEditable(false);
       
       scambioPanel.setLayout(new GridLayout(4,1));
       utente1Panel.setLayout(new BorderLayout());
       utente2Panel.setLayout(new BorderLayout());
       commandPanel1.setLayout(new GridLayout(3,1));
       commandPanel2.setLayout(new GridLayout(3,1));
       infoPanel.setLayout(new BorderLayout());
       infoPanel1.setLayout(new GridLayout(4,1));
       infoPanel2.setLayout(new GridLayout(4,1));       
       userPanel.setLayout(new GridLayout(2,2));
       bottomPanel.setLayout(new GridLayout(1,3));
       bottomPanel.setOpaque(true);
       
   
         //Inizializza la collezione utenti
       
       initCollezione();
  
       //Aggiunge i componenti

       //Pannelli utente e sotto-pannelli
                  
       utente1Panel.add(scrollFig1,BorderLayout.CENTER);
       utente2Panel.add(scrollFig2,BorderLayout.CENTER);
       
       sliderPanel1.add(sliderLabel1, BorderLayout.NORTH);
       sliderPanel1.add(feedSlider1,BorderLayout.CENTER);
       sliderPanel2.add(sliderLabel2,BorderLayout.NORTH);
       sliderPanel2.add(feedSlider2,BorderLayout.CENTER);

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
	   infoPanel.add(statusLabel,BorderLayout.NORTH);

	   bottomPanel.add(sliderPanel1);
	   bottomPanel.add(eseguiScambioButton);
	   bottomPanel.add(sliderPanel2);
	   
	   
       //Pannneli della frame
       
       userPanel.add(utente1Panel);
       userPanel.add(utente2Panel);
       userPanel.add(commandPanel1);
       userPanel.add(commandPanel2);
       
       scambioPanel.add(infoPanel);
       scambioPanel.add(userPanel);
       scambioPanel.add(scrollChat);
       scambioPanel.add(bottomPanel);
       
       
       this.add(scambioPanel);
       
      }
   
   //Mappa i componenti su una hashmap
   
   private void mapComponents(){
	   

	   componentMap.put(this.messageButton1,1);
	   componentMap.put(this.confermaButton1,2);
	   componentMap.put(this.messageButton2,3);
	   componentMap.put(this.confermaButton2,4);
	   componentMap.put(this.eseguiScambioButton,5);
	   
	   
	   
   }
   
   //Aggiunge actionListener ai componenti
   
   private void actionComponents(){
	   
	   this.messageButton1.addActionListener(controller);
	   this.messageButton2.addActionListener(controller);
	   this.confermaButton1.addActionListener(controller);
	   this.confermaButton2.addActionListener(controller);
	   this.eseguiScambioButton.addActionListener(controller);
	   
	   
   }
   
   //inizializza le collezioni degli utenti
   
   private void initCollezione(){
	   
	   
	   int i;
	 
	   //aggiunge figurine all'utente1
	   
	   for(i=0;i<utente1.getCollezione().size();i++){
		   
		   visualOfferta1.add(new JButton(utente1.getCollezione().get(i).toString()));
		   visualOfferta1.get(i).addActionListener(controllerFig1);
		   figPanel1.add(visualOfferta1.get(i));
    }
	   
	   scrollFig1.updateUI();
	   
	   //Aggiunge figurine all'utente 2
	   for(i=0;i<utente2.getCollezione().size();i++){
		   
		   visualOfferta2.add(new JButton(utente2.getCollezione().get(i).toString()));
		   visualOfferta2.get(i).addActionListener(controllerFig2);
		   figPanel2.add(visualOfferta2.get(i));
    }
	   
	   scrollFig2.updateUI();
   }
   
   //Verifica se lo scambio è pronto per essere concluso
   
   public void checkConcludiScambio(){
	   
	   if(this.confermaButton1.getBackground().equals(Color.GREEN)&& this.confermaButton2.getBackground().equals(Color.GREEN)){
		   
		   this.eseguiScambioButton.setEnabled(true);
		   this.eseguiScambioButton.setBackground(Color.CYAN);
		   
	   }
	   
	   
   }
   
     //Metodi interattivi
   
   public JTextArea getChat(){
	   
	   
	   return this.chat;
   }
   
   public String getChatText(){
	   
	   
	   return this.chat.getText();
   }
   
   public void updateStatoScambio(){
	   
	   this.statusLabel.setText("Stato dello scambio: "+this.scambio.getStatoScambio());
   }
   
   public void clearChat(){
	   
	   
	   this.chat.setText("");
   }
   
   public void updateChatPane(){
	   
	   this.scrollChat.updateUI();
   }
   
   public int getFeedbackValue1(){
	   
	   return this.feedSlider1.getValue();
   }
   
 public int getFeedbackValue2(){
	   
	   return this.feedSlider2.getValue();
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



