#include<stdio.h>
#include<conio.h>
void main()
{
	int i,sum=0;
	float avg,bonus;
	struct salesperson
	{
		char name[20];
		int sales;
	};
	struct salesperson mem[3];
	printf("Enter the details:\n");
	for(i=0;i<3;i++)
	{
		printf("Enter the name:\n");
		scanf("%s",mem[i].name);
		printf("Enter the sales of the person:\n");
		scanf("%d",&mem[i].sales);
	}
	for(i=0;i<3;i++)
		sum=sum+mem[i].sales;
	avg=sum/3;
	printf("Average is: %f\n",avg);
	for(i=0;i<3;i++)
	{
		if(mem[i].sales > ((2*avg)/3))
		{
		bonus = ((mem[i].sales-((2*avg)/3)))*(0.20);
		printf("Salesperson name: %s\nbonus: %f\n",mem[i].name,bonus);
		}
	}
getch();
}