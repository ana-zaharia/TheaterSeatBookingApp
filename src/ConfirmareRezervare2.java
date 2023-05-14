import java.io.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

class ConfirmareRezervare2 extends JFrame{
    JPanel p0, p1, p2;
    JLabel l_info, l_nume, l_telefon, l_plata, l_achitat;
    JTextField tf_nume, tf_telefon, tf_plata, tf_cost;
    JButton bOk;
    
    ConfirmareRezervare2(String title){
        super(title);
        AscultatorButon ab=new AscultatorButon();
        p0= new JPanel();
        l_info=new JLabel("Pentru confirmarea rezervării, vă rugăm să completați cu datele dvs. personale: ");
        p0.add(l_info);
        getContentPane().add(p0, BorderLayout.NORTH);
        p1= new JPanel();
        l_nume=new JLabel("Nume și prenume: ");
        l_telefon=new JLabel("Nr. telefon: ");
        l_plata=new JLabel("Total de plata: ");
        l_achitat=new JLabel("Introduceti suma: ");
        tf_nume=new JTextField();
        tf_telefon=new JTextField();
        tf_plata=new JTextField();
        tf_cost = new JTextField();
        tf_cost.setEditable(false);
        p1.add(l_nume);  p1.add(tf_nume);  
        p1.add(l_telefon); p1.add(tf_telefon);
        p1.add(l_plata); 
        p1.add(tf_cost);
        p1.add(l_achitat);
        p1.add(tf_plata);
        
        p1.setLayout(new GridLayout(5, 2));
        getContentPane().add(p1, BorderLayout.CENTER);
        
        p2=new JPanel();
        bOk=new JButton("Confirmare");
        bOk.addActionListener(ab);
       
        p2.add(bOk);
        getContentPane().add(p2, BorderLayout.SOUTH);
        
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       
               try{
                    BufferedReader in=new BufferedReader(new FileReader("cost2.txt"));
                    String linie ;
                    while ((linie=in.readLine())!=null){
                        double suma = Double.parseDouble(linie);
                        tf_cost.setText(" "+suma);
                    }
                    in.close();
                    
                }catch(IOException e) {
                    System.err.println(e.getMessage());
                }
    }
    
        class AscultatorButon implements ActionListener{ 
        public void actionPerformed(ActionEvent ev){
           
          if (ev.getSource()==bOk) {
           if(!tf_nume.getText().equals("")) {
           try{
                BufferedWriter out=new BufferedWriter(new FileWriter("rezervare2.txt",true));
                out.write(tf_nume.getText()+"\r\n");
                out.flush();
                out.close();

                }catch(IOException e) {
                    System.err.println(e.getMessage());
                }
                }
            if(!tf_telefon.getText().equals("")) {
               try{
                BufferedWriter out=new BufferedWriter(new FileWriter("rezervare2.txt",true));
                out.write(tf_telefon.getText()+"\r\n");
                out.flush();
                out.close();
                }catch(IOException e) {
                    System.err.println(e.getMessage());
                }
          }
          
           if(!tf_plata.getText().equals("") ) {
                   double suma_introdusa = Double.parseDouble(tf_plata.getText());
                   double suma_afisata = Double.parseDouble(tf_cost.getText());
                   
                   if(suma_introdusa>= suma_afisata) {
                       double rest = suma_introdusa-suma_afisata;
                       try{
                BufferedWriter out=new BufferedWriter(new FileWriter("rest2.txt",true));
                out.write(rest+"\r\n");
                out.flush();
                out.close();
                }catch(IOException e) {
                    System.err.println(e.getMessage()); }
                       
                   dispose();
                   new Bilet2("Bilet");
                   }
                   else {
                     JOptionPane.showMessageDialog(ConfirmareRezervare2.this,
                     "Suma introdusa este prea mica. Va rugam sa introduceti suma corecta.", "Atentionare",
                      JOptionPane.WARNING_MESSAGE);
                        }
            }
           
    }
  }
 }
}



