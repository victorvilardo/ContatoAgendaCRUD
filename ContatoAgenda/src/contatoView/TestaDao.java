package contatoView;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import contatoConnection.ConnectionFactory;


public class TestaDao {
	public static void main(String[] args) {
		try {
			Connection con = ConnectionFactory.getConnection();
			String sql = "insert into contatos (nome,email, endereco) values (?,?,?)";
			PreparedStatement stmt = con.prepareStatement(sql);
			
			stmt.setString(1, "Victor");
			stmt.setString(2, "victor@vilardo.com");
			stmt.setString(3, "Av Brasil, 1000");
			
			stmt.execute();
			stmt.close();
			
			System.out.println("Gravado com sucesso!");
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}