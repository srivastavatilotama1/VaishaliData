package com.cg.skyStar.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "SKYCustomers")
public class SkyStar {
	
	@Id
	@Column(name= "custNum", length=10)
	private String custNum;
	
	@Column(name= "basePack", length=10)
	private String basePack;
	
	@Column(name = "optionalPack")
	private String optionalPack;

	public String getCustNum() {
		return custNum;
	}

	public void setCustNum(String custNum) {
		this.custNum = custNum;
	}

	public String getBasePack() {
		return basePack;
	}

	public void setBasePack(String basePack) {
		this.basePack = basePack;
	}

	public String getOptionalPack() {
		return optionalPack;
	}

	public void setOptionalPack(String optionalPack) {
		this.optionalPack = optionalPack;
	}


	
}
