package itstudio.bank.dao;

import java.util.List;

import itstudio.bank.bean.Appointment;
/**
 * ԤԼ����ӿ�
 * @author apple
 *
 */
public interface AppointmentDAO {
	
	public boolean addAppointment(Appointment appointment) ;//���ԤԼ
	public List<Appointment> FindAppointmentList(int currentPage,int i) ;//��ѯԤԼ�б� int currentPage����ǰҳ��  int i 0 �����Ѷ� 1 ����δ��
	public List<Appointment> FindAppointmentById(Appointment appointment) ;//��ѯ����ԤԼ
	public List<Appointment> deleteAppointment(int id) ;//ɾ��ԤԼ
}
