package com.app.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

@Entity
public class PurchaseDtl {

	@Id
	@GeneratedValue
	private Integer id;
	
	@Transient
	private Integer slno;
	private Integer qnt;
	
	@ManyToOne
	@JoinColumn(name = "partIdFk")
	private Part part;
	
	@ManyToOne
	@JoinColumn(name = "pdIdFk")
	private Purchase parent;

	public PurchaseDtl() {
		super();
	}

	public PurchaseDtl(Integer id) {
		super();
		this.id = id;
	}
	
	public PurchaseDtl(Purchase parent) {
		super();
		this.parent = parent;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getSlno() {
		return slno;
	}

	public void setSlno(Integer slno) {
		this.slno = slno;
	}

	public Integer getQnt() {
		return qnt;
	}

	public void setQnt(Integer qnt) {
		this.qnt = qnt;
	}

	public Part getPart() {
		return part;
	}

	public void setPart(Part part) {
		this.part = part;
	}

	public Purchase getParent() {
		return parent;
	}

	public void setParent(Purchase parent) {
		this.parent = parent;
	}

	
	
}
