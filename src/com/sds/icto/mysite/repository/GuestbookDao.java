package com.sds.icto.mysite.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.sds.icto.mysite.domain.GuestbookVo;



@Repository
public class GuestbookDao {

	public void insert( GuestbookVo vo ) {
		
		Connection conn;
		try {
			conn = getConnection();
			String sql = "insert into guestbook values(guestbook_seq.nextval,?,?,?, SYSDATE)";
			PreparedStatement pstmt = conn.prepareStatement( sql );
			
			pstmt.setString( 1, vo.getName() );
			pstmt.setString( 2, vo.getPassword() );
			pstmt.setString( 3, vo.getMessage() );
			
			pstmt.executeUpdate();
			
			pstmt.close();
			conn.close();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public List<GuestbookVo> fetchList(){ 
		List<GuestbookVo> list = new ArrayList<GuestbookVo>();
		
		Connection conn;
		try {
			conn = getConnection();
			Statement stmt = conn.createStatement();
			
			String sql = "select * from guestbook";
			ResultSet rs = stmt.executeQuery( sql );
			
			while( rs.next() ) {
				Long no = rs.getLong( 1 );
				String name = rs.getString( 2 );
				String password = rs.getString ( 3 );
				String message = rs.getString( 4 );
				String regDate = rs.getString( 5 );
				
				GuestbookVo vo = new GuestbookVo();
				vo.setNo(no);
				vo.setName(name);
				vo.setPassword(password);
				vo.setMessage(message);
				vo.setRegDate(regDate);
				
				list.add( vo );
			}
			
			rs.close();
			stmt.close();
			conn.close();
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	public GuestbookVo getGuestbook(Long no){
		Connection conn;
		GuestbookVo vo = new GuestbookVo();
		try {
			conn = getConnection();
			String sql = "select * from guestbook where no=?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			pstmt.setLong(1, no);
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()){
				no = rs.getLong(1);
				String name = rs.getString( 2 );
				String password = rs.getString ( 3 );
				String message = rs.getString( 4 );
				String regDate = rs.getString( 5 );
				
				vo.setNo(no);
				vo.setName(name);
				vo.setPassword(password);
				vo.setMessage(message);
				vo.setRegDate(regDate);
				
				System.out.println(password);
			}
			
			rs.close();
			pstmt.close();
			conn.close();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return vo; 
	}
	
	public void delete()
		{
		Connection conn;
		try {
			conn = getConnection();
			Statement stmt = conn.createStatement();
			
			String sql = "delete from guestbook";
			stmt.executeUpdate(sql);
			
			stmt.close();
			conn.close();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void delete(Long no, String password )
		{
		Connection conn;
		try {
			conn = getConnection();
			String sql = "delete from guestbook where no = ? and password = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			pstmt.setLong( 1, no);
			pstmt.setString( 2, password );
			
			pstmt.executeUpdate();
			
			pstmt.close();
			conn.close();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void delete(Long no){
			Connection conn;
			try {
				conn = getConnection();
				String sql = "delete from guestbook where no = ?";
				PreparedStatement pstmt = conn.prepareStatement(sql);
				
				pstmt.setLong( 1, no);
				
				pstmt.executeUpdate();
				
				pstmt.close();
				conn.close();
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}

	private Connection getConnection()
		throws ClassNotFoundException, SQLException {
		Connection conn = null;
		//1. 드라이버 로딩
		Class.forName( "oracle.jdbc.driver.OracleDriver" );
		//2. connection 생성
		String dbURL = "jdbc:oracle:thin:@localhost:1521:xe";
		conn = DriverManager.getConnection(dbURL, "webdb", "webdb");
		return conn;
	}
	
}
