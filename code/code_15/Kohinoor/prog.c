#include<stdio.h>
#include<string.h>
//#include<alloc.h>

void printing_block();

struct data
{
	char name[50];
	char address[50];
	char phone_number[15];	
	char d_pizza[8][15];
	int topping;
	int total_cost;
	struct data *next_data;
}*info;

int main()
{
	char pizza_detail[7][15];
	char temp,temp1;
	char _temp[15];	
	info = NULL;
	//char *str;	
	struct data *pizza;
	pizza=(struct data *)malloc(sizeof(struct data));
	//printf("size of struct is %d\n",sizeof(struct data));
	
	info = pizza;
	int i=0,k=0;
	//int topping;

	strcpy(pizza_detail[0],"Bacon");
	strcpy(pizza_detail[1],"Olives");
	strcpy(pizza_detail[2],"Ham");
	strcpy(pizza_detail[3],"Mushrooms");
	strcpy(pizza_detail[4],"Pineapple");
	strcpy(pizza_detail[5],"Salami");
	strcpy(pizza_detail[6],"Anchovies");

	printf("Welcome to pizza shop.\n");
	while(1)
	{
		//if(k!=0)
			//pizza=(struct data *)malloc(sizeof(struct data));
		
		pizza->next_data = NULL;
		k++;
		//str = pizza->name;
		//printf("The pointer is %u\n",str);
		printf("Enter the name of the person: \n");
		scanf("%[^\n]",pizza->name);
		//gets(pizza->name);
		//scanf("%[^\n]",((char *)&pizza+(int)(&(pizza->name))));			
									//Scannig the whole line till you click the 'enter' key 
		scanf("%c",&temp);				
		//strcpy(&pizza->name,str);		

		printf("Enter the phone number of the buyer:\n");
		scanf("%[^\n]",pizza->phone_number);
		//gets(pizza->phone_number);		
		//scanf("%[^\n]",((char *)&pizza+(int)(&(pizza->phone_number))));
		scanf("%c",&temp);

		i=0;
		//scanf("%c",&temp);
		while(i==0)
		{
			printf("Enter 'c' to collect the pizza or Enter 'd' to get delivered:\n");
			scanf("%c",&temp);
			scanf("%c",&temp1);			
	
			if(temp=='c')
			{
				pizza->address[0]='0';
				i=1;
				//break;
			}			
			else if(temp=='d')
			{
				printf("Enter the address for delivery:\n");
				//gets(pizza->address);
				scanf("%[^\n]",pizza->address);
				scanf("%c",&temp);
				i=1;
				//break;
			}
			else			
				printf("You have entered wrong input. Please Enter the input again.\n");
		}

		//scanf("%c",&temp);
		
		printf("What type of pizza would you like to purchase: \n");
		while(1)
		{
			printf("Enter 'l' for 'Large pizza'\n      'm' for 'medium pizza'\n      's' for 'small pizza'\n");
			scanf("%c",&temp);
			if(temp=='l')
			{
				strcpy(pizza->d_pizza[0],"Large pizza");
				strcpy(pizza->d_pizza[1],"tomato base");
				strcpy(pizza->d_pizza[2],"cheese topping");
				pizza->total_cost = 12;
				break;
			}
			else if(temp=='m')
			{
				strcpy(pizza->d_pizza[0],"medium pizza");
				strcpy(pizza->d_pizza[1],"tomato base");
				strcpy(pizza->d_pizza[2],"cheese topping");
				pizza->total_cost = 8;
				break;
			}
			else if(temp=='s')
			{
				strcpy(pizza->d_pizza[0],"small pizza");
				strcpy(pizza->d_pizza[1],"tomato base");
				strcpy(pizza->d_pizza[2],"cheese topping");
				pizza->total_cost = 5;
				break;
			}
			else
			{
				printf("Entred wrong input.Please input again.");
			}
		}	

		printf("How many additional topping would you like to add in your pizza ?\n");
		scanf("%d",&pizza->topping);

		pizza->total_cost += pizza->topping;		
	
		printf("The additional topping:\n");
		for(i=0;i<7;i++)
		{
			printf("%s\n",&pizza_detail[i]);
		}		

		printf("Enter the additional topping:\n");
		for(i=0;i<pizza->topping;i++)
		{
			int count=0;

			while(1)
			{
				printf("Topping no %d:",i);
				scanf("%s",_temp);
				int j;
				for(j=0;j<7;j++)
				{
					if(!strcmp(_temp,pizza_detail[j]))
						count++;
				}

				if(count==0)
				{
					printf("Some mistake in input. Please input again:\n");
					for(j=0;j<7;j++)
					{
						printf("%s\n",pizza_detail[j]);
					}
				}
				else
				{
					count=0;
					break;
				}
			}
			
			strcpy(pizza->d_pizza[i+3], _temp);
		}

		scanf("%c",&temp);

		if(pizza->total_cost<30 && strcmp(pizza->address,"0"))		//Additinal delivary cost for perticular condition
			pizza->total_cost+=8;
	
		printf("Do you want to enter another pizza order's detail(y/n)\n");
		scanf("%c",&temp);

		if(temp!='y')
			break;
		else
		{
			pizza->next_data = (struct data *)malloc(sizeof(struct data));
			pizza = pizza->next_data;
		}
		scanf("%c",&temp);
	}

	printing_block();	

	return 0;
}

void printing_block()
{
	struct data *pizza;
	int i=0;
	pizza = info;
	while(pizza!=NULL)
	{
		printf("Name          :%s\n",pizza->name);
		printf("Phone Number  :%s\n",pizza->phone_number);
		if(!strcmp(pizza->address,"0"))
			printf("Pizza order is of collected type\n");
		else
			printf("Pizza order is of delivery type at address : %s\n",pizza->address);
		printf("Ordered pizza detail :\n");	
		for(i=0;i<3+pizza->topping;i++)
		{	
			if(i<3)	
				printf("%s\n",pizza->d_pizza[i]);
			else
				printf("%s topping\n",pizza->d_pizza[i]);
		}		
		printf("Total cost    :%d\n\n",pizza->total_cost);
		pizza = pizza->next_data;
	}
	printf("Thanks for visiting pizza shop..\n");
}
