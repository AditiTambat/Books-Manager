import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.*;

public class ReadBookGUI extends JFrame {

    JTable table;
    DefaultTableModel model;

    public ReadBookGUI() {
        setTitle("All Books");
        setSize(600, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        model = new DefaultTableModel();
        table = new JTable(model);

        model.addColumn("Book ID");
        model.addColumn("Book Name");
        model.addColumn("Price");
        model.addColumn("Author");

        retriveData(); // Load data from database
        getContentPane().setLayout(null);

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(0, 0, 586, 402);
        getContentPane().add(scrollPane);

        setVisible(true);
    }

    private void retriveData() {
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/practice", "root", "root");
            String sql = "SELECT * FROM books";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                int id = rs.getInt("BId");
                String name = rs.getString("BName");
                float price = rs.getFloat("BPrice");
                String author = rs.getString("BAuthor");

                model.addRow(new Object[]{id, name, price, author});
            }

            con.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error fetching data: " + ex.getMessage());
        }
    }
}
