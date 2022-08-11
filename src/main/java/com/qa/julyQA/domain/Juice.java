package com.qa.julyQA.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Juice {

	@Id // PK
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private Integer id;

	@Column(unique = true, nullable = false)
	private String name;

	@Column
	private int amount;

	@Column
	private double cost;

	public Juice(Integer id, String name, int amount, double cost) {
		super();
		this.id = id;
		this.name = name;
		this.amount = amount;
		this.cost = cost;
	}

	public Juice(String name, int amount, double cost) {
		super();
		this.name = name;
		this.amount = amount;
		this.cost = cost;
	}

	
	public Juice() {
		super();
	}

	
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAmount() {
		return this.amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public double getCost() {
		return this.cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	@Override
	public String toString() {
		return "Juice [name=" + this.name + ", amount=" + this.amount + ", cost=" + this.cost + "]";
	}
}
