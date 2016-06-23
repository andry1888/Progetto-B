package gui;

import utenti.*;
import collezionabili.*;
import manager.*;
import mercato.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.*;


public class LoginGui extends JFrame {
	
	
	
	private JLabel usernameLabel,passwordLabel;
	private JTextField usernameField;
	private JPasswordField passwordField;
	private JButton accessButton;
	private JPanel loginPanel,upperPanel,lowerPanel,middlePanel;
	public UtenteController userController;
	private loginListener  listener;
	
	
	
	//Costruttore 
	
	public LoginGui(UtenteController cont){
		
		super("Login");
		userController=cont;
		
		this.initComponents();
		this.formatComponents();
				
		
	}
	
	//Inizializza i componenti della finestra
	private void initComponents(){
		
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

		
	}
	
	
	//Formatta i componenti
	
	private void formatComponents(){
		
		
		this.setSize(640,400);
		this.setResizable(false);
		this.setVisible(true);

		this.usernameLabel.setForeground(Color.RED);
		this.passwordLabel.setForeground(Color.ORANGE);
		this.loginPanel.setLayout(new BorderLayout());
		this.upperPanel.setLayout(new GridLayout(2,1));
		this.lowerPanel.setLayout(new FlowLayout());
		this.middlePanel.setLayout(new GridLayout(2,1));
		this.accessButton.setSize(400,200);
		this.accessButton.addActionListener(listener);		
		this.usernameField.setSize(70,20);
		this.passwordField.setBounds(10,10,30,10);
		this.accessButton.setSize(150,50);
		this.accessButton.setBackground(Color.GREEN);
		
		
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
		
	}
	
	
	//Metodi interattivi
	
	public void setUserText(String s){
		
		this.usernameField.setText(s);
	}
	
	public void setPasswordText(String s){
		
		this.passwordField.setText(s);
	}
	
	public String getUserText(){
		
		return this.usernameField.getText();
	}
	
	public String getPasswordText(){
		
		return this.passwordField.getText();
	}

	
	
	

}



class loginListener implements ActionListener{

     private LoginGui gui;
	
	
	public loginListener(LoginGui g){
		
		gui=g;
		
	}
	
	
	public void actionPerformed(ActionEvent e) {
		
		
         gui.userController.login(gui.getUserText(),gui.getPasswordText());
         gui.setVisible(false);
		
	}
	
	
	
	
}
