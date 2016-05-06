/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import collezionabili.*;

/**
 *
 * @author Miky
 */
public class testFigurine {
   public static void main(String[] args) {
            /*
              FileReader in;
              BufferedReader b;

              try {
                 in = new FileReader("figurine.txt");
                 b=new BufferedReader(in);
                 
                 String s;
                 String[] split;
                 int id, rar;
                 Strin nome;
                 while ((b.ready()) {
                    s=b.readLine();
                    split=s.split("\t");
                    id=Integer.toString(split[0]);
                    nome=split[1];
                    rar=Integer.toString(split[2]);
                    Figurina f=new Figurina();
                    addFig(f);
              }
              catch(IOException ioex){
                    System.out.println(ioex.getMessage());
              
              } finally {
                 if (in != null) {
                    in.close();
                 }
               
              }
            
       
       
       
            */
       
       
            Figurina f1=new Figurina("F1", 100);
            System.out.println (f1);
            
            Figurina f2=new Figurina("F2", 90);
            System.out.println (f2);
            
            Figurina f3=new Figurina("F3", 50);
            System.out.println (f3);
        }
}
