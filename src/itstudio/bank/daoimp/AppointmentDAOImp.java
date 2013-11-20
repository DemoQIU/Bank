package itstudio.bank.daoimp;

import itstudio.bank.bean.Appointment;
import itstudio.bank.dao.AppointmentDAO;

import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;
/**
 * 用于 预约处理的业务处理
 * @author apple
 *
 */
public class AppointmentDAOImp implements AppointmentDAO{
	private static SqlMapClient sqlMapClient=null;
	
	static {
		try {
			Reader reader=com.ibatis.common.resources.Resources.getResourceAsReader("itstudio/bank/config/SqlMapConfig.xml");
			sqlMapClient = com.ibatis.sqlmap.client.SqlMapClientBuilder.buildSqlMapClient(reader);
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
}
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
	public List<Appointment> FindAppointmentList(int currentPage, int i) {
		// TODO Auto-generated method stub
		return null;
	}
	public List<Appointment> FindAppointmentById(Appointment appointment) {
		// TODO Auto-generated method stub
		return null;
	}
	public List<Appointment> deleteAppointment(int id) {
		// TODO Auto-generated method stub
		return null;
	}
}
