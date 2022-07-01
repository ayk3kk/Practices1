package bean;

/**
 * お寿司1件分をオブジェクト化するためのJavaBeans
 *
 * @author 21002S
 *
 */
public class Product {

	private int	id;
	private String name;
	private int	price;

	public Product() {
		super();
	}

	public Product(int id, String name, int price) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public int getPrice() {
		return price;
	}

}
