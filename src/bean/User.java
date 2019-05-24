package bean;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @program: homework
 * @Date: 2019/5/21 22:28
 * @Author: 黄文威
 * @Description: 用户实体类
 */
public class User implements TableToClass{
	private String name;
	private String passWord;
	private String phoneNumber;
	private String eamil;
	private int Id;

	public User(String name, String passWord, String phoneNumber, String eamil){
		this.name = name;
		this.passWord = passWord;
		this.phoneNumber = phoneNumber;
		this.eamil = eamil;
	}

	public User(){
	}

	public String getName(){
		return name;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getPassWord(){
		return passWord;
	}

	public void setPassWord(String passWord){
		this.passWord = passWord;
	}

	public String getPhoneNumber(){
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber){
		this.phoneNumber = phoneNumber;
	}

	public String getEamil(){
		return eamil;
	}

	public void setEamil(String eamil){
		this.eamil = eamil;
	}

	public int getId(){
		return Id;
	}

	public void setId(int id){
		this.Id = id;
	}

	@Override
	public User tableToClass(ResultSet resultSet){
		User user = new User();
		while (true) {
			try {
				if (!resultSet.next()) break;
				user.setId(resultSet.getInt("id"));
				user.setEamil(resultSet.getString("email"));
				user.setName(resultSet.getString("name"));
				user.setPhoneNumber(resultSet.getString("phonenumber"));
				user.setPassWord(resultSet.getString("password"));
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return user;
	}
}
