package br.com.studyhibernate.finances.model.test;

import javax.persistence.EntityManager;

import br.com.studyhibernate.finances.model.Account;
import br.com.studyhibernate.finances.util.JPAUtil;

public class Test {

	public static void main(String []args) {
		EntityManager em = new JPAUtil().getEntityManager();
		
		em.getTransaction().begin();
		Account ac = em.find(Account.class, 1);
		ac.setAccountHolder("Everton Ferreira");
		
		em.getTransaction().commit();
		em.close();
	}
}
