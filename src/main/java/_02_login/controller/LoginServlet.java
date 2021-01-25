﻿package _02_login.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import _00_init.util.GlobalService;
import _01_register.model.StudentBean;
import _01_register.service.MemberService;
import _01_register.service.impl.MemberServiceImpl;

@WebServlet("/_02_login/login.do")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		// 定義存放錯誤訊息的Map物件
		Map<String, String> errorMsgMap = new HashMap<String, String>();

		// 將errorMsgMap放入request物件內，識別字串為 "ErrorMsgKey"
		request.setAttribute("ErrorMsgKey", errorMsgMap);
		// 1. 讀取使用者輸入資料
		String email = request.getParameter("email");
		String password = request.getParameter("pswd");
		
		String requestURI = (String) session.getAttribute("requestURI");
		// 2. 進行必要的資料轉換
		// 無
		// 3. 檢查使用者輸入資料
		// 如果 userId 欄位為空白，放一個錯誤訊息到 errorMsgMap 之內
		if (email == null || email.trim().length() == 0) {
			errorMsgMap.put("EmailEmptyError", "信箱必須輸入");
		}
		// 如果 password 欄位為空白，放一個錯誤訊息到 errorMsgMap 之內
		if (password == null || password.trim().length() == 0) {
			errorMsgMap.put("PasswordEmptyError", "密碼欄必須輸入");
		}

		// 如果 errorMsgMap 不是空的，表示有錯誤，交棒給login.jsp
		if (!errorMsgMap.isEmpty()) {
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			rd.forward(request, response);
			return;
		}

		// **********Remember Me****************************
//		Cookie cookieUser = null;
//		Cookie cookiePassword = null;
//		Cookie cookieRememberMe = null;
//		
//		
//	
//			cookieUser = new Cookie("user", email);
//			cookieUser.setMaxAge(0); // MaxAge==0 表示要請瀏覽器刪除此Cookie
//			cookieUser.setPath(request.getContextPath());
//
//			String encodePassword = GlobalService.encryptString(password);
//			cookiePassword = new Cookie("password", encodePassword);
//			cookiePassword.setMaxAge(0);
//			cookiePassword.setPath(request.getContextPath());
//
//			cookieRememberMe = new Cookie("rm", "true");
//			cookieRememberMe.setMaxAge(0);
//			cookieRememberMe.setPath(request.getContextPath());
//		
//		response.addCookie(cookieUser);
//		response.addCookie(cookiePassword);
//		response.addCookie(cookieRememberMe);
		// ********************************************

		// 4. 進行 Business Logic 運算
		// 將MemberServiceImpl類別new為物件，存放物件參考的變數為 loginService
		MemberService studentService = new MemberServiceImpl();

		// 將密碼加密兩次，以便與存放在表格內的密碼比對
//		password = GlobalService.getMD5Endocing(GlobalService.encryptString(password));
		StudentBean sb = null;
		try {
			// 呼叫 loginService物件的 checkIDPassword()，傳入userid與password兩個參數
			sb = (StudentBean) studentService.checkIdPassword(email, password);
			if (sb != null) {
				// OK, 登入成功, 將mb物件放入Session範圍內，識別字串為"LoginOK"
				session.setAttribute("LoginOK", sb);
			} else {
				// NG, 登入失敗, userid與密碼的組合錯誤，放相關的錯誤訊息到 errorMsgMap 之內
				errorMsgMap.put("LoginError", "該帳號不存在或密碼錯誤");
			}
		} catch (RuntimeException ex) {
			errorMsgMap.put("LoginError", ex.getMessage());
		}

		// 5.依照 Business Logic 運算結果來挑選適當的畫面
		// 如果 errorMsgMap 是空的，表示沒有任何錯誤，交棒給下一棒
		if (errorMsgMap.isEmpty()) {
			if (requestURI != null) {
				requestURI = (requestURI.length() == 0 ? request.getContextPath() : requestURI);
				response.sendRedirect(response.encodeRedirectURL(requestURI));
				return;
			} else {
				response.sendRedirect(response.encodeRedirectURL(request.getContextPath()));
				return;
			}
		} else {
			// 如果errorMsgMap不是空的，表示有錯誤，交棒給login.jsp
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			rd.forward(request, response);
			return;
		}
	}
}
