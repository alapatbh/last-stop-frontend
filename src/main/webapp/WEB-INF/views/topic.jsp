<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script>
function validate(){
	var question = document.getElementById("topicFieldId").value;
	if(question == ""){
		alert("please write a topic name before submitting!");
		return false;
	}
	return true;
}
</script>

</head>
<body>
<h1>Topics</h1>
	<table style="margin-left: 20px">
	<c:forEach var="topic" items="${allTopics}">
	<tr>  
   		 <td>&bull;&nbsp;&nbsp;&nbsp;<a href="/topic?id=${topic.topicId}">${topic.topicName }</a> </td>
   	</tr> 
	</c:forEach>
	<form action="insertTopic" onsubmit="return validate();">
	<tr>
		<td>
			<input type="text" name="topicName" id="topicFieldId" >
			<input type="hidden" name="chapterId" value="${chapterIdInput }">
		</td>
	</tr>
	<tr>
		<td><input type="submit" value="Add topic"> </td>
	</tr>
	</form>  
	</table>
</body>
</html>