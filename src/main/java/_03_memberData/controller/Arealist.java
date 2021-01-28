package _03_memberData.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import _01_register.service.MemberService;
import _01_register.service.impl.MemberServiceImpl;
import _03_memberData.model.MemDataDao;
import model.AreaBean;
import model.GymBean;


@WebServlet("/AreaList")
public class Arealist extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8"); 
		response.setContentType("application/json; charset=utf-8");

//		String cityId = request.getParameter("cityId");
		String cityId = request.getParameter("cityId");
		System.out.println(cityId);
		
		MemDataDao dao = new MemDataDao();
		List<AreaBean> area = dao.areaList(Integer.parseInt(cityId));


		
		try (PrintWriter out = response.getWriter()){
			
			String st = new Gson().toJson(area);
			
			out.write(st);
			out.flush();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
