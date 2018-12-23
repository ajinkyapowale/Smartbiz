package com.smartbiz.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
/**
 * 
 * @author Ajinkya
 *
 */
@Entity
@Table(name="user_group")
public class UserGroup extends BaseModel implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private Integer ugid;
	private String groupName;
	private List<User> users;
	
	public UserGroup() {
	}

	public UserGroup(Integer ugid, String groupName) {
		super();
		this.ugid = ugid;
		this.groupName = groupName;
	}

	@Id
	@Column
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getUgid() {
		return ugid;
	}
	public void setUgid(Integer ugid) {
		this.ugid = ugid;
	}

	@Column (name="group_name")	
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	public List<User> getUsers() {
		return users;
	}
	public void setUsers(List<User> users) {
		this.users = users;
	}

	@Override
	public String toString() {
		return "UserGroup [ugid=" + ugid + ", groupName=" + groupName + "]";
	}
	
}
