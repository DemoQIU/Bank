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
 * 用于 预约处理的业务处理
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
	 * 添加预约
	 * @param Appointment 预约
	 * @return boolean  是否添加预约成功
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
	 * 获取预约列表
	 * @param int currentPage 当前页数
	 * @param int choice 0 代表未读 1 代表已读
	 * @return boolean  是否添加预约成功
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
	 * 获取预约详情
	 * @param int id 预约编号
	 * @return Appointment 预约详情
	 */
	public Appointment findAppointmentById(int id) {
		// TODO Auto-generated method stub
		Appointment appointment = null;
		try {
			appointment = (Appointment) sqlMapClient.queryForObject("findAppointment",id);
			//如果未读设置成已读
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
	 * 删除预约
	 * @param int id 预约编号
	 * @return boolean 是否删除成功
	 */
	public boolean deleteAppointment(int id) {
		boolean result =false;
		// TODO Auto-generated method stub
		try {
			int i=  sqlMapClient.update("deleteAppointment",id);
			if (i==1){
				result =true;//结果为1 代表删除成功
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
}
