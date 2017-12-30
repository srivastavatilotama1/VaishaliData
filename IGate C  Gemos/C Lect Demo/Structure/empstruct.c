#include <conio.h>
#include <stdio.h>

struct emp
	{
		int eid;
		char enm[10];
		float esal;
		struct dob 
		{
			int day;
			int  mon;
			int year;
		}empDOB;		
	};

int main()
{
	struct emp e1;	
	struct emp e2={1234,"abcd",2345.9,{12,12,1290}};

	int no;
	printf("\n Enter no :");
	scanf("%d",&e1.eid);

	printf("\n Enter name :");
	scanf("%s",e1.enm);//do not use &
	
	printf("\n Enter salary :");
	scanf("%f",&e1.esal);

	printf("\n Enter DOB");
	scanf("%d",&e1.empDOB.day);
	scanf("%d",&e1.empDOB.mon);
	scanf("%d",&e1.empDOB.year);
	
	printf("EMPID : %d  EMPNAME : %s EMPSAL:  %f   DOB : %d- %d-%d",e1.eid,e1.enm,e1.esal,e1.empDOB.day,e1.empDOB.mon,e1.empDOB.year);
	//printf("EMPID : %d  EMPNAME : %s EMPSAL:  %f   DOB : %d- %d-%d",e1.eid,e1.enm,e1.esal,e1.empDOB.day,e1.empDOB.mon,e1.empDOB.year);
	
//printf("EMPID : %d  EMPNAME : %s EMPSAL:  %f ",e1.eid,e1.enm,e1.esal);
	getch();
	return 0;
}