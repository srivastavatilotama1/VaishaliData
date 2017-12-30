package com.capgemini.salesmanagement.bean;

public class ProductBean
{
	private int productCode;
	private String productName;
	private String productCategory;
	private String productDescription;
	private int productPrice;
	
	public ProductBean(){}
	
	public int getProductCode() {
		return productCode;
	}
	public ProductBean(int productCode, String productName,
			String productCategory, String productDescription, int productPrice) {
		super();
		this.productCode = productCode;
		this.productName = productName;
		this.productCategory = productCategory;
		this.productDescription = productDescription;
		this.productPrice = productPrice;
	}
	@Override
	public String toString() {
		return "ProductBean [productCode=" + productCode + ", productName="
				+ productName + ", productCategory=" + productCategory
				+ ", productDescription=" + productDescription
				+ ", productPrice=" + productPrice + "]";
	}
	public void setProductCode(int productCode) {
		this.productCode = productCode;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductCategory() {
		return productCategory;
	}
	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}
	public String getProductDescription() {
		return productDescription;
	}
	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}
	public int getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}
}
