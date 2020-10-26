package com.prs.business;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Request {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)//database increments the id by 1
	private int id;
	@ManyToOne
	@JoinColumn(name="UserID")
	private User user;
	private String description;
	private String justification;
	private LocalDate dateNeeded;
	private String deliveryMode;
	private String status;
	private Double total;
	private LocalDateTime submittedDate;
	private String reasonForRejection;
	public Request() {

	}

	public Request(int id, User user, String description, String justification, LocalDate dateNeeded, String deliveryMode,
			String status, Double total, LocalDateTime submittedDate, String reasonForRejection) {
		super();
		this.id = id;
		this.user = user;
		this.description = description;
		this.justification = justification;
		this.dateNeeded = dateNeeded;
		this.deliveryMode = deliveryMode;
		this.status = status;
		this.total = total;
		this.submittedDate = submittedDate;
		this.reasonForRejection = reasonForRejection;

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getJustification() {
		return justification;
	}

	public void setJustification(String justification) {
		this.justification = justification;
	}

	public LocalDate getDateNeeded() {
		return dateNeeded;
	}

	public void setDateNeeded(LocalDate dateNeeded) {
		this.dateNeeded = dateNeeded;
	}

	public String getDeliveryMode() {
		return deliveryMode;
	}

	public void setDeliveryMode(String deliveryMode) {
		this.deliveryMode = deliveryMode;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public LocalDateTime getSubmittedDate() {
		return submittedDate;
	}

	public void setSubmittedDate(LocalDateTime submittedDate) {
		this.submittedDate = submittedDate;
	}

	public String getReasonForRejection() {
		return reasonForRejection;
	}

	public void setReasonForRejection(String reasonForRejection) {
		this.reasonForRejection = reasonForRejection;
	}
	

	@Override
	public String toString() {
		return "Request [id= " + id + ", userId= " + user + ", description= " + description + ", justification= "
				+ justification + ", dateNeeded= " + dateNeeded + ", deliveryMode= " + deliveryMode + ", status= " + status
				+ ", total= " + total + ", submitDate= " + submittedDate + ", reasonForRejection= " + reasonForRejection;
				
	}
	public String displayRequest() {
		String str = "============================================\n";
		str += "========================Request===========================\n";
		str += "=====================================================\n";
		str += "ID:\t\t\t " + id + "\n";
		str += "User Id:\t\t " + user + "\n";
		str += "Justification:\t\t " + justification + "\n";
		str += "Date Needed:\t\t " + dateNeeded + "\n";
		str += "Delivery Mode: \t\t " + deliveryMode + "\n";
		str += "Status:\t\t\t" + status + "\n";
		str += "Total:\t\t\t" + total + "\n";
		str += "Submitted Date: \t"+submittedDate+"\n";
		str += "Reason For Rejection: \t"+reasonForRejection+"\n";
		str += "======================================================\n";
		

		return str;
	}
}
