package itstudio.bank.servlet;

import itstudio.bank.bean.Appointment;
import itstudio.bank.daoimp.AppointmentDAOImp;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AppointmentServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String path = "xxxx.jsp" ;
		request.setCharacterEncoding("utf8");
		
		String name = request.getParameter("name") ;
		float tellphone = Integer.parseInt(request.getParameter("tellphone")) ;;
		String email =request.getParameter("email") ;;
		DateFormat date=new SimpleDateFormat("yyyy-MM-dd HH:mm");
		Date time =null;
		try {
			 time =date.parse(request.getParameter("time"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		String type = request.getParameter("type"); 
		String content = request.getParameter("content"); 
		Appointment app= new Appointment(name, tellphone, email, time, type, content);
		AppointmentDAOImp appointmentDAOImp= new AppointmentDAOImp();
    	if(appointmentDAOImp.addAppointment(app)){
    		System.out.println("Ô¤Ô¼³É¹¦");
    	}
    	else{
    		
    	}
    	request.getRequestDispatcher(path).forward(request,response) ;
	}


}
