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
		
		
		ScambioGui s=new ScambioGui(c1,c2);
		
		
	} catch (NumberFormatException | IOException e) {
		
		e.printStackTrace();
	}

	
	}
	
	

}