package com.sds.icto.mysite.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Repository;

import com.sds.icto.mysite.domain.GuestbookVo;



@Repository
public class GuestbookDao {
	
	@Autowired
	private SqlMapClientTemplate sqlMapClientTemplate;

	public void insert( GuestbookVo vo ) {
		
		sqlMapClientTemplate.insert("guestbook.insert", vo);
		
	}
	
	@SuppressWarnings("unchecked")
	public List<GuestbookVo> fetchList(){ 
		List<GuestbookVo> list = sqlMapClientTemplate.queryForList("guestbook.list");
		
		return list;
	}
	
	
	@SuppressWarnings("unchecked")
	public void delete(Long no, String password ){
		Map map = new HashMap();
		map.put("no", no);
		map.put("password", password);
		
		sqlMapClientTemplate.delete("guestbook.delete", map);
		
	}
	
}
