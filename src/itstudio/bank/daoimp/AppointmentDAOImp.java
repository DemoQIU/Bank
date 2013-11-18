package itstudio.bank.daoimp;

import itstudio.bank.bean.Admin;
import itstudio.bank.bean.Appointment;
import itstudio.bank.utils.MD5Util;

import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;
import java.util.Date;

import com.ibatis.sqlmap.client.SqlMapClient;

public class AppointmentDAOImp {
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
}
