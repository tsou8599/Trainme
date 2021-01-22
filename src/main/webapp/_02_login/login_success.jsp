
<!DOCTYPE HTML>
<html>
<head>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<meta charset="UTF-8">
<title>登入成功</title>
 <style>
        #box{
            border: 5px solid rgb(221, 97, 66);
            border-radius: 30px;
            height: 400px;
            width: 400px;
            margin: 100px auto;
        }
        #success{
            
            font-size: 50px;
            text-align: center;
            color: rgb(38, 147, 197);
        }
        #con{
            font-size: 30px;
            text-align: center;
            color: rgb(38, 147, 197);
        }
        #img{
            
            border: 3px solid rgb(3, 3, 3);
            border-radius: 50%;
            width: 120px;
            height: 120px;

        }
        #imgDiv{
            /* border: 1px solid red; */
            text-align: center;
        }


    </style>
</head>
<body>
    <div id="box">
        <p id="success">
        登入成功
    </p>
    <div id="imgDiv">
        
        <img id="img" src="..\images\like-1.1s-258px.png" alt="">
    </div>
        <p id="con">
            即將跳轉首頁
        </p>
    </div>
</body>
</html>