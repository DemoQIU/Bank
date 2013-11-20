package itstudio.bank.daoimp;

import itstudio.bank.bean.Appointment;
import itstudio.bank.dao.AppointmentDAO;

import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;
/**
 * ���� ԤԼ�����ҵ����
 * @author apple
 *
 */
public class AppointmentDAOImp implements AppointmentDAO{
	private static SqlMapClient sqlMapClient=null;
	private int start ;
	private final int PAGESIZE =2 ;
	
	static {
		try {
			Reader reader=com.ibatis.common.resources.Resources.getResourceAsReader("itstudio/bank/config/SqlMapConfig.xml");
			sqlMapClient = com.ibatis.sqlmap.client.SqlMapClientBuilder.buildSqlMapClient(reader);
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
}
	/**
	 * ���ԤԼ
	 * @param Appointment ԤԼ
	 * @return boolean  �Ƿ����ԤԼ�ɹ�
	 */
	public boolean addAppointment(Appointment appointment) {
		// TODO Auto-generated method stub
		appointment.setSystemTime(new Date());
		try {
			sqlMapClient.insert("addAppointment",appointment);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	/**
	 * ��ȡԤԼ�б�
	 * @param int currentPage ��ǰҳ��
	 * @param int choice 0 ����δ�� 1 �����Ѷ�
	 * @return boolean  �Ƿ����ԤԼ�ɹ�
	 */
	public List<Appointment> findAppointmentList(int currentPage, int choice) {
		// TODO Auto-generated method stub
		List<Appointment> appointmentList=null;
		try {
			HashMap<String, Object> map = new HashMap<String, Object>();  
			start = (currentPage-1)*PAGESIZE;
			map.put("start", start);
			map.put("end", PAGESIZE);
			if(choice==0){
				appointmentList= sqlMapClient.queryForList("findAppoinListnoread",map);
			}
			else if(choice==1){
				appointmentList= sqlMapClient.queryForList("findAppoinListread",map);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return appointmentList;
	}
	/**
	 * ��ȡԤԼ����
	 * @param int id ԤԼ���
	 * @return Appointment ԤԼ����
	 */
	public Appointment findAppointmentById(int id) {
		// TODO Auto-generated method stub
		Appointment appointment = null;
		try {
			appointment = (Appointment) sqlMapClient.queryForObject("findAppointment",id);
			//���δ�����ó��Ѷ�
			if (appointment.getIsRead()==null){
				sqlMapClient.update("updateAppointment",appointment.getId());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return appointment;
	}
	/**
	 * ɾ��ԤԼ
	 * @param int id ԤԼ���
	 * @return boolean �Ƿ�ɾ���ɹ�
	 */
	public boolean deleteAppointment(int id) {
		boolean result =false;
		// TODO Auto-generated method stub
		try {
			int i=  sqlMapClient.update("deleteAppointment",id);
			if (i==1){
				result =true;//���Ϊ1 ����ɾ���ɹ�
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
}
