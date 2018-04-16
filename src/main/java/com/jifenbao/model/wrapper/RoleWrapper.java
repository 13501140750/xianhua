package com.jifenbao.model.wrapper;

import java.io.Serializable;

import com.jifenbao.model.Role;

public class RoleWrapper implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -25765349440435535L;


	/**
	 * 是否启用
	 */
	private boolean enabled;

	private Role role;

	public RoleWrapper(Role role){
		this.role = role;
		this.enabled = false;
	}
	
	/**
	 * @return the enabled
	 */
	public boolean isEnabled() {
		return enabled;
	}

	/**
	 * @param enabled the enabled to set
	 */
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	/**
	 * @return the role
	 */
	public Role getRole() {
		return role;
	}

	/**
	 * @param role the role to set
	 */
	public void setRole(Role role) {
		this.role = role;
	}

}
