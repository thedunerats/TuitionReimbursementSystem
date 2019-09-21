package proj1.model;

public class LoginCredentials {
	
	private String firstName;
	private String eMailAddress;
	private String userName;
	private String passWord;
	
	public LoginCredentials(String firstName, String eMailAddress, String userName, String passWord) {
		super();
		this.firstName = firstName;
		this.eMailAddress = eMailAddress;
		this.userName = userName;
		this.passWord = passWord;
	}

	public LoginCredentials() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String geteMailAddress() {
		return eMailAddress;
	}

	public void seteMailAddress(String eMailAddress) {
		this.eMailAddress = eMailAddress;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((eMailAddress == null) ? 0 : eMailAddress.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((passWord == null) ? 0 : passWord.hashCode());
		result = prime * result + ((userName == null) ? 0 : userName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LoginCredentials other = (LoginCredentials) obj;
		if (eMailAddress == null) {
			if (other.eMailAddress != null)
				return false;
		} else if (!eMailAddress.equals(other.eMailAddress))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (passWord == null) {
			if (other.passWord != null)
				return false;
		} else if (!passWord.equals(other.passWord))
			return false;
		if (userName == null) {
			if (other.userName != null)
				return false;
		} else if (!userName.equals(other.userName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "LoginCredentials [firstName=" + firstName + ", eMailAddress=" + eMailAddress + ", userName=" + userName
				+ ", passWord=" + passWord + "]";
	}
	
	
}
