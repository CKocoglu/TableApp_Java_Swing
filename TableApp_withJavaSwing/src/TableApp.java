import java.awt.*;
import java.awt.event.*;

import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

import javax.swing.table.*;


public class TableApp {

	private JFrame frame;
	private JScrollPane pane;
	private JTable jTable1;
	private JTableHeader header;
	
	private JButton btnAdd;
    private JButton btnDelete;
    private JButton btnUpdate;
    
    private JTextField txtId;
    private JTextField txtName;
    private JTextField txtState;
    private JTextField txtCountry;
		
    private DefaultTableModel model;
    private JTextField txtMath;
    private JTextField txtMarks;
    private JTextField txtGrade;
    
    private JPanel panel;
    
    private List<String[]> lst;
	

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TableApp window = new TableApp();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public TableApp() 
	{
		    frame = new JFrame("Creating a Scrollable JTable!");

		    txtId = new JTextField();
			txtId.setBounds(135, 33, 182, 20);
			txtId.setColumns(10);
			frame.getContentPane().add(txtId);
			
			
			JLabel lblId = new JLabel("Id:");
			lblId.setBounds(56, 36, 46, 14);
			frame.getContentPane().add(lblId);
			
			txtName = new JTextField();
			txtName.setBounds(135, 64, 182, 20);
			txtName.setColumns(10);
			frame.getContentPane().add(txtName);
			
			JLabel lblFirstName = new JLabel("Name:");
			lblFirstName.setBounds(56, 67, 69, 14);
			frame.getContentPane().add(lblFirstName);
			
			txtState = new JTextField();
			txtState.setBounds(135, 95, 182, 20);
			txtState.setColumns(10);
			frame.getContentPane().add(txtState);
			
			JLabel lblLastName = new JLabel("State:");
			lblLastName.setBounds(56, 98, 69, 14);
			frame.getContentPane().add(lblLastName);
			
			txtCountry = new JTextField();
			txtCountry.setBounds(135, 126, 182, 20);
			txtCountry.setColumns(10);
			frame.getContentPane().add(txtCountry);
			
			
			JLabel lblAddress = new JLabel("Country:");
			lblAddress.setBounds(56, 129, 69, 14);
			frame.getContentPane().add(lblAddress);
			
			btnAdd = new JButton("Add");
			btnAdd.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
					if(!txtId.getText().matches("([0-9]*){1,20}"))
					{
						JOptionPane.showMessageDialog(frame, "Id value must be numeric!");
					}
					else if(!txtMath.getText().matches("([0-9]*){1,20}"))
					{
						JOptionPane.showMessageDialog(frame, "Math value must be numeric!");
					}
					else
					{
					    if(!txtId.getText().equals("") && 
					    		!txtName.getText().equals("") && 
					    		!txtState.getText().equals("") && 
					    		!txtCountry.getText().equals("") &&
					    		!txtMath.getText().equals("") && 
					    		!txtMarks.getText().equals("") && 
					    		!txtGrade.getText().equals(""))
					    {   
					    	model.addRow(new Object[]{txtId.getText(), txtName.getText(),txtState.getText(),txtCountry.getText(), txtMath.getText(),txtMarks.getText(),txtGrade.getText()});
					        JOptionPane.showMessageDialog(frame, "Successfully added!");
					        
					          txtId.setText("");
					          txtName.setText("");
					          txtState.setText("");
					          txtCountry.setText("");
					          txtMath.setText("");
					          txtMarks.setText("");
					          txtGrade.setText("");
					    }
					    else
					    {
					    	JOptionPane.showMessageDialog(frame, "All texts must be filled!");
					    }
					}
				}
			 });
			
			 btnAdd.setBackground(Color.GREEN);
			 btnAdd.setBounds(327, 33, 130, 31);
			 frame.getContentPane().add(btnAdd);
			
			 btnDelete = new JButton("Delete selected");
			 btnDelete.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
					int selectedRow = jTable1.getSelectedRow();
					
					int answer = JOptionPane.showConfirmDialog(frame, "Are you sure you want to delete this instance?", "An Inane Question", JOptionPane.YES_NO_OPTION);
					
					if(selectedRow>=0 && answer == 0)
					{
					      model.removeRow(selectedRow);
					      txtId.setText("");
				          txtName.setText("");
				          txtState.setText("");
				          txtCountry.setText("");
				          txtMath.setText("");
				          txtMarks.setText("");
				          txtGrade.setText("");
					}
				}
			 });
			
			 btnDelete.setBackground(Color.ORANGE);
			 btnDelete.setBounds(327, 74, 130, 31);
			 frame.getContentPane().add(btnDelete);
			
			 btnUpdate = new JButton("Update");
			 btnUpdate.addActionListener(new ActionListener() {
		    	public void actionPerformed(ActionEvent e) {
		    		
		    		int update_row = jTable1.getSelectedRow();
		    		if(update_row != -1)
		    		{
		    		    model.setValueAt(txtId.getText(), update_row, 0);
		    		    model.setValueAt(txtName.getText(), update_row, 1);
		    		    model.setValueAt(txtState.getText(), update_row, 2);
		    		    model.setValueAt(txtCountry.getText(), update_row, 3);
		    		    model.setValueAt(txtMath.getText(), update_row, 4);
		    		    model.setValueAt(txtMarks.getText(), update_row, 5);
		    		    model.setValueAt(txtGrade.getText(), update_row, 6);
		    		    update_row = -1;
		    		}
		    	}
		      });
			
			  btnUpdate.setBounds(327, 115, 130, 31);
			  frame.getContentPane().add(btnUpdate);
		   
		   
			  JLabel label = new JLabel("Math:");
			  label.setBounds(56, 160, 69, 14);
			  frame.getContentPane().add(label);
			  
			  txtMath = new JTextField();
			  txtMath.setColumns(10);
			  txtMath.setBounds(135, 157, 182, 20);
			  frame.getContentPane().add(txtMath);
			  
			  JLabel label_1 = new JLabel("Marks:");
			  label_1.setBounds(56, 191, 69, 14);
			  frame.getContentPane().add(label_1);
			  
			  txtMarks = new JTextField();
			  txtMarks.setColumns(10);
			  txtMarks.setBounds(135, 188, 182, 20);
			  frame.getContentPane().add(txtMarks);
			  
			  JLabel label_2 = new JLabel("Garde:");
			  label_2.setBounds(56, 222, 69, 14);
			  frame.getContentPane().add(label_2);
			  
			  txtGrade = new JTextField();
			  txtGrade.setColumns(10);
			  txtGrade.setBounds(135, 219, 182, 20);
			  frame.getContentPane().add(txtGrade);
		   
		   
		   
		   panel = new JPanel();
		   lst = new ArrayList<String[]>();
		  
		   lst.add(new String[]{"1","vinod","Bihar","India","Biology","65","First"});
		   lst.add(new String[]{"2","Raju","ABC","Kanada","Geography","58","second"});
		   lst.add(new String[]{"3","Aman","Delhi","India","computer","98","Dictontion"});
		   lst.add(new String[]{"4","Ranjan","Bangloor","India","chemestry","90","Dictontion"});
		   lst.add(new String[]{"5","vinod","Bihar","India","Biology","65","First"});
		   lst.add(new String[]{"6","Raju","ABC","Kanada","Geography","58","second"});
		   lst.add(new String[]{"7","Aman","Delhi","India","computer","98","Dictontion"});
		   lst.add(new String[]{"8","Ranjan","Bangloor","India","chemestry","90","Dictontion"});
		   lst.add(new String[]{"9","vinod","Bihar","India","Biology","65","First"});
		   lst.add(new String[]{"10","Raju","ABC","Kanada","Geography","58","second"});
		   lst.add(new String[]{"11","Aman","Delhi","India","computer","98","Dictontion"});
		   lst.add(new String[]{"12","Ranjan","Bangloor","India","chemestry","90","Dictontion"});
		   lst.add(new String[]{"13","vinod","Bihar","India","Biology","65","First"});
		   lst.add(new String[]{"14","Raju","ABC","Kanada","Geography","58","second"});
		   lst.add(new String[]{"15","Aman","Delhi","India","computer","98","Dictontion"});
		   lst.add(new String[]{"16","Ranjan","Bangloor","India","chemestry","90","Dictontion"});
		   lst.add(new String[]{"17","vinod","Bihar","India","Biology","65","First"});
		   lst.add(new String[]{"18","Raju","ABC","Kanada","Geography","58","second"});
		   lst.add(new String[]{"19","Aman","Delhi","India","computer","98","Dictontion"});
		   lst.add(new String[]{"20","Ranjan","Bangloor","India","chemestry","90","Dictontion"});
		   lst.add(new String[]{"21","vinod","Bihar","India","Biology","65","First"});
		   lst.add(new String[]{"22","Raju","ABC","Kanada","Geography","58","second"});
		   lst.add(new String[]{"23","Aman","Delhi","India","computer","98","Dictontion"});
		   lst.add(new String[]{"24","Ranjan","Bangloor","India","chemestry","90","Dictontion"});
		   lst.add(new String[]{"25","vinod","Bihar","India","Biology","65","First"});
		   lst.add(new String[]{"26","Raju","ABC","Kanada","Geography","58","second"});
		   lst.add(new String[]{"27","Aman","Delhi","India","computer","98","Dictontion"});
		   lst.add(new String[]{"28","Ranjan","Bangloor","India","chemestry","90","Dictontion"});
		   lst.add(new String[]{"29","vinod","Bihar","India","Biology","65","First"});
		   lst.add(new String[]{"30","Raju","ABC","Kanada","Geography","58","second"});
		   lst.add(new String[]{"31","Aman","Delhi","India","computer","98","Dictontion"});
		   lst.add(new String[]{"32","Ranjan","Bangloor","India","chemestry","90","Dictontion"});
		   String col[] = {"Id","Name","State","Country","Math","Marks","Grade"};
		  
            model = new DefaultTableModel(col, 0);
	        for (String[] row : lst) {
	            model.addRow(row);
	        }
		  
		  
		  jTable1 = new JTable();
		  jTable1.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent evt) 
				{
					int update_row = jTable1.rowAtPoint( evt.getPoint() );
		          
		          txtId.setText(model.getValueAt(update_row, 0).toString());
		          txtName.setText(model.getValueAt(update_row, 1).toString());
		          txtState.setText(model.getValueAt(update_row, 2).toString());
		          txtCountry.setText(model.getValueAt(update_row, 3).toString());
		          txtMath.setText(model.getValueAt(update_row, 4).toString());
		          txtMarks.setText(model.getValueAt(update_row, 5).toString());
		          txtGrade.setText(model.getValueAt(update_row, 6).toString());
		          
				}
			});
		  
		  
		   jTable1.addKeyListener(new KeyListener() {
	            @Override
	            public void keyPressed(KeyEvent e) 
	            {
	            	
	            	int keyboard_row = jTable1.getSelectedRow();
	            	
	                if (e.getKeyCode() == 38)
	                {
	                     if(keyboard_row > 0)
	                     {
	                    	keyboard_row--;
	                    	 
	     		          txtId.setText(model.getValueAt(keyboard_row, 0).toString());
	     		          txtName.setText(model.getValueAt(keyboard_row, 1).toString());
	     		          txtState.setText(model.getValueAt(keyboard_row, 2).toString());
	     		          txtCountry.setText(model.getValueAt(keyboard_row, 3).toString());
	     		          txtMath.setText(model.getValueAt(keyboard_row, 4).toString());
	     		          txtMarks.setText(model.getValueAt(keyboard_row, 5).toString());
	     		          txtGrade.setText(model.getValueAt(keyboard_row, 6).toString());
	                     }
	                }
	                else if (e.getKeyCode() == 40)
	                {
	                	if(keyboard_row < model.getRowCount())
	                     {
	                    	keyboard_row++;
	                    	 
	     		          txtId.setText(model.getValueAt(keyboard_row, 0).toString());
	     		          txtName.setText(model.getValueAt(keyboard_row, 1).toString());
	     		          txtState.setText(model.getValueAt(keyboard_row, 2).toString());
	     		          txtCountry.setText(model.getValueAt(keyboard_row, 3).toString());
	     		          txtMath.setText(model.getValueAt(keyboard_row, 4).toString());
	     		          txtMarks.setText(model.getValueAt(keyboard_row, 5).toString());
	     		          txtGrade.setText(model.getValueAt(keyboard_row, 6).toString());
	                    	 
	                     }
	                }
	            }

				@Override
				public void keyTyped(KeyEvent e) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void keyReleased(KeyEvent e) {
					// TODO Auto-generated method stub
					
				}

		   });
		   
	      jTable1.setModel(model);
		  
		  header = jTable1.getTableHeader();
		  header.setBackground(Color.yellow);
		  panel.setLayout(null);
		  
		  pane = new JScrollPane(jTable1);
		  pane.setBounds(24, 271, 452, 444);
		  jTable1.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		  
		  panel.add(pane);
		  frame.getContentPane().add(panel);
		  
		  
		  frame.setSize(500,750);
		  frame.setUndecorated(true);
		  frame.getRootPane().setWindowDecorationStyle(JRootPane.PLAIN_DIALOG);
		  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		  frame.setVisible(true);
	}
}
