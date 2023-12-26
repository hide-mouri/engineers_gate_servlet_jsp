package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.ContactBeans;

/**
 * CONTACT画面。
 */
public class ContactServlet extends HttpServlet {

	/**
	 * 初期表示リクエスト。
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);

		ContactBeans contactBeans = new ContactBeans();
		if (session != null) {
			contactBeans = (ContactBeans) session.getAttribute("contact");
		}

		request.setAttribute("contact", contactBeans);

		String view = "/WEB-INF/views/contact.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(view);
		dispatcher.forward(request, response);
	}

	/**
	 * 「確認画面へ」押下時リクエスト。
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		// リクエスト情報取得。
		ContactBeans contact = new ContactBeans(request);

		HttpSession session = request.getSession();
		session.setAttribute("contact", contact);
		request.setAttribute("contact", contact);

		String view = "/WEB-INF/views/confirm.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(view);
		dispatcher.forward(request, response);

	}
}
