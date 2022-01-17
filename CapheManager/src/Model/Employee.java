package Model;

public class Employee implements Comparable<Employee> {
	private int emID;
	private String emName;
	private String emGender;
	private String emAddress;
	private String emEntryDate;
	private String emPhone;
	private String emPassword;

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employee(int emID, String emName, String emPhone) {
		this.emID = emID;
		this.emName = emName;
		this.emPhone = emPhone;
	}
	public Employee(int emID, String emName, String emGender, String emAddress, String emEntryDate, String emPhone,
			String emPassword) {
		super();
		this.emID = emID;
		this.emName = emName;
		this.emGender = emGender;
		this.emAddress = emAddress;
		this.emEntryDate = emEntryDate;
		this.emPhone = emPhone;
		this.emPassword = emPassword;
	}

	public int getEmID() {
		return emID;
	}

	public void setEmID(int emID) {
		this.emID = emID;
	}

	public String getEmName() {
		return emName;
	}

	public void setEmName(String emName) {
		this.emName = emName;
	}

	public String getEmGender() {
		return emGender;
	}

	public void setEmGender(String emGender) {
		this.emGender = emGender;
	}

	public String getEmAddress() {
		return emAddress;
	}

	public void setEmAddress(String emAddress) {
		this.emAddress = emAddress;
	}

	public String getEmEntryDate() {
		return emEntryDate;
	}

	public void setEmEntryDate(String emEntryDate) {
		this.emEntryDate = emEntryDate;
	}

	public String getEmPhone() {
		return emPhone;
	}

	public void setEmPhone(String emPhone) {
		this.emPhone = emPhone;
	}

	public String getEmPassword() {
		return emPassword;
	}

	public void setEmPassword(String emPassword) {
		this.emPassword = emPassword;
	}

	@Override
	public String toString() {
		return emID + "|" + emName + "|" + emGender + "|" + emAddress + "|" + emEntryDate + "|" + emPhone + "|"
				+ emPassword;
	}

	@Override
	public int compareTo(Employee o) {

		return this.getEmName().compareToIgnoreCase(o.getEmName());
	}

}
