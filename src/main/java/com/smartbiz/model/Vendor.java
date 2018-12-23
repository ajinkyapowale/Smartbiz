package com.smartbiz.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.annotation.Persistent;

@Entity
@Table(name="vendor")
public class Vendor extends BaseModel implements Serializable {

	private Integer vid;
	private String name;
	
	public Vendor() {
	}
	
	public Vendor(String name) {
		super();
		this.name = name;
	}

	public Vendor(Integer vid, String name) {
		super();
		this.vid = vid;
		this.name = name;
	}

	@Id
	@Column
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getVid() {
		return vid;
	}
	public void setVid(Integer vid) {
		this.vid = vid;
	}

	@Column(name="name")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Vendor [vid=" + vid + ", name=" + name + "]";
	}

	
}
