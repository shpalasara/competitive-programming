import java.util.*;

public class Car_Service {

	Scanner sc;
	ArrayList<Service_Booking> completed,active,to_do;
	private HashMap<String, ArrayList<Service_Booking> > data_wrt_date;			//Here hashMap maps shows which services are in progress on perticular date
	
	private Payment po;
	
	//ArrayList<Active> active;
	//ArrayList<To_do> to_do;
	
	private int offset=3;					//It shows after how many days from service date does the service center complete the service
	
											//And also assuming that service will complete in one day if we are starting servicing the car at particular day
	
	public Car_Service(){
		
		sc = new Scanner(System.in);
		completed = new ArrayList<Service_Booking>();
		active = new ArrayList<Service_Booking>();
		to_do = new ArrayList<Service_Booking>();
		po = new Payment();
		data_wrt_date = new HashMap<String, ArrayList<Service_Booking> >();
	}
	
//Case 1: Adding new Booking
	public void Add_newEntry(String[] today){
		
		//Adding new booking Entries in car service
		
		System.out.println("Enter the type of service you want to use : 'm' for modification and 's'for service ");
		String mORs = sc.nextLine();
		

		System.out.println("Enter the service date(In form of dd/mm/yyyy) :");
		String date = sc.nextLine();
		String[] _date = date.split("/");
		
		int[] _today = new int[3];
			_today[0] = Integer.parseInt(today[0]);
			_today[1] = Integer.parseInt(today[1]);
			_today[2] = Integer.parseInt(today[2]);
		
		int[] service_date = new int[3];
			int temp = Integer.parseInt(_date[0])+offset;
			service_date[0] = temp%31;				//Assuming that every month contains 30 days
			temp = Integer.parseInt(_date[1])+temp/31;
			service_date[1] = temp%13;
			service_date[2] = Integer.parseInt(_date[2])+temp/13;

		String str = service_date[0]+"/"+service_date[1]+"/"+service_date[2];	
		//System.out.println(str+"The date of service:");
		
		int i=0;	
		Service_Booking info;															//Using polymorphism 
		
		if(service_date[0]==_today[0] && service_date[1]==_today[1] && service_date[2]==_today[2])
		{
			//System.out.println("Acive");
			info = new Active();
			i=1;
		}
		else if(service_date[2]<_today[2] || (service_date[2]==_today[2] && service_date[1]<_today[1]) || (service_date[2]==_today[2] && service_date[1]==_today[1] && service_date[0]<_today[0]) )
		{
			//System.out.println("Completed");
			info = new Completed_Service();
			i=2;
		}
		else
		{
			//System.out.println("Future");
			info = new To_do();
			i=3;
		}
		
		info.setDate(date);
		info.setService_type(mORs.charAt(0));
		info.setPayment();
		
		System.out.println("Enter your Name :");
		info.setName(sc.nextLine());
		
		System.out.println("Enter your Address :");
		info.setAddress(sc.nextLine());
		
		System.out.println("Enter yout mobile number :");
		info.setPhone_number(sc.nextLine());
		
		System.out.println("Enter your car detail :");
		
		System.out.println("Number plate :");
		info.getCar().setNumber_plate(sc.nextLine());
		
		System.out.println("Information of maker :");
		info.getCar().setMake(sc.nextLine());
		
		System.out.println("Information about car model :");
		info.getCar().setModel(sc.nextLine());
		
		System.out.println("Enter the manufacturing year of your car :");
		info.getCar().setManufacture_data(Integer.parseInt(sc.nextLine()));
		
		System.out.println("Your unique Id is: "+info.getUid());

		if(mORs.equalsIgnoreCase("m"))
			po.initialPayment(info);
		
		if(i==1)
			active.add(info);
		else if(i==2)
			completed.add(info);
		else
			to_do.add(info); 
		
		if(!data_wrt_date.containsKey(str))
			data_wrt_date.put(str,new ArrayList<Service_Booking>());
		data_wrt_date.get(str).add(info);
		
	}
//Case 2: List all jobs still actively being worked on 	
	public void job_active_to_do(){
		
		int length = active.size();
		System.out.println("Completed today");
		if(length!=0)
		{
			for(int i=0;i<length;i++)
			{
				System.out.println("Name :"+active.get(i).getName()+" Address :"+active.get(i).getAddress()+" Phone number :"+active.get(i).getPhone_number());
				System.out.println("Number plate :"+active.get(i).getCar().getNumber_plate()+" Make :"+active.get(i).getCar().getMake()+" Model :"+active.get(i).getCar().getModel()+" Manufacture_date :"+active.get(i).getCar().getManufacture_data());
				System.out.println(" Sevice date :"+active.get(i).getDate());
			}
		}
		else
			System.out.println("Null");
			
		System.out.println("Would be done in futurre");
		length = to_do.size();
		if(length!=0)
		{
			for(int i=0;i<length;i++)
			{
				System.out.println("Name :"+to_do.get(i).getName()+" Address :"+to_do.get(i).getAddress()+" Phone number :"+to_do.get(i).getPhone_number());
				System.out.println("Number plate :"+to_do.get(i).getCar().getNumber_plate()+" Make :"+to_do.get(i).getCar().getMake()+" Model :"+to_do.get(i).getCar().getModel()+" Manufacture_date :"+to_do.get(i).getCar().getManufacture_data());
				System.out.println(" Service date :"+to_do.get(i).getDate());
			}
		}
		else
			System.out.println("Null");
	}
	
//Case 7: Methods when you change the day
	public void activeTocompleted(String today){
		
		//int length = active.size();
		Completed_Service temp = new Completed_Service();
		Service_Booking remove = new Active();
		for(;0<active.size();)
		{
			remove  = active.remove(0);
			temp.setAddress(remove.getAddress());
			temp.setAmount(remove.getAmount());
			temp.setCar(remove.getCar());
			temp.setDate(remove.getDate());
			temp.setInitial_pay_paid(remove.isInitial_pay_paid());
			temp.setName(remove.getName());
			temp.setPhone_number(remove.getPhone_number());
			temp.setPost_amount(remove.getPost_amount());
			temp.setPost_pay_paid(remove.isPost_pay_paid());
			temp.setService_No(remove.getService_No());
			temp.setUid(remove.getUid());
			//temp.setPayment(false);
			completed.add(temp);
		}
		//System.out.println("The size of active is:"+active.size());
	}
//Case 7: Method when u change the day
	public void to_doToactive(String today){
		
		String[] _date = today.split("/");
		int[] service_date = new int[3];
		int temp = Integer.parseInt(_date[0])-offset;
		service_date[0] = temp%31;				//Assuming that every month contains 30 days
		temp = Integer.parseInt(_date[1])+temp/31;
		service_date[1] = temp%13;
		service_date[2] = Integer.parseInt(_date[2])+temp/13;
		today = service_date[0]+"/"+service_date[1]+"/"+service_date[2];	
		
		int length = to_do.size();
		Service_Booking remove = new To_do();
		for(int i=0;i<length;i++)
		{
			remove = to_do.get(i);
			if(remove.getDate().compareTo(today)==0)
			{
				to_do.remove(i);
				i--;
				Active add = new Active();
				add.setAddress(remove.getAddress());
				add.setAmount(remove.getAmount());
				add.setCar(remove.getCar());
				add.setDate(remove.getDate());
				add.setInitial_pay_paid(remove.isInitial_pay_paid());
				add.setName(remove.getName());
				add.setPhone_number(remove.getPhone_number());
				add.setPost_amount(remove.getPost_amount());
				add.setPost_pay_paid(remove.isPost_pay_paid());
				add.setService_No(remove.getService_No());
				add.setUid(remove.getUid());
				active.add(add);
			}
		}
	}
	
//For case 3: completed job still requiring payment
	
	public void listOfpayment()
	{
		int length = completed.size();
		//Service_Booking temp;
		for(int i=0;i<length;i++)
		{
			//temp = completed.get(i);
			if(!completed.get(i).isPost_pay_paid())
			{
				System.out.println(" Name :"+completed.get(i).getName()+" Address :"+completed.get(i).getAddress()+" Phone number :"+completed.get(i).getPhone_number());
				System.out.println("Number plate :"+completed.get(i).getCar().getNumber_plate()+" Make :"+completed.get(i).getCar().getMake()+" Model :"+completed.get(i).getCar().getModel()+" Manufacture_data :"+completed.get(i).getCar().getManufacture_data());
				System.out.println("Service Date :"+completed.get(i).getDate());
				if(completed.get(i).getService_type()=='m')
					System.out.println("Type of Service Booked is modification");
				else
					System.out.println("Type of Service Booked is vehicle service");
				System.out.println("Amount owing :"+completed.get(i).getPost_amount());
				System.out.println();
			}
		}
	}
	
//For case 5: Accept payment toward service job
	public void takePayment(String name){
		
		int length = completed.size();
		int j=0;
		for(int i=0;i<length;i++)
		{
			if(completed.get(i).getName().compareToIgnoreCase(name)==0)
			{
				j++;
				po.postPayment(completed.get(i));
			}
		}
		
		length = active.size();
		for(int i=0;i<length;i++)
		{
			if(active.get(i).getName().compareToIgnoreCase(name)==0)
			{
				j++;
				po.postPayment(active.get(i));
			}
		}
		
		if(j==0)
		{
			System.out.println("There is no person named "+name+" in the list of remaining payment");
		}
	}
	
//For case 4: Gives the detail of booking from service date
	public void printBooking(String date){
		
		ArrayList<Service_Booking> booking = data_wrt_date.get(date);
		if(booking!=null)
		{
			int length=booking.size();
			for(int i=0;i<length;i++)
			{
				System.out.println(" Name :"+booking.get(i).getName()+" Address :"+booking.get(i).getAddress()+" Phone number :"+booking.get(i).getPhone_number());
				System.out.println(" Number Plate "+booking.get(i).getCar().getNumber_plate()+" Make :"+booking.get(i).getCar().getMake()+" Model :"+booking.get(i).getCar().getModel()+" Manufacture_data :"+booking.get(i).getCar().getManufacture_data());
				System.out.println(" Service Date "+booking.get(i).getDate());
				System.out.println();
			}
		}
		else
			System.out.println("No data at that date");
	}

//For Case 6: Report detailed status for a particular booked service
	public void service_detail(int Id){
		
		int length = completed.size();
		for(int i=0;i<length;i++)
		{
			if(completed.get(i).getUid()==Id)
			{
				System.out.println(" Name :"+completed.get(i).getName()+" Address :"+completed.get(i).getAddress()+" Phone Number :"+completed.get(i).getPhone_number());
				System.out.println(" Number plate "+completed.get(i).getCar().getNumber_plate()+" Make "+completed.get(i).getCar().getMake()+" Model "+completed.get(i).getCar().getModel()+" Manufacture_data "+completed.get(i).getCar().getManufacture_data());
				System.out.println(" Service date "+completed.get(i).getDate());
				if(completed.get(i).getService_type()=='m')
					System.out.println("Type of Service Booked is modification");
				else
					System.out.println("Type of Service Booked is vehicle service");
				System.out.println("Job status is 'Completed'");
				System.out.println("Total Service Cost : "+(completed.get(i).getAmount()+completed.get(i).getService_charge()));
				System.out.println("The amount paid is: "+(completed.get(i).getAmount()+completed.get(i).getService_charge()-completed.get(i).getPost_amount()));
				System.out.println("The amount owing is: "+completed.get(i).getPost_amount());
				return;
			}
		}
		length = active.size();
		for(int i=0;i<length;i++)
		{
			if(active.get(i).getUid()==Id)
			{
				System.out.println("Name :"+active.get(i).getName()+" Address :"+active.get(i).getAddress()+" Phone number :"+active.get(i).getPhone_number());
				System.out.println(" Number plate: "+active.get(i).getCar().getNumber_plate()+" Make :"+active.get(i).getCar().getMake()+" Model :"+active.get(i).getCar().getModel()+" Manufacture_data "+active.get(i).getCar().getManufacture_data());
				System.out.println(" Service date "+active.get(i).getDate());
				if(active.get(i).getService_type()=='m')
					System.out.println("Type of Service Booked is modification");
				else
					System.out.println("Type of Service Booked is vehicle service");
				System.out.println("Job status is 'In progress'");
				System.out.println("Total Service Cost : "+(active.get(i).getAmount()+active.get(i).getService_charge()));
				System.out.println("The amount paid is: "+(active.get(i).getAmount()+active.get(i).getService_charge()-active.get(i).getPost_amount()));
				System.out.println("The amount owing is: "+active.get(i).getPost_amount());
				return;
			}
		}
		length = to_do.size();
		for(int i=0;i<length;i++)
		{
			if(to_do.get(i).getUid()==Id)
			{
				System.out.println(" Name :"+to_do.get(i).getName()+" Address :"+to_do.get(i).getAddress()+" Phone number :"+to_do.get(i).getPhone_number());
				System.out.println(" Number Plate :"+to_do.get(i).getCar().getNumber_plate()+" Make :"+to_do.get(i).getCar().getMake()+" Model :"+to_do.get(i).getCar().getModel()+" Manufacture_data :"+to_do.get(i).getCar().getManufacture_data());
				System.out.println(" Service Date "+to_do.get(i).getDate());
				if(to_do.get(i).getService_type()=='m')
					System.out.println("Type of Service Booked is modification");
				else
					System.out.println("Type of Service Booked is vehicle service");
				System.out.println("Job status is 'sheduled'");
				System.out.println("Total Service Cost : "+(to_do.get(i).getAmount()+to_do.get(i).getService_charge()));
				System.out.println("The amount paid is: "+(to_do.get(i).getAmount()+to_do.get(i).getService_charge()-to_do.get(i).getPost_amount()));
				System.out.println("The amount owing is: "+to_do.get(i).getPost_amount());
				return;
			}
		}
		
		System.out.println("Entered Id is wrong");
	}
}
//@Todo
//When u do post payment, if post_pay_paid is true, delete that object from activity to completed arraylist.