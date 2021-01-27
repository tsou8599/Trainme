package mail;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

@WebServlet("/ActivateAccount")
public class ActivateAccount extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
    public ActivateAccount() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	
		String type = request.getParameter("key");
		String email = request.getParameter("key1");
		String hash = request.getParameter("key2");
		
		MailDao mail = new MailDao();
		int n = mail.changeVerification(type,email, hash);
	
		

				if(n == 1) {
					response.sendRedirect("/_02_login/st-login.jsp");					
					System.out.println("Account Successfully Verified.");
				}else {
					response.sendRedirect("index.jsp");
					
				}
			
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
