package com.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "parttab")
public class Part {
	
	@Id
	@GeneratedValue
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "code")
	private String code;
	
	@Column(name = "width")
	private Double width;
	
	@Column(name = "len")
	private Double length;
	
	@Column(name = "heigh")
	private Double height;
	
	@Column(name = "basecost")
	private Double baseCost;
	
	@Column(name = "basecurr")
	private String baseCurr;
	
	@ManyToOne
	@JoinColumn(name = "UomIdFK")
	private Uom uom;
	
	@ManyToOne
	@JoinColumn(name = "saleIdFK")
	private OrderMethod sale;
	
	@ManyToOne
	@JoinColumn(name = "purchaseIdFK")
	private OrderMethod purchase;
	
	@Column(name = "note")
	private String note;

	public Part() {
		super();
	}

	public Part(Integer id) {
		super();
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Double getWidth() {
		return width;
	}

	public void setWidth(Double width) {
		this.width = width;
	}

	public Double getLength() {
		return length;
	}

	public void setLength(Double length) {
		this.length = length;
	}

	public Double getHeight() {
		return height;
	}

	public void setHeight(Double height) {
		this.height = height;
	}

	public Double getBaseCost() {
		return baseCost;
	}

	public void setBaseCost(Double baseCost) {
		this.baseCost = baseCost;
	}

	public String getBaseCurr() {
		return baseCurr;
	}

	public void setBaseCurr(String baseCurr) {
		this.baseCurr = baseCurr;
	}

	public Uom getUom() {
		return uom;
	}

	public void setUom(Uom uom) {
		this.uom = uom;
	}


	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public OrderMethod getSale() {
		return sale;
	}

	public void setSale(OrderMethod sale) {
		this.sale = sale;
	}

	public OrderMethod getPurchase() {
		return purchase;
	}

	public void setPurchase(OrderMethod purchase) {
		this.purchase = purchase;
	}

	@Override
	public String toString() {
		return "Part [id=" + id + ", code=" + code + ", width=" + width + ", length=" + length + ", height=" + height
				+ ", baseCost=" + baseCost + ", baseCurr=" + baseCurr + ", uom=" + uom + ", sale=" + sale
				+ ", purchase=" + purchase + ", note=" + note + "]";
	}

	
	
}
