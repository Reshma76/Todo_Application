package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.UserDto;

@WebServlet("/home")
public class Loadhome extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	 	UserDto dto = (UserDto) req.getSession().getAttribute("user");
	 	if(dto==null)
	 	{
	 		resp.getWriter().print("<h1 align='center' style='color:red'>>Session Expired, Login Again</h1>");
	 		req.getRequestDispatcher("Login.jsp").include(req, resp);
	 	}
	 	else
	 	{
	 		req.setAttribute("list", dto.getTasks());
	 		req.getRequestDispatcher("Home.jsp").include(req, resp);
	 	}
	}
}
