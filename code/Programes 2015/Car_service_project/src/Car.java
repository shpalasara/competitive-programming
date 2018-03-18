
public class Car {

	private String Service_type; 	//Type of Service eg.vehicle modification or a vehicle service
	private String number_plate;		
	private String make;
	private String model;
	private int manufacture_data;
	private boolean active;
	
	public Car(){	
		Service_type = new String();
		number_plate = new String();
		make = new String();
		model = new String();
		active = false;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}
	
	public String getService_type() {
		return Service_type;
	}

	public void setService_type(String service_type) {
		Service_type = service_type;
	}

	public String getNumber_plate() {
		return number_plate;
	}

	public void setNumber_plate(String number_plate) {
		this.number_plate = number_plate;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getManufacture_data() {
		return manufacture_data;
	}

	public void setManufacture_data(int manufacture_data) {
		this.manufacture_data = manufacture_data;
	}
	
}
