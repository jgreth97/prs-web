package com.prs.business;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Vendor {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)//database increments the id by 1
		private int id;
		private String code;
		private String name;
		private String address;
		private String city;
		private String state;
		private String zip;
		private String phoneNumber;
		private String email;

		public Vendor() {

		}

		public Vendor(int id, String code, String name, String address, String city, String state, String zip,
				String phoneNumber, String email) {
			super();
			this.id = id;
			this.code = code;
			this.name = name;
			this.address = address;
			this.city = city;
			this.state = state;
			this.zip = zip;
			this.phoneNumber = phoneNumber;
			this.email = email;
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getCode() {
			return code;
		}

		public void setCode(String code) {
			this.code = code;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getAddress() {
			return address;
		}

		public void setAddress(String address) {
			this.address = address;
		}

		public String getCity() {
			return city;
		}

		public void setCity(String city) {
			this.city = city;
		}

		public String getState() {
			return state;
		}

		public void setState(String state) {
			this.state = state;
		}

		public String getZip() {
			return zip;
		}

		public void setZip(String zip) {
			this.zip = zip;
		}

		public String getPhoneNumber() {
			return phoneNumber;
		}

		public void setPhoneNumber(String phoneNumber) {
			this.phoneNumber = phoneNumber;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		@Override
		public String toString() {
			return "Vendor [id=" + id + ", code=" + code + ", name=" + name + ", address=" + address + ", city=" + city
					+ ", state=" + state + ", zip=" + zip + ", phoneNumber=" + phoneNumber + ", email=" + email;
		}
		
		public String displayVendor() {
			String str = "-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+\n";
			str += "-+-+-+-+-+-+-+-+-+-+-+-+-Vendor-+-+-+-+-+-+-+-+-+-+-+-+-+\n";
			str += "-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+--+-+-\n";
			str += "ID:\t\t " + id + "\n";
			str += "Code:\t\t " + code + "\n";
			str += "Name:\t\t " + name + "\n";
			str += "Address:\t " + address + "\n";
			str += "City : \t\t "+city+"\n";
			str += "State:\t\t"+state+"\n";
			str += "Zip:\t\t"+zip+"\n";
			str += "Phone Number \t"+phoneNumber+"\n";
			str += "Email:\t\t"+email+"\n";
			str += "-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-\n";

			return str;
		}

		}

