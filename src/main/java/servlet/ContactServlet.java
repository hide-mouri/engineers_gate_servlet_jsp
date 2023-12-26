package servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.ContactBeans;
import common.StringUtil;

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
		request.setAttribute("errors", new HashMap<>());

		String view = "/WEB-INF/views/contact.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(view);
		dispatcher.forward(request, response);
	}

	/**
	 * 「確認画面へ」押下時リクエスト。
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		RequestDispatcher dispatcher = null;

		// リクエスト情報取得。
		ContactBeans contact = new ContactBeans(request);

		// 入力チェック
		Map<String, String> errors = validation(contact);
		if (errors != null && errors.size() > 0) {
			request.setAttribute("contact", contact);
			request.setAttribute("errors", errors);

			dispatcher = request.getRequestDispatcher("/WEB-INF/views/contact.jsp");
			dispatcher.forward(request, response);
			return;
		}

		HttpSession session = request.getSession();
		session.setAttribute("contact", contact);
		request.setAttribute("contact", contact);

		dispatcher = request.getRequestDispatcher("/WEB-INF/views/confirm.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * 入力チェック処理。
	 * @param contact formの内容
	 * @return エラーメッセージ
	 */
	private Map<String, String> validation(ContactBeans contact) {

		Map<String, String> errors = new HashMap<>();

		if (contact == null) {
			errors.put("name", "お氏名は必須項目となります。");
			errors.put("mail", "メールアドレスは必須項目となります。");
			errors.put("title", "タイトルは必須項目となります。");
			errors.put("body", "お問い合わせ内容は必須項目となります。");

			return errors;
		}

		if (StringUtil.isEmpty(contact.getName())) {
			errors.put("name", "お氏名は必須項目となります。");
		}
		if (StringUtil.isEmpty(contact.getMail())) {
			errors.put("mail", "メールアドレスは必須項目となります。");
		}
		if (StringUtil.isEmpty(contact.getTitle())) {
			errors.put("title", "タイトルは必須項目となります。");
		}
		if (StringUtil.isEmpty(contact.getBody())) {
			errors.put("body", "お問い合わせ内容は必須項目となります。");
		}

		return errors;
	}
}
