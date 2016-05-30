package test;

import gui.*;
import mercato.*;
import collezionabili.*;

import java.awt.*;
import java.awt.Event;

import utenti.*;

public class TestGui {
	
	public static void main(String args[]){
	
	Utente c1=new Collezionista("mario","rossi","via roma",30,100,"bimbo93","bamba","mail@yahoo.it");	
	Utente c2=new Collezionista("luigi","verdi","via del corso",28,150,"thunderbolt","pecorino","hotmail@libero.com");	
	
	Figurina f1=new Figurina(1,"aaa",20);
	Figurina f2=new Figurina(2,"bbb",30);
	
	c1.addFigurina(f1);
	c2.addFigurina(f2);
	
	c1.updateCollezioneView();
	c2.updateCollezioneView();

	
	ScambioGui s=new ScambioGui(c1,c2);
	
	
	}
	
	

}