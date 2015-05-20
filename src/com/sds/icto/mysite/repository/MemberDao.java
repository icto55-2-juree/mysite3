package com.sds.icto.mysite.repository;

import java.io.IOException;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Repository;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;
import com.sds.icto.mysite.domain.MemberVo;
import com.sds.icto.mysite.exception.MemberDaoException;

@Repository
public class MemberDao {

	@Autowired
	private SqlMapClientTemplate sqlMapClientTemplate;

	public void insert(MemberVo vo) {

		sqlMapClientTemplate.insert("member.insert", vo);

	}

	public MemberVo getMember(MemberVo vo) {
		MemberVo memberVo = new MemberVo();

		memberVo = (MemberVo) sqlMapClientTemplate.queryForObject(
				"member.getMember", vo);

		return memberVo;
	}

	public void updateMember(MemberVo vo) throws ClassNotFoundException,
			SQLException {
		/*
		 * Connection conn = getConnection();
		 * 
		 * String sql = "update member set name=?, password=? where no = ?";
		 * PreparedStatement pstmt = conn.prepareStatement(sql);
		 * 
		 * pstmt.setString( 1, vo.getName()); pstmt.setString( 2,
		 * vo.getPassword()); pstmt.setLong(3, vo.getNo());
		 * 
		 * pstmt.executeUpdate();
		 * 
		 * pstmt.close(); conn.close();
		 */
	}

}
