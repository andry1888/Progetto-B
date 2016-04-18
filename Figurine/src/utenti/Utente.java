package utenti;

import java.util.*;

import collezionabili.*;


public class Utente implements Figurina_Interface {
	
	//dati dell'utente
	//implementare file precompilati per figurine
	private String Nome,Cognome,User,Password,Mail,Indirizzo;
	private int Età,Feedback;
	private double Credito;
	private boolean Online;
	private ArrayList<Figurina> Figurine; 
	
	//Overload su costruttore
	public Utente(String nom,String cogn,String indir,int e,double inicre){
		
		
		this.Nome=nom;
		this.Cognome=cogn;
		this.Indirizzo=indir;
		this.Età=e;
		this.Credito=inicre;
		this.Feedback=0;        //feedback iniziale 0
		this.User="User";
		this.Password="Password";         //credenziali di default
		this.Mail="User@Mydomain.com";
		this.Online=false;
		this.Figurine=new ArrayList<>();
		
	}
	
public Utente(String nom,String cogn,String indir,int e,double inicre,String u,String pass,String m){
		
		
		this.Nome=nom;
		this.Cognome=cogn;
		this.Indirizzo=indir;
		this.Età=e;
		this.Credito=inicre;
		this.Feedback=0;        //feedback iniziale 0
		this.User=u;
		this.Password=pass;
		this.Mail=m;
		this.Online=false;
		this.Figurine=new ArrayList<>();
		
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
	
	
	return this.Feedback;
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

//metodi Setter (User,Password,Mail,Credito,Web State)

protected void setUser(String u){
	
	
	this.User=u;
}

protected void setPassword(String p){
	
	
	this.Password=p;
}

protected void setMail(String m){
	
	
	this.Mail=m;
}

//L'utente in genera non utilizza questo metodo

public void setWebState(boolean b){
	
	Online=b;
}

//metodi Operativi

protected boolean login(String u,String p){
	
	
	//...
	if(Online==false) this.Online=true;
	return Online;
}

protected boolean logout(){
	
	//..
	if(Online==true) this.Online=false;
	return Online;
	
	
}

@Override
public boolean addFigurina(String n, int i, int r) {
	// TODO Auto-generated method stub
	return false;
}

@Override
public boolean removeFigurina(int i) {
	// TODO Auto-generated method stub
	return false;
}

@Override
public int countFigurina() {
	// TODO Auto-generated method stub
	return 0;
}

@Override
public void sortAlfa() {
	// TODO Auto-generated method stub
	
}

@Override
public void sortRar() {
	// TODO Auto-generated method stub
	
}

@Override
public boolean addFigurina(Figurina f) {
	// TODO Auto-generated method stub
	return false;
}

@Override
public Figurina getFigurinabyId(int i) {
	// TODO Auto-generated method stub
	return null;
}

@Override
public ArrayList<Figurina> getFigurinabyNome(String n) {
	// TODO Auto-generated method stub
	return null;
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


}
