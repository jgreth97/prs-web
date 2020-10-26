package com.prs.business;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Product {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)//database increments the id by 1
	private int id;
	@ManyToOne
	@JoinColumn(name="VendorID")
	private Vendor vendor;
	private String partNumber;
	private String name;
	private Double price;
	private String unit;
	private String photoPath;

	public Product() {

	}

	public Product(int id, Vendor vendor, String partNumber, String name, Double price, String unit, String photoPath) {
		super();
		this.id = id;
		this.vendor = vendor;
		this.partNumber = partNumber;
		this.name = name;
		this.price = price;
		this.unit = unit;
		this.photoPath = photoPath;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Vendor getVendor() {
		return vendor;
	}

	public void setVendor(Vendor vendor) {
		this.vendor = vendor;
	}

	public String getPartNumber() {
		return partNumber;
	}

	public void setPartNumber(String partNumber) {
		this.partNumber = partNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getPhotoPath() {
		return photoPath;
	}

	public void setPhotoPath(String photoPath) {
		this.photoPath = photoPath;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", vendorId=" + vendor + ", partNumber=" + partNumber + ", name=" + name
				+ ", price=" + price + ", unit=" + unit + ", photoPath=" + photoPath + ", toString()=";

	}

	public String displayProduct() {
		String str = "-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+\n";
		str += "-+-+-+-+-+-+-+-+-+-+-+-+-Product-+-+-+-+-+-+-+-+-+-+-+-+-+\n";
		str += "-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+--+-+-\n";
		str += "ID:\t\t\t " + id + "\n";
		str += "Vendor Id:\t\t " + vendor + "\n";
		str += "Part Number:\t\t " + partNumber + "\n";
		str += "Name:\t\t\t " + name + "\n";
		str += "Price : \t\t " + price + "\n";
		str += "Unit:\t\t\t" + unit + "\n";
		str += "Photopath:\t\t" + photoPath + "\n";
		str += "-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-\n";

		return str;
	}
}