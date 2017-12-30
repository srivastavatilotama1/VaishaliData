#include <stdio.h>
#include <conio.h>

enum e_dept {Accounts,HR,Training};
 struct emp
{
	int empno;
	char ename[10];	
	enum e_dept dept;
}e1;

int main()
{
	printf("Enter empno:");
	scanf("%d",&e1.empno);
	printf("\n Enter Name:");	
	scanf("%s",e1.ename);
	e1.dept=Training;
	printf("%d  %s  %d",e1.empno,e1.ename,e1.dept);
	getch();	
	return 0;
}