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
    JPanel p3=new JPanel();
    
    JScrollBar s=new JScrollBar();
    
    JButton b1=new JButton("invio");
    JButton b2=new JButton("Carica Credito");
    JButton[]b=new JButton[10];
    
    JTextField t1=new JTextField("Ricerca Utente");
    JTextField t2=new JTextField("Ricerca Figurina");

    public UtenteGui() {
    	
        super("Menu");
        initComponent();
        
    }
       
    private void initComponent(){
       
        t1.setHorizontalAlignment(JTextField.CENTER);
        t2.setHorizontalAlignment(JTextField.CENTER);
        p1.setPreferredSize(new Dimension(500,500));
        
        
        this.add(l);
        p1.setName("Collezione");
        p3.setName("Portale");
        p1.add(s,BorderLayout.EAST);
        l.add(p1);
        l.add(p3);
        p2.add(t1);
        p2.add(t2);
        p2.add(b1);
        p2.add(b2);
        s.setVisibleAmount(500);

        for(int i=0;i<10;i++){
            
            b[i]=new JButton(""+(i+1));
            p1.add(b[i]);
        }
        p3.add(p2);
        pack();
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
    private void initLayout(){
    	
    	
    	//...
    }
    
    

    
    
}
