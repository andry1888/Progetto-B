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
	
	private UtenteController controller;
	private Utente utente;
	
	
	private JPanel figPanelIO;
	private JPanel figPanelDEST;
	private JPanel figPanelIO2;
	private JPanel figPanelDEST2;

        private JPanel portalOptionPanel;
	private JPanel portalPanel;
	private JPanel manageCollectionPanel;
	private JPanel manageOffertPanel;
	private JPanel collectionPanel;
	private JPanel offertPanel;
	private JPanel userListPanel;
	private JPanel infoTextPanel;
	private JPanel infoAndOptionPanel;
        //private JPanel manageCollectionPanel1;
	
	private JSeparator portalOptionSeparator;
	private JSeparator infoTextSeparator;
    
	private JScrollPane scrollFig,scrollFig2;
	private JScrollPane scrollFigDEST,scrollFigDEST2;

        
        private JScrollPane scrollMess;
	private JTabbedPane tabPane;
	private JTextArea   infoTextArea;
	
    private  JButton   sendButton;
    private  JButton   addFigButton;
    private  JButton   remFigButton;
    private  JButton   sortAlfaButton;
    private  JButton   sortRarButton;
    private JButton    scambioButton;
    private JButton    inviaScambio;

    private JButton    compravenditaButton;
    private  JLabel    infoTextLabel;
    private  JLabel    infoDest,infoDest2;
    private  JLabel    infoIO,infoIO2;

    
    private JLabel     searchUserLabel;
    private JLabel     searchFigLabel;
    
    private JTextField searchUserText;
    private JTextField searchFigText;
    private JList userList;

    private  JButton[] provafigurine;
    private String[] provaString;
    
    private JTextField figurinaName;
    private JLabel vuota;
    private JLabel vuota1;
    private JLabel vuota2;
    
    
    public ScambioGui(Utente u) {
    	
    	   super("Scambio Interface");
    	   utente=u;
    	   
           this.initComponents();
           this.formatComponents();
       
    }
    
    
   private void initComponents() {
	   
	
	   //Crea gli oggetti
	   
	   //controller=new UtenteController(this,utente);
	   
	   collectionPanel=new JPanel();
	   offertPanel=new JPanel();
	   portalPanel=new JPanel();
	   manageCollectionPanel=new JPanel(new GridLayout(5,2));
	   manageOffertPanel=new JPanel(new GridLayout(5,2));
	   userListPanel=new JPanel();
	   portalOptionPanel=new JPanel();
	   figPanelIO=new JPanel();
	   figPanelDEST=new JPanel();
	   figPanelIO2=new JPanel();
	   figPanelDEST2=new JPanel();
           infoTextPanel=new JPanel();
	   infoAndOptionPanel=new JPanel();
           
	   
	   tabPane=new JTabbedPane();
	   scrollFig=new JScrollPane(figPanelIO,scrollFig.VERTICAL_SCROLLBAR_AS_NEEDED,scrollFig.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	   scrollFigDEST=new JScrollPane(figPanelDEST,scrollFigDEST.VERTICAL_SCROLLBAR_AS_NEEDED,scrollFigDEST.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	   scrollFig2=new JScrollPane(figPanelIO2,scrollFig2.VERTICAL_SCROLLBAR_AS_NEEDED,scrollFig2.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	   scrollFigDEST2=new JScrollPane(figPanelDEST2,scrollFigDEST2.VERTICAL_SCROLLBAR_AS_NEEDED,scrollFigDEST2.HORIZONTAL_SCROLLBAR_AS_NEEDED);

           
           scrollMess=new JScrollPane(infoTextPanel,scrollMess.VERTICAL_SCROLLBAR_ALWAYS,scrollMess.HORIZONTAL_SCROLLBAR_NEVER);
	   infoTextArea=new JTextArea();
	   infoTextLabel=new JLabel("Messaggi di sistema");
	   infoDest=new JLabel("Destinatario ");
	   infoDest2=new JLabel("Destinatario ");
	   infoIO=new JLabel("La tua esposizione ");
	   infoIO2=new JLabel("La tua esposizione ");
            

           
           searchUserLabel=new JLabel("Ricerca Utente");
	   searchFigLabel=new JLabel("Ricerca Figurina");
	   
	   sendButton=new JButton("Invia");
	   addFigButton=new JButton("Aggiungi Figurina allo scambio");
	   remFigButton=new JButton("Rimuovi Figurina allo scambio");
	   sortAlfaButton=new JButton("Ordine Alfabetico");
	   inviaScambio=new JButton("INVIA");

           sortRarButton=new JButton("Ordine Rarità");
	   scambioButton=new JButton("Inizia Scambio");
	   compravenditaButton=new JButton("Inizia Compravendita");
	   
	   searchUserText=new JTextField();
	   searchFigText=new JTextField();
	   portalOptionSeparator=new JSeparator();
	   infoTextSeparator=new JSeparator();
	   
           figurinaName=new JTextField("Nome Figurina");
           vuota=new JLabel("    ");
           vuota1=new JLabel("    ");
           vuota2=new JLabel("    ");
           
            //Elementi di prova
	   
	   provaString=new String[]{"pippo","pluto","topolino","paperino"};
	   provafigurine=new JButton[100];
	   
	   userList=new JList(provaString);
   }
   
   private void formatComponents(){
	   
	   //Layout Setup
	   
	   this.setSize(800,650);
	   this.setVisible(true);
       this.setResizable(false);
       this.setDefaultCloseOperation(EXIT_ON_CLOSE);
       this.userList.setSize(400,300);
       
       infoTextArea.setVisible(true);
       infoTextArea.setText("prova");
       searchUserText.setHorizontalAlignment(JTextField.CENTER);
       searchFigText.setHorizontalAlignment(JTextField.CENTER);
       infoTextLabel.setAlignmentX(CENTER_ALIGNMENT);
       infoDest.setAlignmentX(CENTER_ALIGNMENT);
       infoDest2.setAlignmentX(CENTER_ALIGNMENT);

       infoIO.setAlignmentX(CENTER_ALIGNMENT);
       infoIO2.setAlignmentX(CENTER_ALIGNMENT);

       
       //Inserisce la finestra al centro dello schermo
       
       Dimension dim_schermo = Toolkit.getDefaultToolkit().getScreenSize();
		 int posX = (int) (dim_schermo.width - this.getWidth())/2;
		 int posY = (int) (dim_schermo.height - this.getHeight())/4;
		 this.setLocation(posX, posY);
   
	   //Tabbed panels
	   collectionPanel.setLayout(new GridLayout(5,1));
	   collectionPanel.setName("Scambio");
	   collectionPanel.setPreferredSize(new Dimension(600,100));
	   offertPanel.setLayout(new GridLayout(5,1));
	   offertPanel.setName("Offerta");
	   offertPanel.setPreferredSize(new Dimension(600,100));
	   portalPanel.setLayout(new GridLayout(1,3));
	   portalPanel.setName("Portale");
	   infoAndOptionPanel.setLayout(new BorderLayout());
	   
	   //Internal Panels
	   portalOptionPanel.setLayout(new GridLayout(4,1));
	   infoTextPanel.setLayout(new GridLayout(4,1));
	   
             
       //Aggiunge i componenti
       
       this.add(tabPane);
       
       
       
       
       for(int i=0;i<100;i++){
           
           provafigurine[i]=new JButton(""+(i+1));
           figPanelIO.add(provafigurine[i]);
       }  
       
       for(int i=0;i<100;i++){
           
           provafigurine[i]=new JButton(""+(i+1));
           figPanelDEST.add(provafigurine[i]);
       }   
       
for(int i=0;i<100;i++){
           
           provafigurine[i]=new JButton(""+(i+1));
           figPanelIO2.add(provafigurine[i]);
       }  
       
       for(int i=0;i<100;i++){
           
           provafigurine[i]=new JButton(""+(i+1));
           figPanelDEST2.add(provafigurine[i]);
       }
       
       //Single components
       
       manageCollectionPanel.add(figurinaName);
       

       manageCollectionPanel.add(addFigButton);
       manageCollectionPanel.add(remFigButton);
       manageCollectionPanel.add(vuota);
       manageCollectionPanel.add(vuota1);
       manageCollectionPanel.add(inviaScambio);
       
       
       manageOffertPanel.add(vuota);
       manageOffertPanel.add(vuota1);
       manageOffertPanel.add(inviaScambio);
       
       
      
       
       
       infoTextPanel.add(infoTextLabel,BorderLayout.NORTH);
       infoTextPanel.add(infoTextArea,BorderLayout.CENTER);
       infoTextPanel.add(scambioButton,BorderLayout.SOUTH);
       infoTextPanel.add(compravenditaButton,BorderLayout.SOUTH);
         
       
       portalOptionPanel.add(searchUserLabel);
       portalOptionPanel.add(searchUserText);
       portalOptionPanel.add(searchFigLabel);
       portalOptionPanel.add(searchFigText);
       portalOptionPanel.add(sendButton);
       portalOptionPanel.add(portalOptionSeparator);
       userListPanel.add(userList);
       
       //Tab View Panels
      infoAndOptionPanel.add(portalOptionPanel,BorderLayout.NORTH);
       infoAndOptionPanel.add(infoTextPanel,BorderLayout.CENTER);
       
       
       collectionPanel.add(infoDest,BorderLayout.NORTH);

       collectionPanel.add(scrollFig,BorderLayout.NORTH);
       collectionPanel.add(infoIO,BorderLayout.NORTH);

       collectionPanel.add(scrollFigDEST,BorderLayout.NORTH);

       
       collectionPanel.add(manageCollectionPanel,BorderLayout.SOUTH);
       
       offertPanel.add(infoDest2,BorderLayout.NORTH);

       offertPanel.add(scrollFig2,BorderLayout.NORTH);
       offertPanel.add(infoIO2,BorderLayout.NORTH);

       offertPanel.add(scrollFigDEST2,BorderLayout.NORTH);
       offertPanel.add(manageOffertPanel,BorderLayout.SOUTH);
       
       
       portalPanel.add(userListPanel);
       portalPanel.add(infoAndOptionPanel);

       
       //Main Tab Panels
       tabPane.add(collectionPanel);
       tabPane.add(portalPanel);
       tabPane.add(offertPanel);
       
       
      }
   
   
   
   
}



