package controller;

import java.io.IOException;
import java.time.LocalDate;
import java.time.Period;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.UserDto;
import service.UserService;

@WebServlet("/signup")
public class Signup extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		LocalDate dob=LocalDate.parse(req.getParameter("dob"));
		
		UserDto dto = new UserDto();
		dto.setName(req.getParameter("name"));
		dto.setEmail(req.getParameter("email"));
		dto.setPassword(req.getParameter("password"));
		dto.setGender(req.getParameter("gender"));
		dto.setMobile(Long.parseLong(req.getParameter("mobile")));
		dto.setDob(dob);
		dto.setAge(Period.between(dob, LocalDate.now()).getYears());
		
		UserService service = new UserService();
		if(service.saveUser(dto))
		{
			resp.getWriter().print("<h1 align='center' style='color:green'>Account created success</h1>");
			req.getRequestDispatcher("Login.html").include(req, resp);
		}
		else
		{
			resp.getWriter().print("<h1 align='center' style='color:red'>Sorry!! Account cannot be Created</h1>");
			req.getRequestDispatcher("Signup.html").include(req, resp);
		}
		
	}
}
