package com.infra.mgmt.pojo;

import java.util.Date;

public class AssetInventory {
	
	public Long itemNumber;
	public String name;
	public String description;
	public String type;
	public Date dateOfLastOrder;
	public String vendor;
	public double pricePerItem;
	public int quantity;
	
	public Long getItemNumber() {
		return itemNumber;
	}
	public void setItemNumber(Long itemNumber) {
		this.itemNumber = itemNumber;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Date getDateOfLastOrder() {
		return dateOfLastOrder;
	}
	public void setDateOfLastOrder(Date dateOfLastOrder) {
		this.dateOfLastOrder = dateOfLastOrder;
	}
	public String getVendor() {
		return vendor;
	}
	public void setVendor(String vendor) {
		this.vendor = vendor;
	}
	public double getPricePerItem() {
		return pricePerItem;
	}
	public void setPricePerItem(double pricePerItem) {
		this.pricePerItem = pricePerItem;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	

}
