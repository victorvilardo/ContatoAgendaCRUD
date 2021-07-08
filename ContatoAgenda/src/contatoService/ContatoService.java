package contatoService;

import java.util.List;

import contatoDao.ContatoDao;
import contatoModel.Contato;

public class ContatoService {

	private ContatoDao dao;
	
	public ContatoService(ContatoDao dao) {
		
		
		this.dao = dao;
	
	}
	
	public Integer incluirContato(Contato contato) {
		
		
		List <Contato> contatos = listarContatos();	
		
		for (Contato c : contatos) {
			if ( c.getNome().equals(contato.getNome())){
				System.out.println("Cliente já existe!");
			}
		}
		
		return dao.incluirContato(contato);
	}


	

	private List<Contato> listarContatos() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}