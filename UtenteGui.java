/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.*;
import javax.swing.*;

/**
 *
 * @author biagio
 */
public class UtenteGui extends JFrame{
    JTabbedPane l=new JTabbedPane();
    JPanel p1=new JPanel();
    JPanel p2=new JPanel(new GridLayout(4,1));
    JPanel p3=new JPanel(new GridLayout(1,2));
    JPanel p4=new JPanel();
    JPanel p0=new JPanel(new GridLayout(2,1));
    JPanel p5=new JPanel();
    
    JScrollPane s=new JScrollPane(p1);
    
    JButton b1=new JButton("invio");
    JButton b2=new JButton("Carica Credito");
    JButton[]b=new JButton[100];
    JButton addf=new JButton("aggiungi figurina");
    JButton remf=new JButton("rimuovi figurina");
    JButton ordalfa=new JButton("ordine alfabetico");
    JButton ordrar=new JButton("ordine rarita'");
    
    JTextField t1=new JTextField("Ricerca Utente");
    JTextField t2=new JTextField("Ricerca Figurina");
    String[] array=new String[]{"pippo","pluto","topolino","paperino"};
    JList listautenti=new JList(array);

    
    public UtenteGui() {
        super("Bacheca");
        
        
        t1.setHorizontalAlignment(JTextField.CENTER);
        t2.setHorizontalAlignment(JTextField.CENTER);
        p0.setPreferredSize(new Dimension(600,100));
        
        
        
        this.add(l);
        p0.setName("Collezione");
        p3.setName("Opzioni");
        p0.add(s,BorderLayout.NORTH);
        p0.add(p4,BorderLayout.SOUTH);
        l.add(p0);
        l.add(p3);
        p2.add(t1);
        p2.add(t2);
        p2.add(b1);
        p2.add(b2);   
        p5.add(listautenti);
        

        for(int i=0;i<100;i++){
            
            b[i]=new JButton(""+(i+1));
            p1.add(b[i]);
        }
        p4.add(addf);
        p4.add(remf);
        p4.add(ordalfa);
        p4.add(ordrar);
        p3.add(p5);
        p3.add(p2);
        pack();
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
    

    
    
}
