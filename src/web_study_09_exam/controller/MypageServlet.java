package web_study_09_exam.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import web_study_09_exam.dto.Employees;
import web_study_09_exam.service.JoinService;

@WebServlet("/mypage.do")
public class MypageServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private JoinService service;

	@Override
	public void init() throws ServletException {
		service = new JoinService();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		/*
			HttpSession session = request.getSession();
			Member loginMember = (Member) session.getAttribute("loginUser");
			System.out.println(loginMember);
		*/

		request.getRequestDispatcher("employees/mypage.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Employees updateEmployees = CustomServlet.getEmployees(request);
		System.out.println("MypageServlet - doPost()" + updateEmployees);
		int res = service.updateEmployees(updateEmployees);
		System.out.println("수정 결과 : " + res);

		if (res == 1) {
			HttpSession session = request.getSession();
			session.setAttribute("loginUser", updateEmployees);
		}

		response.sendRedirect("login.do"); 
	}

}
