package itstudio.bank.dao;

import itstudio.bank.bean.Admin;

/**
 * ����Ա��½�ӿ�
 * @author apple
 *
 */
public interface AdminDAO {
	public boolean login(Admin admin);//��½��֤
	public void FindPsw(Admin admin);//�һ�����

}
