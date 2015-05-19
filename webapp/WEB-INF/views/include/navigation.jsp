<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="fn"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%-- <%
	MemberVo authMember = (MemberVo)session.getAttribute( "authMember" );
%> --%>
<ul>
<c:choose>
<c:when test="${param.type=='main' }"> 
	<li class="selected" style="text-align: center;">${authMember.name }님 로그인</li>
	<li><a href="/mysite3/guestbook/list">방명록</a></li>
	<li><a href="/mysite3/board/board_list">게시판</a></li>
</c:when>
<c:otherwise>
	<li><a href="/mysite3/guestbook/list">방명록</a></li>
	<li><a href="/mysite3/board/board_list">게시판</a></li>
</c:otherwise>
</c:choose>
</ul>