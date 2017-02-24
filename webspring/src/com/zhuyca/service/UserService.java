package com.zhuyca.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import com.zhuyca.util.JdbcUtils;

public class UserService {
	private String stuId;
	private String stuName;
	private String phone;
	private String idNumber;
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Map<String,String> getUserInfo(Map<String,String> parameter){
		Map<String,String> map = new HashMap<String,String>();
		String stuId = parameter.get("stuId");
		Connection con = JdbcUtils.getConnection(); 
		PreparedStatement pstmt = null;
		Map resMap = new HashMap();
		resMap.put("RtnCode", "00");
		try {
			pstmt = con.prepareStatement("SELECT stuId,stuName,phone,idNumber FROM stu_info WHERE stuId = ?");
			pstmt.setString(1, stuId);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				map.put("stuId", rs.getString(1));
				map.put("stuName", rs.getString(2));
				map.put("phone", rs.getString(3));
				map.put("idNumber", rs.getString(4));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			resMap.put("RtnCode", "99");
		}
		resMap.put("RtnData", map);
		return resMap;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Map <String,String> saveUserInfo(Map<String,String> parameter) {
		String stuId = parameter.get("stuId");
		String stuName = parameter.get("stuName");
		String phone = parameter.get("phone");
		String idNumber = parameter.get("idNumber");
		Map resMap = new HashMap();
		resMap.put("RtnCode", "00");
		Connection con = JdbcUtils.getConnection(); 
		PreparedStatement pstmt = null;
		try {
			pstmt = con.prepareStatement("INSERT INTO stu_info(stuId,stuName,phone,idNumber) VALUES(?,?,?,?)");
			pstmt.setString(1, stuId);
			pstmt.setString(2, stuName);
			pstmt.setString(3, phone);
			pstmt.setString(4, idNumber);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			resMap.put("RtnCode", "99");
		}
		JdbcUtils.closeConnection(con);
		return resMap;
	}
	
	public void setName(String stuId) {
		this.stuId = stuId;
	}
	public void setAge(String stuName) {
		this.stuName = stuName;
	}
	public void setAddress(String phone) {
		this.phone = phone;
	}
	public void setSex(String idNumber) {
		this.idNumber = idNumber;
	}
}
