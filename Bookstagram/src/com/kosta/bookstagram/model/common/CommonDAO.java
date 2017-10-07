package com.kosta.bookstagram.model.common;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.kosta.bookstagram.model.listener.CommonListener;

public class CommonDAO implements CommonListener{
	private DataSource dataSource;
	
	/*
	 * CommonDAO 생성시 dataSource 생성
	 * public 으로 정의하여 MemberDAO 와 BoardDAO에서 상속받아 하나의 DataSourceManager를 사용한다.
	 */
	public CommonDAO(){
		dataSource = DataSourceManager.getInstance().getDataSource();
	}
	
	public Connection getConnection() throws SQLException{
		return dataSource.getConnection();
	}
	
	public void closeAll(PreparedStatement pstmt,Connection con) throws SQLException{
		if(pstmt!=null)
			pstmt.close();
		if(con!=null)
			con.close(); 
	}
	
	public void closeAll(ResultSet rs,PreparedStatement pstmt,Connection con) throws SQLException{
		if(rs!=null)
			rs.close();
		closeAll(pstmt,con);
	}
}
