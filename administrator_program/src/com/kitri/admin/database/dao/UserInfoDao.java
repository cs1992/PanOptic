package com.kitri.admin.database.dao;

import java.sql.*;
import java.util.ArrayList;

import com.kitri.admin.database.dto.UserInfoDto;

public class UserInfoDao extends Dao {
    // private Dao dao;

    public UserInfoDao() {

    }

    public ArrayList<UserInfoDto> selectAll() {
	ArrayList<UserInfoDto> dtos = new ArrayList<>();

	try {
	    con = getConnection();
	    stmt = con.createStatement();
	    rs = stmt.executeQuery("select * from user_info");

	    // preStmt = con.prepareStatement("select * from user_info where
	    // user_num = ?");
	    // preStmt.setString(1, "0");

	    UserInfoDto dto;
	    while (rs.next()) {
		dto = new UserInfoDto();
		dto.setUserNum(rs.getInt(1));
		dto.setUserName(rs.getString(2));
		dto.setUserId(rs.getString(3));
		dto.setUserPw(rs.getString(4));
		dto.setUserHp(rs.getString(5));
		dto.setUserEmail(rs.getString(6));
		dto.setUserAccuTime(rs.getString(7));
		dto.setUserLeftTime(rs.getString(8));
		dto.setUserJoinDate(rs.getString(9));

		dtos.add(dto);
	    }

	} catch (Exception e) {
	    e.printStackTrace();
	} finally {
	    resetStmt();
	}

	return dtos;
    }

    public boolean insert(String name, String id, String pw, String hp, String email) {
	int result = 0;

	try {
	    con = getConnection();
	    preStmt = con.prepareStatement(
		    "insert into user_info(user_num, user_name, user_id, user_pw, user_hp, user_email) values(user_info_seq.nextval,?,?,?,?,?)");
	    preStmt.setString(1, name);
	    preStmt.setString(2, id);
	    preStmt.setString(3, pw);
	    preStmt.setString(4, hp);
	    preStmt.setString(5, email);
	    result = preStmt.executeUpdate();

	} catch (Exception e) {
	    e.printStackTrace();
	} finally {
	    resetPreStmt();
	}

	return result == 0 ? false : true;

    }

    public boolean checkId(String id) {
	boolean result = false;

	try {
	    con = getConnection();
	    preStmt = con.prepareStatement("select user_id from user_info where user_id = ?");
	    preStmt.setString(1, id);
	    rs = preStmt.executeQuery();

	    if (!rs.next()) {
		result = true;
	    }

	} catch (SQLException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	} finally {
	    resetPreStmt();
	}
	
	return result;
    }

   

    // public static void main(String[] args) {
    // UserInfoDao u = new UserInfoDao();
    //
    // ArrayList<UserInfoDto> dtos = u.selectAllUserInfo();
    //// System.out.println(u.insertUserInfo(4, "321312231", "32332", "32w2ew",
    // "32we2432", "qweq5wr@qwqwe"));
    //
    // int size = dtos.size();
    // for (int i = 0; i < size; i++) {
    // System.out.println(dtos.get(i).toString());
    // }
    //
    // }

}
