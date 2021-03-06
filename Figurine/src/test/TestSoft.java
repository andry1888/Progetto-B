

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
                
                   
		Utente u1=new Collezionista("pippo","rossi","aaa",20,100,port,"user1","password1","mail1");
		Utente u2=new Collezionista("pluto","verdi","aaa",20,100,port,"user2","password2","mail2");
		
		
		b1=port.logIn("user1","password1",u1);
		b2=port.logIn("user2","password2",u2);
		
		System.out.println(b1);
		System.out.println(b2);
		
		System.out.println(u1.toString());
		System.out.println(u2.toString());
		System.out.println("Registro figurine \n");
		System.out.println(port.getStringRegFig());
		
                u1.addFigurina(port.getRegFig().get(1));
                u1.addFigurina(port.getRegFig().get(0));
                u2.addFigurina(port.getRegFig().get(1));
                u2.addFigurina(port.getRegFig().get(2));

                
                Scambio sc=new Scambio(u1,u2);
                System.out.println("SCAMBIO PROVA STATO="+sc.getStatoScambio());               
                sc.addFigurina(u1,0);
                System.out.println("SCAMBIO PROVA STATO="+sc.getStatoScambio());

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
		catch (NumberFormatException e){
			
			System.out.println("Formato file non corretto");
		}
		
		
		
		
		
		
		
		
	}
	
	

}
