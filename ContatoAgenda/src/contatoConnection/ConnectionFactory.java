package contatoConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ConnectionFactory {
	
	
	
		 private final static String url ="jdbc:sqlserver://192.100.100.59:1433;databaseName=treinamento_java";
		 private final static String userName = "sysmestra";
		 private final static String password = "mestrasys"; 
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
			 JOptionPane.showMessageDialog(null,  "Erro ao finalizar a conexão com o Banco de Dados!\n"+ e.getMessage()); }
		 }
	 }

		public static void closeConnection(Connection con, PreparedStatement stmt) {
			closeConnection(con);
				if(stmt != null) {
					try {
						stmt.close();
					} catch (SQLException e) {
						JOptionPane.showMessageDialog(null,  "Erro ao finalizar a conexão com o Banco de Dados!\n"+ e.getMessage()); 
					}
				}
		}


		public static void closeConnection(Connection con, PreparedStatement stmt, ResultSet rs) {
			closeConnection(con, stmt);
				if (rs != null) {
					try {
						rs.close();
					} catch (SQLException e) {
						JOptionPane.showMessageDialog(null,  "Erro ao finalizar a conexão com o Banco de Dados!\n"+ e.getMessage());
					}
				}
			
		}
}

