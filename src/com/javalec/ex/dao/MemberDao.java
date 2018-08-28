package com.javalec.ex.dao;

// DataSource 활용 
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.javalec.ex.dto.*;

public class MemberDao {
  DataSource ds;

  public MemberDao() {
		// TODO Auto-generated constructor stub
		
		try {
			Context context = new InitialContext();
			ds = (DataSource) context.lookup("java:comp/env/jdbc/mydb");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
/*
  public List<Member> selectList() throws Exception {
    Connection connection = null;
    Statement stmt = null;
    ResultSet rs = null;
    
    try {
      connection = ds.getConnection();
      stmt = connection.createStatement();
      rs = stmt.executeQuery(
          "SELECT MNO,MNAME,EMAIL,CRE_DATE" + 
              " FROM MEMBERS" +
          " ORDER BY MNO ASC");

      ArrayList<Member> members = new ArrayList<Member>();

      while(rs.next()) {
        members.add(new Member()
        .setNo(rs.getInt("MNO"))
        .setName(rs.getString("MNAME"))
        .setEmail(rs.getString("EMAIL"))
        .setCreatedDate(rs.getDate("CRE_DATE"))	);
      }

      return members;

    } catch (Exception e) {
      throw e;

    } finally {
      try {if (rs != null) rs.close();} catch(Exception e) {}
      try {if (stmt != null) stmt.close();} catch(Exception e) {}
      try {if (connection != null) connection.close();} catch(Exception e) {}
    }
  }
*/
  public int insert(String name,String password,String email,String id,String major,String phonenumber,String gender) throws Exception  { 
    Connection connection = null;
    PreparedStatement stmt = null;
 
    try {
      connection = ds.getConnection();
      stmt = connection.prepareStatement(
          "INSERT INTO KMEMBER(NAME,PASSWORD,EMAIL,ID,MAJOR,PHONENUMBER,GENDER)"
              + " VALUES (?,?,?,?,?,?,?)");
      stmt.setString(1, name);
      stmt.setString(2, password);
      stmt.setString(3, email);
      stmt.setString(4, id);
      stmt.setString(5, major);
      stmt.setString(6, phonenumber);
      stmt.setString(7, gender);
      return stmt.executeUpdate();

    } catch (Exception e) {
      throw e;

    } finally {
      try {if (stmt != null) stmt.close();} catch(Exception e) {}
      try {if (connection != null) connection.close();} catch(Exception e) {}
    }
  }

  public int delete(int no) throws Exception {  
    Connection connection = null;
    Statement stmt = null;

    try {
      connection = ds.getConnection();
      stmt = connection.createStatement();
      return stmt.executeUpdate(
          "DELETE FROM KMEMBER WHERE MNO=" + no);

    } catch (Exception e) {
      throw e;

    } finally {
      try {if (stmt != null) stmt.close();} catch(Exception e) {}
      try {if (connection != null) connection.close();} catch(Exception e) {}
    }
  }

  public int selectOne(String id) throws Exception { 
	  Connection connection = null;
	    PreparedStatement stmt = null;
	    ResultSet rs = null;
    int flag=0;
    try {
      connection = ds.getConnection();
      stmt = connection.prepareStatement(
              "SELECT * FROM KMEMBER"
                  + " WHERE ID=?");
          stmt.setString(1, id);
          rs = stmt.executeQuery();
          if (rs.next()) {
       flag=1;
       return flag;
      } else {
    	  return flag;
      }

    } catch (Exception e) {
      throw e;
    } finally {
      try {if (rs != null) rs.close();} catch(Exception e) {}
      try {if (stmt != null) stmt.close();} catch(Exception e) {}
      try {if (connection != null) connection.close();} catch(Exception e) {}
    }
  }

  /*
  public int update(Member member) throws Exception { 
    Connection connection = null;
    PreparedStatement stmt = null;
    try {
      connection = ds.getConnection();
      stmt = connection.prepareStatement(
          "UPDATE MEMBERS SET EMAIL=?,MNAME=?,MOD_DATE=now()"
              + " WHERE MNO=?");
      stmt.setString(1, member.getEmail());
      stmt.setString(2, member.getName());
      stmt.setInt(3, member.getNo());
      return stmt.executeUpdate();

    } catch (Exception e) {
      throw e;

    } finally {
      try {if (stmt != null) stmt.close();} catch(Exception e) {}
      try {if (connection != null) connection.close();} catch(Exception e) {}
    }
  }
  */
  public Member exist(String id, String password) throws Exception {
    Connection connection = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;
    Member vo=new Member();
System.out.println(id);
System.out.println(password);
    try {
      connection = ds.getConnection();
      stmt = connection.prepareStatement(
          "SELECT * FROM KMEMBER"
              + " WHERE ID=? AND PASSWORD=?");
      stmt.setString(1, id);
      stmt.setString(2, password);
      rs = stmt.executeQuery();
      if (rs.next()) {
        return vo;
      } else {
        return null;
      }
    } catch (Exception e) {
      throw e;

    } finally {
      try {if (rs != null) rs.close();} catch (Exception e) {}
      try {if (stmt != null) stmt.close();} catch (Exception e) {}
      try {if (connection != null) connection.close();} catch(Exception e) {}
    }
  }

}
