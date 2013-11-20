package itstudio.bank.test;

import java.util.Date;

import itstudio.bank.bean.Admin;
import itstudio.bank.bean.Appointment;
import itstudio.bank.daoimp.AdminDAOImp;
import itstudio.bank.daoimp.AppointmentDAOImp;
public class Test {
	public static void main(String[] args) {
		AdminDAOImp dao = new AdminDAOImp();
		
		//登陆验证
    	System.out.println("登陆验证");
    	Admin admin = new Admin ("123","3r223sew");
    	System.out.println(dao.login(admin));	
    	//添加预约
    	AppointmentDAOImp appointmentDAOImp= new AppointmentDAOImp();
    	Appointment app= new Appointment("xiaosan",12345,"673463786@qq.com",new Date(),"汉子","ceshi");
    	//appointmentDAOImp.addAppointment(app);
    	//查询未读预约
		for ( Appointment  appointment:appointmentDAOImp.findAppointmentList(1, 0))
		{
			System.out.println( appointment.getId());
		}
		//查询已读预约
		for ( Appointment  appointment:appointmentDAOImp.findAppointmentList(1, 1))
		{
			System.out.println( appointment.getId());
		}
		// 查询具体的某一个预约
		System.out.println(appointmentDAOImp.findAppointmentById(1));
		// 删除某一个预约
		System.out.println(appointmentDAOImp.deleteAppointment(1));
	}
}
