//package contatoView;
//
//import java.sql.Connection;
//import java.sql.SQLException;
//import java.util.List;
//
//import contatoConnection.ConnectionFactory;
//import contatoDao.ContatoDao;
//import contatoModel.Contato;
//
//public class TestaLista {
//	
//private  ContatoDao dao;
//private static Connection con;
//	
//	public TestaLista(ContatoDao dao) {
//		
//		
//		this.dao = dao;
//	
//	}
//	
//	
//	public static void main(String[] args) {
//		
//		try {
//			
//			con = ConnectionFactory.getConnection();
//			List<Contato> contatos =  dao.listarContatos();
//			
//			System.out.println(contatos);
//			
//			for (Contato contato : contatos) {
//				System.out.println("-----------------------");
//				System.out.println("Nome: "+contato.getNome());
//				System.out.println("E-mail: "+contato.getEmail());
//				System.out.println("Endereço: "+contato.getEndereco());
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//	}
//}