package pizza_shop;
import java.util.*;

public class main_pizza {

		public static void main(String[] args){
			
			Scanner sc = new Scanner(System.in);
			System.out.println("Welcom to Pizza Shop.");
			String[] topping = {"Bacon","Olives","Ham","Mushrooms","Pineapple","Salami","Anchovies"};
			List<pizza_order> collected = new LinkedList<pizza_order>();
			List<pizza_order> delivered = new LinkedList<pizza_order>();
			pizza_order data;
			String temp = "with tomato base \ndefault topping as cheese";
			String add_topping;
			char _temp;
			
			while(true)
			{
				data = new pizza_order();
				System.out.println("Enter your name:");
				data.setName(sc.nextLine());
				
				System.out.println("Enter your mobile number:");
				data.setPhone_number(sc.nextLine());
				
				while(true)
				{
					System.out.println("Enter 'l' for large pizza 'm' for mideum type of pizza and 's' for small pizza");
					_temp = sc.nextLine().charAt(0);
					
					if(_temp=='l')
					{
						temp = "large pizza\n"+temp;
						data.setTotal_cost(data.getTotal_cost()+12);
						break;
					}
					else if(_temp=='m')
					{	
						temp = "medium pizzz\n"+temp;
						data.setTotal_cost(data.getTotal_cost()+8);
						break;
					}
					else if(_temp=='s')
					{
						temp = "small pizza\n"+temp;
						data.setTotal_cost(data.getTotal_cost()+5);
						break;
					}
					else
						System.out.println("You have entered wrong input");
				}
				
				while(true)
				{
					System.out.println("How many additional topping would you like to add:");
					data.setNo_topping(Integer.parseInt(sc.nextLine()));
				
					if(data.getNo_topping()<=4)
					{
						data.setTotal_cost(data.getTotal_cost()+data.getNo_topping());
						break;
					}
					else
						System.out.println("Number of additional topping should be less than or equals to 4.");
				}
				
				for(int j=0;j<7;j++)
					System.out.println(topping[j]+"");
				
				for(int i=0;i<data.getNo_topping();i++)
				{
					boolean a=true;
					System.out.println("Enter the additinal topping:");
					while(a)
					{
						add_topping = sc.nextLine();
						for(int j=0;j<7;j++)
						{
							if(add_topping.equalsIgnoreCase(topping[j]))
							{
								temp = temp+"\n"+add_topping+" topping";
								a= false;
								break;
							}
						}
						if(a)
							System.out.println("You have entred wrong input.Please input again.");
					}
				}
				
				data.setD_pizza(temp);
				
				System.out.println("Enter 'd' for delivery purpose and 'c' if you want to collect pizza from the shop");
				_temp = sc.nextLine().charAt(0);
				
				if(_temp=='d')
				{
					System.out.println("Enter the address of the client.");
					data.setAddress(sc.nextLine());
					if(data.getTotal_cost()<30)
						data.setTotal_cost(data.getTotal_cost()+8);
					
					delivered.add(data);
				}
				else
				{
					data.setAddress("\0");
					collected.add(data);
				}
				
				System.out.println("Enter 'y' to add new pizza entry. ");
				_temp = sc.nextLine().charAt(0);
				if(_temp!='y')
					break;		
			}
			
			System.out.println("Pizza detail which is collected from shop.\n");
			for(int i=0;i<collected.size();i++)
			{
				System.out.println("Name :"+collected.get(i).getName());
				System.out.println("Phone number :"+collected.get(i).getPhone_number());
				//System.out.println("Address"+collected.get(i).getAddress());
				System.out.println("Pizza detail :\n"+collected.get(i).getD_pizza());
				System.out.println("Total cost :"+collected.get(i).getTotal_cost()+"\n");
			}
			
			System.out.println("\nPizza detail which is delivered from shop to given address\n");
			for(int i=0;i<delivered.size();i++)
			{
				System.out.println("Name :"+delivered.get(i).getName());
				System.out.println("Phone number :"+delivered.get(i).getPhone_number());
				System.out.println("Address :"+delivered.get(i).getAddress());
				System.out.println("Pizza detail :\n"+delivered.get(i).getD_pizza());
				System.out.println("Total cost :"+delivered.get(i).getTotal_cost()+"\n");
			}
			
			sc.close();
		}
}
