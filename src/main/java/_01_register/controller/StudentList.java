package _01_register.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import _01_register.model.StudentBean;
import _01_register.service.MemberService;
import _01_register.service.impl.MemberServiceImpl;
import model.GymBean;


@WebServlet("/StudentList")
public class StudentList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public StudentList() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8"); // 文字資料轉內碼
		response.setContentType("application/json; charset=utf-8");
		MemberService service = new MemberServiceImpl();
		List<StudentBean> list = service.listAll();
//		System.out.println(list);
		
		try (PrintWriter out = response.getWriter()){
			//把list轉成Json檔
			String st = new Gson().toJson(list);
			// 回傳回瀏覽器
			out.write(st);
			out.flush();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
    
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		request.setCharacterEncoding("UTF-8"); // 文字資料轉內碼
//		response.setContentType("application/json; charset=utf-8");
//		MemberService service = new MemberServiceImpl();
//		List<GymBean> gym = service.gymList();
////		System.out.println(list);
//		
//		try (PrintWriter out = response.getWriter()){
//			//把list轉成Json檔
//			String st = new Gson().toJson(gym);
//			// 回傳回瀏覽器
//			out.write(st);
//			out.flush();
//			
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
//		
//	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
