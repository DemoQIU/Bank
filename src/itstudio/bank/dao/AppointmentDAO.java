package itstudio.bank.dao;

import java.util.List;

import itstudio.bank.bean.Appointment;
/**
 * 预约处理接口
 * @author apple
 *
 */
public interface AppointmentDAO {
	
	public boolean addAppointment(Appointment appointment) ;//添加预约
	public List<Appointment> FindAppointmentList(int currentPage,int i) ;//查询预约列表 int currentPage代表当前页数  int i 0 代表已读 1 代表未读
	public List<Appointment> FindAppointmentById(Appointment appointment) ;//查询具体预约
	public List<Appointment> deleteAppointment(int id) ;//删除预约
}
