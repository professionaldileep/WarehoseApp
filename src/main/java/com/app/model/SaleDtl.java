package com.app.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class SaleDtl {
	
	@Id
	private Integer id;
	
	private Integer slno;
	
	private Integer qty;
	
	@ManyToOne
	@JoinColumn(name = "partIdFk")
	private Sale part;

	public SaleDtl() {
		super();
	}

	public SaleDtl(Integer id) {
		super();
		this.id = id;
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

	public Integer getQty() {
		return qty;
	}

	public void setQty(Integer qty) {
		this.qty = qty;
	}

	public Sale getPart() {
		return part;
	}

	public void setPart(Sale part) {
		this.part = part;
	}

	@Override
	public String toString() {
		return "SaleDtl [id=" + id + ", slno=" + slno + ", qty=" + qty + ", part=" + part + "]";
	}

}
