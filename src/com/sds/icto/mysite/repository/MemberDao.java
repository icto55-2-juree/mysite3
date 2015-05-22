package com.sds.icto.mysite.repository;

import java.io.IOException;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

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

	

	public void updateUser(String name, String password, Long no) {
		Map map = new HashMap();
		map.put("name", name);
		map.put("password", password);
		map.put("no", no);
		
		sqlMapClientTemplate.update("member.updateMember", map);
		
		
	}

}
