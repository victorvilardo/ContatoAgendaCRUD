package contatoDao;

import java.util.List;

import contatoModel.Contato;

public interface ContatoDao {
	
	
	/**
	 * Metodo que ira incluir um contato no banco de dados
	 * @param contado
	 * @return
	 */

	Integer incluirContato (Contato contado);
	
	
	/**
	 * Metodo que ira buscar um contato com base no nome informado
	 * @param contato
	 * @return
	 */
	Contato buscarContato (String contato);
	
	
	/**
	 * Metodo para listar os contatos
	 * @return
	 */
	List <Contato> listarContatos();
	
}
