package contatoDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import contatoConnection.ConnectionFactory;
import contatoModel.Contato;

public class ContatoDaoImpl implements ContatoDao {

private Connection con;
	
	public ContatoDaoImpl() throws SQLException{
		this.con = ConnectionFactory.getConnection();
	}


	@Override
	public List<Contato> listarContatos() throws SQLException {

		
		String sql = "SELECT * FROM contatos";
		 
		 List<Contato> contatos = new ArrayList<Contato>();
		 
		 Connection conn = null;
		 PreparedStatement pstm = null;
		 
		 //Classe que vai recuperar os dados do banco de dados
		 ResultSet rset = null;
		 
		 try {
		 
		 conn = ConnectionFactory.getConnection();
		 pstm = conn.prepareStatement(sql);
		 
		 rset = pstm.executeQuery();
		 
		 //Enquanto existir dados no banco de dados, faça
		 while(rset.next()){
		 
		 Contato contato = new Contato();
		 
		 //Recupera o id do banco e atribui ele ao objeto
		 contato.setId(rset.getInt("id"));
		 
		 //Recupera o nome do banco e atribui ele ao objeto
		 contato.setNome(rset.getString("nome"));
		 
		 //Recupera a idade do banco e atribui ele ao objeto
		 contato.setEmail(rset.getString("email"));
		 
		 //Recupera a data do banco e atribui ela ao objeto
		 contato.setEndereco(rset.getString("endereco"));
		 
		 //Adiciono o contato recuperado, a lista de contatos
		 
		 contatos.add(contato);
		 	}
		 } catch (Exception e) {
		 
		 e.printStackTrace();
	 }
		 
	finally{
		 
		 try{
		 
			 if(rset != null){
		 
				rset.close();
		 }
		 
			 if(pstm != null){
		 
				 pstm.close();
		 }
		 
			 if(conn != null){
				 
				 conn.close();
		 }
		 
		 }catch(Exception e){
		 
		 e.printStackTrace();
		 }
	 }
		 
		 return contatos;
	 }
		

	@Override
	public Integer incluirContato (Contato contato) {

		try {
			String sql = "INSERT into contatos (nome,email, endereco) VALUES (?,?,?)";
			PreparedStatement stmt = con.prepareStatement(sql);
			
			stmt.setString(1, contato.getNome());
			stmt.setString(2, contato.getEmail());
			stmt.setString(3, contato.getEndereco());
			
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return contato.getId();
		
		
	}
	
	
	
	public void update(Contato contato){
		 
		 String sql = "UPDATE contatos SET nome = ?, email = ?, endereco = ?" +
		 " WHERE = '" + contato.getId() +  "'";
		 
		 Connection conn = null;
		 PreparedStatement pstm = null;
		 
		 try {
		 //Cria uma conexão com o banco
		 
		 //Cria um PreparedStatment, classe usada para executar a query
		 pstm = con.prepareStatement(sql);
	
		 //Adiciona o valor do primeiro parâmetro da sql
		 pstm.setString(1, contato.getNome());
		 //Adicionar o valor do segundo parâmetro da sql
		 pstm.setString(2, contato.getEmail());
		 //Adiciona o valor do terceiro parâmetro da sql
		 pstm.setString(3, contato.getEmail());
		 
		 pstm.setInt(4, contato.getId());
		 
		 //Executa a sql para inserção dos dados
		 pstm.execute();
		 
		 } catch (Exception e) {
		 
		 e.printStackTrace();
		 }finally{
		 
		 //Fecha as conexões
		 
		 try{
		 if(pstm != null){
		 
		 pstm.close();
		 }
		 
		 if(conn != null){
		 conn.close();
		 }
		 
		 }catch(Exception e){
		 
		 e.printStackTrace();
		 
		 	}
		 }
	}
	
	  public void excluir(Contato contato) {
		    String sql = "DELETE FROM contatos WHERE id ='" + contato.getId() + "'";
		    try {
				PreparedStatement stmt = con.prepareStatement(sql);
				stmt.execute();
				stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		  }

	  
	  public Contato consultarPorId(Integer id) {
		   
		    Contato contato = null;
		    try {
		      String sql = "SELECT * FROM contatos WHERE nome = '" + id + "'";
		      PreparedStatement stmt = con.prepareStatement(sql);
		      ResultSet rs = stmt.executeQuery(sql.toString());

		      if(rs.next()) {
		         contato = new Contato();
		        contato.setNome(rs.getString("Nome"));
		        contato.setEmail(rs.getString("Email"));
		        contato.setEndereco(rs.getString("Endereço"));
		        
		        stmt.close();
		        con.close();
		      }
		    } catch (SQLException ex) {
		      System.out.println("Nao conseguiu consultar os dados do Contato.");
		    } 

		    return contato;
		  }  
	  
	  
	  
}




