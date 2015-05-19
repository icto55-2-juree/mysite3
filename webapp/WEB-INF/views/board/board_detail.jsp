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
#ctd{
height: 200px;
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
			<div id="button">
				<a href="/mysite3/board/editBoard?no=${vo.no }">수정 |</a> <a
					href="/mysite3/board/deleteBoard?no=${vo.no }"> 삭제</a>
			</div>
			<table class="type10">
				<tr>
					<th colspan="2">${vo.title }</th>
				<tr>
					<!-- 글 상세 페이지 -->
					<div id="top">
						<tr>
							<td>${vo.member_name } </td>
							<td>${vo.reg_date }</td>
						</tr>
					</div>
						<tr>
					<td id="ctd" colspan="2">${vo.content }</td></tr>
					
			</table>
			<div id="list">
				<a href="/mysite3/board/board_list">리스트로 돌아가기</a>
			</div>
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