import java.util.*;
import java.io.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
 class Spectacol extends JFrame  {
    JButton buton1, buton2, buton3, buton4, buton5;
    JLabel lmesaj;
    JPanel p1;
    ArrayList<JButton> buton = new ArrayList<>();
    ArrayList<String> spectacole = new ArrayList<String>();
   
    Spectacol(String title){
        super(title);
        
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        AscultatorButon ab=new AscultatorButon();
            
        
        lmesaj=new JLabel("Alegeti spectacolul la care doriti sa participati:");
        spectacole.add("O scrisoare pierdută (I.L. Caragiale)");
        spectacole.add("D-ale carnavalului (I.L. Caragiale)");
        spectacole.add("Oscar și Tanti Roz (E.E. Schmitt)");
        spectacole.add("Hamlet (W. Shakespeare)");
        spectacole.add("Iona (M. Sorescu)");
        
         buton.add(buton1 = new JButton(spectacole.get(0)));
         buton.add(buton2 = new JButton(spectacole.get(1)));
         buton.add(buton3 = new JButton(spectacole.get(2)));
         buton.add(buton4 = new JButton(spectacole.get(3)));
         buton.add(buton5 = new JButton(spectacole.get(4)));

        p1=new JPanel();
        p1.add(lmesaj);
        p1.add(buton1);
        buton1.addActionListener(ab);
        p1.add(buton2);
        buton2.addActionListener(ab);
        p1.add(buton3);
        buton3.addActionListener(ab);
        p1.add(buton4);
        buton4.addActionListener(ab);
        p1.add(buton5);
        buton5.addActionListener(ab);
        
        p1.setLayout(new GridLayout(6, 1));
        getContentPane().add(p1, BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
 
     class  AscultatorButon implements ActionListener{
        public void actionPerformed(ActionEvent ev){
          if (ev.getSource()==buton1){
            dispose();
	     new ReprezentatieS1(spectacole.get(0));
        }
          else
              if (ev.getSource()==buton2){
            dispose();
	     new ReprezentatieS2(spectacole.get(1));
        }
          else
              if (ev.getSource()==buton3){
            dispose();
	     new ReprezentatieS3(spectacole.get(2));
        }
          else
              if (ev.getSource()==buton4){
            dispose();
	     new ReprezentatieS4(spectacole.get(3));
        }
          else
              if (ev.getSource()==buton5){
            dispose();
	     new ReprezentatieS5(spectacole.get(4));
        }
              
    }
   }
 }

  