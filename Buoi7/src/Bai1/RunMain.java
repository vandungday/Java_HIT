package Bai1;

public class RunMain {
	public static void main(String[] args) {
		Person person1 = new Employee("Dũng", "TN", 2000);
		person1.display();
		Person person2 = new Customer("Trung", "TN", 2000);
		person2.display();
	}
}
