package contatoDao;

import java.sql.SQLException;
import java.util.List;

import contatoModel.Contato;

public interface ContatoDao {
	
	
	
	/**
	 * Metodo que ira incluir um contato no banco de dados
	 * @param contato
	 */

	Integer incluirContato (Contato contato);
	
	
	/**
	 * Metodo que ira buscar um contato com base no nome informado
	 * @param contato
	 * @return
	 * @throws SQLException 
	 */
	Contato buscarContato (String contato) throws SQLException;
	
	
	/**
	 * Metodo para listar os contatos
	 * @return
	 * @throws SQLException 
	 */
	List <Contato> listarContatos() throws SQLException;
	
	
	/**
	 * Metodo de atualizar um contato
	 * @param contato
	 */
	void update(Contato contato);
	
}
