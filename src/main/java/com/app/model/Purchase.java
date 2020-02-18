package com.app.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="purchasetab")
public class Purchase {
	@Id
	@GeneratedValue
	@Column(name="id")
	private Integer id;
	
	@Column(name="ordCode")
	private String orderCode;

	@ManyToOne
	@JoinColumn(name = "shpIdFK")
	private ShipmentType shipmentCode;
	
	@ManyToOne
	@JoinColumn(name = "whuserIdFK")
	private WhUserType vendor;
	
	@Column(name="refNum")
	private String referenceNum;
	
	@Column(name="qaCheck")
	private String qualityCheck;
	
	@Column(name="defStatus")
	private String defaultStatus;
	
	@Column(name="descr")
	private String description;
	
	@OneToMany(mappedBy = "parent", fetch = FetchType.EAGER)
	private List<PurchaseDtl> purchaseDtl; 
	
	public Purchase() {
		super();
	}
	public Purchase(Integer id) {
		super();
		this.id = id;
	}
	
	public Purchase(String defaultStatus) {
		super();
		this.defaultStatus = defaultStatus;
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
	
	public WhUserType getVendor() {
		return vendor;
	}
	public void setVendor(WhUserType vendor) {
		this.vendor = vendor;
	}
	public String getReferenceNum() {
		return referenceNum;
	}
	public void setReferenceNum(String referenceNum) {
		this.referenceNum = referenceNum;
	}
	public String getQualityCheck() {
		return qualityCheck;
	}
	public void setQualityCheck(String qualityCheck) {
		this.qualityCheck = qualityCheck;
	}
	public String getDefaultStatus() {
		return defaultStatus;
	}
	public void setDefaultStatus(String defaultStatus) {
		this.defaultStatus = defaultStatus;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public List<PurchaseDtl> getPurchaseDtl() {
		return purchaseDtl;
	}
	public void setPurchaseDtl(List<PurchaseDtl> purchaseDtl) {
		this.purchaseDtl = purchaseDtl;
	}
	
	
	@Override
	public String toString() {
		return "Purchase [id=" + id + ", orderCode=" + orderCode + ", shipmentCode=" + shipmentCode + ", vendor="
				+ vendor + ", referenceNum=" + referenceNum + ", qualityCheck=" + qualityCheck + ", defaultStatus="
				+ defaultStatus + ", description=" + description + ", purchaseDtl=" + purchaseDtl + "]";
	}
	
	
}
