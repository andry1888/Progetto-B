/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.*;

import javax.swing.*;




public class UtenteGui extends JFrame{
	
	//Componenti dell'interfaccia
	
	
	private JPanel figPanel;
	private JPanel portalOptionPanel;
	private JPanel portalPanel;
	private JPanel manageCollectionPanel;
	private JPanel collectionPanel;
	private JPanel userListPanel;
	private JPanel infoTextPanel;
	private JPanel infoAndOptionPanel;
	
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
    private  JLabel    infoTextLabel;
    private JLabel     searchUserLabel;
    private JLabel     searchFigLabel;
    
    private JTextField searchUserText;
    private JTextField searchFigText;
    private JList userList;

    private  JButton[] provafigurine;
    private String[] provaString;
    
    public UtenteGui() {
    	
    	   super("User Interface");
           this.initComponents();
           this.formatComponents();
       
    }
    
    
   private void initComponents() {
	   
	
	   //Crea gli oggetti
	   
	   collectionPanel=new JPanel();
	   portalPanel=new JPanel();
	   manageCollectionPanel=new JPanel();
	   userListPanel=new JPanel();
	   portalOptionPanel=new JPanel();
	   figPanel=new JPanel();
	   infoTextPanel=new JPanel();
	   infoAndOptionPanel=new JPanel();
	   
	   tabPane=new JTabbedPane();
	   scrollFig=new JScrollPane(figPanel,scrollFig.VERTICAL_SCROLLBAR_AS_NEEDED,scrollFig.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	   scrollMess=new JScrollPane(infoTextPanel,scrollMess.VERTICAL_SCROLLBAR_ALWAYS,scrollMess.HORIZONTAL_SCROLLBAR_NEVER);
	   infoTextArea=new JTextArea();
	   infoTextLabel=new JLabel("Messaggi di sistema");
	   searchUserLabel=new JLabel("Ricerca Utente");
	   searchFigLabel=new JLabel("Ricerca Figurina");
	   
	   sendButton=new JButton("Invia");
	   addCreditButton=new JButton("Carica Credito");
	   addFigButton=new JButton("Aggiungi Figurina");
	   remFigButton=new JButton("Rimuovi Figurina");
	   sortAlfaButton=new JButton("Ordine Alafabetico");
	   sortRarButton=new JButton("Ordine Rarità");
	   
	   searchUserText=new JTextField();
	   searchFigText=new JTextField();
	   portalOptionSeparator=new JSeparator();
	   infoTextSeparator=new JSeparator();
	   
	   
	   //Elementi di prova
	   
	   provaString=new String[]{"pippo","pluto","topolino","paperino"};
	   provafigurine=new JButton[100];
	   
	   userList=new JList(provaString);
   }
   
   private void formatComponents(){
	   
	   //Layout Setup
	   
	   this.setSize(800,600);
	   this.setVisible(true);
       this.setResizable(false);
       this.setDefaultCloseOperation(EXIT_ON_CLOSE);
       
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
	   portalPanel.setLayout(new GridLayout(1,2));
	   portalPanel.setName("Portale");
	   infoAndOptionPanel.setLayout(new BorderLayout());
	   
	   //Internal Panels
	   portalOptionPanel.setLayout(new GridLayout(5,1));
	   infoTextPanel.setLayout(new GridLayout(2,1));
	   
             
       //Aggiunge i componenti
       
       this.add(tabPane);
       
       
       
       
       for(int i=0;i<100;i++){
           
           provafigurine[i]=new JButton(""+(i+1));
           figPanel.add(provafigurine[i]);
       }     
       
       //Single components
       
       manageCollectionPanel.add(addFigButton);
       manageCollectionPanel.add(remFigButton);
       manageCollectionPanel.add(sortAlfaButton);
       manageCollectionPanel.add(sortRarButton);
       manageCollectionPanel.add(addCreditButton);
       
       infoTextPanel.add(infoTextLabel,BorderLayout.NORTH);
       infoTextPanel.add(infoTextArea,BorderLayout.CENTER);
   
       
       portalOptionPanel.add(searchUserLabel);
       portalOptionPanel.add(searchUserText);
       portalOptionPanel.add(searchFigLabel);
       portalOptionPanel.add(searchFigText);
       portalOptionPanel.add(sendButton);
     //  portalOptionPanel.add(portalOptionSeparator);
       userListPanel.add(userList);
       
       //Tab View Panels
      infoAndOptionPanel.add(portalOptionPanel,BorderLayout.NORTH);
       infoAndOptionPanel.add(infoTextPanel,BorderLayout.CENTER);
       
       
       
       collectionPanel.add(scrollFig,BorderLayout.NORTH);
       collectionPanel.add(manageCollectionPanel,BorderLayout.SOUTH);
       portalPanel.add(userListPanel);
       portalPanel.add(infoAndOptionPanel);

       
       //Main Tab Panels
       tabPane.add(collectionPanel);
       tabPane.add(portalPanel);
      
  
      
      }
   
   
}