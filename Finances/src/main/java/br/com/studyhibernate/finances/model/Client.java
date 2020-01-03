package br.com.studyhibernate.finances.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
    private String name;
	private String address;
    @JoinColumn(unique=true)
    @OneToOne
	private Account account;
	private String profession;

	public String getName() {
		return name;
	}

	public String getAddress() {
		return address;
	}

	public Account getAccount() {
		return account;
	}

	public String getProfession() {
		return profession;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setProfession(String profession) {
		this.profession = profession;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

}
