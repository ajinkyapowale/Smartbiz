package com.smartbiz.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="user")

/*@JsonIgnoreProperties(value = {"createdAt", "updatedAt"}, 
        allowGetters = true)*/
public class User extends BaseModel implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	private Integer uid;
	//private Integer ugid;
	private UserGroup userGroup;
	private String firstName;
	private String lastName;
	private String emailId;
	private String password;
	
	public User() {
	}
	
	
	public User(Integer uid, /*Integer ugid,*/ UserGroup userGroup, String firstName, String lastName, String emailId,
			String password) {
		super();
		this.uid = uid;
		//this.ugid = ugid;
		this.userGroup = userGroup;
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailId = emailId;
		this.password = password;
	}



	@Id
	@Column
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}

	/*@Column (name="userGroup")
	public Integer getUgid() {
		return ugid;
	}
	public void setUgid(Integer ugid) {
		this.ugid = ugid;
	}*/


	@JoinColumn(name = "user_group")
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
	public UserGroup getUserGroup() {
		return userGroup;
	}
	public void setUserGroup(UserGroup userGroup) {
		this.userGroup = userGroup;
	}

	@Column (name="first_name")
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@Column (name="last_name")
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	@Column (name="email_id")
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	@Column (name="password")
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [uid=" + uid + ", userGroup=" + userGroup + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", emailId=" + emailId + ", password=" + password + "]";
	}
	
}
