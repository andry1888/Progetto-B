

package test;

import java.util.*;
import java.io.*;

import collezionabili.*;
import mercato.*;
import utenti.*;




public class TestSoft {
	
	public static void main(String args[]){
		
		boolean b1,b2,b3,b4,b5;
		
		
		try{
			
		Portale port=new Portale();
		Utente u1=new Collezionista("pippo","rossi","aaa",20,100,"user1","password1","mail1");
		Utente u2=new Collezionista("pluto","verdi","aaa",20,100,"user2","password2","mail2");
		
		
		b1=port.logIn("user1","password1",u1);
		b2=port.logIn("user2","password2",u2);
		
		System.out.println(b1);
		System.out.println(b2);
		
		System.out.println(u1.toString());
		System.out.println(u2.toString());
		
		}
		
		catch (FileNotFoundException e){
			
			System.out.println("File utenti non trovato");
		}
		
		catch(IOException e){
			
			System.out.println("Voce utente non trovata");
			
			
		}
		
		catch(IndexOutOfBoundsException e){
			
			System.out.println("Lettura voce file fallita");
			
		}
		
		
		
		
		
		
		
		
	}
	
	

}
