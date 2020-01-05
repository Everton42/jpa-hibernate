package br.com.studyhibernate.finances.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Account {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String accountHolder;
	private String accountNumber;
	private String bankName;
	private String bankBranch;
	@JoinColumn(unique = true)
	@OneToOne
	private Client client;
	@OneToMany(mappedBy="account")
	private List<Transaction> transactions;

	public void setId(Integer id) {
		this.id = id;
	}

	public Client getCliente() {
		return client;
	}

	public void setCliente(Client cliente) {
		this.client = cliente;
	}

	public Integer getId() {
		return id;
	}

	public String getAccountHolder() {
		return accountHolder;
	}

	public void setAccountHolder(String accountHolder) {
		this.accountHolder = accountHolder;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getBankBranch() {
		return bankBranch;
	}

	public void setBankBranch(String bankBranch) {
		this.bankBranch = bankBranch;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Transaction> getTransactions() {
		return this.transactions;
	}
}
