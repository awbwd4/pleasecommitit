<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%-- <%@ taglib uri="http://java.sun.com/jsp/jstl.core" prefix="c" %> --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page session="false" import="java.util.*" %>  
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>error_page.jsp</title>
</head>
<body>

	<h4><c:out value="${exception.getMessage()}"></c:out></h4>
	
	<ul>
		<c:forEach items="${exception.getStackTrace() }" var="stack">
			<li>
				<c:out value="${stack}"></c:out>
			</li>
		</c:forEach>
	</ul>

</body>
</html>