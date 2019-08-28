package com.smoothstack.lms.admin.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_publisher")
public class Publisher {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer publisherId;
    
    @Column(name = "publisherName")
	private String publisherName;
    
    @Column(name = "publisherAddress")
	private String publisherAddress;
    
    @Column(name = "publisherPhone")
	private String publisherPhone;

	public Publisher() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Publisher(Integer publisherId) {
		super();
		this.publisherId = publisherId;
	}

	public Publisher(Integer publisherId, String publisherName, String publisherAddress, String publisherPhone) {
		super();
		this.publisherId = publisherId;
		this.publisherName = publisherName;
		this.publisherAddress = publisherAddress;
		this.publisherPhone = publisherPhone;
	}

	public Publisher(String publisherName, String publisherAddress, String publisherPhone) {
		super();
		this.publisherName = publisherName;
		this.publisherAddress = publisherAddress;
		this.publisherPhone = publisherPhone;
	}

	public Integer getPublisherId() {
		return publisherId;
	}

	public void setPublisherId(Integer publisherId) {
		this.publisherId = publisherId;
	}

	public String getPublisherName() {
		return publisherName;
	}

	public void setPublisherName(String publisherName) {
		this.publisherName = publisherName;
	}

	public String getPublisherAddress() {
		return publisherAddress;
	}

	public void setPublisherAddress(String publisherAddress) {
		this.publisherAddress = publisherAddress;
	}

	public String getPublisherPhone() {
		return publisherPhone;
	}

	public void setPublisherPhone(String publisherPhone) {
		this.publisherPhone = publisherPhone;
	}

	@Override
	public String toString() {
		return "Publisher [publisherId=" + publisherId + ", publisherName=" + publisherName + ", publisherAddress="
				+ publisherAddress + ", publisherPhone=" + publisherPhone + "]";
	}
    

	
}
