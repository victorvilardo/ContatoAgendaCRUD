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
	public Contato buscarContato(String nome) throws SQLException {
	
		//Crie um m�todo para pesquisar um contato inserido no banco de dados (getContato) e retornar suas informa��es armazenadas, 
		//utilizando como entrada o nome do contato passado para a classe Scanner e tamb�m crie uma classe para fazer os testes desta pesquisa
		
		StringBuilder sql = new StringBuilder ("select * from Contatos where nome =: nome ");
		PreparedStatement stmt = con.prepareStatement(sql.toString());
		ResultSet rs = stmt.executeQuery();
		
		
		
		return null;
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
		 
		 //Enquanto existir dados no banco de dados, fa�a
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
		 " WHERE id = ?";
		 
		 Connection conn = null;
		 PreparedStatement pstm = null;
		 
		 try {
		 //Cria uma conex�o com o banco
		 
		 //Cria um PreparedStatment, classe usada para executar a query
		 pstm = conn.prepareStatement(sql);
		 
		 //Adiciona o valor do primeiro par�metro da sql
		 pstm.setString(1, contato.getNome());
		 //Adicionar o valor do segundo par�metro da sql
		 pstm.setString(2, contato.getEmail());
		 //Adiciona o valor do terceiro par�metro da sql
		 pstm.setString(3, contato.getEmail());
		 
		 pstm.setInt(4, contato.getId());
		 
		 //Executa a sql para inser��o dos dados
		 pstm.execute();
		 
		 } catch (Exception e) {
		 
		 e.printStackTrace();
		 }finally{
		 
		 //Fecha as conex�es
		 
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
}




