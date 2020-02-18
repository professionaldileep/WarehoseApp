package com.app.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "grntab")
public class Grn {
	@Id
	@GeneratedValue
	@Column(name = "id")
	private Integer id;
	@Column(name = "grncode")
	private String grnCode;
	@Column(name = "grntype")
	private String grnType;
	
	@ManyToOne
	@JoinColumn(unique = true, name = "poIdFk")
	private Purchase purchase;
	
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="grnIdFk")
	private List<GrnDtl> childs;
	
	@Column(name = "descr")
	private String description;
	public Grn() {
		super();
	}
	
	public Grn(Integer id) {
		super();
		this.id = id;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getGrnCode() {
		return grnCode;
	}
	public void setGrnCode(String grnCode) {
		this.grnCode = grnCode;
	}
	public String getGrnType() {
		return grnType;
	}
	public void setGrnType(String grnType) {
		this.grnType = grnType;
	}

	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	public Purchase getPurchase() {
		return purchase;
	}

	public void setPurchase(Purchase purchase) {
		this.purchase = purchase;
	}

	public List<GrnDtl> getChilds() {
		return childs;
	}

	public void setChilds(List<GrnDtl> childs) {
		this.childs = childs;
	}
	
	
	
	
	
}
