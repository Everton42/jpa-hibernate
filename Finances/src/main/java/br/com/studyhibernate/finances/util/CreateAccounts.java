package br.com.studyhibernate.finances.util;

import javax.persistence.EntityManager;

import br.com.studyhibernate.finances.model.Account;

public class CreateAccounts {
	private static EntityManager manager;

	public static void main(String[] args) {

		try {
			manager = new JPAUtil().getEntityManager();
			manager.getTransaction().begin();

			Account account1 = new Account();
			Account account2 = new Account();
			Account account3 = new Account();
			Account account4 = new Account();
			Account account5 = new Account();

			account1.setBankName("001 - BANCO DO BRASIL");
			account1.setAccountNumber("16987-8");
			account1.setBankBranch("6543");
			account1.setAccountHolder("Maria dos Santos");

			account2.setBankName("237 - BANCO BRADESCO");
			account2.setAccountNumber("86759-1");
			account2.setBankBranch("1745");
			account2.setAccountHolder("Paulo Roberto Souza");

			account3.setBankName("341 - BANCO ITAU UNIBANCO");
			account3.setAccountNumber("46346-3");
			account3.setBankBranch("4606");
			account3.setAccountHolder("Antonio Duraes");

			account4.setBankName("033 - BANCO SANTANDER");
			account4.setAccountNumber("12345-6");
			account4.setBankBranch("9876");
			account4.setAccountHolder("Leandra Marques");

			account5.setBankName("104 - CAIXA ECONOMICA FEDERAL");
			account5.setAccountNumber("98654-3");
			account5.setBankBranch("1234");
			account5.setAccountHolder("Alexandre Duarte");

			// persistindo as Accounts
			manager.persist(account1);
			manager.persist(account2);
			manager.persist(account3);
			manager.persist(account4);
			manager.persist(account5);

			manager.getTransaction().commit();
		} finally {
			manager.close();
		}
	}
}
