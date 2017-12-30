#include<stdio.h>
#include<conio.h>
void bonus(int,int);
#define e_25_n_above 60
#define e_20_n_25 55
#define e_10_n_20 50
#define e_less_10 45
#define money_25_n_above 55
#define money_20_25 50
#define money_10_20 45
void main()
{
	int pchoice,tchoice,sum;
	printf("1) Endowment\n2) Money back\n3) Term Assurance\n");
	printf("Enter the policy type:\n");
	scanf("%d",&pchoice);
	if((pchoice==1)||(pchoice==2))
	{
		printf("1) 25 and above\n2) Between 20 and 25\n3) Between 10 and 20\n4) Less than 20\n");
		printf("Enter the term of your policy:\n");
		scanf("%d",&tchoice);
		printf("Enter the sum assured:\n");
		scanf("%d",&sum);
		if((pchoice==2)&&(tchoice==4))
			printf("You have entered wrong term\n");
		else  
		{	
			switch(pchoice)
			{
				case 1:
					switch(tchoice)
					{
						case 1: bonus(sum,e_25_n_above);
								break;
						case 2: bonus(sum,e_20_n_25);
								break;
						case 3: bonus(sum,e_10_n_20);
								break;
						case 4: bonus(sum,e_less_10);
								break;
						default: printf("You have entered wrongly\n");
					}
					break;
				case 2: 
					switch(tchoice)
					{
						case 1: bonus(sum,money_25_n_above);
								break;
						case 2: bonus(sum,money_20_25);
								break;
						case 3: bonus(sum,money_10_20);
								break;
						default: printf("You have entered wrongly\n");
					}
					break;
			}
		}
	}
	else
		printf("Bonus rate is not applicable for term assurance\n");
	
	
	getch();
	}

	void bonus(int a,int b)
	{
		int res;
		res = (a/1000);
		printf("The bonus amount is: %d\n",(res*b));
	}


