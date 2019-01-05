package com.airtel.demo.dto;

public interface CustomerDto {
	
	/**
	 * @return the id
	 */
	public String getId();

	/**
	 * @param id the id to set
	 */
	public void setId(String id);

	/**
	 * @return the name
	 */
	public String getName();

	/**
	 * @param name the name to set
	 */
	public void setName(String name);

	/**
	 * @return the phone
	 */
	public String getPhone();

	/**
	 * @param phone the phone to set
	 */
	public void setPhone(String phone);

	/**
	 * @return the email
	 */
	public String getEmail();

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email);

	/**
	 * @return the kycStatus
	 */
	public String getKycStatus();

	/**
	 * @param kycStatus the kycStatus to set
	 */
	public void setKycStatus(String kycStatus);

	/**
	 * @return the aadhaarNumber
	 */
	public String getAadhaarNumber();

	/**
	 * @param aadhaarNumber the aadhaarNumber to set
	 */
	public void setAadhaarNumber(String aadhaarNumber);

	/**
	 * @return the panNumber
	 */
	public String getPanNumber();

	/**
	 * @param panNumber the panNumber to set
	 */
	public void setPanNumber(String panNumber);
}