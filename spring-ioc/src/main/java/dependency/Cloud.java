package dependency;

public class Cloud {

	private String url;
	private int port;
	private String username;
	private String password;
	
	public Cloud() {}
	
	public Cloud(String url, int port, String username, String password) {
		this.url = url;
		this.port = port;
		this.username = username;
		this.password = password;
	}
	
	public void setUrl(String url) {
		this.url = url;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void connect() {
		System.out.println("클라우드에 접속하기");
		System.out.println("url : " + url);
		System.out.println("port : " + port);
		System.out.println("username : " + username);
		System.out.println("password : " + password);
	}
}
