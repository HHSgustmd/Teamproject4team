package pos;

import java.sql.Connection;
import java.sql.DriverManager; 
import java.sql.ResultSet; 
import java.sql.SQLException; 
import java.sql.Statement; 
import java.util.ArrayList; 

public class menuDAO { 
	private Connection con; 
	private Statement stmt; 
	private ResultSet rs; 
	private static final String DRIVER = "com.mysql.jdbc.Driver"; 
	private static final String URL = "jdbc:mysql://localhost:3306/201710572HHS"; 
	private static final String USER = "root"; 
	private static final String PW = "64503621"; 
	public menuDAO() { 
		try { Class.forName(DRIVER); 
			} catch (ClassNotFoundException e) { 
				e.printStackTrace(); 
			} 
	}
	public void select1() { 
		String sql = "select * from MENU"; 
		try {
			con = DriverManager.getConnection(URL, USER, PW); 
			stmt = con.createStatement(); 
			rs = stmt.executeQuery(sql); 
			
			while (rs.next()) { 
			System.out.print(rs.getInt("barcode") + " "); 
			System.out.print(rs.getString("menuName") + " "); 
			System.out.print(rs.getInt("menuPrice") + " "); 
			System.out.println(rs.getString("menuDesc") + " "); 
			} 
		} catch (SQLException e) { 
			e.printStackTrace(); 
		} finally { close(con, stmt, rs); 
		} 
	} 
	public ArrayList<menuDTO> select2() { 
		ArrayList<menuDTO> list = new ArrayList<menuDTO>(); 
		String sql = "select * from menu"; 
		try { 
			con = DriverManager.getConnection(URL, USER, PW); 
			stmt = con.createStatement(); 
			rs = stmt.executeQuery(sql); 
			while (rs.next()) { 
			menuDTO DTO = new menuDTO(); 
			DTO.setBarcode(rs.getInt("barcode")); 
			DTO.setMenuName(rs.getString("menuName")); 
			DTO.setMenuPrice(rs.getInt("menuPrice")); 
			DTO.setMenuDesc(rs.getString("menuDesc")); 
			list.add(DTO);
			} 
			return list; 
		} catch (SQLException e) {
			e.printStackTrace(); 
		} finally { 
			close(con, stmt, rs); 
		} 
		return null; 
	} 
	
	public void close(Connection con, Statement stmt, ResultSet rs) { 
		
		if (rs != null) { 
			try { 
				rs.close(); 
			} catch (SQLException e) { 
			} 
		}
		if (stmt != null) { 
			try { 
				stmt.close(); 
			} catch (SQLException e) { 
			} 
		} 
		if (con != null) { 
			try { 
				con.close(); 
			} catch (SQLException e) { 
			} 
		} 
	} 
}
	