package com.javalec.ex.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.javalec.ex.dto.CCDto;
import com.javalec.ex.dto.Discount;

public class DiscountDao {

	DataSource dataSource;
	
	public DiscountDao() {
		// TODO Auto-generated constructor stub
		
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/mydb");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public void write(int bId, String bName, String userId, String contents) {
		// TODO Auto-generated method stub
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection = dataSource.getConnection();
			String query = "insert into discount ( bId,bName,userId, contents) values (?, ?, ?,? )";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, bId);
			preparedStatement.setString(2, bName);
			preparedStatement.setString(3, userId);
			preparedStatement.setString(4, contents);
			int rn = preparedStatement.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				if(preparedStatement != null) preparedStatement.close();
				if(connection != null) connection.close();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
		
	}
	
	public void accept(int cId) {
		// TODO Auto-generated method stub
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection = dataSource.getConnection();
			String query = "update discount set flag = 1 where cId = ?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, cId);
			int rn = preparedStatement.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				if(preparedStatement != null) preparedStatement.close();
				if(connection != null) connection.close();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
		
	}
	public void reject(int cId) {
		// TODO Auto-generated method stub
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection = dataSource.getConnection();
			String query = "update discount set flag = 2 where cId = ?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, cId);
			int rn = preparedStatement.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				if(preparedStatement != null) preparedStatement.close();
				if(connection != null) connection.close();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
		
	}
	
	public ArrayList<Discount> list(int bId) {
		
		ArrayList<Discount> dtos = new ArrayList<Discount>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection = dataSource.getConnection();
			
			String query = "select cId, bName,userId, contents, flag from discount where bId = ? order by cId asc";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, bId);
			resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()) {
				int cId = resultSet.getInt("cId");
				String userId = resultSet.getString("userId");
				String bName = resultSet.getString("bName");
				String contents = resultSet.getString("contents");
				int flag = resultSet.getInt("flag");
				
				
				Discount dto = new Discount (cId,bId,bName, userId, contents, flag);
				dtos.add(dto);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				if(resultSet != null) resultSet.close();
				if(preparedStatement != null) preparedStatement.close();
				if(connection != null) connection.close();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
		return dtos;
	}
	
	
	
	public void delete(String cId) {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			
			
				connection = dataSource.getConnection();
				String query = "delete from discount where cId = ?";
				preparedStatement = connection.prepareStatement(query);
				preparedStatement.setInt(1, Integer.parseInt(cId));
			
			int rn = preparedStatement.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				if(preparedStatement != null) preparedStatement.close();
				if(connection != null) connection.close();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
	}
	
	
	
	
	
}
