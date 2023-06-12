package com.javalec.bbs.homecontroller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javalec.bbs.dao.NDOrdersDao_OKH;

/**
 * Servlet implementation class NDRefund
 */
@WebServlet("/NDRefund")
public class NDRefund extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NDRefund() {
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
		int ordercode = Integer.parseInt(request.getParameter("ordercode"));
		
		NDOrdersDao_OKH ordersDao_OKH = new NDOrdersDao_OKH();
		int result;
		try {
			ordersDao_OKH.refundupdate(ordercode);
			result = 0;
		} catch (Exception e) {
			result = 1;
		}
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(result);
	}

}
