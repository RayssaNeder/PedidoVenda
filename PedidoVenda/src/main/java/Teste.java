import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.algaworks.pedidovenda.model.Cliente;
import com.algaworks.pedidovenda.model.Endereco;
import com.algaworks.pedidovenda.model.TipoPessoa;

public class Teste {
	
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("PedidoPU");
		EntityManager manager = factory.createEntityManager();
		
		EntityTransaction trx = manager.getTransaction();
		trx.begin();
		
		Cliente cliente = new  Cliente();
		cliente.setNome("Joao das couves");
		cliente.setEmail("joaodascouves@gmail.com");
		cliente.setDocumentoReceitaFederal("08033291299");
		cliente.setTipoPessoa(TipoPessoa.FISICA);
		
		Endereco endereco = new Endereco();
		endereco.setLogradouro("Rua das Pedras Grandes Azuis");
		endereco.setCidade("Uberlandia");
		endereco.setNumero("1234");
		endereco.setCep("38499-533");
		endereco.setUf("MG");
		endereco.setCliente(cliente);
		
		cliente.getEnderecos().add(endereco);
		
		
		manager.persist(cliente);
		
		trx.commit();
	}

}
