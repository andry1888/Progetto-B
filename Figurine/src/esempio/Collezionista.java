package esempio;

import java.util.ArrayList;

public class Collezionista {
	
	private int totFigurine;
	private String nome,cognome;
	private int età;
	private ArrayList <Figurina> figurs;
	private Figurina ftemp;
	
	
	public Collezionista(String nom,String cogn,int e){
		
		figurs=new ArrayList<>();
		totFigurine=figurs.size();
		nome=nom;
		cognome=cogn;
		età=e;
		
	}
	
	public void addFigurina(String nom,String des,int rar,int num){
		
		ftemp=new Figurina(nom,des,rar,num);
		figurs.add(ftemp);
		
	}
	
	public void removeFigurina(int i){
		
	
		figurs.remove(i);
	}
	

}