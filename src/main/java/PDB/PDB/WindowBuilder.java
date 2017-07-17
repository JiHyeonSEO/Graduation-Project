package PDB.PDB;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import org.biojava.nbio.structure.Structure;
import org.biojava.nbio.structure.StructureIO;
import org.biojava.nbio.structure.align.gui.MenuCreator;
import org.biojava.nbio.structure.align.gui.jmol.JmolPanel;
import org.biojava.nbio.structure.align.model.AFPChain;
import org.biojava.nbio.structure.align.webstart.AligUIManager;


public class WindowBuilder
{
	private JFrame frame;
	private JTextField textField;
	private JmolPanel jmolPanel;
	static ReadXMLFile readXMLfile;
	static PostBLASTQuery postblastquery;
	static String seq;
	
	public static String getSequence()
	{
		return seq;
	}
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				try
				{
					postblastquery = new PostBLASTQuery(seq);
			    	readXMLfile = new ReadXMLFile();
			    	System.out.println("\n"+readXMLfile.getPDBID());
			        //String molName = readXMLfile.getPDBID();
			        System.out.println("Type the name of molecular structure. (ex: 4HHB, 4EAR, 5UN5...)");
			        //Scanner sc = new Scanner(System.in);
			        //molName = sc.next();   
			        //WindowBuilder wf = new WindowBuilder(molName);
			        WindowBuilder window = new WindowBuilder();
					window.frame.setVisible(true);
					
				} catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public WindowBuilder()
	{
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize()
	{
		try
		{
			frame = new JFrame();
			frame.setBounds(100, 100, 500, 500);
			frame.setPreferredSize(new Dimension(800, 700));
			
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			JMenuBar menu = Menu.initMenu(frame);
			frame.setJMenuBar(menu);
			
			Container container = frame.getContentPane();
			Box molBox = Box.createVerticalBox();
			Box molNameBox = Box.createHorizontalBox();
			
			Font font = new Font("Arial", Font.PLAIN, 20);
			
			Structure struc = StructureIO.getStructure(readXMLfile.getPDBID());
			jmolPanel = new JmolPanel();
			jmolPanel.setStructure(struc);
			jmolPanel.setPreferredSize(new Dimension(100, 400));
			molBox.add(jmolPanel);
			
			JLabel molNameLabel = new JLabel("Mol Name: ");
	        molNameLabel.setFont(font);
	        molNameLabel.setPreferredSize(new Dimension(250,50));
			
			molNameBox.setMaximumSize(new Dimension(Short.MAX_VALUE, 50));
	        molNameBox.add(molNameLabel);
	        molBox.add(molNameBox);
	        
	        final JTextField molNameText = new JTextField();
	        molNameText.setBackground(Color.WHITE);
	        molNameText.setText(readXMLfile.getPDBID());
	        molNameText.setFont(font);
	        molNameText.setPreferredSize(new Dimension(250, 50));
	        molBox.add(molNameText);
			
	        
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
	
	        container.add(molBox);
	        
	        frame.pack();
	        frame.setVisible(true);
	        
			JPanel panel = new JPanel();
			frame.getContentPane().add(panel, BorderLayout.NORTH);
			
			textField = new JTextField();
			panel.add(textField);
			textField.setColumns(30);
			seq = textField.getText();
					
			JButton btnNewButton = new JButton("Click");
			panel.add(btnNewButton);
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					//JOptionPane.showMessageDialog(null, textField.getText());
					System.out.println(textField.getText());
				}
			});
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
