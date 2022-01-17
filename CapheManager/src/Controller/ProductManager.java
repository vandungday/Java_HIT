package Controller;

import java.lang.ModuleLayer.Controller;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.IllegalFormatFlagsException;
import java.util.List;
import java.util.Scanner;

import Model.Employee;
import Model.Product;

//import Product.Product;

public class ProductManager {
	static Scanner sc = new Scanner(System.in);
	static FunctionController functionController = new FunctionController();
	static List<Product> listProduct = new ArrayList<Product>();
	static FileController file = new FileController();

	public void menuProductManager() {
		do {
			System.out.println("=======MENU MANAGER=====");
			System.out.println("1) Show list menu       ");
			System.out.println("2) Add new product      ");
			System.out.println("3) Edit drink of menu   ");
			System.out.println("4) Sort menu by price   ");
			System.out.println("5) Search menu by price ");
			System.out.println("6) Search menu by name  ");
			System.out.println("7) Delete product       ");
			System.out.println("8) Exit                 ");
			System.out.println("========================");

			switch (functionController.Choose(1, 8)) {
			case (1):
				show();
				break;
			case (2):
				add();
				break;
			case (3):
				edit();
				break;
			case (4):
				sortPrice();
				break;
			case (5):
				searchByPrice();
				break;
			case (6):
				searchByName();
				break;
			case (7):
				deleteP();
				break;
			case (8):
				System.out.println("Exit successful");
				return;
			}
		} while (true);
	}

	private void edit() {

		do {
			System.out.println("1) Edit product");
			System.out.println("2) Add quantity");
			System.out.println("3) Exit");
			switch (functionController.Choose(1, 3)) {
			case (1):
				editProduct();
				break;
			case (2):
				editQuantity();
				break;
			case (3):
				return;
			}
		} while (true);
	}

	public void editProduct() {
		listProduct = file.ReadProductFromFile("Product.txt");
		int id;
		do {
			String Idtemp;
			System.out.print("Enter id product you need edit:  ");
			Idtemp = sc.nextLine();

			if (functionController.MyParseInt(Idtemp) == null) {
				System.out.println("Invalid data");
			} else if (!check(Integer.parseInt(Idtemp))) {
				System.out.println("Id does not exist");
			} else {
				id = Integer.parseInt(Idtemp);
				break;
			}
		} while (true);

		for (Product pd : listProduct) {
			if (pd.getIdProduct() == id) {
				System.out.print("Enter new name product : ");
				pd.setNameProduct(sc.nextLine());
				do {
					String price;
					System.out.print("\tEnter product price: ");
					price = sc.nextLine();
					if (functionController.MyParseDouble(price) != null) {
						pd.setPrice(Double.parseDouble(price));
						break;
					} else
						System.out.println("Invalid data");
				} while (true);

				do {
					String quantity;
					System.out.print("\tEnter product quantity: ");
					quantity = sc.nextLine();
					if (functionController.MyParseInt(quantity) != null) {
						pd.setQuantity(Integer.parseInt(quantity));
						break;
					} else
						System.out.println("Invalid data");
				} while (true);
				file.UpdateProductFile(listProduct, "Product.txt");
			}
		}
	}

	public void editQuantity() {

		int id;
		do {
			String Idtemp;
			System.out.print("Enter id product you need add quantity:  ");
			Idtemp = sc.nextLine();

			if (functionController.MyParseInt(Idtemp) == null) {
				System.out.println("Invalid data");
			} else if (!check(Integer.parseInt(Idtemp))) {
				System.out.println("Id does not exist");
			} else {
				id = Integer.parseInt(Idtemp);
				break;
			}
		} while (true);

		for (Product product : listProduct) {
			if (product.getIdProduct() == id) {
				int a = product.getQuantity();
				String b;
				do {
					System.out.print("Enter quantity product you need add: ");
					b = sc.nextLine();
					if (functionController.MyParseInt(b) != null) {
						break;
					} else
						System.out.println("Invalid data");
				} while (true);
				int c = a + Integer.parseInt(b);
				product.setQuantity(c);
				System.out.println("Add successful");
				file.UpdateProductFile(listProduct, "Product.txt");
			}
		}
	}

	public boolean check(int id) {
		listProduct = file.ReadProductFromFile("Product.txt");
		for (Product pd : listProduct) {
			if (pd.getIdProduct() == id)
				return true;
		}
		return false;
	}

	private void deleteP() {
		String name;
		listProduct = file.ReadProductFromFile("Product.txt");
		System.out.print("Enter name product you need delete:  ");
		name = sc.nextLine();
		boolean isExited = false;
		for (Product pd : listProduct) {
			if (pd.getNameProduct().compareToIgnoreCase(name) == 0) {
				isExited = true;
				listProduct.remove(pd);
				file.UpdateProductFile(listProduct, "Product.txt");
				break;
			}
		}
		if (!isExited) {
			System.out.println("No product name to delete");
		} else {
			System.out.println("Delete successful");
		}

	}

	public void show() {
		listProduct = file.ReadProductFromFile("Product.txt");
		outputTemp();
		for (Product pd : listProduct) {
			pd.outputTemp();
		}
	}

	public void add() {

		Product pd = new Product();
		List<Product> list = file.ReadProductFromFile("Product.txt");
		pd.setIdProduct((MAX(list) + 1));

		System.out.print("Enter new name product : ");
		pd.setNameProduct(sc.nextLine());
		do {
			String price;
			System.out.print("\tEnter product price: ");
			price = sc.nextLine();
			if (functionController.MyParseDouble(price) != null) {
				pd.setPrice(Double.parseDouble(price));
				break;
			} else
				System.out.println("Invalid data");
		} while (true);

		do {
			String quantity;
			System.out.print("\tEnter product quantity: ");
			quantity = sc.nextLine();
			if (functionController.MyParseInt(quantity) != null) {
				pd.setQuantity(Integer.parseInt(quantity));
				break;
			} else
				System.out.println("Invalid data");
		} while (true);

		listProduct.add(pd);
		file.WriteProductToFile("Product.txt", pd);

	}

	public int MAX(List<Product> a) {
		int MAX = 0;
		for (Product pd : a) {
			if (pd.getIdProduct() > MAX)
				MAX = pd.getIdProduct();
		}
		return MAX;
	}

	public void sortPrice() {
		listProduct = file.ReadProductFromFile("Product.txt");
		Collections.sort(listProduct, new Comparator<Product>() {
			@Override
			public int compare(Product o1, Product o2) {
				// TODO Auto-generated method stub
				return (int) (o1.getPrice() - o2.getPrice());
			}
		});
		outputTemp();
		for (Product pd : listProduct) {
			pd.outputTemp();
		}
	}

	public void searchByPrice() {
		do {
			System.out.println("\n");
			System.out.println("==========SEARCH BY PRICE===========");
			System.out.println("1) Search price <=20000             ");
			System.out.println("2) Search price from 20000 to 40000 ");
			System.out.println("3) Search price >= 40000            ");
			System.out.println("4) Exit                             ");
			System.out.println("====================================");
			System.out.println("\n");

			listProduct = file.ReadProductFromFile("Product.txt");
			Collections.sort(listProduct, new Comparator<Product>() {
				@Override
				public int compare(Product o1, Product o2) {
					// TODO Auto-generated method stub
					return (int) (o1.getPrice() - o2.getPrice());
				}
			});
			switch (functionController.Choose(1, 4)) {
			case (1):
				System.out.println("=============PRICE <= 20000=========");
				outputTemp();
				for (Product pd : listProduct) {
					if (pd.getPrice() <= 20000) {
						pd.outputTemp();
					}
				}
				System.out.println("====================================");
				break;
			case (2):
				System.out.println("==========PRICE 20000 -> 40000======");
				outputTemp();
				for (Product pd : listProduct) {
					if (pd.getPrice() >= 20000 && pd.getPrice() <= 40000) {
						pd.outputTemp();
					}
				}
				System.out.println("====================================");
				break;
			case (3):
				System.out.println("=============PRICE >= 40000=========");
				outputTemp();
				for (Product pd : listProduct) {
					if (pd.getPrice() >= 40000) {
						pd.outputTemp();
					}
				}
				System.out.println("====================================");
				break;
			case (4):
				System.out.println("Exit successfull ^^");
				return;
			}
		} while (true);

	}

	public void outputTemp() {
		System.out.printf("%-20s %-30s %-20s %-20s \n", "ID", "Name", "Price", "Quantity");
	}

	public void searchByName() {
		String name;
		listProduct = file.ReadProductFromFile("Product.txt");
		System.out.print("Enter name product you need search:  ");
		name = sc.nextLine();
		name = name.toLowerCase();
		boolean isExited = false;
		for (Product pd : listProduct) {
			if (contains(pd.getNameProduct().toLowerCase(), name)) {
				isExited = true;
			}
		}
		if (!isExited) {
			System.out.printf("%s not existed \n", name);
		} else {
			outputTemp();
			for (Product pd : listProduct) {
				if (contains(pd.getNameProduct().toLowerCase(), name)) {
					pd.outputTemp();
				}
			}
		}
	}

	boolean contains(String haystack, String needle) {
		if (haystack == null)
			return false;

		return haystack.contains(needle.toLowerCase());
	}

}
