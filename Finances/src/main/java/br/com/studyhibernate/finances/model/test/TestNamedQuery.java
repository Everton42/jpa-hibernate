package br.com.studyhibernate.finances.model.test;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import br.com.studyhibernate.finances.model.Account;
import br.com.studyhibernate.finances.model.TransactionType;
import br.com.studyhibernate.finances.util.JPAUtil;

public class TestNamedQuery {

	private static EntityManager em;

	public static void main(String[] args) {
		try {
			em = new JPAUtil().getEntityManager();

			Account account = new Account();
			account.setId(2);

			TypedQuery<Double> typedQuery = em.createNamedQuery("AverageTransactionPerDayAndType", Double.class);

			typedQuery.setParameter("pAccount", account);
			typedQuery.setParameter("pTransactionType", TransactionType.OUT);

			List<Double> averages = typedQuery.getResultList();
			for (Double average : averages) {
				System.out.println(average);
			}
		} finally {
			em.close();
		}

	}
}