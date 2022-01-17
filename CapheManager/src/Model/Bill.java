package Model;

import java.util.List;

public class Bill extends Customer {

	private int billID;
	private String purchaseDate;
	List<Product> listProcProducts;

	public Bill() {

	}

	public Bill(int billID, String purchaseDate, int customerID, String customerName, String gender, int age,
			String customerAddress, String customerPhone) {
		super(customerID, customerName, gender, age, customerAddress, customerPhone);
		// TODO Auto-generated constructor stub
	}

	public Bill(int customerID2, String customerName2) {
		super(customerID2, customerName2);
		// TODO Auto-generated constructor stub
	}

	public Bill(int billID, String purchaseDate, int customerID2, String customerName2,
			List<Product> listProcProducts) {
		super(customerID2, customerName2);
		this.billID = billID;
		this.purchaseDate = purchaseDate;
		this.listProcProducts = listProcProducts;
	}

	public int getBillID() {
		return billID;
	}

	public void setBillID(int billID) {
		this.billID = billID;
	}

	public String getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(String purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	public List<Product> getListProcProducts() {
		return listProcProducts;
	}

	public void setListProcProducts(List<Product> listProcProducts) {
		this.listProcProducts = listProcProducts;
	}

	@Override
	public String toString() {
		return billID + "|" + purchaseDate + "|" + listProcProducts;
	}

	public void outputProducts() {
		for (Product product : listProcProducts) {
			product.output();
		}
		double sum = sumProducts();
		System.out.printf("%-80s   Sum = %-4s %-20f \n", "", "", sum);
	}

	public void outputProductsVIP() {
		for (Product product : listProcProducts) {
			product.output();
		}
		System.out.printf("%-70s   Sum = %-14s %-20f \n", "", "", sumProducts());
		System.out.printf("%-70s   VIP Customer =   %-2s- %-20f \n", "", "", sumProducts() / 10);
		double sum = sumProducts() - sumProducts() / 10;
		System.out.printf("%-70s   Sum Total =  %-8s %-6f \n", "", "", sum);
	}

	public double sumProducts() {
		double sum = 0;
		for (Product product : listProcProducts) {
			sum += product.getPrice() * product.getQuantity();
		}
		return sum;
	}

	public double sumProductsVIP() {
		double sum = 0;
		for (Product product : listProcProducts) {
			sum += product.getPrice() * product.getQuantity();
		}
		return sum - sum / 10;
	}

}
