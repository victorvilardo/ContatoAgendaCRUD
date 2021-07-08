package contatoConnection;

import java.sql.Connection;

public class TestaConexao {

public static void main(String[] args) {

	Connection con = ConnectionFactory.getConnection();
	
		if(con!=null) {
			System.out.println("Conexao aberta");
			ConnectionFactory.closeConnection(con);
			System.out.println("fechando...");
			
		}
	
	}
	
}
