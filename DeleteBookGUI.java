import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;

public class DeleteBookGUI extends JFrame {
	 JTextField idField;
	    JButton deleteButton;

	    public DeleteBookGUI() {
	    	setTitle("Delete Book");
	        setSize(559, 352);
	        setLocationRelativeTo(null);
	        setDefaultCloseOperation(DISPOSE_ON_CLOSE); 
	        getContentPane().setLayout(null);

	        // Labels and fields
	        JLabel lblEnterTheBook = new JLabel("  Enter the Book ID:");
	        lblEnterTheBook.setFont(new Font("Arial", Font.BOLD, 16));
	        lblEnterTheBook.setBounds(195, 55, 203, 44);
	        getContentPane().add(lblEnterTheBook);
	        idField = new JTextField();
	        idField.setBounds(88, 109, 386, 44);
	        getContentPane().add(idField);

	        deleteButton = new JButton("Delete Book");
	        deleteButton.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 19));
	        deleteButton.setBounds(156, 186, 242, 52);
	        getContentPane().add(deleteButton);

	        JLabel label_1 = new JLabel();
	        label_1.setBounds(0, 163, 386, 44);
	        getContentPane().add(label_1);

	        deleteButton.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                deleteBook();
	            }
	        });

	        setVisible(true);
	    }

	    
	    private void deleteBook() {
	        try {
	            int id = Integer.parseInt(idField.getText());
	        

	            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/practice", "root", "root");
	            String sql = "delete from books where BId=?";
	            PreparedStatement pstmt = con.prepareStatement(sql);
	            pstmt.setInt(1, id);
	          
	            int result = pstmt.executeUpdate();

	            if (result > 0) {
	                JOptionPane.showMessageDialog(this, "Book deleted successfully!");
	                idField.setText("");
	                
	            } else {
	                JOptionPane.showMessageDialog(this, "Deletion failed!");
	            }

	            con.close();
	        } catch (Exception ex) {
	            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
	        }
	    }
}