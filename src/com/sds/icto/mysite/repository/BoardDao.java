package com.sds.icto.mysite.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Repository;

import com.sds.icto.mysite.domain.BoardVo;


@Repository
public class BoardDao {
	
	@Autowired
	private SqlMapClientTemplate sqlMapClientTemplate;
	
	//글 입력
	public void insert(BoardVo vo ){
		
		sqlMapClientTemplate.insert("board.insert", vo);
		
	}
	
	//글 리스트 불러오기
	@SuppressWarnings("unchecked")
	public List<BoardVo> fetchList(){ 
		List<BoardVo> list = sqlMapClientTemplate.queryForList("board.list");
		
		return list;
	}
	
	//no받아서 글 삭제
	public void delete(int no ){
		sqlMapClientTemplate.delete("board.delete", no);
	}


	//글 상세 페이지
	public BoardVo getBoard(int no){
		BoardVo vo = (BoardVo) sqlMapClientTemplate.queryForObject("board.getBoard", no);
		
		return vo; 
	}
	
	//조회수 증가
	public void updateCnt(int no){
		sqlMapClientTemplate.update("board.updateCnt", no);
		
	}
	
	//글 수정
	@SuppressWarnings("unchecked")
	public void updateBoard(int no, String title, String content){
		Map map = new HashMap();
		map.put("no", no);
		map.put("title", title);
		map.put("content", content);
		sqlMapClientTemplate.update("board.updateBoard", map);
		
	}
	
	
	
	
}
