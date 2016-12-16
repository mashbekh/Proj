package com.personal_details;

public interface Personal_settings {
	
	public String add_company_profile(Long id, String company_name, String addr_line1, String addr_line2,String country, String state, String city, String pincode,String email,
			String landline, String mobile, String website, String tin_no, String pan_no , String cin_no);
	public String update_company_profile(Long id);
	public String view_company_profile(Long id);

}
