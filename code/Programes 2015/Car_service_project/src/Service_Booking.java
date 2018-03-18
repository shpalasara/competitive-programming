import java.util.Random;

public abstract class Service_Booking {

	private int service_No=0,uid;
	private String Name;
	private String Address;
	private String phone_number;
	private int amount=0,post_amount;
	private Car car;
	private static int generate_Id=1;
	private String date;
	private boolean initial_pay_paid,post_pay_paid;
	private int service_charge;
	private char service_type;
	private Random r;
	
	public Service_Booking(){
		
		date = new String();
		car = new Car();
		r = new Random();
//		@Todo
//		Find on internet, how today's date is set
		Name = new String();
		Address = new String();
		setUid(generate_Id++);
		initial_pay_paid = false;
		post_pay_paid = false;
		service_No = generate_Id;
		uid = generate_Id;
	}
	
	public void setPayment(){
		
		int x=(Math.abs(r.nextInt())+1)%1000;
		setPost_amount(x);
		setService_charge(x);
		
		//System.out.println("check "+getService_charge()+" "+getPost_amount());
	}
	public char getService_type() {
		return service_type;
	}

	public void setService_type(char service_type) {
		this.service_type = service_type;
	}

	public int getService_charge() {
		return service_charge;
	}

	public void setService_charge(int service_charge) {
		this.service_charge = service_charge;
	}

	public int getGenerate_Id(){
		return generate_Id;
	}
	
	public int getPost_amount() {
		return post_amount;
	}

	public void setPost_amount(int post_amount) {
		this.post_amount = post_amount;
	}

	public boolean isPost_pay_paid() {
		return post_pay_paid;
	}

	public void setPost_pay_paid(boolean post_pay_paid) {
		this.post_pay_paid = post_pay_paid;
	}
	
	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public boolean isInitial_pay_paid() {
		return initial_pay_paid;
	}

	public void setInitial_pay_paid(boolean initial_pay_paid) {
		this.initial_pay_paid = initial_pay_paid;
	}
	
	public int getService_No() {
		return service_No;
	}


	public void setService_No(int Number) {
		service_No = Number;
	}


	public String getName() {
		return Name;
	}


	public void setName(String name) {
		Name = name;
	}


	public String getAddress() {
		return Address;
	}


	public void setAddress(String address) {
		Address = address;
	}


	public String getPhone_number() {
		return phone_number;
	}


	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}


	public int getAmount() {
		return amount;
	}


	public void setAmount(int amount) {
		this.amount = amount;
	}


	public Car getCar() {
		return car;
	}


	public void setCar(Car car) {
		this.car = car;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}


}
