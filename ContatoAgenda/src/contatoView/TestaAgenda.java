package contatoView;

import java.sql.SQLException;
import java.util.Scanner;

import contatoDao.ContatoDaoImpl;
import contatoModel.Contato;

public class TestaAgenda {
	 public static void main(String[] args) throws SQLException {
		    ContatoDaoImpl contatoDao = new ContatoDaoImpl();
		    char opcao = ' ';
		    do {
		      Contato contato = null;
		      opcao = menu();
		      switch(opcao) {
		        case 'I':
		          contato = coletarDados();
		          contatoDao.incluirContato(contato);
		          break;
		      
		        case 'E':
		          Integer ContatoExcluir = consultarContato();
		          contato = contatoDao.consultarPorId(ContatoExcluir);
		          contatoDao.excluir(contato);
		          break;
		        case 'A':
		          Integer ContatoAlterar = consultarContato();
			      contato = contatoDao.consultarPorId(ContatoAlterar);
		          contato = coletarDados();
		          
		          contatoDao.update(contato);
		          break;
		        case 'C':
		          Integer ContatoConsultar = consultarContato();
		          contato = contatoDao.consultarPorId(ContatoConsultar);
		          break;
		      }
		      mostrarDadoscontato(contato);
		    } while(opcao != 'S');
		  }

		  public static char menu() {
		    Scanner s = new Scanner(System.in);
		    char opcao = ' ';
		        
		    System.out.println("Escolha a sua opcao: ");
		    System.out.println("\t(I)ncluir");
		    System.out.println("\t(E)xcluir");
		    System.out.println("\t(A)lterar");
		    System.out.println("\t(C)onsultar");
		    System.out.println("\t(S)air");
		    System.out.print("\nOpcao: ");
		    opcao = s.nextLine().toUpperCase().charAt(0);

		    return opcao;
		  }

		  public static Integer consultarContato() {
		    Scanner s = new Scanner(System.in);
		    System.out.print("Digite o id do Contato: ");
		    return s.nextInt();
		  }

		  public static Contato coletarDados() {
		    Scanner s = new Scanner(System.in);
		    Contato contato = new Contato();

		    System.out.print("Digite o nome do contato: ");
		    contato.setNome(s.nextLine());
		    System.out.print("Digite o email do contato: ");
		    contato.setEmail(s.nextLine());
		    System.out.print("Digite o endereço do contato: ");
		    contato.setEndereco(s.nextLine());

		    return contato;
		  }

		  public static void mostrarDadoscontato(Contato contato) {
		    if(contato != null) {
		      System.out.println("\n############### DADOS DO contato #################");
		      System.out.println("Nome: " + contato.getNome());
		      System.out.println("Email: " + contato.getEmail());
		      System.out.println("Endereço: " + contato.getEndereco());
		      System.out.println("############### DADOS DO contato #################\n");
		    }
		  }
		}

