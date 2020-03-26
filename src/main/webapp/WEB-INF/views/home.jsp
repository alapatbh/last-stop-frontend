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
	var question = document.getElementById("courseFieldId").value;
	if(question == ""){
		alert("please write a Course name before submitting!");
		return false;
	}
	return true;
}
</script>

</head>
<body>
<h1>Courses</h1>
	<table style="margin-left: 20px">
	<c:forEach var="course" items="${allCourses}">
	<tr>  
   		 <td>&bull;&nbsp;&nbsp;&nbsp;<a href="/course?id=${course.courseId }"><c:out value="${course.courseName}"/></a></td>
   	</tr> 
	</c:forEach>
	<form action="insertCourse" onsubmit="return validate();">
	<tr>
		<td>
			<input type="text" name="courseName" id="courseFieldId" >
		</td>
	</tr>
	<tr>
		<td><input type="submit" value="submit"> </td>
	</tr>
	</form>   
	  
	</table>
</body>
</html>