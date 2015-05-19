package com.sds.icto.mysite.exception;

public class MemberDaoException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public MemberDaoException() {
		super("MemberDaoException!!");
	}

	public MemberDaoException(String msg) {
		super(msg);
	}

}
