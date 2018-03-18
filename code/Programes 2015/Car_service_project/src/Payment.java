import java.util.*;
import java.io.*;

public class Payment {
	
	private HashMap<String, ArrayList<Service_Booking> > ht;
	private BufferedReader br;
	private Random r;
	//private int check=0;
	
	public Payment(){
		r = new Random();
		ht = new HashMap<String, ArrayList<Service_Booking> >();
		br = new BufferedReader(new InputStreamReader(System.in));
	}
	
	public void initialPayment(Service_Booking b){
		
		b.setAmount(Math.abs(r.nextInt())%1000);
		recievePayment(b.getAmount());
		b.setInitial_pay_paid(true);
		ht.put(b.getDate(), new ArrayList<Service_Booking>());
	}
	
	public void postPayment(Service_Booking b){
		
		recievePostPayment(b);
	}
	
	public ArrayList<Service_Booking> dateStatement(Date d){
		return ht.get(d);
	}
	
	private void recievePostPayment(Service_Booking b){
		int inp;
		if(b.getPost_amount()==0)
		{
			System.out.println("Your amount is already paid");
			return;
		}
		System.out.println("Your payment for service is "+b.getPost_amount()+"\nPay now");
		try{
			inp = Integer.parseInt(br.readLine());
			if(inp==b.getPost_amount()){
				b.setPost_amount(0);
				b.setPost_pay_paid(true);
				System.out.println("Your payment is paid. THANK YOU");
				return;
			}
			else if(inp > b.getPost_amount()){
				System.out.println("Payment is tooo much. Please pay less");
				recievePostPayment(b);
			}
			else if(inp < b.getPost_amount()){
				b.setPost_amount(b.getPost_amount()-inp);
				return;
			}
		}
		catch(Exception e){
			System.out.println("Paymount amount not valid. Pay again");
			recievePostPayment(b);
		}
	}
	
	private void recievePayment(int am){
		int inp;
		System.out.println("Your payment for modification is "+am+"\nPay now");
		try{
			inp = Integer.parseInt(br.readLine());
									//System.out.println(inp);
			if(inp==am)
			{
				System.out.println("Your payment is paid. THANK YOU");
				return ;
			}
			else{
				System.out.println("Amount too much or too less. Please pay exactly"+am);
				recievePayment(am);
			}
		}
		catch(Exception e){
			System.out.println("Paymount amount not valid.");
			recievePayment(am);
		}
	}
}
