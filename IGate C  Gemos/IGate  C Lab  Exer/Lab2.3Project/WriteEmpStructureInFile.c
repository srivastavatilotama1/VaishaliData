#include<conio.h>
#include<stdio.h>

void serchBloodGroup();
void addEmp();

struct Date
{
	int day;
	int mon;
	int year;
} ;
struct Emp
{
	int empCode;
	char empName[30];
	struct Date dob;
	char bloodGroup[5];
	char location[20];
	long int netSalary;
};

void addEmp()
{
	int i;
	int count;
	FILE * fpw;
	struct Emp empArr[50];
	fpw=fopen("Emp.txt","a");
	printf(" How Many Emp :");
	scanf("%d",&count);
	for(i=0;i<count;i++)
	{
	
		printf(" \nEnter ur EmpCode:");
		scanf("%d",&empArr[i].empCode);
		fflush(stdin);

		printf(" Enter EmpName:");
		scanf("%s",empArr[i].empName);

		printf(" Enter Date Of Birth: dd-mm-yy");
		printf("\nday:");
		scanf("%d",&empArr[i].dob.day);			
		printf(" mon:");
		scanf("%d",&empArr[i].dob.mon);
		printf(" year:");
		scanf("%d",&empArr[i].dob.year);
		fflush(stdin);//for character data

		printf(" Enter Blood Group:");
		scanf("%s",empArr[i].bloodGroup);
		fflush(stdin);//for character data

		printf(" Enter Location:");
		scanf("%s",empArr[i].location);

		printf(" Enter  Net Salary:");
		scanf("%ld",&empArr[i].netSalary);
	
		printf("\nU Entered : %d %s %d-%d-%d %s %s %ld",empArr[i].empCode,empArr[i].empName,
			empArr[i].dob.day,empArr[i].dob.mon,empArr[i].dob.year,
			empArr[i].bloodGroup,empArr[i].location,empArr[i].netSalary);
	
		fprintf(fpw,"%d %s %d%c%d%c%d %s %s %ld \n",empArr[i].empCode,empArr[i].empName,
			empArr[i].dob.day,'-',empArr[i].dob.mon,'-',empArr[i].dob.year,
			empArr[i].bloodGroup,empArr[i].location,empArr[i].netSalary);	
	}
	fclose(fpw);
	printf("\nData is written  in File");	


}

void searchBloodGroup()
{
	struct Emp  tempEmpStr;
	char hf1,hf2;
	int ret;

	FILE  *fpr;	
	int bloodGroupCount;
	char bloodGroup[5];
	//char *bloodGroup;
	fpr=fopen("Emp.txt","r");
	bloodGroupCount=0;

	printf("Enter Blood Group To  be Search: ");
	scanf("%s",bloodGroup);
	
	printf(" U Entered : %s",bloodGroup);

	printf("\n******************File Read Operation*******************");
	while((fscanf(fpr,"%d %s %d%c%d%c%d %s %s %ld",&tempEmpStr.empCode,tempEmpStr.empName,
			&tempEmpStr.dob.day,&hf1,&tempEmpStr.dob.mon,&hf2,&tempEmpStr.dob.year,
			tempEmpStr.bloodGroup,tempEmpStr.location,&tempEmpStr.netSalary))!=EOF)
	{	
		
		printf("\n%d %s %d-%d-%d %s %s %ld",tempEmpStr.empCode,tempEmpStr.empName,
			tempEmpStr.dob.day,tempEmpStr.dob.mon,tempEmpStr.dob.year,
			tempEmpStr.bloodGroup,tempEmpStr.location,tempEmpStr.netSalary)	;
			
		ret=strcmp(bloodGroup,tempEmpStr.bloodGroup);
		if(ret==0)
		{
			bloodGroupCount++;
		}
	//	if(
	}
	printf(" Total %s blood groups are %d ",bloodGroup,bloodGroupCount);

}
int main()
{
	int option;	
	printf(" 1: Add Employee \n 2:serach Blood Group \n 3: EXIT \t\nEnter UR Option :");
	while(1)
	{
		scanf("%d",&option);
		switch(option)
		{
			case 1:
				addEmp();break;
			case 2:
				searchBloodGroup();break;
			default: exit(0);
		}
	}		
	getch();
	return 0;

}