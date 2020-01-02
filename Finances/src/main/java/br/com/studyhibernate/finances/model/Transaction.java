package br.com.studyhibernate.finances.model;

import java.math.BigDecimal;
import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity

public class Transaction {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar transactionDay;
	private String description;
	private BigDecimal value;
	@Enumerated(EnumType.STRING)
	private TransactionType money;
	@ManyToOne
	private Account account;

	public TransactionType getTransactionType() {
		return money;
	}

	public Calendar getTransactionDay() {
		return transactionDay;
	}

	public String getDescription() {
		return description;
	}

	public BigDecimal getValue() {
		return value;
	}

	public Account getAccount() {
		return account;
	}

	public void setTransactionDay(Calendar date) {
		this.transactionDay = date;
	}

	public void setDescription(String desc) {
		this.description = desc;
	}

	public void setValue(BigDecimal value) {
		this.value = value;
	}

	public void setTransactionType(TransactionType type) {
		this.money = type;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

}
