package utenti;

public class Negoziante extends Collezionista {
	
	private String NomeNegozio,PartitaIva;
	
	
	//OverLoad Costruttore
	
	public Negoziante(String nom,String cogn,String indir,int e,int inicre,String nn,String pi){
		
		
		super(nom,cogn,indir,e,inicre);
		this.NomeNegozio=nn;
		this.PartitaIva=pi;
		
		
	}
	
	public Negoziante(String nom,String cogn,String indir,int e,int inicre,String u,String pass,String m,String nn,String pi){
		
		
		super(nom,cogn,indir,e,inicre,u,pass,m);
		this.NomeNegozio=nn;
		this.PartitaIva=pi;
	}

}
