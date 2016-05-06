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
	private JPanel loginPanel;
	private LayoutManager lay;
	
	
	
	//Costruttore 
	
	public LoginGui(){
		
		super("Login");
		this.initComponents();
		
				
		
	}
	
	//Inizializza i componenti della finestra
	private void initComponents(){
		
		
		this.setSize(800,600);
		this.setResizable(false);
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
       //Crea gli oggetti
		
		this.accessButton=new JButton("Accedi");
		this.usernameLabel=new JLabel("Username");
		this.passwordLabel=new JLabel("Password");
		this.usernameField=new JTextField("Inserisci nome utente");
		this.passwordField=new JPasswordField();
		this.loginPanel=new JPanel();
		accessButton.setSize(400,200);
		
		
		this.formatComponents();
		this.initLayout();
		
		//Aggiunge gli oggetti
		this.add(loginPanel);
		loginPanel.setLayout(new FlowLayout());
		getContentPane().add(usernameLabel);
		getContentPane().add(usernameField);
		getContentPane().add(passwordLabel);
		getContentPane().add(passwordField);
		getContentPane().add(accessButton);
		
		
		

		
	}
	
	//Inizializza il layout della finestra
	private void initLayout(){
		
		
		//Raffinare in seguito
		
		this.lay=new BorderLayout();
		
		
	}
	
	//Formatta i compoenenti
	
	private void formatComponents(){
		
		
		//Raffinare il codice
		
		this.accessButton.setBackground(Color.GREEN);
		
	}
	
	
	//Nasconde la finestra
	public void hide(){
		
		
		this.setVisible(false);
	}
	

	
	
	

}
