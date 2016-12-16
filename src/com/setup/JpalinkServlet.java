package com.setup;

import java.io.IOException;
import javax.servlet.http.*;

@SuppressWarnings("serial")
public class JpalinkServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		Register e= new Register();
		resp.setContentType("text/plain");
		resp.getWriter().println("Hello, world");
		//resp.getWriter().println(e.add_user("hello", "hejkjkllo@pp.com", "Yo!"));
	}
}
