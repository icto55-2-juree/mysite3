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
<title>Board List</title>
<style type="text/css">
#content{
background-image: url("assets/images/rilak2.JPG");
height: 600px;

}
input[type="submit"] {
}

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

#title{
width: 500px;
}
#writer, #date{
width: 100px;
}

#cnt{
width: 100px;
}
</style>
</head>
<body>
	<div id="container">
		<div id="header">
			<jsp:include page="/WEB-INF/views/include/header.jsp" flush="false" />
		</div>
		<!-- Table -->
				<div id="content">
		
		<form action="/mysite3/board/insert" method="get">
		<div id="writeBtn">
			<input type="submit" value="글쓰기">
			</div>
		<table class="type10">
		<tr>
					<th></th>
					<th id= "writer">글쓴이</th>
					<th id="title">제목</th>
					<th width="100">조회수</th>
					<th id="date">날짜</th>
				</tr>
				<c:forEach var="g" items="${list }">
				<tr>
					<td>${g.no }</td>
					<td>${g.member_name } </td>
					<td><a href="/mysite3/board/getBoard?no=${g.no }">${g.title } </a></td>
					<td id="cnt">${g.view_cnt }</td>
					<td>${g.reg_date }</td>
				</tr>
				</c:forEach>
				
			</table>
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