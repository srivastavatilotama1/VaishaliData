package com.capgemini.salesmanagement.bean;

import java.util.Date;

public class SalesBean
{
	private int salesId;
	private int productCode;
	private int quantity;
	private Date salesDate;
	private int lineTotal;
	
	public SalesBean(){} 
	
	@Override
	public String toString() {
		return "SalesBean [salesId=" + salesId + ", productCode=" + productCode
				+ ", quantity=" + quantity + ", salesDate=" + salesDate
				+ ", lineTotal=" + lineTotal + "]";
	}

	public int getSalesId() {
		return salesId;
	}

	public void setSalesId(int salesId) {
		this.salesId = salesId;
	}

	public int getProductCode() {
		return productCode;
	}

	public void setProductCode(int productCode) {
		this.productCode = productCode;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Date getSalesDate() {
		return salesDate;
	}

	public void setSalesDate(Date salesDate) {
		this.salesDate = salesDate;
	}

	public int getLineTotal() {
		return lineTotal;
	}

	public void setLineTotal(int lineTotal) {
		this.lineTotal = lineTotal;
	}

	public SalesBean(int salesId, int productCode, int quantity,
			Date salesDate, int lineTotal) {
		super();
		this.salesId = salesId;
		this.productCode = productCode;
		this.quantity = quantity;
		this.salesDate = salesDate;
		this.lineTotal = lineTotal;
	}
	
	
}
