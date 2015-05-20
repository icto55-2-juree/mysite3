package com.sds.icto.mysite.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.sds.icto.mysite.domain.GuestbookVo;
import com.sds.icto.mysite.service.GuestbookService;


@Controller
@RequestMapping("/guestbook")
public class GuestbookController {

	@Autowired
	GuestbookService guestbookService;

	@RequestMapping("/list")
	public String guestbookListForm(Model model) {
		
		List<GuestbookVo> list = guestbookService.guestbookList();
		model.addAttribute("list", list);
	return "guestbook/list";
}
	
	@RequestMapping(value="/insert", method=RequestMethod.POST)
	public String insert(
			@RequestParam("name") String name,
			@RequestParam("password") String password,
			@RequestParam("message") String message){
		
		guestbookService.insertGuestbook(name, password, message);
		
		
		return "redirect:list";
	}
	
	@RequestMapping(value="/deleteGuestbook", method=RequestMethod.GET)
	public String deleteGuestbook(
			@RequestParam ("no") Long no,
			@RequestParam("password") String password){
		guestbookService.deleteGuestbook(no, password);

		return "redirect:list";

	}
}
