import java.awt.*;
import javax.swing.*;
import java.io.*;
import java.util.*;
import java.awt.event.*;
class ReprezentatieS2 extends JFrame{
    double pret_spec= 78.9;
    double cost;
    JLabel lDen, lSpec, lOrar, lData, lOra, lPret, lDen1, lOrar1, locuri_libere, loc_lib, pretn, pret;
    JCheckBox buton1, buton2, buton3, buton4;
    JCheckBox loc1, loc2, loc3, loc4, loc5, loc6, loc7, loc8;
    JPanel p1, p2, p3, p4, panel;
    JButton bOk, bSuma;
    ButtonGroup group;
    JTextField tf_text, tf_suma;
    ArrayList<JCheckBox> buton = new ArrayList<>();
    ArrayList<String> reprezentatie = new ArrayList<>();
    ArrayList<JCheckBox> loc = new ArrayList<>();
    ArrayList<String> locuri = new ArrayList<>();
    
    
    ReprezentatieS2(String title){
        super(title);
        AscultatorButon ab = new AscultatorButon();
        lDen=new JLabel("Denumire spectacol: ");
        lDen1=new JLabel("D-ale carnavalului (I.L. Caragiale)");

        lOrar=new JLabel("Orar reprezentatii");
        lOrar1=new JLabel("Selectati data favorita:");
        lData=new JLabel("      Data               Ora");
        
        reprezentatie.add("20.02.2021   11:45");
        reprezentatie.add("20.02.2021   19:30");
        reprezentatie.add("22.02.2021   08:30");
        reprezentatie.add("22.02.2021   12:25");
        
        buton.add(buton1 = new JCheckBox(reprezentatie.get(0), false));
        buton.add(buton2 = new JCheckBox(reprezentatie.get(1), false));
        buton.add(buton3 = new JCheckBox(reprezentatie.get(2), false));
        buton.add(buton4 = new JCheckBox(reprezentatie.get(3), false));
        
          locuri.add("Loc 1A"); 
          locuri.add("Loc 2B");
          locuri.add("Loc 3C");
          locuri.add("Loc 4C");
          locuri.add("Loc 5A");
          locuri.add("Loc 6B");
          locuri.add("Loc 7D");
          locuri.add("Loc 8D");
          
          loc.add(loc1=new JCheckBox(locuri.get(0), false));
          loc.add(loc2=new JCheckBox(locuri.get(1), false));
          loc.add(loc3=new JCheckBox(locuri.get(2), false));
          loc.add(loc4=new JCheckBox(locuri.get(3), false));
          loc.add(loc5=new JCheckBox(locuri.get(4), false));
          loc.add(loc6=new JCheckBox(locuri.get(5), false));
          loc.add(loc7=new JCheckBox(locuri.get(6), false));
          loc.add(loc8=new JCheckBox(locuri.get(7), false));
        
        bSuma = new JButton("Calculeaza cost");
        bSuma.addActionListener(ab);
        bOk=new JButton("Confirma");
        bOk.addActionListener(ab);
        p1=new JPanel();
         p1.add(lDen);
         p1.add(lDen1); 
         p1.add(lOrar); 
         p1.add(lOrar1); 
         p1.add(lData);
         p1.add(buton1);
         p1.add(buton2);
         p1.add(buton3);
         p1.add(buton4);
         
         p1.setLayout(new GridLayout(10, 1));
         getContentPane().add(p1, BorderLayout.NORTH);
          
          p2=new JPanel();
          lSpec=new JLabel("Numar rezervari:");
          p2.add(lSpec);
          tf_text=new JTextField();
          p4 = new JPanel( new FlowLayout(0, 0, FlowLayout.LEADING) );
            tf_text.setPreferredSize(new Dimension(50,20));
          p4.add(tf_text);
            p2.add(p4);
            panel=new JPanel();
         locuri_libere=new JLabel("Locuri");
         loc_lib=new JLabel("disponibile");
         panel.add(locuri_libere);
         panel.add(loc_lib);
         p2.add(panel);
         p2.setLayout(new GridLayout(2, 2));

         getContentPane().add(p2, BorderLayout.CENTER);
         
          p3=new JPanel();
          p3.add(loc1);
          p3.add(loc2);
          p3.add(loc3);
          p3.add(loc4);
          p3.add(loc5);
          p3.add(loc6);
          p3.add(loc7); 
          p3.add(loc8);
          pret=new JLabel("Pret /reprezentatie: ");
          pretn=new JLabel("78.9 lei.");
          p3.add(pret);
          p3.add(pretn);
          p3.add(bSuma);
          tf_suma=new JTextField();
          tf_suma.setEditable(false);
          p3.add(tf_suma);
          p3.add(bOk);
          p3.setLayout(new GridLayout(8, 2));
          getContentPane().add(p3, BorderLayout.SOUTH);

        
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
          class AscultatorButon implements ActionListener{
        public void actionPerformed(ActionEvent ev){
            if (ev.getSource()==bOk){
                  try {
                             BufferedWriter out=new BufferedWriter(new FileWriter("spec2.txt", true));
                             out.write("D-ale carnavalului (I.L. Caragiale)\r\n");
                                out.flush();
                                out.close();
                         }catch (IOException e){
                          System.err.println(e.getMessage());}
                 for(int i=0;i<buton.size();i++){
                         if(buton.get(i).isSelected()){
                             try {
                             BufferedWriter out=new BufferedWriter(new FileWriter("spec2.txt", true));
                             out.write(reprezentatie.get(i)+"\r\n");
                                out.flush();
                                out.close();
                         }catch (IOException e){
                          System.err.println(e.getMessage());}
                         }
                     } 
                if (!tf_text.getText().equals("")) {
                    try{
                        BufferedWriter out=new BufferedWriter(new FileWriter("rez2.txt", true));
                         cost = Integer.parseInt(tf_text.getText())*pret_spec;
                        out.write(tf_text.getText()+"\r\n");
                                out.flush();
                                out.close();
                    }catch (IOException e){
                        System.err.println(e.getMessage());}
                }
                     for(int i=0;i<loc.size();i++){
                          if(loc.get(i).isSelected()){
                             try {
                             BufferedWriter out=new BufferedWriter(new FileWriter("spec2.txt", true));
                             out.write(locuri.get(i)+"\r\n");
                                out.flush();
                                out.close();
                         }catch (IOException e){
                          System.err.println(e.getMessage());}
                         }
                     }
                     try{
                        BufferedWriter out=new BufferedWriter(new FileWriter("cost2.txt", true));
                        out.write(cost+"\r\n");
                                out.flush();
                                out.close();
                                
                    }catch (IOException e){
                        System.err.println(e.getMessage());}
                 if(Integer.parseInt(tf_text.getText()) > 1){
                      JOptionPane.showMessageDialog(ReprezentatieS2.this,"Deoarece ati facut mai multe rezervari, se va genera un abonament.","Atentionare",
                  JOptionPane.ERROR_MESSAGE);
                  }
                   dispose();
	           new ConfirmareRezervare2("Confirmare rezervare");
                
                 } 
            if (ev.getSource()==bSuma){
                if (!tf_text.getText().equals("")) {
                     cost = Integer.parseInt(tf_text.getText())*pret_spec;
                }
               tf_suma.setText(" "+cost+" lei");
            
            }          
            }
        }
    }


