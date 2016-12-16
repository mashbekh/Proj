package com.personal_details;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

@Path("/details")
public class PersonalDetailsDispatcher {
	
	Personal_settingsImpl p = new Personal_settingsImpl();

	@POST
	@Path("add_profile")
	public String add_profile(@QueryParam("user_id") Long user_id, @FormParam("company_name") String company_name, @FormParam("addr_line1") String addr_line1,@FormParam("addr_line2") String addr_line2,@FormParam("country") String country,@FormParam("state") String state,@FormParam("city") String city
			,@FormParam("pincode") String pincode,@FormParam("email") String email,@FormParam("code") String std_code,@FormParam("landline") String landline,@FormParam("mobile") String mobile,
			@FormParam("website") String website,@FormParam("tin_no") String tin_no,@FormParam("pan_no") String pan_no,@FormParam("cin_no") String cin_no)
	{
		
		String landline_no = std_code + landline;
		return p.add_company_profile(user_id,company_name,addr_line1, addr_line2,country,state,city,pincode,email,landline_no,mobile,website,tin_no,pan_no,cin_no);
	}
	
}

