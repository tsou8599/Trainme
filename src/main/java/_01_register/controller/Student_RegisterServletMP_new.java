package _01_register.controller;

import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import org.apache.commons.codec.digest.DigestUtils;

import _01_register.model.StudentBean;
import _01_register.service.MemberService;
import _01_register.service.impl.MemberServiceImpl;
import mail.SendingEmail;


@MultipartConfig(location = "", fileSizeThreshold = 5 * 1024 * 1024, maxFileSize = 1024 * 1024
		* 500, maxRequestSize = 1024 * 1024 * 500 * 5)

@WebServlet("/dmot/_01_tr_register/Student_RegisterServletMP_new.do")

public class Student_RegisterServletMP_new extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// 設定密碼欄位必須由大寫字母、小寫字母、數字與 !@#$%!^'" 等四組資料組合而成，且長度不能小於八個字元
	private static final String PASSWORD_PATTERN = "((?=.*\\d)(?=.*[a-z]).{6,})";
	private Pattern patternPsw = null;
	private Matcher matcherPsw = null;

	// 設定Email欄位必須必須包含@符號；必須包含點；點和@之間必須有字元
	private static final String Email_PATTERN = "^\\w{1,63}@[a-zA-Z0-9]{2,63}\\.[a-zA-Z]{2,63}(\\.[a-zA-Z]{2,63})?$";
	private Pattern patternMail = null;
	private Matcher matcherMail = null;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
//		JavaMailer javaMailer = new JavaMailer();
//		javaMailer.sendMail("test@gmail.com", "嗨嗨", "<h1>嗨嗨嗨</h1>");
		
		
		request.setCharacterEncoding("UTF-8"); // 文字資料轉內碼
		// 準備存放錯誤訊息的Map物件
		Map<String, String> errorMsg = new HashMap<String, String>();

		// 準備存放註冊成功之訊息的Map物件
		Map<String, String> msgOK = new HashMap<String, String>();
		// 註冊成功後將用response.sendRedirect()導向新的畫面，所以需要
		// session物件來存放共用資料。
		HttpSession session = request.getSession();
		request.setAttribute("MsgMap", errorMsg); // 顯示錯誤訊息
		session.setAttribute("MsgOK", msgOK); // 顯示正常訊息
		

		String name = "";
		String phone = "";
		Date birthday = null;
		String email = "";
		String password = "";
		String passwordcheck = "";
		String id = "";
		String sex = "";
		String myHash = "";
		
		Random theRandom = new Random();
		theRandom.nextInt(999999);
		myHash = DigestUtils.md5Hex("" +	theRandom);

		// 取出HTTP multipart request內所有的parts
		Collection<Part> parts = request.getParts();
//		GlobalService.exploreParts(parts, request);
		// 由parts != null來判斷此上傳資料是否為HTTP multipart request
		if (parts != null) { // 如果這是一個上傳資料的表單
			for (Part p : parts) {
				String fldName = p.getName();
				String value = request.getParameter(fldName);

				// 1. 讀取使用者輸入資料，進行必要的資料轉換
				if (p.getContentType() == null) {
					if (fldName.equals("name")) {
						name = value;
					} else if (fldName.equals("phone")) {
						phone = value;
					} else if (fldName.equals("birthday")) {
						try {
							SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
							java.util.Date date = simpleDateFormat.parse(value);
							birthday = new Date(date.getTime());

						} catch (ParseException e) {
							e.printStackTrace();
						}
					} else if (fldName.equals("email")) {
						email = value;
					} else if (fldName.equals("password")) {
						password = value;
					} else if (fldName.equals("passwordcheck")) {
						passwordcheck = value;
					} else if (fldName.equals("id")) {
						id = value;
					} else if (fldName.equals("sex")) {
						sex = value;
					}

				}
			}

			// 3. 檢查使用者輸入資料
			if (name == null || name.trim().length() == 0) {
				errorMsg.put("errorName", "姓名必須輸入");
			}
			if (phone == null || phone.trim().length() == 0) {
				errorMsg.put("errorPhone", "電話必須輸入");
			}
			if (birthday == null) {
				errorMsg.put("errorbirthday", "生日必須輸入");
			}
			if (email == null || email.trim().length() == 0) {
				errorMsg.put("errorEmail", "電子郵件欄必須輸入");
			}
			if (password == null || password.trim().length() == 0) {
				errorMsg.put("errorPasswordEmpty", "密碼必須輸入");
			}
			if (passwordcheck == null || passwordcheck.trim().length() == 0) {
				errorMsg.put("errorPpasswordCcheckEmpty", "密碼確認必須輸入");
			}
			if (id == null || id.trim().length() == 0) {
				errorMsg.put("errorId", "身分證必須輸入");
			}

			// 如果沒有錯誤
			if (errorMsg.isEmpty()) {
				// 檢查密碼格式
				patternPsw = Pattern.compile(PASSWORD_PATTERN);
				matcherPsw = patternPsw.matcher(password);
				if (!matcherPsw.matches()) {
					errorMsg.put("passwordError", "密碼至少含有一個小寫字母、數字與組合而成，且長度不能小於六個字元");
				}

				// 檢查Email格式
				patternMail = Pattern.compile(Email_PATTERN);
				matcherMail = patternMail.matcher(email);
				if (!matcherMail.matches()) {
					errorMsg.put("emailError", "Email欄位必須包含@符號，必須包含點，點和@之間必須有字元");
				}

				// 檢查密碼欄位和密碼確認欄位是否一致
				if (!password.equals(passwordcheck)) {
					errorMsg.put("passwordCheckError", "密碼欄位並須和密碼確認一致");
				}
			}
			// 如果有錯誤
			if (!errorMsg.isEmpty()) {
				errorResponse(request, response, errorMsg);
				return;
			}
			try {
				// 4. 產生StudentService物件，以便進行Business Logic運算
				// StudentServiceImpl類別的功能：
				// 1.檢查信箱是否已經存在，已存在的信箱不能使用，回傳相關訊息通知使用者修改
				// 2.若無問題，儲存會員的資料
				MemberService service = new MemberServiceImpl();
				if (service.idExists(email)) {
					errorMsg.put("errorIdDup", "此信箱已存在，請換新信箱");
				} else {

//=============================================================================================密碼加密					
					// 為了配合Hibernate的版本。
					// 要在此加密，不要在 dao.saveMember(mem)進行加密
//				password = GlobalService.getMD5Endocing(
//						GlobalService.encryptString(password));

					// 將所有會員資料封裝到StudentBean(類別的)物件

					
//					StudentBean	stdent = new StudentBean(null, null, name, phone, email, birthday, passwordcheck, id, sex, null, null,myHash);
					StudentBean stdent = new StudentBean(null, null, name, phone, email, birthday, password, id, sex, null, null, myHash);
					
					// 呼叫StudentService的saveStudent方法
					int n = service.saveStudent(stdent);
					if (n == 1) {
//=============================================================================================註冊成功後導入頁面	
						SendingEmail se = new SendingEmail(1 ,email, myHash);
						se.sendMail();
						msgOK.put("InsertOK", "<Font color='red'>新增成功，請開始使用本系統</Font>");
						response.sendRedirect("/dmot/_01_tr_register/register_success.jsp");
						return;
					} else {
						errorMsg.put("errorIdDup", "新增此筆資料有誤(RegisterServlet)");
					}
				}

				// 5.依照 Business Logic 運算結果來挑選適當的畫面
				if (!errorMsg.isEmpty()) {
					errorResponse(request, response, errorMsg);
					return;
				}

			} catch (Exception e) {
				e.printStackTrace();
				errorMsg.put("errorIdDup", e.getMessage());
				errorResponse(request, response, errorMsg);
			}
		}
	}

	private void errorResponse(HttpServletRequest request, HttpServletResponse response, Map<String, String> errorMsg)
			throws ServletException, IOException {
		errorMsg.put("from", "signUp");
		RequestDispatcher rd = request.getRequestDispatcher("/_02_login\\st-login.jsp");
		rd.forward(request, response);
	}


}