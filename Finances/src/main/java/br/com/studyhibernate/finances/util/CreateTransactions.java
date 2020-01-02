package br.com.studyhibernate.finances.util;

import java.math.BigDecimal;
import java.util.Calendar;

import javax.persistence.EntityManager;

import br.com.studyhibernate.finances.model.Account;
import br.com.studyhibernate.finances.model.Transaction;
import br.com.studyhibernate.finances.model.TransactionType;

public class CreateTransactions {
	private static EntityManager manager;

	public static void main(String[] args) {

		try {
			EntityManager manager = new JPAUtil().getEntityManager();

			manager.getTransaction().begin();

			Account account1 = manager.find(Account.class, 1);
			Account account2 = manager.find(Account.class, 2);
			Account account3 = manager.find(Account.class, 3);
			Account account4 = manager.find(Account.class, 4);
			Account account5 = manager.find(Account.class, 5);

			// Movimentacoes da account1
			Transaction transaction1 = new Transaction();
			Transaction transaction2 = new Transaction();
			Transaction transaction3 = new Transaction();
			Transaction transaction4 = new Transaction();

			transaction1.setTransactionDay(Calendar.getInstance());
			transaction1.setDescription("Account de luz - ABRIL/2012");
			transaction1.setValue(new BigDecimal("135"));
			transaction1.setTransactionType(TransactionType.OUT);
			transaction1.setAccount(account1);

			manager.persist(transaction1);

			transaction2.setTransactionDay(Calendar.getInstance());
			transaction2.setDescription("Almoco no Restaurante - AGOSTO/2012");
			transaction2.setValue(new BigDecimal("175.80"));
			transaction2.setTransactionType(TransactionType.OUT);
			transaction2.setAccount(account1);

			manager.persist(transaction2);

			transaction3.setTransactionDay(Calendar.getInstance());
			transaction3.setDescription("Aluguel - MAIO/2012");
			transaction3.setValue(new BigDecimal("680.00"));
			transaction3.setTransactionType(TransactionType.IN);
			transaction3.setAccount(account1);

			manager.persist(transaction3);

			transaction4.setTransactionDay(Calendar.getInstance());
			transaction4.setDescription("Salario - FEVEREIRO/2012");
			transaction4.setValue(new BigDecimal("3830.68"));
			transaction4.setTransactionType(TransactionType.IN);
			transaction4.setAccount(account1);

			manager.persist(transaction4);

			// Movimentacoes da account2
			Transaction transaction5 = new Transaction();
			Transaction transaction6 = new Transaction();

			transaction5.setTransactionDay(Calendar.getInstance());
			transaction5.setDescription("Account de telefone - SETEMBRO/2011");
			transaction5.setValue(new BigDecimal("168.27"));
			transaction5.setTransactionType(TransactionType.OUT);
			transaction5.setAccount(account2);

			manager.persist(transaction5);

			transaction6.setTransactionDay(Calendar.getInstance());
			transaction6.setDescription("Aniversario - MAIO/2011");
			transaction6.setValue(new BigDecimal("200"));
			transaction6.setTransactionType(TransactionType.IN);
			transaction6.setAccount(account2);

			manager.persist(transaction6);

			// Movimentacoes da account3
			Transaction transaction7 = new Transaction();
			Transaction transaction8 = new Transaction();
			Transaction transaction9 = new Transaction();

			transaction7.setTransactionDay(Calendar.getInstance());
			transaction7.setDescription("Lanche - JULHO/2011");
			transaction7.setValue(new BigDecimal("28.50"));
			transaction7.setTransactionType(TransactionType.OUT);
			transaction7.setAccount(account3);

			manager.persist(transaction7);

			transaction8.setTransactionDay(Calendar.getInstance());
			transaction8.setDescription("Presente - DEZEMBRO/2011");
			transaction8.setValue(new BigDecimal("49.99"));
			transaction8.setTransactionType(TransactionType.OUT);
			transaction8.setAccount(account3);

			manager.persist(transaction8);

			transaction9.setTransactionDay(Calendar.getInstance());
			transaction9.setDescription("Bonus - JANEIRO/2012");
			transaction9.setValue(new BigDecimal("2000"));
			transaction9.setTransactionType(TransactionType.IN);
			transaction9.setAccount(account3);

			manager.persist(transaction9);

			// Movimentacoes da account4
			Transaction transaction10 = new Transaction();

			transaction10.setTransactionDay(Calendar.getInstance());
			transaction10.setDescription("Carnaval - MARCO/2012");
			transaction10.setValue(new BigDecimal("765.20"));
			transaction10.setTransactionType(TransactionType.OUT);
			transaction10.setAccount(account4);

			manager.persist(transaction10);

			// Movimentacoes da account5
			Transaction transaction11 = new Transaction();
			Transaction transaction12 = new Transaction();

			transaction11.setTransactionDay(Calendar.getInstance());
			transaction11.setDescription("Salario - ABRIL/2012");
			transaction11.setValue(new BigDecimal("2651.90"));
			transaction11.setTransactionType(TransactionType.IN);
			transaction11.setAccount(account5);

			manager.persist(transaction11);

			transaction12.setTransactionDay(Calendar.getInstance());
			transaction12.setDescription("Bonus - JANEIRO/2012");
			transaction12.setValue(new BigDecimal("1000"));
			transaction12.setTransactionType(TransactionType.IN);
			transaction12.setAccount(account5);

			manager.persist(transaction12);

			manager.getTransaction().commit();
		} finally {
			manager.close();
		}
	}
}
