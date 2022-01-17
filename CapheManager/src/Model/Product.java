package Model;

public class Product {

	private int idProduct;
	private String nameProduct;
	private double price;
	private int quantity;

	@Override
	public String toString() {
		return idProduct + "|" + nameProduct + "|" + price + "|" + quantity;
	}

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Product(int idProduct, String nameProduct, double price, int quantity) {
		super();
		this.idProduct = idProduct;
		this.nameProduct = nameProduct;
		this.price = price;
		this.quantity = quantity;
	}

	public int getIdProduct() {
		return idProduct;
	}

	public void setIdProduct(int idProduct) {
		this.idProduct = idProduct;
	}

	public String getNameProduct() {
		return nameProduct;
	}

	public void setNameProduct(String nameProduct) {
		this.nameProduct = nameProduct;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public void output() {
		System.out.printf("%-20d %-30s %-20f %-20d %-20f \n", idProduct, nameProduct, price, quantity,
				price * quantity);
	}

	public void outputTemp() {
		System.out.printf("%-20d %-30s %-20f %-20d \n", idProduct, nameProduct, price, quantity);
	}
}
