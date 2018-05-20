package com.infra.mgmt.pojo;

import java.util.Date;

public class OrderTracking {
	
	public Long orderNumber;
	public Long itemNumber;
	public int quantity;
	public String vendor;
	public String processor;
	public Date dateOfOrder;
	public String orderStatus;
	public Date expectedDateOfDelivery;
	public String message;
	public String currentStatus;
	
	public Long getOrderNumber() {
		return orderNumber;
	}
	public void setOrderNumber(Long orderNumber) {
		this.orderNumber = orderNumber;
	}
	public Long getItemNumber() {
		return itemNumber;
	}
	public void setItemNumber(Long itemNumber) {
		this.itemNumber = itemNumber;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getVendor() {
		return vendor;
	}
	public void setVendor(String vendor) {
		this.vendor = vendor;
	}
	public String getProcessor() {
		return processor;
	}
	public void setProcessor(String processor) {
		this.processor = processor;
	}
	public Date getDateOfOrder() {
		return dateOfOrder;
	}
	public void setDateOfOrder(Date dateOfOrder) {
		this.dateOfOrder = dateOfOrder;
	}
	public String getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	public Date getExpectedDateOfDelivery() {
		return expectedDateOfDelivery;
	}
	public void setExpectedDateOfDelivery(Date expectedDateOfDelivery) {
		this.expectedDateOfDelivery = expectedDateOfDelivery;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getCurrentStatus() {
		return currentStatus;
	}
	public void setCurrentStatus(String currentStatus) {
		this.currentStatus = currentStatus;
	}
	
}
