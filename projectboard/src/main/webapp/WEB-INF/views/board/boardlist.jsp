<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ page import="java.util.*"%>
<%@ page import="com.example.demo.model.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!doctype html>
<html lang="ko">
<head>
	<meta charset="UTF-8">
	<title>게시판 목록</title>
    <link rel="stylesheet" href="./css/bbs.css" type="text/css">
</head>

<body>
	<!-- 게시판 리스트 -->
	<div id="bbslist_wrap">
		<h2 class="bbslist_title">게시판 목록</h2>
		<div id="bbslist_c">글 개수 : ${listCount}</div>

		<table id="bbslist_t">
			<tr align="center" valign="middle" bordercolor="#333333">
				<td style="font-family: Tahoma; font-size: 11pt;" width="8%"
					height="26">
					<div align="center">번호</div>
				</td>
				<td style="font-family: Tahoma; font-size: 11pt;" width="47%">
					<div align="center">제목</div>
				</td>
				<td style="font-family: Tahoma; font-size: 11pt;" width="14%">
					<div align="center">작성자</div>
				</td>
				<td style="font-family: Tahoma; font-size: 11pt;" width="17%">
					<div align="center">날짜</div>
				</td>
				<td style="font-family: Tahoma; font-size: 11pt;" width="14%">
					<div align="center">조회수</div>
				</td>
			</tr>

            <!-- 화면 출력 번호  변수 정의 -->		
			<c:set var="num" value="${listCount-(page-1)*10}"/> 	
	
			${num}
            <c:forEach var="b" items="{boardList}">
                ${b.board_subject}
            </c:forEach>
        </table>
</body>
</html>