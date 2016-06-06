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




public class UtenteGui extends JFrame{
	
	//Componenti dell'interfaccia
	
	private UtenteController controller;
	private Utente utente;
	public HashMap<JComponent,Integer> componentMap;
	
	
	private JPanel figPanel;
	private JPanel portalOptionPanel;
	private JPanel portalPanel;
	private JPanel manageCollectionPanel;
	private JPanel collectionPanel;
	private JPanel userListPanel;
	private JPanel infoTextPanel;
	private JPanel infoAndOptionPanel;
	private JPanel infoPanel;

	
	private JSeparator portalOptionSeparator;
	private JSeparator infoTextSeparator;
    
	private JScrollPane scrollFig;
	private JScrollPane scrollMess;
	private JTabbedPane tabPane;
	private JTextArea   infoTextArea;
	
    private  JButton   sendButton;
    private  JButton   addCreditButton;
    private  JButton   addFigButton;
    private  JButton   remFigButton;
    private  JButton   sortAlfaButton;
    private  JButton   sortRarButton;
    private JButton    scambioButton;
    private JButton    compravenditaButton;
    private  JLabel    infoTextLabel;
    private JLabel     searchUserLabel;
    private JLabel     searchFigLabel;
    private JLabel     userListLabel;
    
    private JTextField searchUserText;
    private JTextField searchFigText;
    private JTextArea userList;
    
    private JButton changeNameButton;
    private JButton changeSurnameButton;
    private JButton changeAgeButton;
    private JButton changeUsernameButton;
    private JButton changeMailButton;
    private JButton changeAddressButton;
    
    
    
    private JTextField figurinaName;
    private JTextField textCredito;    
    private JLabel figurineCountLabel;
    private JLabel feedbackLabel;
    private JLabel nameLabel;
    private JLabel surnameLabel;
    private JLabel userLabel;
    private JLabel ageLabel;
    private JLabel mailLabel;
    private JLabel addressLabel;
    private JLabel creditLabel;
    
    
    public UtenteGui(Utente u) {
    	
       	   super(u.getUser()+" User Interface");
    	   
    	   utente=u;
           this.initComponents();
           this.formatComponents();
           this.mapComponents();
           this.actionComponents();
       
    }
    
    
   private void initComponents() {
	   
	
	   //Crea gli oggetti
	   
	   controller=new UtenteController(this,utente);
	   componentMap=new HashMap<JComponent,Integer>();
	   
	   collectionPanel=new JPanel();
	   portalPanel=new JPanel();
	   manageCollectionPanel=new JPanel();
	   userListPanel=new JPanel();
	   portalOptionPanel=new JPanel();
	   figPanel=new JPanel();
	   infoTextPanel=new JPanel();
	   infoAndOptionPanel=new JPanel();
	   infoPanel=new JPanel();
           
	   
	   tabPane=new JTabbedPane();
	   scrollFig=new JScrollPane(figPanel,scrollFig.VERTICAL_SCROLLBAR_ALWAYS,scrollFig.HORIZONTAL_SCROLLBAR_ALWAYS);
	   scrollMess=new JScrollPane(infoTextPanel,scrollMess.VERTICAL_SCROLLBAR_ALWAYS,scrollMess.HORIZONTAL_SCROLLBAR_NEVER);
	   infoTextArea=new JTextArea();
	   infoTextLabel=new JLabel("Messaggi di sistema");
	   searchUserLabel=new JLabel("Ricerca Utente");
	   searchFigLabel=new JLabel("Ricerca Figurina");
	   userListLabel=new JLabel("Lista utenti");
	   nameLabel=new JLabel("Nome: "+utente.getNome());
	   surnameLabel=new JLabel("Cognome: "+utente.getCognome());
	   ageLabel=new JLabel("Età: "+String.valueOf(utente.getEtà()));
	   userLabel=new JLabel("Username: "+utente.getUser());
	   mailLabel=new JLabel("Mail: "+utente.getMail());
	   addressLabel=new JLabel("Indirizzo: "+utente.getIndirizzo());
	   
	   sendButton=new JButton("Invia");
	   addCreditButton=new JButton("Carica Credito");
	   addFigButton=new JButton("Aggiungi Figurina");
	   remFigButton=new JButton("Rimuovi Figurina");
	   sortAlfaButton=new JButton("Ordine Alfabetico");
	   sortRarButton=new JButton("Ordine Rarità");
	   scambioButton=new JButton("Inizia Scambio");
	   compravenditaButton=new JButton("Inizia Compravendita");
	   userList=new JTextArea();
	   
	   changeNameButton=new JButton("Cambia");
	   changeSurnameButton=new JButton("Cambia");
	   changeAgeButton=new JButton("Cambia");
	   changeUsernameButton=new JButton("Cambia");
	   changeMailButton=new JButton("Cambia");
	   changeAddressButton=new JButton("Cambia");
	   
	   searchUserText=new JTextField();
	   searchFigText=new JTextField();
	   portalOptionSeparator=new JSeparator();
	   infoTextSeparator=new JSeparator();
	   
       figurinaName=new JTextField("Nome Figurina");
       textCredito=new JTextField("Credito");
       figurineCountLabel=new JLabel("Figurine attuali: "+String.valueOf(utente.countFigurina()));
       feedbackLabel=new JLabel("    ");
       creditLabel=new JLabel("  ");
           
	   
	   

   }
   
   private void formatComponents(){
	   
	   //Property and Layout Setup
	   
	   this.setSize(800,600);
	   this.setVisible(true);
       this.setResizable(false);
       this.setDefaultCloseOperation(EXIT_ON_CLOSE);
       this.userList.setSize(400,300);
       this.userList.setEditable(false);
       
       updateCreditValue();
       updateCollezione();
       updateFeedbackvalue();
       
       infoTextArea.setVisible(true);
       infoTextArea.setText("prova");
       searchUserText.setHorizontalAlignment(JTextField.CENTER);
       searchFigText.setHorizontalAlignment(JTextField.CENTER);
       infoTextLabel.setAlignmentX(CENTER_ALIGNMENT);
       
       //Inserisce la finestra al centro dello schermo
       
       Dimension dim_schermo = Toolkit.getDefaultToolkit().getScreenSize();
		 int posX = (int) (dim_schermo.width - this.getWidth())/2;
		 int posY = (int) (dim_schermo.height - this.getHeight())/4;
		 this.setLocation(posX, posY);
   
	   //Tabbed panels
	   collectionPanel.setLayout(new GridLayout(2,1));
	   collectionPanel.setName("Collezione");
	   collectionPanel.setPreferredSize(new Dimension(600,100));	   
	   portalPanel.setLayout(new GridLayout(1,3));
	   portalPanel.setName("Portale");
	   infoAndOptionPanel.setLayout(new BorderLayout());
	   infoPanel.setName("Info");
	   infoPanel.setLayout(new GridLayout(7,2));
	   
	   //Internal Panels
	   portalOptionPanel.setLayout(new GridLayout(5,1));
	   infoTextPanel.setLayout(new GridLayout(4,1));
	   manageCollectionPanel.setLayout(new GridLayout(5,2));
	   userListPanel.setLayout(new BorderLayout());
	   
       //Aggiunge i componenti
       
       this.add(tabPane);
      
       
       //Single components
       
       manageCollectionPanel.add(figurinaName);
       manageCollectionPanel.add(sortAlfaButton);
       manageCollectionPanel.add(addFigButton);
       manageCollectionPanel.add(sortRarButton);
       manageCollectionPanel.add(remFigButton);
       manageCollectionPanel.add(figurineCountLabel);
       manageCollectionPanel.add(textCredito);
       manageCollectionPanel.add(feedbackLabel);
       manageCollectionPanel.add(addCreditButton);       
       manageCollectionPanel.add(creditLabel);
       
       
       
       infoTextPanel.add(infoTextLabel,BorderLayout.NORTH);
       infoTextPanel.add(infoTextArea,BorderLayout.CENTER);
       infoTextPanel.add(scambioButton,BorderLayout.SOUTH);
       infoTextPanel.add(compravenditaButton,BorderLayout.SOUTH);
         
       
       portalOptionPanel.add(searchUserLabel);
       portalOptionPanel.add(searchUserText);
       portalOptionPanel.add(searchFigLabel);
       portalOptionPanel.add(searchFigText);
       portalOptionPanel.add(sendButton);
     //  portalOptionPanel.add(portalOptionSeparator);
       userListPanel.add(userListLabel,BorderLayout.NORTH);
       userListPanel.add(userList,BorderLayout.CENTER);
       
       //Tab View Panels
      infoAndOptionPanel.add(portalOptionPanel,BorderLayout.NORTH);
      infoAndOptionPanel.add(infoTextPanel,BorderLayout.CENTER);
       
       
       
       collectionPanel.add(scrollFig,BorderLayout.NORTH);
       collectionPanel.add(manageCollectionPanel,BorderLayout.SOUTH);
       
       
       portalPanel.add(userListPanel);
       portalPanel.add(infoAndOptionPanel);
       
       infoPanel.add(nameLabel);
       infoPanel.add(changeNameButton);
       infoPanel.add(surnameLabel);
       infoPanel.add(changeSurnameButton);
       infoPanel.add(ageLabel);
       infoPanel.add(changeAgeButton);
       infoPanel.add(userLabel);
       infoPanel.add(changeUsernameButton);
       infoPanel.add(mailLabel);
       infoPanel.add(changeMailButton);
       infoPanel.add(addressLabel);
       infoPanel.add(changeAddressButton);
       infoPanel.add(feedbackLabel);

       
       //Main Tab Panels
       tabPane.add(collectionPanel);
       tabPane.add(portalPanel);
       tabPane.add(infoPanel);
       
       
      }
   
   //Mappa i componenti sulla Hashmap
   
   private void mapComponents(){
	   
	   componentMap.put(this.addFigButton,1);
	   componentMap.put(this.remFigButton,2);
	   componentMap.put(this.sortAlfaButton,3);
	   componentMap.put(this.sortRarButton,4);
	   componentMap.put(this.addCreditButton,5);
	   
	   //Inserire un JDialog per cambiare i valori dell'utente
	   componentMap.put(this.changeNameButton,6);
	   componentMap.put(this.changeSurnameButton,7);
	   componentMap.put(this.changeAgeButton,8);
	   componentMap.put(this.changeUsernameButton,9);
	   componentMap.put(this.changeMailButton,10);
	   componentMap.put(this.changeAddressButton,11);
	   
	   
	   
   }
   
   //Aggiunge action listener ai componenti
   private void actionComponents(){
	   
	   
	   this.addCreditButton.addActionListener(controller);
	   this.addFigButton.addActionListener(controller);
	   this.remFigButton.addActionListener(controller);
	   this.sortAlfaButton.addActionListener(controller);
	   this.sortRarButton.addActionListener(controller);
	   
	   
   }
   
   //Metodi Getter e utilità
   
   public String getCreditValue(){
	   
	   return this.textCredito.getText();
	   
	   
	   
   }
   
   public String getFigurinaValue(){
	   
	   //Da sviluppare per ottenere tutti i campi della figurina
	   
	   
	   return this.figurinaName.getText();
	   
   }
   
   public void clearCreditValue(){
	   
	   
	   this.textCredito.setText("");
   }
   
   
   public void clearFigurinaValue(){
	   
	   this.figurinaName.setText("");
   }
   
   public void updateCreditValue(){
	   
	   this.creditLabel.setText("Credito attuale: "+String.valueOf(utente.getCredito()));
	   
	   
   }
   
   public void updateFeedbackvalue(){
	   
	   
	   this.feedbackLabel.setText("Feedback attuale: "+String.valueOf(utente.getFeedback()));
	   
	   
	   }
   
   //Aggiorna la visuale figurine in base alla collezione dell'utente
   
   public void updateCollezione(){
	   
	   JButton btmp;
	   
	   this.figPanel.removeAll();
	   
	   for (int i=0;i<utente.getCollezione().size();i++){
		   
		   btmp=new JButton(utente.getCollezione().get(i).toString());
		   figPanel.add(btmp);
		   
	   }
	   
	  this.figurineCountLabel.setText("Figurine attuali: "+String.valueOf(utente.countFigurina()));
      scrollFig.updateUI();
	   
   }
   
   //Aggiorna la lista utenti dell'utente
   public void updateUserList(Portale p){
	   
	   ArrayList<String> u=p.getUserUtentiOnline();
	   String s="";
	   
	     this.userList.setText("");
	     
	     for(int i=0;i<u.size();i++){
	    	 
	    	 
	    	 s+=u.get(i);
	     }
	     
	     this.userList.setText(s);
	     
	       }
   
   //Aggiorna solamente il numero figurine
   
   public void updateFigurineCount(){
	   
	   String tmp;
	   
	   tmp=String.valueOf(utente.countFigurina());
	   this.figurineCountLabel.setText("Figurine attuali: "+tmp);
   }
   
   //Ritorna il pannello informazioni dell'utente
   
   public JPanel getuserInfoPanel(){
	   
	   return this.infoPanel;
	   
	   
   }
   
   //Aggiorna i dati dell'utente
   
   public void updateUserInfo(){
	   
	   this.setTitle(utente.getUser()+" User Interface");
	   this.nameLabel.setText("Nome: "+utente.getNome());
	   this.surnameLabel.setText("Cognome: "+utente.getCognome());
       this.ageLabel.setText("Età: "+String.valueOf(utente.getEtà()));
       this.userLabel.setText("Username: "+utente.getUser());
       this.mailLabel.setText("Mail: "+utente.getMail());
       this.addressLabel.setText("Indirizzo: "+utente.getIndirizzo());
  }
   
}



