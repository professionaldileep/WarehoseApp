package com.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="uomtab")
public class Uom {
	
	@Id
	@Column(name="id")
	@GeneratedValue
	private Integer id;

	@Column(name="utype")
	private String uomType;
	
	@Column(name="umodel")
	private String uomModel;
	
	@Column(name="description")
	private String descr;

	public Uom() {
		super();
	}

	public Uom(Integer id) {
		super();
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUomType() {
		return uomType;
	}

	public void setUomType(String uomType) {
		this.uomType = uomType;
	}

	public String getUomModel() {
		return uomModel;
	}

	public void setUomModel(String uomModel) {
		this.uomModel = uomModel;
	}

	public String getDescr() {
		return descr;
	}

	public void setDescr(String descr) {
		this.descr = descr;
	}

	@Override
	public String toString() {
		return "Uom [id=" + id + ", uomType=" + uomType + ", uomModel=" + uomModel + ", descr=" + descr + "]";
	}
	
	

}
