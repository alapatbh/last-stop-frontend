<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript">
function validate(){
	var question = document.getElementById("textAreaId").value;
	if(question == ""){
		alert("please write a question before submitting!");
		return false;
	}
	return true;
}

</script>
<link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro&display=swap" rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Questions</h1>
	<table style="margin-left: 20px;font-family: 'Source Sans Pro', sans-serif; width: 60%; font-size: 14px ">
	<c:forEach var="ques" items="${allQuestions}">
	<tr>  
   		 <td style="border: 1px solid #f2f2f2;padding: 6px; border-radius: 10px; background-color: #fcfcfc" >
   		 <c:out value="${ques.question}"/>
   		 </td>
   		 <td style="font-size: 12px;text-align: center;border-radius: 10px;" 
   		 <c:if test="${ques.difficulty eq 'm'.charAt(0)}">bgcolor="#ffce85"</c:if>
   		 <c:if test="${ques.difficulty eq 'h'.charAt(0)}">bgcolor="#ff8585"</c:if>
   		 <c:if test="${ques.difficulty eq 'e'.charAt(0)}">bgcolor="#a2fca5"</c:if> 
   		 <c:if test="${ques.difficulty eq 'e'.charAt(0)}">bgcolor="#e0e0e0"</c:if> 
   		 >
   		 <c:if test="${ques.difficulty eq 'm'.charAt(0)}">medium</c:if>
   		 <c:if test="${ques.difficulty eq 'h'.charAt(0)}">high</c:if>
   		 <c:if test="${ques.difficulty eq 'e'.charAt(0)}">easy</c:if> 
   		 <c:if test="${ques.difficulty eq 't'.charAt(0)}">TUD</c:if> 
   		 </td>
   	</tr> 
	</c:forEach>
	<form action="insertQuestion" onsubmit="return validate();">
		<tr>
			<td>
					<textarea id="textAreaId" name="question" cols="100" ></textarea>
			</td>
			<td>
					<select name="difficulty">
						<option value="e">easy</option>
						<option value="m">medium</option>
						<option value="h">hard</option>
					</select>
					<input type="hidden" name="id" value="${topicId}">
			</td>
		</tr> 
		<tr>
		<td colspan="2" style="text-align: center;" ><input type="submit" value="submit"></td>
		</tr> 
		</form>
	</table>
</body>
</html>