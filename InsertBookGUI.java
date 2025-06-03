import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class InsertBookGUI extends JFrame {

    JTextField idField, nameField, priceField, authorField;
    JButton insertButton;

    public InsertBookGUI() {
        setTitle("Insert New Book");
        setSize(713, 447);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE); 
        getContentPane().setLayout(null);

        // Labels and fields
        JLabel lblEnterTheBook = new JLabel("  Enter the Book ID:");
        lblEnterTheBook.setFont(new Font("Arial", Font.BOLD, 16));
        lblEnterTheBook.setBounds(147, 63, 174, 33);
        getContentPane().add(lblEnterTheBook);
        idField = new JTextField();
        idField.setFont(new Font("Arial", Font.PLAIN, 16));
        idField.setBounds(345, 60, 255, 43);
        getContentPane().add(idField);

        JLabel lblEnterTheBook_1 = new JLabel("  Enter the Book Name:");
        lblEnterTheBook_1.setFont(new Font("Arial", Font.BOLD, 16));
        lblEnterTheBook_1.setBounds(125, 131, 185, 33);
        getContentPane().add(lblEnterTheBook_1);
        nameField = new JTextField();
        nameField.setFont(new Font("Arial", Font.PLAIN, 16));
        nameField.setBounds(345, 128, 255, 43);
        getContentPane().add(nameField);

        JLabel label_2 = new JLabel("Enter the Book Price:");
        label_2.setFont(new Font("Arial", Font.BOLD, 16));
        label_2.setBounds(136, 202, 185, 33);
        getContentPane().add(label_2);
        priceField = new JTextField();
        priceField.setFont(new Font("Arial", Font.PLAIN, 16));
        priceField.setBounds(345, 199, 255, 43);
        getContentPane().add(priceField);

        JLabel lblEnterTheBook_2 = new JLabel(" Enter the Book Author:");
        lblEnterTheBook_2.setFont(new Font("Arial", Font.BOLD, 16));
        lblEnterTheBook_2.setBounds(125, 268, 185, 38);
        getContentPane().add(lblEnterTheBook_2);
        authorField = new JTextField();
        authorField.setFont(new Font("Arial", Font.PLAIN, 16));
        authorField.setBounds(345, 268, 258, 43);
        getContentPane().add(authorField);

        insertButton = new JButton("Insert Book");
        insertButton.setForeground(new Color(0, 0, 0));
        insertButton.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 19));
        insertButton.setBounds(269, 336, 146, 50);
        getContentPane().add(insertButton);

        JLabel label_4 = new JLabel();
        label_4.setBounds(354, 336, 344, 74);
        getContentPane().add(label_4);

        insertButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                insertBook();
            }
        });

        setVisible(true);
    }

    private void insertBook() {
        try {
            int id = Integer.parseInt(idField.getText());
            String name = nameField.getText();
            float price = Float.parseFloat(priceField.getText());
            String author = authorField.getText();

            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/practice", "root", "root");
            String sql = "INSERT INTO books VALUES (?, ?, ?, ?)";
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, id);
            pstmt.setString(2, name);
            pstmt.setFloat(3, price);
            pstmt.setString(4, author);
            int result = pstmt.executeUpdate();

            if (result > 0) {
                JOptionPane.showMessageDialog(this, "Book inserted successfully!");
                idField.setText("");
                nameField.setText("");
                priceField.setText("");
                authorField.setText("");
            } else {
                JOptionPane.showMessageDialog(this, "Insertion failed!");
            }

            con.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
        }
    }
}
