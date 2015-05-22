<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="fn"%>
<!DOCTYPE html PUBLIC>
<html>
<head>
<meta charset="UTF-8">
<link href="/mysite3/assets/css/user.css" rel="stylesheet" type="text/css">
<title>Insert title here</title>
<style type="text/css">

h1{
margin: 20px;
}
span{
margin: 10px;
}
#respond{
	margin-bottom: 10px;
	margin-top: 10px;
margin: 0 auto;
width: 940px;
}
#button{
	background-color: white;
	font-family: 'Nanum Gothic';
	float: right;
	padding: 10px;
}
#content {
	background-image: url("assets/images/rilak2.JPG");
	height: 600px;
	font-size: 15px;
}

#detailTable{
padding: 0;
margin-top: 30px;
border: solid;
width: 500px;
height: 500px;
margin: 0 auto;
}
#button {
	font-family: 'Nanum Gothic';
	float: right;
	margin-right: 30px;
	padding: 20px;
}

#contents {
height: : 400px;
}

#list {
text-align: center;
}
#title{
height: 20px;
font-size: 20px;
}
#top{
height: 20px;
text-align: left;
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
			<form action="/mysite3/board/editBoard?no=${vo.no }" method="post">
				<table id="detailTable">
				<tr>
					<th colspan="2" id="title"><input type="text" name="title" value="${vo.title}"></th>
				<tr>
					<!-- 글 상세 페이지 -->
					<div id="top">
						<tr>
							<td>${vo.member_name } </td>
							<td>${vo.reg_date }</td>
						</tr>
					</div>
						<tr>
					<td colspan="2"><input type="text" name="content" value="${vo.content }"></td></tr>
					
			</table>
				<input type="submit" value="수정">
			</form>
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