package com.infra.mgmt.pojo;

import java.util.Date;

public class EmployeeRequest {

	public String employeeName;
	public String item;
	public Long itemNumber;
	public Date dateOfOrder;
	public String Status;
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public String getItem() {
		return item;
	}
	public void setItem(String item) {
		this.item = item;
	}
	public Long getItemNumber() {
		return itemNumber;
	}
	public void setItemNumber(Long itemNumber) {
		this.itemNumber = itemNumber;
	}
	public Date getDateOfOrder() {
		return dateOfOrder;
	}
	public void setDateOfOrder(Date dateOfOrder) {
		this.dateOfOrder = dateOfOrder;
	}
	public String getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
	}
	
}
