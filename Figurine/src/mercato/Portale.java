

package mercato;

import collezionabili.*;
import utenti.*;

import java.io.*;
import java.util.*;






public class Portale {

	
	private static ArrayList<Utente> Utenti_Online;
	private FileReader fr;
	private BufferedReader br;
        private FileReader ffig;
	private BufferedReader bfig;
	private static ArrayList<Figurina> Figurine_reg;

	
	//implementare database user-password
	
	//imporre la staticità delle componenti della classe
	
	public Portale() throws IOException,NumberFormatException{
		
		Utenti_Online= new ArrayList<>();
		Figurine_reg= new ArrayList<>();

                fr = new FileReader("registro_utenti.txt");
                ffig = new FileReader("registro_figurine.txt");

                br=new BufferedReader(fr);
                bfig=new BufferedReader(ffig);
                this.caricaFigurine();

	}
        
	//Carica le figurine dal registro

	public boolean caricaFigurine() throws IOException{

		
		String s;
        String[] split;
        
        String nome;
        Integer rar;
        Integer Id;
    
        //Data parsing
        while (bfig.ready()) {
        	
           s=bfig.readLine();
           split=s.split(" ");
           
           Id=Integer.parseInt(split[0]);
           nome=split[1];
           rar=Integer.parseInt(split[2]);
           Figurina f=new Figurina(Id,nome, rar);
           Figurine_reg.add(f);
        }
        
  return false;      
  }
	
	//Login utente
	public boolean logIn(String u,String p,Utente ut) throws IOException{
		
		String s;
        String[] split;
        
        String user,psw;
        while (br.ready()) {
           s=br.readLine();
           split=s.split(" ");
           user=split[0];
           psw=split[1];
           if(user.equals(u) && psw.equals(p)){
           	Utenti_Online.add(ut);
           	ut.setWebState(true);
           	return true;
           	
           	
           }
        }
        
        
        return false;
        
  }
	
	//Logout utente
	public boolean logOut(String u,Utente ut){
		
		for(int i=0;i<Utenti_Online.size();i++){
			
			if(Utenti_Online.get(i).getUser().compareTo(u)==0){
				
				this.Utenti_Online.remove(i);
				ut.setWebState(false);
				return true;
			}
		}
		
		return false;
		
	}
	
	
	public ArrayList<Utente> getUtenti(){
		
		//Deve ritornare gli user
		return Utenti_Online;
		
	}
	
	
	
	
	//inizia lo scambio tra due utenti
	
	public Scambio startScambio(Utente u1,Utente u2){
		
		Scambio s=new Scambio(u1,u2);
		
		return s;
		
		
	}
	
	//Inizia una compravendita, tra un utente e almeno un negoziante
	
	public Compravendita startCompravendita(Negoziante n,Utente u){
		
		Compravendita c=new Compravendita(n,u);
		
		return c;
		
	}
	
	
	//Ritorna un utente dato lo user, null se non esiste, uso esclusivo di portale
	
	private Utente getUtentebyUser(String u){
				
		for(int i=0;i<this.Utenti_Online.size();i++){
			
			if(Utenti_Online.get(i).getUser()==u) return Utenti_Online.get(i);
			
			
		}
		
		return null;
		
		
	}
	
	//Ritorna un utente online dato l'indice del vettore
	private Utente getUtentebyIndex(int ind){
		
		return Utenti_Online.get(ind);
	}
	
	
	//Metodo che ritorna l'elenco user online
	public ArrayList<String> getUserUtentiOnline(){
		
		
		ArrayList<String> elenco=new ArrayList<>();
		
		for(int i=0;i<Utenti_Online.size();i++){
			
			elenco.add(Utenti_Online.get(i).getUser());
			
		}
		
		return elenco;
	}
        
        

	//Ritorna il registro figurine
        public ArrayList<Figurina> getRegFig(){
		
		return Figurine_reg;
	}
        
        //Ritorna il registro figurine come stringa
        public String getStringRegFig(){
        	
        	String res="";
        	
        	for(int i=0;i<this.Figurine_reg.size();i++){
        		
        		res=res+this.Figurine_reg.get(i).toString()+"\n";
        	}
        	
        	return res;
        	
        }
	
	//Ritorna la collezione di un utente dato lo user, null se non esiste lo user
	
	public ArrayList<Figurina> getFigurineByUser(String u){
		
		
		for(int i=0;i<Utenti_Online.size();i++){
			
			if(Utenti_Online.get(i).getUser().compareTo(u)==0) return Utenti_Online.get(i).getCollezione();
		}
		
		return null;
	}
	
	public ArrayList<Figurina> getFigurineByUser(Utente u){
		
		
		for(int i=0;i<this.Utenti_Online.size();i++){
			
			
			if(Utenti_Online.get(i).equals(u)) return Utenti_Online.get(i).getCollezione();
		}
		
		return null;
	}
	
	//Ritorna l'insieme di utenti aventi figurine con l'id inserito
	public ArrayList<Utente> getUsersByFigurinaId(int id){
		
		ArrayList<Utente> ufin=new ArrayList<>();
		Utente utemp;
		
		for(int i=0;i<Utenti_Online.size();i++){
			
			utemp=Utenti_Online.get(i);
			for(int j=0;j<utemp.getCollezione().size();j++){
				
				if(id==utemp.getCollezione().get(j).getId()){
					ufin.add(utemp);
					break;
				}
				
			}
		
			
			
		}
		return ufin;
		
	}
	
	//Gestire il primo accesso dell'utente con registrazione
	
	
	
	
	
	
	
	
}
