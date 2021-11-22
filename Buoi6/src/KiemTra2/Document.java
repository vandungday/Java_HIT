package KiemTra2;

public class Document {
	private String id;
	private String name;
	private String publisher;
	private float price;
	public Document(String id, String name, String publisher, float price) {
	
		this.id = id;
		this.name = name;
		this.publisher = publisher;
		this.price = price;
	}
	public Document() {
		
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	
	
}
