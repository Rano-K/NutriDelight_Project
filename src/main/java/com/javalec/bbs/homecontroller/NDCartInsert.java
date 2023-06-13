package com.javalec.bbs.homecontroller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.javalec.bbs.dao.NDUserDao;

/**
 * Servlet implementation class NDCartInsert
 */
@WebServlet("/NDCartInsert")
public class NDCartInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NDCartInsert() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		String pcode = request.getParameter("pcode");
		String userid = "";
		int result;
		
		try {
			userid = (String) session.getAttribute("ID");
		} catch (Exception e) {
			result = 2;
		}
		
		NDUserDao dao = new NDUserDao();
		
		try {
			result = dao.userCartIn(pcode, userid);
		} catch (Exception e) {
			result = 1;
		}
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(result + "");
	}

}
