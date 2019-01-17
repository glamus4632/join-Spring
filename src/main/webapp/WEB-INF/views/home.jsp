<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P><%-- ${serverTime1}처럼 없는 변수를 적으면 에러가 안나고 동작도 안한다 --%>
<form action="<%= request.getContextPath() %>/" method="GET"><%-- 홈 컨트롤러로 전송 --%>
	<input type="text" name="id" id="id">
	<button type="submit">전송</button>
</form>
<a href="<%= request.getContextPath() %>/signup">회원가입</a>

<script type="text/javascript">
	var signup = ${signup};
	if(signup == true) alert("회원가입에 성공했습니다.");
</script>
</body>
</html>
