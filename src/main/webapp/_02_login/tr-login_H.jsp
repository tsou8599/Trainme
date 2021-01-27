<%--
	執行本網頁之前，會先執行_02_login.filter.FindUserPassword.java這個過濾器。執行過濾器目的
	在檢視請求物件是否含有帳號與密碼等資料。
	  
        本網頁 login.jsp 提供登入的畫面，讓使用者輸入帳號與密碼。輸入完畢後，按下Submit按鈕，瀏覽器
        會帳號與密碼給  <Form>標籤action屬性對應的程式: _02_login.controller.LoginServlet.java，
        由該Servlet來檢查帳號與密碼是否正確。
            
--%>
<!DOCTYPE HTML>
<html>
<head>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<meta charset="UTF-8">
<title>登入</title>
<style>
*, *::before, *::after {
	box-sizing: border-box;
}

body {
	margin: 0;
	font-family: Roboto, -apple-system, "Helvetica Neue", "Segoe UI", Arial,
		sans-serif;
	background: #3b4465;
}

.forms-section {
	display: flex;
	flex-direction: column;
	justify-content: center;
	align-items: center;
}

.section-title {
	font-size: 32px;
	letter-spacing: 1px;
	color: #fff;
}

.forms {
	display: flex;
	align-items: flex-start;
	margin-top: 30px;
}

.form-wrapper {
	animation: hideLayer 0.3s ease-out forwards;
}

.form-wrapper.is-active {
	animation: showLayer 0.3s ease-in forwards;
}

@
keyframes showLayer { 50% {
	z-index: 1;
}

100






%
{
z-index






:






1




;
}
}
@
keyframes hideLayer { 0% {
	z-index: 1;
}

49






.999


 


%
{
z-index




:


 


1




;
}
}
.switcher {
	position: relative;
	cursor: pointer;
	display: block;
	margin-right: auto;
	margin-left: auto;
	padding: 0;
	text-transform: uppercase;
	font-family: inherit;
	font-size: 16px;
	letter-spacing: 0.5px;
	color: #999;
	background-color: transparent;
	border: none;
	outline: none;
	transform: translateX(0);
	transition: all 0.3s ease-out;
}

.form-wrapper.is-active .switcher-login {
	color: #fff;
	transform: translateX(90px);
}

.form-wrapper.is-active .switcher-signup {
	color: #fff;
	transform: translateX(-90px);
}

.underline {
	position: absolute;
	bottom: -5px;
	left: 0;
	overflow: hidden;
	pointer-events: none;
	width: 100%;
	height: 2px;
}

.underline::before {
	content: "";
	position: absolute;
	top: 0;
	left: inherit;
	display: block;
	width: inherit;
	height: inherit;
	background-color: currentColor;
	transition: transform 0.2s ease-out;
}

.switcher-login .underline::before {
	transform: translateX(101%);
}

.switcher-signup .underline::before {
	transform: translateX(-101%);
}

.form-wrapper.is-active .underline::before {
	transform: translateX(0);
}

.form {
	overflow: hidden;
	min-width: 500px;
	/* min-height: 600px; */
	margin-top: 50px;
	padding: 30px 25px;
	border-radius: 5px;
	transform-origin: top;
}

.form-signup {
	min-width: 500px;
	min-height: 600px;
}

.form-login {
	animation: hideLogin 0.3s ease-out forwards;
}

.form-wrapper.is-active .form-login {
	animation: showLogin 0.3s ease-in forwards;
}

@
keyframes showLogin { 0% {
	background: #d7e7f1;
	transform: translate(40%, 10px);
}

50






%
{
transform






:






translate




(






0
,
0






)




;
}
100






%
{
background-color






:






#fff




;
transform






:






translate




(






35




%
,
-20px






)




;
}
}
@
keyframes hideLogin { 0% {
	background-color: #fff;
	transform: translate(35%, -20px);
}

50






%
{
transform






:






translate




(






0
,
0






)




;
}
100






%
{
background






:






#d7e7f1




;
transform






:






translate




(






40




%
,
10px






)




;
}
}
.form-signup {
	animation: hideSignup 0.3s ease-out forwards;
}

.form-wrapper.is-active .form-signup {
	animation: showSignup 0.3s ease-in forwards;
}

@
keyframes showSignup { 0% {
	background: #d7e7f1;
	transform: translate(-40%, 10px) scaleY(0.8);
}

50






%
{
transform






:






translate




(






0
,
0






)






scaleY




(






0




.8






)




;
}
100






%
{
background-color






:






#fff




;
transform






:






translate




(






-35




%
,
-20px






)






scaleY




(






1






)




;
}
}
@
keyframes hideSignup { 0% {
	background-color: #fff;
	transform: translate(-35%, -20px) scaleY(1);
}

50






%
{
transform






:






translate




(






0
,
0






)






scaleY




(






0




.8






)




;
}
100






%
{
background






:






#d7e7f1




;
transform






:






translate




(






-40




%
,
10px






)






scaleY




(






0




.8






)




;
}
}
.form fieldset {
	position: relative;
	opacity: 0;
	margin: 0;
	padding: 0;
	border: 0;
	transition: all 0.3s ease-out;
}

.form-login fieldset {
	transform: translateX(-50%);
}

.form-signup fieldset {
	transform: translateX(50%);
}

.form-wrapper.is-active fieldset {
	opacity: 1;
	transform: translateX(0);
	transition: opacity 0.4s ease-in, transform 0.35s ease-in;
}

.form legend {
	position: absolute;
	overflow: hidden;
	width: 1px;
	height: 1px;
	clip: rect(0, 0, 0, 0);
}

.input-block {
	margin-bottom: 20px;
}

.input-block label {
	font-size: 14px;
	color: #a1b4b4;
}

.input-block input {
	display: block;
	width: 100%;
	margin-top: 8px;
	padding-right: 15px;
	padding-left: 15px;
	font-size: 16px;
	line-height: 40px;
	color: #3b4465;
	background: #eef9fe;
	border: 1px solid #cddbef;
	border-radius: 2px;
}

#sex, #gymList {
	display: block;
	width: 100%;
	height: 50px;
	margin-top: 8px;
	padding-right: 15px;
	padding-left: 15px;
	font-size: 16px;
	line-height: 40px;
	color: #3b4465;
	background: #eef9fe;
	border: 1px solid #cddbef;
	border-radius: 2px;
}

.form [type="submit"] {
	opacity: 0;
	display: block;
	min-width: 120px;
	margin: 30px auto 10px;
	font-size: 18px;
	line-height: 40px;
	border-radius: 25px;
	border: none;
	transition: all 0.3s ease-out;
}

.form-wrapper.is-active .form [type="submit"] {
	opacity: 1;
	transform: translateX(0);
	transition: all 0.4s ease-in;
}

.btn-login {
	color: #fbfdff;
	background: #a7e245;
	transform: translateX(-30%);
}

.btn-signup {
	color: #a7e245;
	background: #fbfdff;
	box-shadow: inset 0 0 0 2px #a7e245;
	transform: translateX(30%);
}
</style>
</head>
<body>
	<section class="forms-section">
		<h1 class="section-title" id="dataFiller">Animated Forms</h1>
		<div class="forms">


			<div class="form-wrapper is-active" id="logIn">
				<button type="button" class="switcher switcher-login">
					Login <span class="underline"></span>
				</button>
				<form action="<c:url value='tr-login.do' />" method="POST"
					name="loginForm" class="form form-login">
					<fieldset>
						<legend>Please, enter your email and password for login.</legend>
						<div class="input-block">
							<label for="login-email">E-mail</label> <input id="login-email"
								type="email" name="lgEmail" required />
							<div>
								<Font color='red' size="-3">${ErrorMsgKey.AccountEmptyError}</Font>
							</div>
						</div>
						<div class="input-block">
							<label for="login-password">Password</label> <input
								id="login-password" type="password" name="pswd" required />
							<div>
								<Font color='red' size="-3">${ErrorMsgKey.PasswordEmptyError}</Font>
							</div>
						</div>
						<Font color='red' size="-1"> ${ErrorMsgKey.LoginError} </Font>
					</fieldset>
					<button type="submit" class="btn-login">Login</button>
				</form>
			</div>



			<div class="form-wrapper" id="signUp">
				<button type="button" class="switcher switcher-signup">
					Sign Up <span class="underline"></span>
				</button>
				<form class="form form-signup" method="post"
					action="<c:url value='/_01_register/H_Train_RegisterServletMP_Hibernate.do'  />"
					enctype="multipart/form-data">
					<fieldset>
						<legend> Please, enter your email, password and password
							confirmation for sign up. </legend>
						<div class="input-block">
							<label for="signup-email">E-mail :</label> <input
								id="signup-email" type="email" name="email"
								value="${param.email}" required />
							<div>
								<font color="red" size="-1">${MsgMap.errorEmail}
									${MsgMap.emailError} ${MsgMap.emailExists} </font>
							</div>
						</div>
						<div class="input-block">
							<label for="signup-password">密碼 :</label> <input
								id="signup-password" type="password" name='password' required />
							<div>
								<font color="red" size="-1">${MsgMap.errorPasswordEmpty}
									${MsgMap.passwordError}</font>
							</div>
						</div>


						<div class="input-block">
							<label for="signup-password-confirm">密碼確認 :</label> <input
								id="signup-password-confirm" type="password"
								name='passwordcheck' required />
							<div>
								<font color="red" size="-1">${MsgMap.errorPpasswordCcheckEmpty}
									${MsgMap.passwordCheckError}</font>
							</div>
						</div>

						<div class="input-block">
							<label for="signup-name">姓名 : </label> <input id="signup-name"
								type="text" name='name' value="${param.name}" required />
							<div>
								<font color="red" size="-1">${MsgMap.errorName}</font>
							</div>
						</div>

						<div class="input-block">
							<label for="signup-phone">電話 : </label> <input id="signup-phone"
								type="text" name='phone' value="${param.phone}" required />
							<div>
								<font color="red" size="-1">${MsgMap.errorPhone}</font>
							</div>
						</div>

						<div class="input-block">
							<label for="signup-birthday">生日 : </label> <input
								id="signup-birthday" type="date" name='birthday' required />
						</div>

						<div class="input-block">
							<label for="signup-id">身分證字號 : </label> <input id="signup-id"
								type="text" name='id' required />
							<div>
								<font color="red" size="-1">${MsgMap.errorId}</font>
							</div>
						</div>

						<div class="input-block">
							<label for="signup-sex">性別 : </label>  <select name="sex"
								id="sex">
								<option value="man">男</option>
								<option value="woman">女</option>
							</select>
						</div>

						<div class="input-block">
							<label for="signup-id">年資 : </label> <input id="signup-year"
								type="text" name='year' required />
							<div>
								<font color="red" size="-1">${MsgMap.erroryear}</font>
							</div>
						</div>

						<div class="input-block">
							<label for="signup-id">服務健身房 : </label>
							 <select name="gymId" id="gymList"></select> 
							<font color="red" size="-1">${MsgMap.erroryear}</font>
						</div>
						
						<div class="input-block">
							<label for="signup-id">健身房驗證碼 : </label> <input id="signup-year"
								type="text" name='verification' required />
							<div>
								<font color="red" size="-1">${MsgMap.errorverification}</font>
							</div>
						</div>



					</fieldset>
					<button type="submit" class="btn-signup">Continue</button>
				</form>
			</div>
		</div>
	</section>
	<script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>
	<script>
      const switchers = [...document.querySelectorAll(".switcher")];

      switchers.forEach((item) => {
        item.addEventListener("click", function () {
          switchers.forEach((item) =>
            item.parentElement.classList.remove("is-active")
          );
          this.parentElement.classList.add("is-active");
        });
      });
      
      // 解決有錯誤資料時跳轉頁面問題
       <c:if test="${MsgMap.from != null}">
        var forms = document.getElementsByClassName('form-wrapper');
        for (let i = 0; i < forms.length; i++) {
          const form = forms[i];
          form.classList.remove("is-active");
        }
            
        var id = "${MsgMap.from}";
        console.log(id);
        var target = document.getElementById(id);
        target.classList.add('is-active');
      	
      	
       </c:if>
       
       
       // 找到 select 標籤
       var gymList = document.getElementById("gymList");

      // 開始尋找健身房資料的servlet去抓資料，會返回一個promise(承諾)
       axios.get("/dmot/Gymlist")
       .then(function (res) {   //若有抓到資料則執行這個function
         var gyms = res.data; // gyms 為一個物件陣列
 		console.log(gyms);
 		for(gym of gyms){
	 		console.log(gym);
 			var option = document.createElement("option");
 			option.value = gym.id;
 			option.innerHTML = gym.name;
 			gymList.appendChild(option);
 		}
       });
       
       var dataFiller =  document.getElementById("dataFiller");
       
       
       
       
    </script>
</body>
</html>

</html>