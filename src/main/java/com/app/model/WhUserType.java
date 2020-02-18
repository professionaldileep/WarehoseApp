package com.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="whusertab")
public class WhUserType{
	
	@Id
	@GeneratedValue
	@Column(name="ID")
	private Integer id;
	
	@Column(name="WhType")
	private String userType;
	
	@Column(name="WhCode")
	private String userCode;
	
	@Column(name="WhFor")
	private String userFor;
	
	@Column(name="email")
	private String userEmail;
	
	@Column(name="Contact")
	private String userContact;
	
	@Column(name="idType")
	private String uidType;
	
	@Column(name="Other")
	private String other;
	
	@Column(name="idnumber")
	private String uidNumber;

	public WhUserType() {
		super();
	}

	public WhUserType(Integer id) {
		super();
		this.id = id;
	}
	

	public WhUserType(String userType, String userCode, String userFor, String userEmail, String userContact,
			String uidType, String other, String uidNumber) {
		super();
		this.userType = userType;
		this.userCode = userCode;
		this.userFor = userFor;
		this.userEmail = userEmail;
		this.userContact = userContact;
		this.uidType = uidType;
		this.other = other;
		this.uidNumber = uidNumber;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	public String getUserFor() {
		return userFor;
	}

	public void setUserFor(String userFor) {
		this.userFor = userFor;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserContact() {
		return userContact;
	}

	public void setUserContact(String userContact) {
		this.userContact = userContact;
	}

	public String getUidType() {
		return uidType;
	}

	public void setUidType(String uidType) {
		this.uidType = uidType;
	}

	public String getOther() {
		return other;
	}

	public void setOther(String other) {
		this.other = other;
	}

	public String getUidNumber() {
		return uidNumber;
	}

	public void setUidNumber(String uidNumber) {
		this.uidNumber = uidNumber;
	}

	@Override
	public String toString() {
		return "WhUserType [id=" + id + ", userType=" + userType + ", userCode=" + userCode + ", userFor=" + userFor
				+ ", userEmail=" + userEmail + ", userContact=" + userContact + ", uidType=" + uidType + ", other="
				+ other + ", uidNumber=" + uidNumber + "]";
	}
	
	
	
}
