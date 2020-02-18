package com.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="shipmenttab")
public class ShipmentType {
	
	@Id
	@GeneratedValue
	@Column(name="id")
	private Integer id;
	
	@Column(name="mode")
	private String shipmentMode;
	
	@Column(name="code")
	private String shipmentCode;
	
	@Column(name="enable")
	private String enable;
	
	@Column(name="grade")
	private String grade;
	
	@Column(name="descr")
	private String descr;

	public ShipmentType() {
		super();
	}

	public ShipmentType(Integer id) {
		super();
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getShipmentMode() {
		return shipmentMode;
	}

	public void setShipmentMode(String shipmentMode) {
		this.shipmentMode = shipmentMode;
	}

	public String getShipmentCode() {
		return shipmentCode;
	}

	public void setShipmentCode(String shipmentCode) {
		this.shipmentCode = shipmentCode;
	}

	public String getEnable() {
		return enable;
	}

	public void setEnable(String enable) {
		this.enable = enable;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getDescr() {
		return descr;
	}

	public void setDescr(String descr) {
		this.descr = descr;
	}

	@Override
	public String toString() {
		return "ShipmentType [id=" + id + ", shipmentMode=" + shipmentMode + ", shipmentCode=" + shipmentCode
				+ ", enable=" + enable + ", grade=" + grade + ", descr=" + descr + "]";
	}
	
	
}
