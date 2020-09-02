package web_study_09_exam.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import web_study_09_exam.dto.Employees;
import web_study_09_exam.service.LoginService;

@WebServlet("/login.do")
public class LoginServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	private LoginService service = new LoginService();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		process(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		process(request, response);
	}

	protected void process(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "employees/login.jsp";

		if (request.getMethod().equalsIgnoreCase("get")) {
			HttpSession session = request.getSession();
			if (session.getAttribute("loginUser") != null)
				url = "main.jsp";
			request.getRequestDispatcher(url).forward(request, response);

		} else {
			String id = request.getParameter("id");
			String pass = request.getParameter("pass");
			String lev = request.getParameter("lev");

			System.out.println("id : " + id + ", pass : " + pass + ", lev : " + lev);

			Employees findEmployees = new Employees(id, pass);
			Employees resEmployees = service.getEmployees(findEmployees);

			if (resEmployees == null) {
				request.setAttribute("message", "존재하지 않는 회원입니다.");
			} else {
				if (pass.equals(resEmployees.getPass())) {
					HttpSession session = request.getSession();
					session.setAttribute("loginUser", resEmployees);
					session.setMaxInactiveInterval(60 * 60);
					request.setAttribute("message", "회원 가입에 성공했습니다.");
					url = "main.jsp";
				} else {
					request.setAttribute("message", "비밀번호가 맞지 않습니다.");
				}

			}
			request.getRequestDispatcher(url).forward(request, response);
		}

	}

}
