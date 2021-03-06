package gui;

import utenti.*;
import collezionabili.*;
import mercato.*;


import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.*;


public class LoginGui extends JFrame {
	
	
	
	private JLabel usernameLabel,passwordLabel;
	private JTextField usernameField;
	private JPasswordField passwordField;
	private JButton accessButton;
	private JPanel loginPanel,upperPanel,lowerPanel,middlePanel;
	private LayoutManager lay;
	
	
	
	//Costruttore 
	
	public LoginGui(){
		
		super("Login");
		this.initComponents();
		
				
		
	}
	
	//Inizializza i componenti della finestra
	private void initComponents(){
		
		
		this.setSize(640,400);
		this.setResizable(false);
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
       //Crea gli oggetti
		
		this.accessButton=new JButton("Accedi");
		this.usernameLabel=new JLabel("Username");
		this.passwordLabel=new JLabel("Password");
		this.usernameField=new JTextField();
		this.passwordField=new JPasswordField();
		this.loginPanel=new JPanel();
		this.upperPanel=new JPanel();
		this.lowerPanel=new JPanel();
		this.middlePanel=new JPanel();
		accessButton.setSize(400,200);
		
		
		this.formatComponents();
		this.initLayout();
		
		//Aggiunge gli oggetti
		this.add(loginPanel);
		loginPanel.add(upperPanel,BorderLayout.NORTH);
		loginPanel.add(middlePanel,BorderLayout.CENTER);
		loginPanel.add(lowerPanel,BorderLayout.SOUTH);
		upperPanel.add(usernameLabel);
		upperPanel.add(usernameField);
        middlePanel.add(passwordLabel);
        middlePanel.add(passwordField);
        lowerPanel.add(accessButton);
		this.pack();
		this.setSize(500,150);

		
		

		
	}
	
	//Inizializza il layout della finestra
	private void initLayout(){
		
		
		//Raffinare in seguito
		
	
		this.usernameLabel.setForeground(Color.RED);
		this.passwordLabel.setForeground(Color.ORANGE);
		this.loginPanel.setLayout(new BorderLayout());
		this.upperPanel.setLayout(new GridLayout(2,1));
		this.lowerPanel.setLayout(new FlowLayout());
		this.middlePanel.setLayout(new GridLayout(2,1));
		
		
	}
	
	//Formatta i compoenenti
	
	private void formatComponents(){
		
		
		//Raffinare il codice
		
		this.usernameField.setSize(70,20);
		this.passwordField.setBounds(10,10,30,10);
		this.accessButton.setSize(150,50);
		this.accessButton.setBackground(Color.GREEN);
		
	}
	
	
	//Nasconde la finestra
	public void hide(){
		
		
		this.setVisible(false);
	}
	

	
	
	

}
