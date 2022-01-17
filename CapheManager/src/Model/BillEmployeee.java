package Model;

import java.util.ArrayList;
import java.util.List;

public class BillEmployeee extends Employee {
	
	private String emShift;
	// 14h -> 18h
	// 19h -> 23h
	private String emDate;
	
	public BillEmployeee(String emShift, String emDate) {
		super();
		this.emShift = emShift;
		this.emDate = emDate;
	}
	public BillEmployeee() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BillEmployeee(int emID, String emName, String emGender, String emAddress, String emEntryDate, String emPhone,
			String emPassword) {
		super(emID, emName, emGender, emAddress, emEntryDate, emPhone, emPassword);
		// TODO Auto-generated constructor stub
	}
	
	public BillEmployeee(int emID, String emName,  String emPhone, String emShift, String emDate) {
		super(emID, emName, emPhone);
		this.emShift = emShift;
		this.emDate = emDate;
		// TODO Auto-generated constructor stub
	}
	public String getEmShift() {
		return emShift;
	}
	public void setEmShift(String emShift) {
		this.emShift = emShift;
	}
	public String getEmDate() {
		return emDate;
	}
	public void setEmDate(String emDate) {
		this.emDate = emDate;
	}
	
	
}
