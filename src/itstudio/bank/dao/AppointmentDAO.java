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
	public List<Appointment> findAppointmentList(int currentPage,int i) ;//��ѯԤԼ�б� int currentPage����ǰҳ��  int i 0 �����Ѷ� 1 ����δ��
	public Appointment findAppointmentById(int id) ;//��ѯ����ԤԼ
	public boolean deleteAppointment(int id) ;//ɾ��ԤԼ
}
