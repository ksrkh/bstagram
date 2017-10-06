package com.kosta.bookstagram.model.listener;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public interface CommonListener {
	
	/**
	 * 
	 * @return Connection
	 * @throws SQLException
	 */
	public Connection getConnection() throws SQLException;
	
	/**
	 * @param pstmt
	 * @param con
	 * @throws SQLException
	 */
	public void closeAll(PreparedStatement pstmt,Connection con) throws SQLException;
	
	/**
	 * 
	 * @param rs
	 * @param pstmt
	 * @param con
	 * @throws SQLException
	 */
	public void closeAll(ResultSet rs,PreparedStatement pstmt,Connection con) throws SQLException;
}
