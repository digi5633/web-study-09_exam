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

@WebServlet("/custom.do")
public class CustomServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private JoinService service = new JoinService();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Process(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Process(request, response);
	}

	private void Process(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// request.setCharacterEncoding("UTF-8");

		if (request.getMethod().equalsIgnoreCase("get")) {
			request.getRequestDispatcher("employees/loin.jsp").forward(request, response);
		}

		Employees emp = getEmployees(request);

		int res = service.insertEmployees(emp);

		HttpSession session = request.getSession();

		if (res == 1) {
			session.setAttribute("id", emp.getId());
			session.setAttribute("message", "회원 가입에 성공했습니다.");
		} else {
			session.setAttribute("message", "회원 가입에 실패했습니다.");
		}

	}

	public static Employees getEmployees(HttpServletRequest request) {
		String id = request.getParameter("ID");
		String pass = request.getParameter("PASS");
		String name = request.getParameter("NAME");
		String lev = request.getParameter("LEV");
		int gender = Integer.parseInt(request.getParameter("GENDER"));
		String phone = request.getParameter("PHONE");
		return new Employees(id, pass, name, lev, gender, phone);

	}

}
