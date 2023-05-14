import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.*;
public class Bilet2 extends JFrame {
    JTextArea ta=new JTextArea(20, 15);
    JTextArea info=new JTextArea(20, 20);
    
    
    JPanel p1, p2, p3;
    JButton bOk, bPrint;
    
    Bilet2(String title){
        super(title);
        AscultatorButon ab=new AscultatorButon();
        ta.setLineWrap(true);
        ta.setWrapStyleWord(true);
        ta.setEditable(false);
        p1=new JPanel();
        p1.add(ta);
        getContentPane().add(p1, BorderLayout.CENTER);
        
         try{
                    BufferedReader in=new BufferedReader(new FileReader("Bilet.txt"));
                    String linie ;
                  while ((linie=in.readLine())!=null){
                       ta.append(linie+"\r\n");
                    }
                    in.close();
                    
                }catch(IOException e) {
                    System.err.println(e.getMessage());
                }
        
        p2=new JPanel();
        info.setLineWrap(true);
        info.setWrapStyleWord(true);
        info.setEditable(false);
        p2.add(info);
        getContentPane().add(p2, BorderLayout.EAST);
         try{
                    BufferedReader in=new BufferedReader(new FileReader("spec2.txt"));
                    String linie ;
                  while ((linie=in.readLine())!=null){
                       info.append(linie+"\r\n");
                    }
                    in.close();
                    
                }catch(IOException e) {
                    System.err.println(e.getMessage());
                }
        
        p3=new JPanel();
        bOk=new JButton("Ok");
        bPrint=new JButton("Print");
        p3.add(bOk);
        bOk.addActionListener(ab);
        p3.add(bPrint);
        getContentPane().add(p3, BorderLayout.SOUTH);
        
        
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }
    class AscultatorButon implements ActionListener{
        public void actionPerformed(ActionEvent ev){
            if (ev.getSource()==bOk){
                dispose();
                new Final2(" ");
            }
        }
        }
}
