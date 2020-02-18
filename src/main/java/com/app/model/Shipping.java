package com.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="shippingtab")
public class Shipping {
	@Id
	@GeneratedValue
	@Column(name="id")
	private Integer id;
	@Column(name="shipCode")
	private String shippingCode;
	@Column(name="shipRefNum")
	private String shippingRefNum;
	@Column(name="courierRefNum")
	private String courierRefNum;
	@Column(name="contactDetails")
	private String contactDetails;
	@Column(name="orderCode")
	private String saleOrderCode;
	@Column(name="descr")
	private String description;
	@Column(name="billaddr")
	private String billToAddr;
	@Column(name="shipaddr")
	private String shipToAddr;
	
	public Shipping() {
		super();
	}

	public Shipping(Integer id) {
		super();
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getShippingCode() {
		return shippingCode;
	}

	public void setShippingCode(String shippingCode) {
		this.shippingCode = shippingCode;
	}

	public String getShippingRefNum() {
		return shippingRefNum;
	}

	public void setShippingRefNum(String shippingRefNum) {
		this.shippingRefNum = shippingRefNum;
	}

	public String getCourierRefNum() {
		return courierRefNum;
	}

	public void setCourierRefNum(String courierRefNum) {
		this.courierRefNum = courierRefNum;
	}

	public String getContactDetails() {
		return contactDetails;
	}

	public void setContactDetails(String contactDetails) {
		this.contactDetails = contactDetails;
	}

	public String getSaleOrderCode() {
		return saleOrderCode;
	}

	public void setSaleOrderCode(String saleOrderCode) {
		this.saleOrderCode = saleOrderCode;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getBillToAddr() {
		return billToAddr;
	}

	public void setBillToAddr(String billToAddr) {
		this.billToAddr = billToAddr;
	}

	public String getShipToAddr() {
		return shipToAddr;
	}

	public void setShipToAddr(String shipToAddr) {
		this.shipToAddr = shipToAddr;
	}

	@Override
	public String toString() {
		return "Shipping [id=" + id + ", shippingCode=" + shippingCode + ", shippingRefNum=" + shippingRefNum
				+ ", courierRefNum=" + courierRefNum + ", contactDetails=" + contactDetails + ", saleOrderCode="
				+ saleOrderCode + ", description=" + description + ", billToAddr=" + billToAddr + ", shipToAddr="
				+ shipToAddr + "]";
	}
	
	
	
}