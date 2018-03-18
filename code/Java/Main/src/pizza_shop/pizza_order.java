package pizza_shop;

public class pizza_order {

	private String name;
	private String phone_number;
	private String address;
	private String d_pizza;
	private int total_cost;
	private int no_topping;
	
	public pizza_order()
	{
		name = new String();
		phone_number = new String();
		address = new String();
		d_pizza = new String();
		total_cost = 0;
		no_topping = 0;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getD_pizza() {
		return d_pizza;
	}

	public void setD_pizza(String d_pizza) {
		this.d_pizza = d_pizza;
	}

	public int getTotal_cost() {
		return total_cost;
	}

	public void setTotal_cost(int total_cost) {
		this.total_cost = total_cost;
	}

	public int getNo_topping() {
		return no_topping;
	}

	public void setNo_topping(int no_topping) {
		this.no_topping = no_topping;
	}
	
	
}
