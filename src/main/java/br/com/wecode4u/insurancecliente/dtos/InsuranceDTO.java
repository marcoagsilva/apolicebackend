package br.com.wecode4u.insurancecliente.dtos;

import java.sql.Date;

import javax.validation.constraints.NotBlank;

import br.com.wecode4u.insurancecliente.models.CustomerModel;

public class InsuranceDTO {
	
	@NotBlank
	private Long insuranceUID;
	
	@NotBlank
	private Date startDate;
	
	@NotBlank
	private Date endDate;
	
	@NotBlank
	private String licensePlate;
	
	@NotBlank
	private float insuranceValue;
	
	@NotBlank
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
