package br.com.studyhibernate.finances.model;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@NamedQuery(query="select distinct avg(tr.value) from Transaction tr where tr.account = :pAccount" +
		" and tr.money = :pTransactionType group by tr.transactionDay", name = "AverageTransactionPerDayAndType")
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
	@ManyToMany
	private List<Category> categories;
	

	public TransactionType getTransactionType() {
		return money;
	}

	public Calendar getTransactionDay() {
		return transactionDay;
	}

	public String getDescription() {
		return description;
	}

	public List<Category> getCategories() {
		return categories;
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

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}

}
