package itstudio.bank.bean;
/**
 * ����Աjavabean
 * @author apple
 *
 */
public class Admin {
	private int id;
	private String userName;
	private String passWord;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	public Admin() {
		// TODO Auto-generated constructor stub
	}
	public Admin( String userName, String passWord) {
		// TODO Auto-generated constructor stub
		this.userName=userName;
		this.passWord= passWord;
	}


}
