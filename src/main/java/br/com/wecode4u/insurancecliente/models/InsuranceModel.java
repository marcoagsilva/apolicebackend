package br.com.wecode4u.insurancecliente.models;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Insurance")
public class InsuranceModel implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "insurance_id")
	private Long insuranceUID;
	
	@Column(name = "startDate", nullable = false)
	private Date startDate;
	
	@Column(name = "endDate", nullable = false)
	private Date endDate;
	
	@Column(name = "licensePlate", nullable = false, unique = true)
	private String licensePlate;
	
	@Column(name = "insuranceValue")
	private float insuranceValue;
	
	@ManyToOne
	@JoinColumn(name = "customer_id")
	private CustomerModel customer;

	public Long getInsuranceUID() {
		return insuranceUID;
	}

	public void setInsuranceUID(Long insuranceUID) {
		this.insuranceUID = insuranceUID;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getLicensePlate() {
		return licensePlate;
	}

	public void setLicensePlate(String licensePlate) {
		this.licensePlate = licensePlate;
	}

	public float getInsuranceValue() {
		return insuranceValue;
	}

	public void setInsuranceValue(float insuranceValue) {
		this.insuranceValue = insuranceValue;
	}

	public CustomerModel getCustomer() {
		return customer;
	}

	public void setCustomer(CustomerModel customer) {
		this.customer = customer;
	}
}
