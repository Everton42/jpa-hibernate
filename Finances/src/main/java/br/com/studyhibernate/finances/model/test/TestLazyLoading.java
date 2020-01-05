package br.com.studyhibernate.finances.model.test;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.studyhibernate.finances.model.Account;
import br.com.studyhibernate.finances.util.JPAUtil;

public class TestLazyLoading {

	private static EntityManager em;

	public static void main(String[] args) {
		try {
			em = new JPAUtil().getEntityManager();
			em.getTransaction().begin();

			// String jpql = "select a from Account a"; // com lazy
			String jpql = "select a from Account a join fetch a.transactions";

			Query query = em.createQuery(jpql);

			List<Account> todasAsContas = query.getResultList();

			for (Account account : todasAsContas) {
				System.out.println("Titular: " + account.getAccountHolder());
				System.out.println("Movimentacoes: ");
				account.getTransactions()
					.forEach(t -> 
								System.out.println("\t"+t.getDescription()));
			}
		} finally {
			em.close();
		}

	}
}