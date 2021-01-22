<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>加入會員</title>

<style>
#bigbox {
	border: 5px rgb(103, 202, 153) dashed;
	border-radius: 30px;
	width: 800px;
	min-height: 1000px;
	margin: 0 auto;
	text-align: center;
}

#photo {
	height: 150px;
	width: 150px;
	border: 3px rgb(0, 0, 0) solid;
	border-radius: 50%;
	margin: 30px;
	text-align: center;
	/* 出現手指按紐 */
	cursor: pointer
}

#theFile {
	display: none;
}

.memberDataBox {
	margin: 10px;
}

.memberDataForm {
	/* border: 3px rgb(251, 255, 16) solid; */
	width: 100%; /* 表單寬度 */
	line-height: 40px; /* 間距 */
}

.memberDataLabel {
	/* border: 3px rgb(255, 24, 24) solid; */
	width: 100px;
	display: inline-block;
}

.mdiDiv {
	/* border: 3px rgb(24, 255, 128) solid; */
	width: 200px;
	display: inline-block;
}

.mdiInput {
	height: 20px;
	border-radius: 20px;
	outline: none;
}

#sex {
	border: 2px rgb(0, 0, 0) solid;
	width: 165px;
	height: 25px;
	padding: 0 0 0 70px;
}

#submitBt {
	margin: 50px;
	width: 80px;
	height: 30px;
	border-radius: 20px;
}

/* #errorMsg { */
/*     position:relative; */
/*     top:0px;  */
/*     left:0px;     */
/* 	color:#FF0000; */
/* 	font-size:0.8em; */
/* } */
</style>
<script type="text/javascript">
	//由<body>的onLoad事件處理函數觸發此函數
	function setFocusToUserId() {
		document.forms[0].mid.focus(); // 將游標放在mid欄位內
	}
</script>
</head>
<body onLoad="setFocusToUserId()">
	<c:set var="funcName" value="REG" scope="session" />
	<!-- 引入共同的頁首 -->
	<jsp:include page="/fragment/topMVC.jsp" />
	<div id="bigbox">
		<h1>學員註冊</h1>
		

		<!-- 用label包住<input>時，按label就等同於按input -->
<!-- 		<label> <img src="/Shinnosuke/Shinnosuke1.jpg" alt="" -->
<!-- 			id="photo"> <input type="file" accept="image/*" id="theFile" -->
<!-- 			class="fileInput" value="" /> accept : 限制上傳檔案類型 -->
<!-- 		</label> -->

		<div class="memberDataBox">
			<!-- 表單內有夾帶檔案要使用，enctype="multipart/form-data" 要求不進行URL編碼，避免破壞檔案組成結構 -->
			<form method="post" action="<c:url value='/_01_tr_register/Tr_RegisterServletMP.do'  />"  class="memberDataForm" enctype="multipart/form-data">
				
				<div class="memberDataBox">
					<div class="memberDataLabel">
						<label for="txt_name">姓 名：</label>						
					</div>
					<div class="mdiDiv">
						<input type="text" class="mdiInput" id="txt_name"  name='name'  value="${param.name}"
							required="required" />
					</div>
					<div>
						<font color="red" size="-1">${MsgMap.errorName}</font>      
					</div>
				</div>
				<div class="memberDataBox">
					<div class="memberDataLabel">
						<label for="txt_phone">電 話：</label>
					</div>
					<div class="mdiDiv">
						<input type="text" class="mdiInput" id="txt_phone"  name='phone'  value="${param.phone}"
							required="required" />					
					</div>
					<div>
						<font color="red" size="-1">${MsgMap.errorPhone}</font> 
					</div>	
				</div>
				<div class="memberDataBox">
					<div class="memberDataLabel">
						<label for="txt_birth">生 日：</label>
					</div>
					
					<div class="mdiDiv">
						<input type="date" class="mdiInput" id="txt_birth" name='birthday'
							required="required" />
					</div>
					<div>
						<font color="red" size="-1">${MsgMap.errorbirthday}</font> 
					</div>
				</div>
				<div class="memberDataBox">
					<div class="memberDataLabel">
						<label for="txt_email">Email : </label>
					</div>
					<div class="mdiDiv">
						<input type="email" class="mdiInput" id="txt_email" name='email'  value="${param.email}"
							required="required" placeholder="abc@google.com" />
					</div>
					<div>
						<font color="red" size="-1">${MsgMap.errorEmail} ${MsgMap.emailError} </font> 
					</div>
				</div>
				<div class="memberDataBox">
					<div class="memberDataLabel">
						<label for="txt_psw">密 碼 : </label>
					</div>
					<div class="mdiDiv">
						<input type="password" class="mdiInput" id="txt_psw" name='password'
							required="required" />
					</div>
					<div>
						<font color="red" size="-1">${MsgMap.errorPasswordEmpty} ${MsgMap.passwordError}</font>      
					</div>
				</div>
				<div class="memberDataBox">
					<div class="memberDataLabel">
						<label for="txt_psw">密 碼 確 認 : </label>
					</div>
					<div class="mdiDiv">
						<input type="password" class="mdiInput" id="txt_pswcheck" name='passwordcheck'
							required="required" />
					</div>
					<div>
						<font color="red" size="-1">${MsgMap.errorPpasswordCcheckEmpty} ${MsgMap.passwordCheckError}</font>      
					</div>
				</div>
				<div class="memberDataBox">
					<div class="memberDataLabel">
						<label for="txt_id">身分證：</label>
					</div>
					<div class="mdiDiv">
						<input type="text" class="mdiInput" id="txt_id" name='id'
							required="required" />
					</div>
					<div>
						<font color="red" size="-1">${MsgMap.errorId}</font> 
					</div>
				</div>
				<div class="memberDataBox">
					<div class="memberDataLabel">
						<label for="txt_sex">性 別 : </label>
					</div>
					<div class="mdiDiv">
						<select name="sex" id="sex" class="mdiInput">
							<option value="man">男</option>
							<option value="woman">女</option>
						</select>
					</div>
				</div>
				
				<input type="submit" id="submitBt" />

			</form>

		</div>
	</div>

	<script>
		//送出表單
		let submitBt = document.getElementById('submitBt');
		submitBt.addEventListener('click', function() {
			let form = document.forms[0];
			form.submit();
		})

		//更換大頭照
		let theFile = document.getElementById('theFile');
		theFile.addEventListener('change', function() {
			showImg(theFile);

		})

		function showImg(imgFile) {
			var file = imgFile.files[0];

			// 建立FileReader物件
			var fr = new FileReader();

			let photo = document.getElementById('photo');
			//註冊load事件
			fr.addEventListener('load', function(e) {
				photo.src = e.target.result;
			});
			//readAsDataURL去讀 file 把檔案轉成 URL
			fr.readAsDataURL(file);

		}
	</script>
</body>
</html>