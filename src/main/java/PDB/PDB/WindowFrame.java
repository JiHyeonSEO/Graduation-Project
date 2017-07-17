package PDB.PDB;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import org.biojava.nbio.structure.Structure;
import org.biojava.nbio.structure.StructureIO;
import org.biojava.nbio.structure.align.gui.MenuCreator;
import org.biojava.nbio.structure.align.gui.jmol.JmolPanel;
import org.biojava.nbio.structure.align.model.AFPChain;
import org.biojava.nbio.structure.align.webstart.AligUIManager;

public class WindowFrame {
   
   private JmolPanel jmolPanel;
   private JFrame frame;
   private int index = 0;
   static ReadXMLFile readXMLfile;
   static PostBLASTQuery postblastquery;
   

   public static void main(String[] args) {
      // TODO Auto-generated method stub
      try
      {
    	 postblastquery = new PostBLASTQuery(WindowBuilder.getSequence());
    	 readXMLfile = new ReadXMLFile();
    	 System.out.println("\n"+readXMLfile.getPDBID());
         String molName = readXMLfile.getPDBID();
         System.out.println("Type the name of molecular structure. (ex: 4HHB, 4EAR, 5UN5...)");
         //Scanner sc = new Scanner(System.in);
         //molName = sc.next();   
         WindowFrame wf = new WindowFrame(molName);
         
      }
      catch(Exception e)
      {
         e.printStackTrace();
      }
   }
   
   public WindowFrame(String molName)
   {
      try
      {                           
         Structure struc = StructureIO.getStructure(molName);
         jmolPanel = new JmolPanel();      
         jmolPanel.setStructure(struc);
         jmolPanel.setPreferredSize(new Dimension(500,500));
         molBox.add(jmolPanel);   
         
         //molNameLabel
         
         JLabel molNameLabel = new JLabel("Mol Name: ");
         molNameLabel.setFont(font);
         molNameLabel.setPreferredSize(new Dimension(250,50));
         
         //molNameBox.add(Box.createGlue());
         molNameBox.setMaximumSize(new Dimension(Short.MAX_VALUE, 50));
         molNameBox.add(molNameLabel);
         molBox.add(molNameBox);
         
         //molNameText
         final JTextField molNameText = new JTextField();
         molNameText.setBackground(Color.WHITE);
         molNameText.setText(molName);
         molNameText.setFont(font);
         molNameText.setPreferredSize(new Dimension(250, 50));
         molBox.add(molNameText);
         
         //molNameButton
         JButton molChange = new JButton("Search");
         molChange.setPreferredSize(new Dimension(100,40));
         molChange.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               
               String newMolName;
               molNameText.setText("");
               
               JOptionPane.showMessageDialog(null, "Confirm");
               
               
            }
         });
         molBox.add(molChange);

         //container
         
         container.add(molBox);
      
         frame.pack();
         frame.setVisible(true);
      }
      catch(Exception e)
      {
         e.printStackTrace();
      }
      
   }
   
   
}