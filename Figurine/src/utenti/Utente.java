package utenti;

import java.util.*;
import javax.swing.*;

import collezionabili.*;
import gui.*;
import mercato.*;


public abstract class Utente implements Figurina_Interface {
	
	//dati dell'utente
	//implementare file precompilati per figurine
	
	private UtenteGui gui;                                          //Gui di riferimento
	public Portale port;                                            //Riferimento al portale
	private String Nome,Cognome,User,Password,Mail,Indirizzo;
	private int Età;
	public int FeedBack;
	private double Credito;
	public double OffertaCredito;
	private boolean Online;
	private ArrayList<Figurina> Figurine,OffertaFigurine; 
	
	//Overload su costruttore
	public Utente(String nom,String cogn,String indir,int e,double inicre,Portale p){
		
		
		
		
		this.Nome=nom;
		this.Cognome=cogn;
		this.Indirizzo=indir;
		this.Età=e;
		this.Credito=inicre;
		this.OffertaCredito=0;
		this.FeedBack=0;        //feedback iniziale 0
		this.User="User";
		this.Password="Password";         //credenziali di default
		this.Mail="User@Mydomain.com";
		this.Online=false;
		this.Figurine=new ArrayList<>();
		this.OffertaFigurine=new ArrayList<>();
		
		gui=new UtenteGui(this);
		port=p;
		
	}
	
public Utente(String nom,String cogn,String indir,int e,double inicre,Portale p,String u,String pass,String m){
		
		
	
		this.Nome=nom;
		this.Cognome=cogn;
		this.Indirizzo=indir;
		this.Età=e;
		this.Credito=inicre;
		this.OffertaCredito=0;
		this.FeedBack=0;        //feedback iniziale 0
		this.User=u;
		this.Password=pass;
		this.Mail=m;
		this.Online=false;
		this.Figurine=new ArrayList<>();
		this.OffertaFigurine=new ArrayList<>();
		
		gui=new UtenteGui(this);
		port=p;
		
		}

//metodi Getter

public String getNome(){
	
	
	return this.Nome;
}
public String getCognome(){
	
	
	return this.Cognome;
}

public int getEtà(){
	
	
	return this.Età;
}

public int getFeedback(){
	
	
	return this.FeedBack;
}

public String getIndirizzo(){
	
	
	return this.Indirizzo;
}

public double getCredito(){
	
	
	return this.Credito;
}

public String getUser(){
	
	
	return this.User;
}

protected String getPassword(){
	
	
	return this.Password;
}

public String getMail(){
	
	
	return this.Mail;
}

public boolean getWebState(){
	
	return Online;
}

public ArrayList<Figurina> getCollezione(){
	
	return Figurine;
}

//Ritorna l'offerta di figurine in uno scambio
public ArrayList<Figurina> getOffertaFigurine(){
	
	return this.OffertaFigurine;
}

//Ritorna l'offerta di credito in uno scambio
public double getOffertaCredito(){
	
	return this.OffertaCredito;
}

//metodi Setter (User,Password,Mail,Credito,Web State)

//Cambia il nome utente
protected void setUser(String u){
	
	
	this.User=u;
}

protected void setMail(String m){
	
	
	this.Mail=m;
}

//L'utente in genere non utilizza questo metodo

public void setWebState(boolean b){
	
	Online=b;
}

//metodi Operativi


//login utente 
protected int login(String u,String p){
	
	if((this.User.equals(u)) && (this.Password.equals(p))&& (this.getWebState()==false)) {
	   this.setWebState(true);
       return 0;
	}
        else return 1;
        
        
	
}

//L'utente esegue un logout dal portale

protected int logout(){
	
	
	if(this.getWebState()==true){
		this.setWebState(false);
		return 0;
	}
	
	else return 1;
	
	
}

//reset password con controllo vecchia password
protected boolean resetPassword(String p, String newP){

	//Primo inserimento di password
	if(this.Password==""){
		this.Password=newP;
		return true;
	}
	
    if(this.Password.equals(p)){
    this.Password=newP;
    return true;
    }
    else return false;
}

//Aggiunge figurina dati gli attributi

public boolean addFigurina(int id,String n, int r) {

		Figurina ftemp=new Figurina(id,n,r);       
	this.getCollezione().add(ftemp);
        
	
	return true;
}

//Aggiugne una figurina dato l'oggetto
public boolean addFigurina(Figurina f){
	
	
	Figurina ftemp=f;
	
	this.getCollezione().add(ftemp);
	return true;
}

//Rimuove una figurina dato l'oggetto
public boolean removeFigurina(Figurina f){
	
	
	for (int i=0;i<this.getCollezione().size();i++){
		
		if(this.getCollezione().get(i).equals(f)){
			
			this.getCollezione().remove(i);
			return true;
		}
	}
	return false;
}

//Rimuove una figurina dato l'id figurina
public boolean removeFigurinabyId(int id) {

	for(int i=0;i<this.getCollezione().size();i++){
		
		if(this.getCollezione().get(i).getId()==id){
			
			this.getCollezione().remove(i);
			return true;
		}
	}
	
	return false;
}

//Rimuove una figurina dato il nome
public boolean removeFigurinabyName(String n) {

	for(int i=0;i<this.getCollezione().size();i++){
		
		if(this.getCollezione().get(i).getNome().equals(n)) {
			
			this.getCollezione().remove(i);
			return true;
		}
	}
	return false;
}

//Ritorna il numero di figurine possedute
public int countFigurina() {

	return this.getCollezione().size();
}

//Ordina le figurine per ordine alfabetico del nome
public void sortAlfa() {

	Figurina ftemp;
	boolean flag;
	
	//bubble sort,ordine crescente
	
	
	do{
		flag=false;
		for(int i=0;i<this.getCollezione().size()-1;i++){
			
			if(this.getCollezione().get(i).getNome().compareTo(this.getCollezione().get(i+1).getNome())>0){
							
				ftemp=this.getCollezione().get(i+1);
                this.getCollezione().set(i+1,this.getCollezione().get(i));
                this.getCollezione().set(i,ftemp);
                flag=true;

			}
			
		}
		
	} while(flag);
	
}

//Ordina le figurine per rarità
public void sortRar() {

	Figurina ftemp;
	boolean flag;
	
	//bubble sort,ordine crescente
	
	do{
		flag=false;
		for(int i=0;i<this.getCollezione().size()-1;i++){
			
			if(this.getCollezione().get(i).getRarità()>this.getCollezione().get(i+1).getRarità()){
				
				ftemp=this.getCollezione().get(i+1);
                this.getCollezione().set(i+1,this.getCollezione().get(i));
                this.getCollezione().set(i,ftemp);
                flag=true;

			}
			
		}
		
	} while(flag);
	
}

//Ordina le figurine per numero Id

public void sortId(){
	
	Figurina ftemp;
	boolean flag;
	
	//Bubble sort ordine crescente
	
	do{
		
		flag=false;
		
		for(int i=0;i<this.getCollezione().size()-1;i++){
			
			if(this.getCollezione().get(i).getId()>this.getCollezione().get(i+1).getId()){
				
				ftemp=this.getCollezione().get(i+1);
                this.getCollezione().set(i+1,this.getCollezione().get(i));
                this.getCollezione().set(i,ftemp);
                flag=true;
			}
			
		}
	} while(flag);
	
	
	
	
}

//Ritorna una figurina dato l'oggetto
public Figurina getFigurina(Figurina f){
	

	for(int i=0;i<this.getCollezione().size();i++){
		
		if(this.getCollezione().get(i).equals(f)) return this.getCollezione().get(i);
		
	}
	return null;
	
}

//Ritorna una figurina della collezione dato l'id
public Figurina getFigurinabyId(int id) {

	
	for(int i=0;i<this.getCollezione().size();i++){
		
		if(this.getCollezione().get(i).getId()==id) return this.getCollezione().get(i);
		
	}
	
	return null;
}

//Ritorna una figurina dato il nome
public Figurina getFigurinabyNome(String n) {


	for(int i=0;i<this.getCollezione().size();i++){
		
		if(this.getCollezione().get(i).getNome()==n) return this.getCollezione().get(i);
		
	}
	
	
	return null;
}

//Aggiunge credito all'utente
public boolean addCredito(double c){
	
	if(c<0) return false;
	this.Credito+=c;
	return true;
}

//Rimuove credito all'utente

public boolean removeCredito(double c){
	
	if(c<0) return false;
	this.Credito-=c;
	return true;
	
}




//paragona nome e id delle figurine

public boolean compareFigurine(Figurina f1, Figurina f2) {
	
	String n1,n2;
	int i1,i2;
	
	n1=f1.getNome();
	n2=f2.getNome();
	i1=f1.getId();
	i2=f2.getId();
	
	if(n1==n2 && i1==i2) return true;
	else return false;
	
	
	
     }

//Ritorna informazioni come stringa dell'utente
public String toString(){
	
	return (String)(this.getNome()+" "+this.getCognome()+" "+this.getUser()+" "+this.getEtà()+" "+this.getCredito()+" "+this.getIndirizzo()+" "+this.getMail()+" "+this.getFeedback());
	
	
}

//Abilita-Disabilita l'interfaccia dell'utente

public void disableUtente(){
	
	
	gui.setEnabled(false);
	
}

public void enableUtente(){
	
	gui.setEnabled(true);
	
}


//Ritorna il pannello informazioni dell'utente, uso per lo scambio

public JPanel getUserInfoPanel(){
	
	return gui.getuserInfoPanel();
	
}

//Aggiorna la vista della collezione

public void updateCollezioneView(){
	
	this.gui.updateCollezione();
}

//Aggiorna la vista del feedback

public void updateFeedbackView(){
	
	
	this.gui.updateFeedbackvalue();
	
}


}