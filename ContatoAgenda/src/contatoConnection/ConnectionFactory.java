package contatoConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ConnectionFactory {
	
	
	
		 private final static String url ="jdbc:sqlserver://localhost:1433;databaseName=DBPROG2";
		 private final static String userName = "SENAC2";
		 private final static String password = "senac123"; 
		 public static Connection getConnection() {
			 try {
			 return DriverManager.getConnection(url, userName, password);
			 } catch (SQLException e) {
			 JOptionPane.showMessageDialog(null, "Erro ao conectar o Banco de Dados!\n"+ e.getMessage());
			 }
			 return null;

		 }
		 
		 
		 
		 public static void closeConnection(Connection con) {
			 if (con!=null) {
			 try {
			 con.close();
			 } catch (SQLException e) {
			 JOptionPane.showMessageDialog(null,  "Erro ao finalizar a conex�o com o Banco de Dados!\n"+ e.getMessage()); }
		 }
	 }

		public static void closeConnection(Connection con, PreparedStatement stmt) {
			closeConnection(con);
				if(stmt != null) {
					try {
						stmt.close();
					} catch (SQLException e) {
						JOptionPane.showMessageDialog(null,  "Erro ao finalizar a conex�o com o Banco de Dados!\n"+ e.getMessage()); 
					}
				}
		}


		public static void closeConnection(Connection con, PreparedStatement stmt, ResultSet rs) {
			closeConnection(con, stmt);
				if (rs != null) {
					try {
						rs.close();
					} catch (SQLException e) {
						JOptionPane.showMessageDialog(null,  "Erro ao finalizar a conex�o com o Banco de Dados!\n"+ e.getMessage());
					}
				}
			
		}
}

