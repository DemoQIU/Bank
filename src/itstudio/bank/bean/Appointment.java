package itstudio.bank.bean;

import java.util.Date;
/**
 * 客户预约实体类
 * @author apple
 *
 */
public class Appointment {

	private int id;
	private String name;
	private float tellphone;
	private String email;
	private Date time; 
	private String type; 
	private String content; 
	private Date systemTime;
	private String isRead;
	
	public String getIsRead() {
		return isRead;
	}
	public void setIsRead(String isRead) {
		this.isRead = isRead;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getTellphone() {
		return tellphone;
	}
	public void setTellphone(float tellphone) {
		this.tellphone = tellphone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getSystemTime() {
		return systemTime;
	}
	public void setSystemTime(Date systemTime) {
		this.systemTime = systemTime;
	}
	public Appointment() {
		// TODO Auto-generated constructor stub
	}
	public Appointment(String name,float tellphone,String email,Date time,String type,String content) {
		// TODO Auto-generated constructor stub
		this.name=name;
		this.tellphone=tellphone;
		this.email= email;
		this.time=time;
		this.type=type;
		this.content=content;
	}
}
