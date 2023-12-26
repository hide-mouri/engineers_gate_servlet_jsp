package servlet;

import java.io.IOException;
import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.ContactBeans;

/**
 * メール送信関連。
 */
public class SendServlet extends HttpServlet {

	/**
	 * 「送信」押下時リクエスト。
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		RequestDispatcher dispatcher = null;

		// メール送信処理。
		HttpSession session = request.getSession();
		ContactBeans contact = (ContactBeans) session.getAttribute("contact");

		try {
			// メールサーバ
			String mailhost = "localhost";
			// 送信元メールアドレス
			String from = "hidetugu.mouri2000@gmail.com";
			// 送信先メールアドレス
			String to = contact.getMail();
			// メールタイトル
			String subject = contact.getTitle();
			// メール本文
			String text = contact.getBody();

			Properties props = System.getProperties();
			props.put("mail.smtp.host", mailhost);

			Session mailSession = Session.getInstance(props, null);
			mailSession.setDebug(true);

			Message msg = new MimeMessage(mailSession);
			msg.setFrom(new InternetAddress(from));

			msg.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse(to, false));

			msg.setSubject(subject);
			msg.setText(text);
			msg.setSentDate(new Date());

			Transport.send(msg);

			System.out.println("\nMail was sent successfully.");
		} catch (Exception e) {
			e.printStackTrace();
			response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			dispatcher = request.getRequestDispatcher("/WEB-INF/views/error.jsp");
			dispatcher.forward(request, response);
			return;
		}
		request.setAttribute("contact", contact);

		// セッションクリア。
		request.getSession().invalidate();

		String view = "/WEB-INF/views/thanks.jsp";
		dispatcher = request.getRequestDispatcher(view);
		dispatcher.forward(request, response);
	}
}
