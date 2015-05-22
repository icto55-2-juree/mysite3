package com.sds.icto.mysite.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sds.icto.mysite.domain.GuestbookVo;
import com.sds.icto.mysite.repository.GuestbookDao;

@Service
public class GuestbookService {

	@Autowired
	GuestbookDao guestbookDao;

	public List<GuestbookVo> guestbookList() {
		
	
		return guestbookDao.fetchList();
	}

	public void insertGuestbook(String name, String password, String message) {
		
		GuestbookVo vo = new GuestbookVo();
		vo.setName(name);
		vo.setPassword(password);
		vo.setMessage(message);
		
		guestbookDao.insert(vo);
		
	}

	public void deleteGuestbook(Long no, String password) {
		guestbookDao.delete(no, password);
		
	}
	
	
}
