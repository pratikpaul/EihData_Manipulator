package com.self.eihDrive.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "EIH_APP_ROLES")
public class EihAppRoles implements Serializable{
	@Id
	@GenericGenerator(name = "custominc", strategy = "increment")
	@GeneratedValue(generator = "custominc")
	@Column(name = "role_id")
	private int roleId;
	@Column(name = "app_id")
	private int appId;

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public int getAppId() {
		return appId;
	}

	public void setAppId(int appId) {
		this.appId = appId;
	}

}
