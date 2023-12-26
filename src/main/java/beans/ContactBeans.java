package beans;

import javax.servlet.http.HttpServletRequest;

public class ContactBeans {

	/** ご氏名 */
	private String name = "";
	/** メールアドレス */
	private String mail = "";
	/** タイトル */
	private String title = "";
	/** お問い合わせ内容 */
	private String body = "";

	/**
	 * コンストラクタ
	 */
	public ContactBeans() {
		super();
	}

	/**
	 * コンストラクタ
	 * @param request リクエストパラメータ
	 */
	public ContactBeans(HttpServletRequest request) {
		this.name = request.getParameter("name");
		this.mail = request.getParameter("mail");
		this.title = request.getParameter("title");
		this.body = request.getParameter("body");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}
}
