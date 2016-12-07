package com.jpa;

import java.io.IOException;
import javax.servlet.http.*;

@SuppressWarnings("serial")
public class JpalinkServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		//Eclipselinktest e= new Eclipselinktest();
		resp.setContentType("text/plain");
		resp.getWriter().println("Hello, world");
		//resp.getWriter().println(e.abc());
	}
}
