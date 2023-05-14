import java.awt.*;
import javax.swing.*;
import java.io.*;
import java.util.*;
import java.awt.event.*;
class ReprezentatieS5 extends JFrame{
    double pret_spec = 101.4;
    double cost;
    JLabel lDen, lSpec, lOrar, lData, lOra, lPret, lDen1, lOrar1,locuri_libere, loc_lib, pret, pretn ;
    JCheckBox buton1, buton2, buton3, buton4;
    JPanel p1, p2, p3, p4, panel;
    JCheckBox loc1, loc2, loc3, loc4, loc5, loc6, loc7, loc8;
    JButton bOk, bSuma;
    ButtonGroup group;
    JTextField tf_text, tf_suma;
    ArrayList<JCheckBox> buton = new ArrayList<>();
    ArrayList<String> reprezentatie = new ArrayList<>();
    ArrayList<JCheckBox> loc = new ArrayList<>();
    ArrayList<String> locuri = new ArrayList<>();
    
   ReprezentatieS5(String title){
        super(title);
        AscultatorButon ab = new AscultatorButon();
        lDen=new JLabel("Denumire spectacol: ");
        lDen1=new JLabel("Iona (M. Sorescu)");

        lOrar=new JLabel("Orar reprezentatii");
        lOrar1=new JLabel("Selectati data favorita:");
        lData=new JLabel("      Data               Ora");
        
        reprezentatie.add("11.05.2021   07:30");
        reprezentatie.add("11.05.2021   14:45");
        reprezentatie.add("12.05.2021   10:30");
        reprezentatie.add("12.05.2021   19:00");
        
        buton.add(buton1 = new JCheckBox(reprezentatie.get(0), false));
        buton.add(buton2 = new JCheckBox(reprezentatie.get(1), false));
        buton.add(buton3 = new JCheckBox(reprezentatie.get(2), false));
        buton.add(buton4 = new JCheckBox(reprezentatie.get(3), false));
        
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
          locuri.add("Loc 1A"); locuri.add("Loc 2B");
          locuri.add("Loc 3C"); locuri.add("Loc 4C");
          locuri.add("Loc 5A"); locuri.add("Loc 6B");
          locuri.add("Loc 7D"); locuri.add("Loc 8D");
          
          loc.add(loc1=new JCheckBox(locuri.get(0)));
          loc.add(loc2=new JCheckBox(locuri.get(1)));
          loc.add(loc3=new JCheckBox(locuri.get(2)));
          loc.add(loc4=new JCheckBox(locuri.get(3)));
          loc.add(loc5=new JCheckBox(locuri.get(4)));
          loc.add(loc6=new JCheckBox(locuri.get(5)));
          loc.add(loc7=new JCheckBox(locuri.get(6)));
          loc.add(loc8=new JCheckBox(locuri.get(7)));
          p3.add(loc1); p3.add(loc2); p3.add(loc3);
          p3.add(loc4); p3.add(loc5); p3.add(loc6);
          p3.add(loc7); p3.add(loc8);
          pret=new JLabel("Pret / reprezentatie: ");
          pretn = new JLabel("101.4 lei.");
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
                             BufferedWriter out=new BufferedWriter(new FileWriter("spec5.txt", true));
                             out.write("Iona (M. Sorescu)\r\n");
                                out.flush();
                                out.close();
                         }catch (IOException e){
                          System.err.println(e.getMessage());}
                 for(int i=0;i<buton.size();i++){
                         if(buton.get(i).isSelected()){
                             try {
                             BufferedWriter out=new BufferedWriter(new FileWriter("spec5.txt", true));
                             out.write(reprezentatie.get(i)+"\r\n");
                                out.flush();
                                out.close();
                         }catch (IOException e){
                          System.err.println(e.getMessage());}
                         }
                     } 
                if (!tf_text.getText().equals("")) {
                    try{
                        BufferedWriter out=new BufferedWriter(new FileWriter("rez5.txt", true));
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
                             BufferedWriter out=new BufferedWriter(new FileWriter("spec5.txt", true));
                             out.write(locuri.get(i)+"\r\n");
                                out.flush();
                                out.close();
                         }catch (IOException e){
                          System.err.println(e.getMessage());}
                         }
                     }
             
                     try{
                        BufferedWriter out=new BufferedWriter(new FileWriter("cost5.txt", true));
                        out.write(cost+"\r\n");
                                out.flush();
                                out.close();
                                
                    }catch (IOException e){
                        System.err.println(e.getMessage());}
                 if(Integer.parseInt(tf_text.getText()) > 1){
                      JOptionPane.showMessageDialog(ReprezentatieS5.this,"Deoarece ati facut mai multe rezervari, se va genera un abonament.","Atentionare",
                  JOptionPane.ERROR_MESSAGE);
                  }
                   dispose();
	           new ConfirmareRezervare5("Confirmare rezervare");
                
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




