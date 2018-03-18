import java.util.Scanner;

public class Main {

	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		int i = 1;
		

		System.out.println("Enter todays date(In form of dd/mm/yyyy) :");
		String today = sc.nextLine();
		
		System.out.println("0 : To get Instruction");
		System.out.println("1 : Enter new Data");
		System.out.println("2 : Info about the jobs which is still actively bein worked on");
		System.out.println("3 : Info about completed jobs still requiring payment");
		System.out.println("4 : Info about the jobs scheduled for work on particular day");
		System.out.println("5 : Accept payment towards completed service job");
		System.out.println("6 : Report detailed status for a particular booked service");
		System.out.println("7 : If day has changed");
		System.out.println("8 : To get exited");
		Car_Service service_center = new Car_Service();
		
		while(i==1)
		{	
			System.out.println("Enter number from 1 to 8 by deciding which service you want to get :");
			int j = Integer.parseInt(sc.nextLine());
			switch(j)
			{
				case 1:
				{
					System.out.println("Enter your data as asked.");
					service_center.Add_newEntry(today.split("/"));
					break;
				}
				case 2:
				{
					System.out.println("Info about jobs still actively being worked on");
					service_center.job_active_to_do();
					break;
				}
				case 3:
				{
					System.out.println("Info about comleted jobs still requiring payment is :");
					service_center.listOfpayment();
					break;
				}
				case 4:
				{
					System.out.println("To get info about the jobs scheduled for work on particular day ,Please enter the date (In form of dd/mm/yyyy)  :");
					String date = sc.nextLine();
					service_center.printBooking(date);
					break;
				}
				case 5:
				{
					System.out.println("Enter the name of the person who wants to pay the payment of his service same as he given at the time of booking :");
					String name = sc.nextLine();
					service_center.takePayment(name);
					break;
				}
				case 6:
				{
					//System.out.println("To get report detailed status for a particular booked service ,enter the name of the person who had Book the service(It should be an integer):");
					//String name = sc.nextLine();
					System.out.println("To get report detail status for perticular Booking ,Please Enter The the unequ Id of the Booking");
					int Id = Integer.parseInt(sc.nextLine());
					service_center.service_detail(Id);
					break;
				}
				case 7:
				{
					String[] str = today.split("/");
					int temp = Integer.parseInt(str[0])+1;
					str[0] = ""+(temp%31);								//Assuming that every month contains 30 days
					temp = Integer.parseInt(str[1])+temp/31;
					str[1] = ""+(temp%13);
					str[2] = ""+(Integer.parseInt(str[2])+temp/13);
					today = str[0]+"/"+str[1]+"/"+str[2];
					service_center.activeTocompleted(today);
					service_center.to_doToactive(today);
					break;
					//Make a method which take detail form active to completed as u change the day
				}
				case 8:
				{
					i=0;
					break;
				}
				default :
				{
					System.out.println("You have enterd wrong number .Please recheck the instruction :");
					System.out.println("0 : To get Instruction");
					System.out.println("1 : Enter new Data");
					System.out.println("2 : Info about the jobs which is still actively bein worked on");
					System.out.println("3 : Info about completed jobs still requiring payment");
					System.out.println("4 : Info about the jobs scheduled for work on particular day");
					System.out.println("5 : Accept payment towards completed service job");
					System.out.println("6 : Report detailed status for a particular booked service");
					System.out.println("7 : If day has changed");
					System.out.println("8 : To get exited");
				}
			}
		}
		sc.close();
	}
	
}
