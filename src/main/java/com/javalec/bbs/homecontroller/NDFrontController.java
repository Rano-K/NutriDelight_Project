package com.javalec.bbs.homecontroller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javalec.bbs.command.NDBoardDeleteCommand_OKH;
import com.javalec.bbs.command.NDBoardModifyCommand_OKH;
import com.javalec.bbs.command.NDBoardInsertCommand_OKH;
import com.javalec.bbs.command.NDBoardSearchCommand_OKH;
import com.javalec.bbs.command.NDCommand;
import com.javalec.bbs.command.NDHeaderCountCommand;
import com.javalec.bbs.command.NDInsertBoardCommand_KMJ;
import com.javalec.bbs.command.NDInsertReviewCommand_KMJ;
import com.javalec.bbs.command.NDKakaoLoginCommand;
import com.javalec.bbs.command.NDLogoutCommand;
import com.javalec.bbs.command.NDMainAdminCommand_OKH;
import com.javalec.bbs.command.NDMainCommand_KMS;
import com.javalec.bbs.command.NDOrdersCheckCommand_OKH;
import com.javalec.bbs.command.NDOrdersGraphCommand_OKH;
import com.javalec.bbs.command.NDOrdersSearchCommand_OKH;
import com.javalec.bbs.command.NDOrdersUpdateCommand_OKH;
import com.javalec.bbs.command.NDProductDeleteCommand_OKH;
import com.javalec.bbs.command.NDProductFindCommand_OKH;
import com.javalec.bbs.command.NDProductInsertCommand_OKH;
import com.javalec.bbs.command.NDProductListCommand_KMS;
import com.javalec.bbs.command.NDProductListSendCommand_KMS;
import com.javalec.bbs.command.NDProductSearchCommand_OKH;
import com.javalec.bbs.command.NDSearchNoticeCommand_KMJ;
import com.javalec.bbs.command.NDSearchReviewCommand_KMJ;
import com.javalec.bbs.command.NDSubscribeScheduleCommand_OKH;
import com.javalec.bbs.command.NDSubscribeSearchCommand_OKH;
import com.javalec.bbs.command.NDSubscribeUpdateCommand_OKH;
import com.javalec.bbs.command.NDUserCartListCommand_LYJ;
import com.javalec.bbs.command.NDUserGraphCommand_OKH;
import com.javalec.bbs.command.NDUserInsertCommand;
import com.javalec.bbs.command.NDUserLoginCommand;
import com.javalec.bbs.command.NDUserOrdersCommand_LYJ;
import com.javalec.bbs.command.NDUserOrdersInsertCommand_LYJ;
import com.javalec.bbs.command.NDUserSearchCommand_OKH;
import com.javalec.bbs.command.NDUserSelectCommand;
import com.javalec.bbs.command.NDWriteBoardPageCommand_KMJ;
import com.javalec.bbs.command.NDWriteReviewPageCommand_KMJ;
import com.javalec.bbs.command.NDuserCartDeleteCommand;

/**
 * Servlet implementation class NDFrontController
 */
@WebServlet("*.do")
public class NDFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public NDFrontController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("doGet");
		actionDo(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("doPost");
		actionDo(request, response);
	}

	private void actionDo(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("actionDo");
		request.setCharacterEncoding("utf-8");
		String viewPage = null;
		NDCommand command = null;

		String uri = request.getRequestURI();
		String conPath = request.getContextPath();

		String com = uri.substring(conPath.length());

		switch (com) {

		/*
		 * Main 구역
		 */
		// Home button 클릭시
		case "/main.do":
			command = new NDHeaderCountCommand();
			command.execute(request, response);
			command = new NDMainCommand_KMS();
			command.execute(request, response);
			viewPage = "index.jsp";
			break;
		// 구독상품 버튼 클릭시
		case "/subscribe.do":
			viewPage = "subscribe.jsp";
			break;
		// 일반상품구매 버튼 클릭시 ->product 목록 페이지로 이동
		case "productList.do":
			command = new NDProductListCommand_KMS();
			command.execute(request, response);
			viewPage = "productList.jsp";
			break;
		case "productInfromSend.do":
			command = new NDProductListSendCommand_KMS();
			command.execute(request, response);
			viewPage = "board.do";
			break;
		// 찜버튼 클릭시
		case "heart.do":
			viewPage = "heart.jsp";
			// 카트
		case "/cart.do":
			command = new NDUserCartListCommand_LYJ();
			command.execute(request, response);
			viewPage = "shoping-cart.jsp";
			break;
		// 삭제
		case "/cartdelete.do":
			command = new NDuserCartDeleteCommand();
			command.execute(request, response);
			viewPage = "cart.do";
			break;
		// 결제 정보
		case "/orders.do":
			command = new NDUserOrdersCommand_LYJ();
			command.execute(request, response);
			viewPage = "orders.jsp";
			break;
		// 결제 하기	
		case "/insertorders.do":
			command = new NDUserOrdersInsertCommand_LYJ();
			command.execute(request, response);
			viewPage = "orders.jsp";
			break;

		// 고객센터 버튼 클릭시 ---------------------------민재야 만들어줘

			
		/*
		 * User 영역 
		 */
		// header-top : 로그인했을 때 : id_session값이 있을 때
		case "/logout.do":
			command = new NDLogoutCommand();
			command.execute(request, response);
			viewPage = "main.do";
			break;
		case "/mypage.do":
			command = new NDUserSelectCommand();
			command.execute(request, response);
			viewPage = "myPage.jsp";
			break;
		// header-top : 로그인안했을 때 : id_session값이 없을 때
		case "/login.do":
			viewPage = "login.jsp";
			break;
		case "/kakaoLogin.do":
			command = new NDKakaoLoginCommand();
			command.execute(request, response);
			viewPage = "login.do";
			break;
		case "/loginCheck.do":
			command = new NDUserLoginCommand();
			command.execute(request, response);
			viewPage = "login.do";
			break;
		case "/registerPage.do":
			// db에서 알러지 정보 불러와야 함
			viewPage = "register.jsp";
			break;
		case "/register.do":
			command = new NDUserInsertCommand();
			command.execute(request, response);
			viewPage = "login.do";
			break;
		case "/duplicate.do":
			// id 찾아서 중복 체크 해야함
			viewPage = "idDupleCheck.jsp";
			break;

		/*
		 * productList구역
		 */
		case "/productList.do":
			command = new NDProductListCommand_KMS();
			command.execute(request, response);
			viewPage = "productList.jsp";
			break;
		// 게시판 및 상품정보

		// 리뷰 불러오기
		case "/board.do":
			command = new NDSearchReviewCommand_KMJ();
			command.execute(request, response);
			viewPage = "shop-board.jsp";
			break;
		// 리뷰 작성페이지로 이동
		case "/write_review.do":
			command = new NDWriteReviewPageCommand_KMJ();
			command.execute(request, response);
			viewPage = "write_review.jsp";
			break;
		// 리뷰 작성
		case "/write_review_confirm.do":
			command = new NDInsertReviewCommand_KMJ();
			command.execute(request, response);
			viewPage = "board.do";
			break;
		// 문의 작성페이지로 이동
		case "/write_board.do":
			command = new NDWriteBoardPageCommand_KMJ();
			command.execute(request, response);
			viewPage = "write_board.jsp";
			break;
		// 문의 작성
		case "/write_board_confirm.do":
			command = new NDInsertBoardCommand_KMJ();
			command.execute(request, response);
			viewPage = "board.do";
			break;
		// 공지사항 작성
		case "/notice.do":
			command = new NDSearchNoticeCommand_KMJ();
			command.execute(request, response);
			viewPage = "shop-notice.jsp";
			break;

		/*
		 * Admin 구역
		 */
		// 메인

		// admin login시,
		case "/admin_login.do":
			viewPage = "admin_main.do";
			break;

		// admin main으로 갈때
		case "/admin_main.do":
			command = new NDMainAdminCommand_OKH();
			command.execute(request, response);
			viewPage = "admin_main.jsp";
			break;

		// 주문 관리

		// admin 주문관리
		case "/admin_searchorders.do":
			command = new NDOrdersSearchCommand_OKH();
			command.execute(request, response);
			viewPage = "admin_orders.jsp";
			break;

		// admin 주문 확인 및 데이터 가져오기
		case "/admin_updateorders.do":
			command = new NDOrdersUpdateCommand_OKH();
			command.execute(request, response);
			viewPage = "admin_orders_update.jsp";
			break;

		// admin 환불 확인 및 배송 확인
		case "/admin_updateorders_checked.do":
			command = new NDOrdersCheckCommand_OKH();
			command.execute(request, response);
			viewPage = "admin_searchorders.do";
			break;

		// admin graph 그릴 자료 넘기기
		case "/admin_graphorders.do":
			command = new NDOrdersGraphCommand_OKH();
			command.execute(request, response);
			viewPage = "admin_orders_graph.jsp";
			break;

		// 구독 관리

		// 구독 확인
		case "/admin_searchsubscribe.do":
			command = new NDSubscribeSearchCommand_OKH();
			command.execute(request, response);
			viewPage = "admin_subscribe.jsp";
			break;

		// 구독 스케쥴 관리
		case "/admin_schedulesubscribe.do":
			command = new NDSubscribeScheduleCommand_OKH();
			command.execute(request, response);
			viewPage = "admin_subscribe_schedule.jsp";
			break;
			
		//	구독 배송 확인	
		case "/admin_updatesubscribe.do":
			command = new NDSubscribeUpdateCommand_OKH();
			command.execute(request, response);
			viewPage = "admin_schedulesubscribe.do";
			break;
		// 유저 관리

		// user 확인
		case "/admin_searchusers.do":
			command = new NDUserSearchCommand_OKH();
			command.execute(request, response);
			viewPage = "admin_user.jsp";
			break;

		// user graph 그릴 자료 넘기기
		case "/admin_graphusers.do":
			command = new NDUserGraphCommand_OKH();
			command.execute(request, response);
			viewPage = "admin_user_graph.jsp";
			break;

		// 상품 관리

		// 상품 관리
		case "/admin_searchproduct.do":
			command = new NDProductSearchCommand_OKH();
			command.execute(request, response);
			viewPage = "admin_product.jsp";
			break;

		// 상품 입력 및 수정에 데이터 표기
		case "/admin_findproduct.do":
			command = new NDProductFindCommand_OKH();
			command.execute(request, response);
			viewPage = "admin_product_insert.jsp";
			break;

		// 상품 수정 및 입력
		case "/admin_insertproduct.do":
			command = new NDProductInsertCommand_OKH();
			command.execute(request, response);
			viewPage = "admin_searchproduct.do";
			break;

		// 상품 삭제
		case "/admin_deleteproduct.do":
			command = new NDProductDeleteCommand_OKH();
			command.execute(request, response);
			viewPage = "admin_searchproduct.do";
			break;

		// 게시판 관리

		// 게시판 확인
		case "/admin_searchboard.do":
			command = new NDBoardSearchCommand_OKH();
			command.execute(request, response);
			viewPage = "admin_board.jsp";
			break;
			
		// 상품 입력 및 수정에 데이터 표기
		case "/admin_modifyboard.do":
			command = new NDBoardModifyCommand_OKH();
			command.execute(request, response);
			viewPage = "admin_board.jsp";
			break;

		// 게시판 작성
		case "/admin_insertboard.do":
			command = new NDBoardInsertCommand_OKH();
			command.execute(request, response);
			viewPage = "admin_board.jsp";
			break;

		// 게시판 삭제
		case "/admin_deleteboard.do":
			command = new NDBoardDeleteCommand_OKH();
			command.execute(request, response);
			viewPage = "admin_board.jsp";
			break;
			
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);

	}

}// END
