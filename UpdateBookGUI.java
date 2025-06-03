import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class UpdateBookGUI extends JFrame {

    JTextField idField, nameField, priceField, authorField;
    JButton updateButton;

    public UpdateBookGUI() {
        setTitle("Update Book");
        setSize(547, 445);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE); 
        getContentPane().setLayout(null);

        // Labels and fields
        JLabel lblEnterBookId = new JLabel(" Enter Book ID:");
        lblEnterBookId.setFont(new Font("Arial", Font.BOLD, 16));
        lblEnterBookId.setBounds(109, 58, 133, 44);
        getContentPane().add(lblEnterBookId);
        idField = new JTextField();
        idField.setBounds(269, 56, 188, 33);
        getContentPane().add(idField);

        JLabel lblEnterTheUpdated_2 = new JLabel("Enter updated Name:");
        lblEnterTheUpdated_2.setFont(new Font("Arial", Font.BOLD, 16));
        lblEnterTheUpdated_2.setBounds(66, 99, 188, 44);
        getContentPane().add(lblEnterTheUpdated_2);
        nameField = new JTextField();
        nameField.setBounds(269, 107, 188, 33);
        getContentPane().add(nameField);

        JLabel lblEnterTheUpdated_1 = new JLabel(" Enter updated Price:");
        lblEnterTheUpdated_1.setFont(new Font("Arial", Font.BOLD, 16));
        lblEnterTheUpdated_1.setBounds(66, 153, 198, 44);
        getContentPane().add(lblEnterTheUpdated_1);
        priceField = new JTextField();
        priceField.setBounds(269, 158, 188, 33);
        getContentPane().add(priceField);

        JLabel lblEnterTheUpdated = new JLabel(" Enter updated Author:");
        lblEnterTheUpdated.setFont(new Font("Arial", Font.BOLD, 16));
        lblEnterTheUpdated.setBounds(55, 216, 236, 33);
        getContentPane().add(lblEnterTheUpdated);
        authorField = new JTextField();
        authorField.setBounds(269, 218, 188, 33);
        getContentPane().add(authorField);

        updateButton = new JButton("Update Book");
        updateButton.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 19));
        updateButton.setBounds(177, 322, 188, 50);
        getContentPane().add(updateButton);

        JLabel label_4 = new JLabel();
        label_4.setBounds(198, 217, 188, 44);
        getContentPane().add(label_4);

        updateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                updateBook();
            }
        });

        setVisible(true);
    }

    private void updateBook() {
        try {
            int id = Integer.parseInt(idField.getText());
            String name = nameField.getText();
            float price = Float.parseFloat(priceField.getText());
            String author = authorField.getText();

            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/practice", "root", "root");
            String sql = "update books set BName=? , BPrice=? , BAuthor=?  where BId=?";
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, name);
            pstmt.setFloat(2, price);
            pstmt.setString(3, author);
            pstmt.setInt(4, id);
            int result = pstmt.executeUpdate();

            if (result > 0) {
                JOptionPane.showMessageDialog(this, "Book updated successfully!");
                idField.setText("");
                nameField.setText("");
                priceField.setText("");
                authorField.setText("");
            } else {
                JOptionPane.showMessageDialog(this, "Updation failed!");
            }

            con.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
        }
    }
}
