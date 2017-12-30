#include<conio.h>
#include<stdio.h>
#define  TRUE 1;
#define PI 3.14;
//preprocessor before compilation it execute.

int show();
int main()
{
	int empid;
	char empname[10];
	char gender;
	float da;
	double salary;

	printf(" Enter ur EmpId:");
	scanf("%d",&empid);

	printf(" Enter EmpName:");
	scanf("%s",&empname);
	fflush(stdin);//for character data
	printf(" Enter gender:");
	scanf("%c",&gender);
	
	printf(" Enter DA:");
	scanf("%f",&da);	
	getch();
	return 0;

}