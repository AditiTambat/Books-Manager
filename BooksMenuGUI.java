
import javax.swing.*;
import java.awt.event.*;
import java.awt.Font;


public class BooksMenuGUI extends JFrame {
    public BooksMenuGUI() {
        setTitle("Books Management System");
        setSize(527, 423);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        JButton insertBtn = new JButton("1. Insert New Record");
        insertBtn.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 16));
        insertBtn.setBounds(135, 52, 244, 48);
        getContentPane().add(insertBtn);

        JButton readBtn = new JButton("2. Read All Records");
        readBtn.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 16));
        readBtn.setBounds(149, 147, 233, 48);
        getContentPane().add(readBtn);
        
        readBtn.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 16));
        readBtn.setBounds(135, 119, 244, 48);
        getContentPane().add(readBtn);

        JButton updateBtn = new JButton("3. Update Record");
        updateBtn.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 16));
        updateBtn.setBounds(135, 177, 244, 47);
        getContentPane().add(updateBtn);

        JButton deleteBtn = new JButton("4. Delete Record");
        deleteBtn.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 16));
        deleteBtn.setBounds(135, 238, 244, 48);
        getContentPane().add(deleteBtn);

        JButton exitBtn = new JButton("5. Exit");
        exitBtn.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 16));
        exitBtn.setBounds(170, 321, 177, 40);
        getContentPane().add(exitBtn);

        // Actions
        insertBtn.addActionListener(e -> new InsertBookGUI());
        readBtn.addActionListener(e -> new ReadBookGUI());
        updateBtn.addActionListener(e -> new UpdateBookGUI());
        deleteBtn.addActionListener(e -> new DeleteBookGUI());
        exitBtn.addActionListener(e -> System.exit(0));

        setVisible(true);
    }

    public static void main(String[] args) {
        new BooksMenuGUI();
    }
}
