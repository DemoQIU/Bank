package itstudio.bank.dao;

import itstudio.bank.bean.Admin;

/**
 * 管理员登陆接口
 * @author apple
 *
 */
public interface AdminDAO {
	public boolean login(Admin admin);//登陆验证
	public void FindPsw(Admin admin);//找回密码

}
