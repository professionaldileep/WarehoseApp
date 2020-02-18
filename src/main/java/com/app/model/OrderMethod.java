package com.app.model;

import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "ordertab")
public class OrderMethod {
	
	@Id
	@GeneratedValue
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "ordMode")
	private String orderMode;
	
	@Column(name = "ordCode")
	private String orderCode;
	
	@Column(name = "ordType")
	private String orderType;
	
	@Column(name = "ordAccept")
	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable(name = "orderAcceptTab",joinColumns = @JoinColumn(name = "id"))
	private List<String> orderAccept;
	
	@Column(name = "description")
	private String description;
	
	public OrderMethod() {
		super();
	}
	
	

	public OrderMethod(Integer id) {
		super();
		this.id = id;
	}



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getOrderMode() {
		return orderMode;
	}

	public void setOrderMode(String orderMode) {
		this.orderMode = orderMode;
	}

	public String getOrderCode() {
		return orderCode;
	}

	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}

	public String getOrderType() {
		return orderType;
	}

	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}

	public List<String> getOrderAccept() {
		return orderAccept;
	}

	public void setOrderAccept(List<String> orderAccept) {
		this.orderAccept = orderAccept;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "OrderMethod [id=" + id + ", orderMode=" + orderMode + ", orderCode=" + orderCode + ", orderType="
				+ orderType + ", orderAccept=" + orderAccept + ", description=" + description + "]";
	}
	
	
}
