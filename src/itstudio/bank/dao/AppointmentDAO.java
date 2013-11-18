package itstudio.bank.dao;

import itstudio.bank.bean.Appointment;
/**
 * 预约处理接口
 * @author apple
 *
 */
public interface AppointmentDAO {
	
	public boolean addAppointment(Appointment appointment) ;//添加预约
}
