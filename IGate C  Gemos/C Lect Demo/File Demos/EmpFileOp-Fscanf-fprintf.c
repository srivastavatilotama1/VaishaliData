#include<conio.h>
#include<stdio.h>


int main()
{
	int empid;
	char empname[10];
	char gender;
	float da;
	double salary;

	int eid;
	char enm[10];
	char gen;
	float daa;
	double sal;
	int k;



	int count;
	int i;
	FILE  *fpw;
	FILE * fpr;

	fpw=fopen("EmpDetails.txt","w");
	fpr=fopen("EmpDetails.txt","r");
	printf(" How Many Emp :");
	scanf("%d",&count);
	for(i=0;i<count;i++)
	{
		printf(" \nEnter ur EmpId:");
		scanf("%d",&empid);
		fflush(stdin);
		printf(" Enter EmpName:");
		scanf("%s",&empname);
		fflush(stdin);//for character data
		printf(" Enter gender:");
		scanf("%c",&gender);	
		printf(" Enter DA:");
		scanf("%f",&da);	
		printf(" Enter Salary:");
		scanf("%lf",&salary);
	
		printf("\nU Entered : %d %s %c %f %lf",empid,empname,gender,da,salary);
		fprintf(fpw,"%d %s %c %f %lf \n",empid,empname,gender,da,salary);		
	}
	fclose(fpw);
		printf("\nData is written  in File");	

	printf("\n******************File Read Operation*******************");
	while((fscanf(fpr,"%d %s %c %f %lf",&eid,enm,&gen,&daa,&sal))!=EOF)
	{					
		printf("\n%d %s %c %f %lf",eid,enm,gen,daa,sal);
	
	}



	getch();
	return 0;

}