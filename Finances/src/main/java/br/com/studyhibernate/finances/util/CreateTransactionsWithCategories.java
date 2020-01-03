package br.com.studyhibernate.finances.util;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Calendar;

import javax.persistence.EntityManager;

import br.com.studyhibernate.finances.model.Account;
import br.com.studyhibernate.finances.model.Category;
import br.com.studyhibernate.finances.model.Transaction;
import br.com.studyhibernate.finances.model.TransactionType;

public class CreateTransactionsWithCategories {
	private static EntityManager manager;

	public static void main(String[] args) {

		try {
		       	Category category1 = new Category("Viagem");
		        Category category2 = new Category("Negócios");

		        Account account = new Account();
		        account.setId(2);

		        Transaction transaction1 = new Transaction();
		        transaction1.setTransactionDay(Calendar.getInstance()); // hoje
		        transaction1.setDescription("Viagem à SP");
		        transaction1.setTransactionType(TransactionType.OUT);
		        transaction1.setValue(BigDecimal.valueOf(100.0));
		        transaction1.setCategories(Arrays.asList(category1, category2));

		        transaction1.setAccount(account);

		        Transaction transaction2 = new Transaction();
		        transaction2.setTransactionDay(Calendar.getInstance()); // hoje
		        transaction2.setDescription("Viagem ao RJ");
		        transaction2.setTransactionType(TransactionType.OUT);
		        transaction2.setValue(BigDecimal.valueOf(300.0));
		        transaction2.setCategories(Arrays.asList(category1, category2));

		        transaction2.setAccount(account);

		        EntityManager em = new JPAUtil().getEntityManager();
		        em.getTransaction().begin();

		        em.persist(category1); // Agora a 'category1' é Managed
		        em.persist(category2); // Agora a 'category2' é Managed

		        em.persist(transaction1);
		        em.persist(transaction2);

		        em.getTransaction().commit();
		} finally {
			manager.close();
		}
	}
}
