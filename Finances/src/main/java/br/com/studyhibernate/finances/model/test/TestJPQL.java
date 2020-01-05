package br.com.studyhibernate.finances.model.test;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.studyhibernate.finances.model.Category;
import br.com.studyhibernate.finances.model.Transaction;
import br.com.studyhibernate.finances.util.JPAUtil;

public class TestJPQL {

	private static EntityManager em;

	public static void main(String[] args) {
		try {
			em = new JPAUtil().getEntityManager();
			em.getTransaction().begin();

			Category category = new Category();
			category.setId(4);

			String selectTransactionByCategory = "select tr from Transaction tr join tr.categories c where c = :pCategory";
			Query jpql = em.createQuery(selectTransactionByCategory);
			jpql.setParameter("pCategory", category);

			 List<Transaction> results = jpql.getResultList();
			
			for (Transaction transaction : results) {
				System.out.println(transaction.getDescription());				
			}

		} finally {
			em.close();
		}
	}
}
