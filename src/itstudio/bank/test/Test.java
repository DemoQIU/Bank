package itstudio.bank.test;

import java.util.Date;

import itstudio.bank.bean.Admin;
import itstudio.bank.bean.Appointment;
import itstudio.bank.daoimp.AdminDAOImp;
import itstudio.bank.daoimp.AppointmentDAOImp;
public class Test {
	public static void main(String[] args) {
		AdminDAOImp dao = new AdminDAOImp();
		
		//��ѯ ����ѧ��
    	System.out.println("��½��֤");
    	Admin admin = new Admin ("123","3r223sew");
    	System.out.println(dao.login(admin));	
    	//���ԤԼ
    	AppointmentDAOImp appointmentDAOImp= new AppointmentDAOImp();
    	Appointment app= new Appointment("xiaosan",12345,"673463786@qq.com",new Date(),"����","ceshi");
    	//appointmentDAOImp.addAppointment(app);
	}
}
