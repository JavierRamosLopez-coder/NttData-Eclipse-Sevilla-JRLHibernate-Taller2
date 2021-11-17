package com.nttdata.persistence;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

/**
 * Clase Abstracta
 * @author jramlope
 *
 */
@MappedSuperclass
public abstract class AbstractEntity implements Serializable{

	/** Atributo serial **/
	private static final long serialVersionUID = 1L;
	
	/** Usuario que actualiza **/
	private String updatedUser;

	/** Día que se actualiza **/
	private Date updatedDate;

	/**
	 * @return the updatedUser
	 */
	@Column(name = "A_UPDATE_USER",nullable = false)
	public String getUpdatedUser() {
		return updatedUser;
	}

	/**
	 * @param updatedUser the updatedUser to set
	 */
	public void setUpdatedUser(String updatedUser) {
		this.updatedUser = updatedUser;
	}

	/**
	 * @return the updatedDate
	 */
	@Column(name = "A_UPDATE_DATE",nullable = false)
	public Date getUpdatedDate() {
		return updatedDate;
	}

	/**
	 * @param updatedDate the updatedDate to set
	 */
	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}
	
	

}
