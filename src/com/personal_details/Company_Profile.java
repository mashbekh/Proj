package com.personal_details;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.setup.User_login;

@Entity
@Table(name = "company_profile")
public class Company_Profile {
	
	private String company_name;
	private String address_line1;
	private String address_line2;
	private String country;
	private String state;
	private String city;
	private String pincode;
	private String landline_no;
	private String email;
	private String mobile_no;
	private String website;
	private String tin_no;
	private String pan_no;
	private String cin_no;
	private long profile_id;
	
	
    @Id	
	public long getProfile_id() {
		return profile_id;
	}
	public void setProfile_id(long profile_id) {
		this.profile_id = profile_id;
	}
	
	private User_login user;
	
	
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Company_Profile() {
		super();
	}
	public Company_Profile(String company_name, String address_line1, String address_line2, String country,
			String state, String city, String pincode,String email ,String landline_no, String mobile_no,
			String website, String tin_no, String pan_no, String cin_no, User_login user) {
		super();
		this.company_name = company_name;
		this.address_line1 = address_line1;
		this.address_line2 = address_line2;
		this.country = country;
		this.state = state;
		this.city = city;
		this.pincode = pincode;
		this.landline_no = landline_no;
		this.email = email;
		this.mobile_no = mobile_no;
		this.website = website;
		this.tin_no = tin_no;
		this.pan_no = pan_no;
		this.cin_no = cin_no;
		this.user = user;
	}
	@Override
	public String toString() {
		return "Company_Profile [company_name=" + company_name + ", address_line1=" + address_line1 + ", address_line2="
				+ address_line2 + ", country=" + country + ", state=" + state + ", city=" + city + ", pincode="
				+ pincode + ", landline_no=" + landline_no + ", email=" + email + ", mobile_no=" + mobile_no
				+ ", website=" + website + ", tin_no=" + tin_no + ", pan_no=" + pan_no + ", cin_no=" + cin_no
				+ ", user_id=" + user.toString() + "]";
	}
	public String getCompany_name() {
		return company_name;
	}
	public void setCompany_name(String company_name) {
		this.company_name = company_name;
	}
	public String getAddress_line1() {
		return address_line1;
	}
	public void setAddress_line1(String address_line1) {
		this.address_line1 = address_line1;
	}
	public String getAddress_line2() {
		return address_line2;
	}
	public void setAddress_line2(String address_line2) {
		this.address_line2 = address_line2;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	public String getLandline_no() {
		return landline_no;
	}
	public void setLandline_no(String landline_no) {
		this.landline_no = landline_no;
	}
	public String getMobile_no() {
		return mobile_no;
	}
	public void setMobile_no(String mobile_no) {
		this.mobile_no = mobile_no;
	}
	public String getWebsite() {
		return website;
	}
	public void setWebsite(String website) {
		this.website = website;
	}
	public String getTin_no() {
		return tin_no;
	}
	public void setTin_no(String tin_no) {
		this.tin_no = tin_no;
	}
	public String getPan_no() {
		return pan_no;
	}
	public void setPan_no(String pan_no) {
		this.pan_no = pan_no;
	}
	public String getCin_no() {
		return cin_no;
	}
	public void setCin_no(String cin_no) {
		this.cin_no = cin_no;
	}
	
	public User_login getUser_id() {
		return user;
	}
	public void setUser_id(User_login user_id) {
		this.user= user_id;
	}
	
	
	
	
}
