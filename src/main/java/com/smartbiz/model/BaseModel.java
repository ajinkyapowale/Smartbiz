package com.smartbiz.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;


@EntityListeners(AuditingEntityListener.class)
@MappedSuperclass
public class BaseModel implements Serializable {
	
	private Date createdOn;
	private Date updatedOn;
	private Integer createdBy;
	private Integer updatedBy;
	private String status;
	private String deleted;
	
	public BaseModel() {
	}

	public BaseModel(Date createdOn, Date updatedOn, Integer createdBy, Integer updatedBy, String status,
			String deleted) {
		super();
		this.createdOn = createdOn;
		this.updatedOn = updatedOn;
		this.createdBy = createdBy;
		this.updatedBy = updatedBy;
		this.status = status;
		this.deleted = deleted;
	}

	@Column (name="created_on")
	@CreatedDate
	@Temporal(TemporalType.TIMESTAMP)
	public Date getCreatedOn() {
		return createdOn;
	}
	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}
	
	@Column (name="updated_on")
	@LastModifiedDate
	@Temporal(TemporalType.TIMESTAMP)
	public Date getUpdatedOn() {
		return updatedOn;
	}
	public void setUpdatedOn(Date updatedOn) {
		this.updatedOn = updatedOn;
	}
	
	@Column (name="created_by")
	@CreatedBy
	public Integer getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(Integer createdBy) {
		this.createdBy = createdBy;
	}
	
	@Column (name="updated_by")
	@LastModifiedBy
	public Integer getUpdatedBy() {
		return updatedBy;
	}
	public void setUpdatedBy(Integer updatedBy) {
		this.updatedBy = updatedBy;
	}
	
	@Column (name="status")
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	@Column (name="deleted")
	public String getDeleted() {
		return deleted;
	}
	public void setDeleted(String deleted) {
		this.deleted = deleted;
	}

	@Override
	public String toString() {
		return "BaseModel [createdOn=" + createdOn + ", updatedOn=" + updatedOn + ", createdBy=" + createdBy
				+ ", updatedBy=" + updatedBy + ", status=" + status + ", deleted=" + deleted + "]";
	}
	
}
