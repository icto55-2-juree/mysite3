<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="fn"%>
<!DOCTYPE html PUBLIC>
<html>
<head>
<meta charset="UTF-8">
<link href="/mysite3/assets/css/user.css" rel="stylesheet"
	type="text/css">
<title>Insert title here</title>
<style type="text/css">


table.type10 {
    border-collapse: collapse;
    text-align: left;
    line-height: 1.5;
    border-top: 1px solid #ccc;
    border-bottom: 1px solid #ccc;
    margin: 20px 40px;
    width: 500px;
    
}
table.type10 th {
 /*   width: 150px; */
    padding: 10px;
    font-weight: bold;
    vertical-align: top;
    color: #fff;
    background: #e7708d;
    margin: 20px auto 0 auto;
}
table.type10 #tbody{
   /*  width: 150px; */
    padding: 10px;
}
table.type10 td {
   /*  width: 350px; */
    padding: 10px;
    vertical-align: top;
}
table.type10 .even {
    background: #fdf3f5;
}

h1 {
	margin: 20px;
}

span {
	margin: 10px;
}
#button {
	background-color: white;
	font-family: 'Nanum Gothic';
	float: right;
	padding: 10px;
}

#contentstd{
height: 300px;
width: 500px;
}
#list {
text-align: center;
}
input[type="submit"] {
  display:  inline;
  width: 30;
  margin: 0;
}
#inputBtn{
margin: 0;
margin-top: 10px;
padding: 10px;
text-align: center;
}
#logina{
margin: 0 auto;
font-size: 20px;
}
</style>
</head>
<body>
	<div id="container">
		<div id="header">
			<jsp:include page="/WEB-INF/views/include/header.jsp" flush="false" />
		</div>
		<!-- 등록순으로 보여지는 첫번째 탭 -->
		<!-- Table -->
		<div id="content">
		<c:choose>
			<c:when test="${empty authMember  }">
				<li id="logina"><a href="/mysite3/member/login">로그인</a>시 게시판을 이용하실 수 있습니다.</li>
			</c:when>	
			<c:otherwise>
			
			
			<form action="/mysite3/board/insert" method="post">
				
				<table class="type10">
				<tr>
					<th id= "writer">${authMember.name }</th>
					<th colspan="3" id="title">제목: <input type="text" name="title"></th>
					
				</tr>
				<tr>
					<td colspan="3" rowspan="10"><input type="text" name="contents" id ="contentstd"></td>
				</tr>
			</table>
			<div id="inputBtn">
				<input type="submit" value="등록">
				<input type="reset" value="취소">
			</div>	
			</form>
			<div id="list">
				<a href="/mysite3/board/board_list">리스트로 돌아가기</a>
			</div>
			
			</c:otherwise>
		</c:choose>
		</div>	
			<div id="navigation">
				<c:import url="/WEB-INF/views/include/navigation.jsp">
					<c:param name="type" value="main"></c:param>
				</c:import>
			</div>
			<div id="footer">
				<c:import url="/WEB-INF/views/include/footer.jsp"></c:import>
			</div>
		</div>
	
</body>
</html>