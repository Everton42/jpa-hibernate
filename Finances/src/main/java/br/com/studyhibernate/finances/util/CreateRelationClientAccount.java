package br.com.studyhibernate.finances.util;

import javax.persistence.EntityManager;

import br.com.studyhibernate.finances.model.Account;
import br.com.studyhibernate.finances.model.Client;

public class CreateRelationClientAccount {
	private static EntityManager manager;

	public static void main(String[] args) {

		try {
			Client client = new Client();
	        client.setName("Mario");
	        client.setAddress("Rua Atlants, 123");
	        client.setProfession("Encanador");

	        Client client2 = new Client();
	        client2.setName("Reginaldo");
	        client2.setAddress("Rua Faisca 5, 569");
	        client2.setProfession("Farmaceutico");

	        Account account = new Account();
	        account.setId(2); // essa conta está no estado 'Detached' pois já possui um id!!

	        client.setAccount(account);
	        client2.setAccount(account);

	        EntityManager em = new JPAUtil().getEntityManager();
	        em.getTransaction().begin();

	        em.persist(client);
	       // em.persist(client2);// teste
	        
	        em.getTransaction().commit();


		} finally {
			manager.close();
		}
	}
}
