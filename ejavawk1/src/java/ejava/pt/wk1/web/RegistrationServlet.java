package ejava.pt.wk1.web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/register")
public class RegistrationServlet extends HttpServlet {

	//Managed objects
	@Inject private AllRegistration allReg;
	@Inject private Registration registration;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {

		System.out.println(">> registerservlet registration: " + registration);

		System.out.println(String.format("name = %s, emai = %s", 
				registration.getName(), registration.getEmail()));

		allReg.add();
		//allReg.add(registration.copy());

		for (Registration r: allReg.getRegistrations())
			System.out.println(">> r = " + r);

		resp.setStatus(HttpServletResponse.SC_ACCEPTED);
		resp.setContentType("text/html");
		try (PrintWriter pw = resp.getWriter()) {
			pw.println("<h2>Thank you</h2>");
		}
	}

	
	
}
