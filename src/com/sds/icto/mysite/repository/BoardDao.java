package com.sds.icto.mysite.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.sds.icto.mysite.domain.BoardVo;


@Repository
public class BoardDao {
	
	//글 입력
	public void insert(BoardVo vo ) 
		{
		
		Connection conn;
		try {
			conn = getConnection();
			String sql = "insert into board values(guestbook_seq.nextval,?,?,?,?,?, SYSDATE)";
			PreparedStatement pstmt = conn.prepareStatement( sql );
			
			pstmt.setString( 1, vo.getTitle());
			pstmt.setString( 2, vo.getContent());
			pstmt.setLong( 3, vo.getMember_no() );
			pstmt.setString( 4, vo.getMember_name() );
			pstmt.setInt( 5, vo.getView_cnt() );
			
			pstmt.executeUpdate();
			
			pstmt.close();
			conn.close();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	//글 리스트 불러오기
	public List<BoardVo> fetchList()
		{ 
		List<BoardVo> list = new ArrayList<BoardVo>();
		
		Connection conn;
		try {
			conn = getConnection();
			Statement stmt = conn.createStatement();
			
			String sql = "select * from board";
			ResultSet rs = stmt.executeQuery( sql );
			
			while( rs.next() ) {
				int no = rs.getInt( 1 );
				String title = rs.getString( 2 );
				String content = rs.getString ( 3 );
				Long member_no = rs.getLong( 4 );
				String member_name = rs.getString( 5 );
				int view_cnt = rs.getInt( 6 );
				Date regDate = rs.getDate( 7 );
				
				BoardVo vo = new BoardVo();
				vo.setNo(no);
				vo.setTitle(title);
				vo.setContent(content);
				vo.setMember_no(member_no);
				vo.setMember_name(member_name);
				vo.setView_cnt(view_cnt);
				vo.setReg_date(regDate);
				
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
	
	//글 삭제
	public void delete(){
		Connection conn;
		try {
			conn = getConnection();
			Statement stmt = conn.createStatement();
			
			String sql = "delete from board";
			stmt.executeUpdate(sql);
			
			stmt.close();
			conn.close();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	
	//no받아서 글 삭제
	public void delete(int no ){
		Connection conn;
		try {
			conn = getConnection();
			String sql = "delete from board where no = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt( 1, no);
			
			pstmt.executeUpdate();
			
			pstmt.close();
			conn.close();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


	//글 상세 페이지
	public BoardVo getBoard(int no){
		Connection conn;
		BoardVo vo = null;
		try {
			conn = getConnection();
			
			String sql = "select * from board where no = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()){
				no = rs.getInt( 1 );
				String title = rs.getString( 2 );
				String content = rs.getString ( 3 );
				Long member_no = rs.getLong( 4 );
				String member_name = rs.getString( 5 );
				int view_cnt = rs.getInt( 6 );
				Date regDate = rs.getDate( 7 );
				
				vo = new BoardVo();
				vo.setNo(no);
				vo.setTitle(title);
				vo.setContent(content);
				vo.setMember_no(member_no);
				vo.setMember_name(member_name);
				vo.setView_cnt(view_cnt);
				vo.setReg_date(regDate);
				
			}
			rs.close();
			pstmt.close();
			conn.close();
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		return vo; 
	}
	
	//조회수 증가
	public void updateCnt(int no){
		Connection conn;
		try {
			conn = getConnection();
			String sql = "update board set view_cnt=view_cnt+1 where no = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			
			pstmt.setInt( 1, no );
			
			pstmt.executeUpdate();
			
			pstmt.close();
			conn.close();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
	
	}
	
	//글 수정
	public void updateBoard(BoardVo vo){
		Connection conn;
		try {
			conn = getConnection();
			String sql = "update board set title=?, content=?, reg_date=sysdate where no = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			pstmt.setString( 1, vo.getTitle());
			pstmt.setString( 2, vo.getContent());
			pstmt.setInt( 3, vo.getNo() );
			
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
