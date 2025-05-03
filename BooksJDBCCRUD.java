import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class BooksJDBCCRUD {
	static Scanner sc;
	

	public static void main(String[] args) {
		sc = new Scanner(System.in);
		Connection con = getConnection();
		int opt;
		do {
			System.out.println("1. Insert a new Record(C)");
			System.out.println("2. Read all records(R)");
			System.out.println("3. Update any record(U)");
			System.out.println("4. Delete any record(D)");
			System.out.println("5.Exit");
			System.out.println("Enter your option : ");
			opt = sc.nextInt();
			switch (opt) {
			case 1:
				insertRecord();
				break;
			case 2:
				readRecord();
				break;
			case 3:
				updateRecord();
				break;
			case 4:
				deleteRecord();
				break;
			case 5:
				break;
			default:
				System.out.println("You entered wrong option");
				break;

			}
		} while (opt != 5);
	}

	private static void deleteRecord() {
		try {
			Connection con = getConnection();
			String qry = "delete from books where id=?";
			PreparedStatement pstmt = con.prepareStatement(qry);

			System.out.println("Enter the bookid to delete ");
			int i = sc.nextInt();
			pstmt.setInt(1, i);
			pstmt.executeUpdate();
			System.out.println("Your record is deleted");
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	private static void updateRecord() {
		try {
			Connection con = getConnection();
			String qry = "update books set name=? , price=? , author=?  where id=?";
			PreparedStatement pstmt = con.prepareStatement(qry);
			
			System.out.println("Enter the id to update ");
			int i = sc.nextInt();
			sc.nextLine();

			System.out.println("Enter the new book name ");
			String n = sc.nextLine();
			
			System.out.println("Enter the new book price ");
			float p = sc.nextFloat(); 
			sc.nextLine();
			
			System.out.println("Enter the new book author ");
			String a = sc.nextLine();
			

			 pstmt.setString(1, n);
		     pstmt.setFloat(2, p);
		     pstmt.setString(3, a);
	         pstmt.setInt(4, i);

			pstmt.executeUpdate();
			System.out.println("Your record is updated");
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	private static void readRecord() {
		try {
			Connection con = getConnection();
			String qry = "select * from books";
			PreparedStatement pstmt = con.prepareStatement(qry);
			ResultSet rs = pstmt.executeQuery();
			ArrayList<Books> booklist = new ArrayList<>();

			while (rs.next()) {
				int i = rs.getInt(1);
				String n = rs.getString(2);
				float p = rs.getFloat(3);
				String a = rs.getString(4);
				Books b1 = new Books(i, n, p, a);
				booklist.add(b1);
			}

			Iterator<Books> i1 = booklist.iterator();
			while (i1.hasNext()) {
				System.out.println(i1.next());
			}
		
		} catch (Exception e) {
			System.out.println(e);
	}
		
}
	

	private static void insertRecord() {
		try {
			Connection con = getConnection();
			String qry = "insert into books values(?,?,?,?)";
			PreparedStatement pstmt = con.prepareStatement(qry);

			System.out.println("Enter the Book Id: ");
 			int i = sc.nextInt();
 			sc.nextLine();
 			System.out.println("Enter the Book Name: ");
			String n = sc.nextLine();
			System.out.println("Enter the Book Price: ");
			float p = sc.nextFloat();
			sc.nextLine();
			System.out.println("Enter the Book Author: ");
			String a = sc.nextLine();

			pstmt.setInt(1, i);
			pstmt.setString(2, n);
			pstmt.setFloat(3, p);
			pstmt.setString(4, a);

			pstmt.executeUpdate();
			System.out.println("Your record is inserted");
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	private static Connection getConnection() {
		Connection con = null;
		try {
			// Step 1 Register the Driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			// Step 2 Create Connection
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/practice?useSSL=false" , "root", "root");
			
		} catch (Exception e) {
			System.out.println(e);
		}
		return con;
	}
}

