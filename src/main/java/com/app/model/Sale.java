package com.app.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="saletab")
public class Sale {
	
	@Id
	@GeneratedValue
	@Column(name = "saleid")
	private Integer id;

	@Column(name = "ordcode")
	private String orderCode;
	
	@ManyToOne
	@JoinColumn(name = "shpcodIdFK")
	private ShipmentType shipmentCode;
	
	@ManyToOne
	@JoinColumn(name = "whuserIdFK")
	private WhUserType customer;
	
	@Column(name = "refnumber")
	private String refNumber;
	
	@Column(name = "stockmode")
	private String stockMode;
	
	@Column(name = "stocksource")
	private String stockSource;
	
	@Column(name = "defstatus")
	private String defStatus;
	
	@Column(name = "descr")
	private String description;

	@OneToMany
	@JoinColumn(name = "saleDtlFk")
	private List<SaleDtl> saleDtl;
	
	public Sale() {
		super();
	}

	public Sale(Integer id) {
		super();
		this.id = id;
	}

	public Sale(String defStatus) {
		super();
		this.defStatus = defStatus;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getOrderCode() {
		return orderCode;
	}

	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}

	public ShipmentType getShipmentCode() {
		return shipmentCode;
	}

	public void setShipmentCode(ShipmentType shipmentCode) {
		this.shipmentCode = shipmentCode;
	}

	public WhUserType getCustomer() {
		return customer;
	}

	public void setCustomer(WhUserType customer) {
		this.customer = customer;
	}

	public String getRefNumber() {
		return refNumber;
	}

	public void setRefNumber(String refNumber) {
		this.refNumber = refNumber;
	}

	public String getStockMode() {
		return stockMode;
	}

	public void setStockMode(String stockMode) {
		this.stockMode = stockMode;
	}

	public String getStockSource() {
		return stockSource;
	}

	public void setStockSource(String stockSource) {
		this.stockSource = stockSource;
	}

	public String getDefStatus() {
		return defStatus;
	}

	public void setDefStatus(String defStatus) {
		this.defStatus = defStatus;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public List<SaleDtl> getSaleDtl() {
		return saleDtl;
	}

	public void setSaleDtl(List<SaleDtl> saleDtl) {
		this.saleDtl = saleDtl;
	}

	@Override
	public String toString() {
		return "Sale [id=" + id + ", orderCode=" + orderCode + ", shipmentCode=" + shipmentCode + ", customer="
				+ customer + ", refNumber=" + refNumber + ", stockMode=" + stockMode + ", stockSource=" + stockSource
				+ ", defStatus=" + defStatus + ", description=" + description + ", saleDtl=" + saleDtl + "]";
	}
	
}
