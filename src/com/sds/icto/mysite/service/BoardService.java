package com.sds.icto.mysite.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

import com.sds.icto.mysite.domain.BoardVo;
import com.sds.icto.mysite.domain.MemberVo;
import com.sds.icto.mysite.repository.BoardDao;

@Service
public class BoardService {

	@Autowired
	BoardDao boardDao;

	public List<BoardVo> boardList() {
		
		return boardDao.fetchList();
		
		
	}

	public BoardVo getBoard(int no) {
		
		boardDao.updateCnt(no);
		BoardVo vo = boardDao.getBoard(no);
		
		return vo;
	}
	

	public BoardVo getBoardDetail(int no) {
		
		BoardVo vo = boardDao.getBoard(no);
		return vo;
	}

	public void deleteBoard(int no) {
		boardDao.delete(no);
	}

	public void insertBoard(HttpSession session, String title, String contents) {
		
		MemberVo authMember = (MemberVo) session.getAttribute("authMember");
		
		BoardVo vo = new BoardVo();
		vo.setTitle(title);
		vo.setContent(contents);
		vo.setMember_no(authMember.getNo());
		vo.setMember_name(authMember.getName());
		vo.setView_cnt(0);
		
		boardDao.insert(vo);
		
	}

	public void editBoard(int no, String title, String content) {
		
		boardDao.updateBoard(no, title, content);
		
	}
}
