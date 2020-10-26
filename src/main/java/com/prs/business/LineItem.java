package com.prs.business;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class LineItem {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)//database increments the id by 1
	private int id;
	private Request request;
	private int productId;
	private int quantity;
	

	public LineItem() {

	}


	public LineItem(int id, Request request, int productId, int quantity) {
		super();
		this.id = id;
		this.request = request;
		this.productId = productId;
		this.quantity = quantity;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public Request getRequest() {
		return request;
	}


	public void setRequest(Request request) {
		this.request = request;
	}


	public int getProductId() {
		return productId;
	}


	public void setProductId(int productId) {
		this.productId = productId;
	}


	public int getQuantity() {
		return quantity;
	}


	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


	@Override
	public String toString() {
		return "LineItem [id=" + id + ", requestId=" + request + ", productId=" + productId + ", quantity=" + quantity
				+ "]";
	}
	public String displayLineItem() {
		String str = "-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+\n";
		str += "-+-+-+-+-+-+-+-+-+-+-+-+-LineItem-+-+-+-+-+-+-+-+-+-+-+-+-+\n";
		str += "-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+--+-+-\n";
		str += "ID:\t\t\t " + id + "\n";
		str += "Request Id:\t\t " + request + "\n";
		str += "Product Id:\t\t " + productId + "\n";
		str += "Quantity:\t\t " + quantity + "\n";
		str += "-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-\n";
		

		return str;
	}
}