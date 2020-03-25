<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Chapters</title>
</head>
<body>
	<h1> Chapters of </h1>
	<table style="margin-left: 20px">
	<c:forEach var="chapter" items="${allChapters}">
	<tr>  
   		 <td>&bull;&nbsp;&nbsp;&nbsp;<a href="/chapter?id=${chapter.chapterId }"><c:out value="${chapter.chapterName}"/></a></td>
   	</tr> 
	</c:forEach>  
	</table>
</body>
</html>