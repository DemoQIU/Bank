package itstudio.bank.daoimp;
import com.ibatis.sqlmap.client.*;

import itstudio.bank.bean.Admin;
import itstudio.bank.dao.AdminDAO;
import itstudio.bank.utils.MD5Util;
import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;
/**
 * 用于登陆验证 和找回密码 的具体方法
 * @author apple
 *
 */
public class AdminDAOImp implements AdminDAO {
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
	public boolean login(Admin admin) {
		// TODO Auto-generated method stub
		Admin findAdmin =null;
		try {
			findAdmin = (Admin) sqlMapClient.queryForObject("selectAdminByName",admin.getUserName());
			if(findAdmin==null){
				return false;
				}
			else if(findAdmin.getPassWord().equals(MD5Util.MD5(admin.getPassWord()))){
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public void FindPsw(Admin admin) {
		// TODO Auto-generated method stub
		
	}

}
