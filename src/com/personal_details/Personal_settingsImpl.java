package com.personal_details;

import com.setup.User_login;

public class Personal_settingsImpl implements Personal_settings{


	@Override
	public String add_company_profile(Long id, String company_name, String addr_line1, String addr_line2,String country, String state, String city, String pincode,String email,
			String landline, String mobile, String website, String tin_no, String pan_no , String cin_no) {
		
		//User_login user new User_login();
		//Company_Profile cp =  new Company_Profile(company_name,addr_line1,addr_line2,country,state,city,pincode,email,landline,mobile,website,tin_no,pan_no,cin_no,23);
		return null;
		//return  cp.toString();
	}

	@Override
	public String update_company_profile(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String view_company_profile(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
