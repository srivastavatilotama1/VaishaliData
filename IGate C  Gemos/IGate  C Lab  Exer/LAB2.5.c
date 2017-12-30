#include <stdio.h>
#include <conio.h>

struct employee		/*STRUCTURE*/
{
		int empcode;
		int empname[25];
		int day,month,year;
		int age;
		float salary;

}e[3];

void main()

{		void accept();	/*FUNCTION DECLARATION*/
		void display();	/*FUNCTION DECLARATION*/
		accept();
		display();
		getch();
}

void accept()

{	
		int current_year=2014;
		int i=0;
		for (i=0;i<3;i++)
	{
		
		printf("enter the empcode:\n");
		scanf("%d",&e[i].empcode);
		printf("enter the name:\n");
		scanf("%s",&e[i].empname);
		printf("enter the dob:\nday\n");
		scanf("%d",&e[i].day);
		printf("month\n");
		scanf("%d",&e[i].month);
		printf("year\n");
		scanf("%d",&e[i].year);
		e[i].age=current_year-e[i].year;
		printf("enter the salary\n");
		scanf("%f",&e[i].salary);
		
	}
	
}

void display()

{	
		float totalsalary=0;
		int j=0,k=0;
		printf("****************SENIOR EMPLOYEES RECORD****************\n");
		printf("date of report: 1-1-2011\n");
		printf("report description: current analysys\n");
		printf("______________________________________________________________________\n");
		for(j=0;j<3;j++)
	{
		if(e[j].age>50)
	{
		printf("Empcode %d\t\n",e[j].empcode);
		printf("Empname %s\t\n",e[j].empname);
		printf("Date of birth %d-%d-%d\t\n",e[j].day,e[j].month,e[j].year);
		printf("Age %d\n",e[j].age);
		printf("Salary %f\t\n",e[j].salary);
		printf("______________________________________________________________________\n");
		totalsalary=totalsalary+e[j].salary;/*TOTAL SALARY CALCULATION*/
		
		k++;/*USING K VARIABLE TO PRINT THE NUMBER OF SENIOR EMPLOYE*/
	}
	}
		printf("Total salary of senior employee's: %f \n",totalsalary);
		printf("______________________________________________________________________\n");
		printf("Total number of senior Employee: %d",k);

}