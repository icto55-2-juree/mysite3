package com.sds.icto.mysite.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sds.icto.mysite.domain.BoardVo;
import com.sds.icto.mysite.domain.GuestbookVo;
import com.sds.icto.mysite.domain.MemberVo;
import com.sds.icto.mysite.repository.BoardDao;
import com.sds.icto.mysite.service.BoardService;
import com.sds.icto.mysite.service.MemberService;

@Controller
@RequestMapping("/board")
public class BoardController {

	@Autowired
	BoardService boardService;
	
	/*@RequestMapping("/list")
	public String index(Model model) {
		
		List<GuestbookVo> list = guestbookDao.fetchList();
		model.addAttribute("list", list);
		return "guestbook/list";*/

	@RequestMapping(value="/board_list")
	public String boardListForm(Model model){
		
		List<BoardVo> list = boardService.boardList();
		model.addAttribute("list", list);
		
		return"board/board_list";
	}
	
	@RequestMapping(value="/insert", method=RequestMethod.GET)
	public String insertForm(){
		return"board/board_write";
	}
	
	
	@RequestMapping(value="/insert", method=RequestMethod.POST)
	public String insert(
			HttpSession session,
			@RequestParam("title") String title,
			@RequestParam("contents") String contents){
		
		boardService.insertBoard(session, title, contents);
		
		return "redirect:board_list";
	}
	
	
	@RequestMapping(value="/getBoard", method=RequestMethod.GET)
	public String boardDetail(@RequestParam ("no") int no, Model model){
		BoardVo vo = boardService.getBoard(no);
		model.addAttribute("vo", vo);
		return"board/board_detail";
	}
	
	@RequestMapping(value="/editBoard", method=RequestMethod.GET)
	public String editBoardForm(@RequestParam ("no") int no, Model model){
		BoardVo vo = boardService.getBoardDetail(no);
		model.addAttribute("vo", vo);
		return"board/board_edit";
	}
	
	@RequestMapping(value="/editBoard", method=RequestMethod.POST)
	public String editBoard(
			@RequestParam ("no") int no,
			@RequestParam ("title") String title,
			@RequestParam ("content") String content,
			Model model){
		
		boardService.editBoard(no, title, content);
		
		BoardVo vo = boardService.getBoard(no);
		
		model.addAttribute("vo", vo);
		return"board/board_detail";
	}
	
	@RequestMapping(value="/deleteBoard", method=RequestMethod.GET)
	public String deleteBoard(@RequestParam ("no") int no){
		boardService.deleteBoard(no);

		return "redirect:board_list";

	}
	
	
}
