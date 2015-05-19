package com.sds.icto.mysite.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Repository;

import com.sds.icto.mysite.domain.MemberVo;
import com.sds.icto.mysite.exception.MemberDaoException;


@Repository
public class MemberDao {
	
	public void insert( MemberVo vo ){
		// 1. Connection 생성
		Connection conn;
		try {
			conn = getConnection();
			//2. Statement(SQL) 준비
			String sql = 
					"insert into member values(member_no_seq.nextval,?,?,?,? )";
			PreparedStatement pstmt = conn.prepareStatement( sql );
			//3.binding
			pstmt.setString( 1, vo.getName() );
			pstmt.setString( 2, vo.getEmail() );
			pstmt.setString( 3, vo.getPassword() );
			pstmt.setString( 4, vo.getGender() );
			
			//4. query 실행
			pstmt.executeUpdate();
			
			//5. 자원정리
			pstmt.close();
			conn.close();
		} catch (ClassNotFoundException | SQLException e) {
			throw new MemberDaoException(e.getMessage());
		}
	}
	
	public MemberVo getMember( MemberVo vo )
		{
		// 1. Connection 생성
		Connection conn=null;
		MemberVo memberVo = null;
		try {
			//2. Statement(SQL) 준비
			
			conn = getConnection();
			String sql = 
					"select * from member where email = ? and password = ?";
			PreparedStatement pstmt = conn.prepareStatement( sql );
			
			//3.binding
			pstmt.setString( 1, vo.getEmail() );
			pstmt.setString( 2, vo.getPassword() );
			
			//4. query 실행
			ResultSet rs = pstmt.executeQuery();
			
			
			if( rs.next() ){
				Long no = rs.getLong( 1 );
				String name = rs.getString( 2 );
				String email = rs.getString( 3 );
				String password = rs.getString( 4 );
				String gender = rs.getString( 5 );
				
				memberVo = new MemberVo();
				memberVo.setNo(no);
				memberVo.setName(name);
				memberVo.setEmail(email);
				memberVo.setPassword(password);
				memberVo.setGender(gender);
			}
			
			//5. 자원정리
			rs.close();
			pstmt.close();
			conn.close();
		} catch (ClassNotFoundException | SQLException e) {
			throw new MemberDaoException(e.getMessage()); 
		}
		
		
		return memberVo;
	}
	
	
	
	public void updateMember(MemberVo vo) throws ClassNotFoundException, SQLException{
		Connection conn = getConnection();
		
		String sql = "update member set name=?, password=? where no = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		pstmt.setString( 1, vo.getName());
		pstmt.setString( 2, vo.getPassword());
		pstmt.setLong(3, vo.getNo());
		
		pstmt.executeUpdate();
		
		pstmt.close();
		conn.close();
	
	}
	
	private Connection getConnection() throws ClassNotFoundException,
			SQLException {
		Connection conn = null;
		// 1. 드라이버 로딩
		Class.forName("oracle.jdbc.driver.OracleDriver");
		// 2. connection 생성
		String dbURL = "jdbc:oracle:thin:@localhost:1521:xe";
		conn = DriverManager.getConnection(dbURL, "webdb", "webdb");
		return conn;
	}
}
