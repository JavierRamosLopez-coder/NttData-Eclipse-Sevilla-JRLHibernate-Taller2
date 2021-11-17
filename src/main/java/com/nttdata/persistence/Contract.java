package com.nttdata.persistence;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * Clase contrato
 * 
 * @author jramlope
 *
 */
@Entity
@Table(name = "NTTDATA_CONTRACTS")
public class Contract extends AbstractEntity implements Serializable {

	/** Atributo Serial **/
	private static final long serialVersionUID = 1L;
	
	/** Número de identificación (PK) **/
	private Long contractNumericIdentifier;
	
	/** Fecha de vigencia **/
	private Date effectiveDate;
	
	/** Fecha de caducidad **/
	private Date expiryDate;
	
	/** Precio mensual **/
	private Double monthlyPrice;
	
	/** Cliente **/
	private Cliente customer;

	/**
	 * @return the contractNumericIdentifier
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="CONTRACT_NUMERIC_IDENTIFIER")
	public Long getContractNumericIdentifier() {
		return contractNumericIdentifier;
	}

	/**
	 * @param contractNumericIdentifier the contractNumericIdentifier to set
	 */
	public void setContractNumericIdentifier(Long contractNumericIdentifier) {
		this.contractNumericIdentifier = contractNumericIdentifier;
	}

	/**
	 * @return the effectiveDate
	 */
	@Column(name="EFFECTIVE_DATE")
	public Date getEffectiveDate() {
		return effectiveDate;
	}

	/**
	 * @param effectiveDate the effectiveDate to set
	 */
	public void setEffectiveDate(Date effectiveDate) {
		this.effectiveDate = effectiveDate;
	}

	/**
	 * @return the expiryDate
	 */
	@Column(name="EXPIRY_DATE")
	public Date getExpiryDate() {
		return expiryDate;
	}

	/**
	 * @param expiryDate the expiryDate to set
	 */
	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}

	/**
	 * @return the monthlyPrice
	 */
	@Column(name="MONTHLY_PRICE")
	public Double getMonthlyPrice() {
		return monthlyPrice;
	}

	/**
	 * @param monthlyPrice the monthlyPrice to set
	 */
	public void setMonthlyPrice(Double monthlyPrice) {
		this.monthlyPrice = monthlyPrice;
	}

	/**
	 * @return the customer
	 */
	
	@ManyToOne()
	@JoinColumn(name = "NUMERIC_IDENTIFIER")
	public Cliente getCustomer() {
		return customer;
	}

	/**
	 * @param customer the customer to set
	 */
	public void setCustomer(Cliente customer) {
		this.customer = customer;
	}
	
	@Transient
	public Class<?> getClase() {
		return Contract.class;
	}

	@Override
	public String toString() {
		return "Contract [contractNumericIdentifier=" + contractNumericIdentifier + ", effectiveDate=" + effectiveDate
				+ ", expiryDate=" + expiryDate + ", monthlyPrice=" + monthlyPrice + ", customer=" + customer + "]";
	}
	
	
	

}
