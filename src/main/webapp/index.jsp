<%@ page language="java" contentType="text/html; charset=UTF-8" 
	pageEncoding="UTF-8"%>
<jsp:useBean id="SYSTEM" class="_00_init.util.GlobalService" scope="application"/>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<c:set var="AppName" value="${SYSTEM.systemName}" scope="application"/>
<title>${AppName}</title>
</head>
<body>
<!-- 設定變數funcName的值為"IND", top.jsp會使用此變數-->
<c:set var="funcName" value="IND" scope="session"/>
<!-- 引入共同的頁首 -->
<jsp:include page="/fragment/topMVC.jsp" />
<div align='center'>
 <h1>
 歡迎光臨<br><font color='RED'>${AppName}</font><br>
 天天有優惠，天天有好康<br>
 今天舉辦<font color='BLUE'>滿佰送仟</font>的促銷活動<br>
  </h1> 
 <br>
  <h2>
 本店絕不販賣盜版書、山寨書與過期書
 </h2>
   <hr>
   <p style='font-family: "Verdana"; color: red'>
  本範例需要先執行_00_init.EDMTableReset.java來建立初始資料 
 </p>
  ${logoutMessage}${MsgOK.InsertOK}<br>
 <br>  
 <% // 顯示MsgOK.InsertOK後，就要立刻移除，以免每次回到首 頁都會顯示新增成功的訊息
    session.removeAttribute("MsgOK");  
 %>
 </div>
</body>
</html>