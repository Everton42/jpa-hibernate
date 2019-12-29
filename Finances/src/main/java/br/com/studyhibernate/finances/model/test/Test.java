package br.com.studyhibernate.finances.model.test;

import javax.persistence.EntityManager;

import br.com.studyhibernate.finances.model.Account;
import br.com.studyhibernate.finances.util.JPAUtil;

public class Test {

	public static void main(String []args) {
		EntityManager em = new JPAUtil().getEntityManager();
		
		Account testAccount = new Account();
		testAccount.setAccountHolder("Everton Ferreira");
		testAccount.setAccountNumber("123456");
		testAccount.setBankBranch("5465659");
		testAccount.setBankName("Nubank");

		em.getTransaction().begin();
		em.persist(testAccount);
		em.getTransaction().commit();

		em.close();
	}
}
