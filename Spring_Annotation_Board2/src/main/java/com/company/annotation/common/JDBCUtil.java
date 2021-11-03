package com.company.annotation.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class JDBCUtil {
	//H2 DB ������ ���� �ҽ�
		static final String driver = "org.h2.Driver";
		static final String url = "jdbc:h2:tcp://localhost/~/test";
		
		public static Connection getConnction() throws Exception{
			try {
				Class.forName(driver);
				Connection con = DriverManager.getConnection(url, "sa", "");
				return con;
			}catch(Exception e) {
				e.printStackTrace();
			}
			return null;
		}
		
		/*
		 * �޼ҵ� �����ε�  => ������ ����
		 */
		//DML(insert, update, delete) �۾� ���� �� ȣ��Ǵ� �޼ҵ�
		public static void close(PreparedStatement pstmt, Connection conn) {
			if(pstmt != null) {
				try {
					if(!pstmt.isClosed()) pstmt.close();   //�ڿ� ����
				}catch(Exception e) {
					e.printStackTrace();
				}finally {
					pstmt = null;
				}
			}if(conn != null) {
				try {
					if(!conn.isClosed()) conn.close();
				}catch(Exception e) {
					e.printStackTrace();
				}finally {
					conn = null;
				}
			}
		}
		
		//select �۾� ���� �� ȣ��Ǵ� �޼ҵ�
		public static void close(ResultSet rs, PreparedStatement pstmt, Connection conn) {
			if(rs != null) {
				try {
					if(!rs.isClosed()) rs.close();   //�ڿ� ����
				}catch(Exception e) {
					e.printStackTrace();
				}finally {
					rs = null;
				}
			}
			if(pstmt != null) {
				try {
					if(!pstmt.isClosed()) pstmt.close();   //�ڿ� ����
				}catch(Exception e) {
					e.printStackTrace();
				}finally {
					pstmt = null;
				}
			}if(conn != null) {
				try {
					if(!conn.isClosed()) conn.close();
				}catch(Exception e) {
					e.printStackTrace();
				}finally {
					conn = null;
				}
			}
		}
}
