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
	
	/**
	 * Metodo para excluir um contato
	 * @param contato
	 */
	void excluir(Contato contato);
	
}
