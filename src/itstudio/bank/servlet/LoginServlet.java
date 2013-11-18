package itstudio.bank.servlet;

import itstudio.bank.bean.Admin;
import itstudio.bank.daoimp.AdminDAOImp;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String path = "login.jsp" ;
		request.setCharacterEncoding("utf8");
		String uname = request.getParameter("name") ;
		String password = request.getParameter("password") ;
		Admin admin = new Admin (uname,password);
		AdminDAOImp dao = new AdminDAOImp();
		if(dao.login(admin)){
			System.out.println("³É¹¦µÇÂ½");
			request.getSession().setAttribute("uname",uname) ;
		}
		else{
			
		}
		request.getRequestDispatcher(path).forward(request,response) ;
	}

}
