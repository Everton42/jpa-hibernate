package br.com.studyhibernate.finances.model.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.studyhibernate.finances.model.Account;

public class Test {

	public static void main(String []args) {
		Account testAccount = new Account();
		testAccount.setAccountHolder("Everton Ferreira");
		testAccount.setAccountNumber("123456");
		testAccount.setBankBranch("5465659");
		testAccount.setBankName("Nubank");

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("finances");
		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();
		em.persist(testAccount);
		em.getTransaction().commit();

		em.close();
		emf.close();
	}
}
