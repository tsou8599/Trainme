<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
  </head>
  <body>
    <select name="" id="list">
		<option value=""></option>
	</select>

    <script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>
    <script>
      var list = document.getElementById("list");

      //   var gyms = document.getElementById('student');
      axios.get("/dmot/StudentList").then(function (res) {
        var users = res.data;
		console.log(users);
		for(user of users){
			var option = document.createElement("option");
			option.value = user.stNo;
			option.innerHTML = user.name;
			list.appendChild(option);
		}

      });
    </script>
  </body>
</html>
