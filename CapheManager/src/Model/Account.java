package Model;

public class Account {

	private int idAccount;
	private String userName;
	private String passWord;
	private String email;
	private String creatAt;

	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Account(int idAccount, String userName, String passWord, String email, String creatAt) {
		super();
		this.idAccount = idAccount;
		this.userName = userName;
		this.passWord = passWord;
		this.email = email;
		this.creatAt = creatAt;
	}

	public int getIdAccount() {
		return idAccount;
	}

	public void setIdAccount(int idAccount) {
		this.idAccount = idAccount;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCreatAt() {
		return creatAt;
	}

	public void setCreatAt(String creatAt) {
		this.creatAt = creatAt;
	}

	@Override
	public String toString() {
		return idAccount + "|" + userName + "|" + passWord + "|" + email + "|" + creatAt;
	}

}
