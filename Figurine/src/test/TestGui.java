package test;

import gui.*;

import mercato.*;
import collezionabili.*;

import java.awt.*;
import java.io.IOException;

import utenti.*;

public class TestGui {
	
	public static void main(String args[]){
		
		
	try {
		Portale port=new Portale();
		
		Utente c1=new Collezionista("mario","rossi","via roma",30,100,port,"bimbo93","bamba","mail@yahoo.it");	
		Utente c2=new Collezionista("luigi","verdi","via del corso",28,150,port,"thunderbolt","pecorino","hotmail@libero.com");	
		
		c1.addFigurina(new Figurina(1,"a",1000));
		c1.addFigurina(new Figurina(2,"b",1000));
		c1.addFigurina(new Figurina(3,"c",1000));
		
		c1.updateCollezioneView();
		
		c2.addFigurina(new Figurina(4,"e",1000));
		c2.addFigurina(new Figurina(5,"f",1000));
		c2.addFigurina(new Figurina(6,"g",1000));
		
		c2.updateCollezioneView();
		
		Scambio s=new Scambio(c1,c2);
		
		
	} catch (NumberFormatException | IOException e) {
		
		e.printStackTrace();
	}

	
	}
	
	

}