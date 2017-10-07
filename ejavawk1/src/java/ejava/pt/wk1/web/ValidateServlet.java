package ejava.pt.wk1.web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/validate")
public class ValidateServlet extends HttpServlet  {

	@Inject private AllRegistration allReg;
	@Inject private Registration registration;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		
		final String name = req.getParameter("name");
		final String email = req.getParameter("email");

		System.out.println(">> validateservlet registration: " + registration);

		registration.setEmail(email);
		registration.setName(name);

		System.out.println(">>> reg = " + registration.getClass());

		/*
		for (Registration r: allReg.getRegistrations())
			if (r.getName().equals(name)) {
				resp.setStatus(HttpServletResponse.SC_NOT_ACCEPTABLE);
				resp.setContentType("text/plain");
				try (PrintWriter pw = resp.getWriter()) {
					pw.println("Curb your enthusiasm");
				}
				return;
			}
		*/

		req.getRequestDispatcher("register").forward(req, resp);
	}

	
	
}
