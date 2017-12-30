#include <stdio.h>
#include <conio.h>

struct census		/*STRUCTURE*/
{
	char name[20];
	int sex;
	int age;
	char address[50];
	int state;
	char maritalstatus[10];
	int education;
	int religion;

}c[2];

void main()

{	
	int i,n=0,p=0,q=0,r=0,x=0,y=0,z=0,l=0,m=0,type;

	for(i=0;i<2;i++)/*TAKEN ONLY 2, USER CAN TAKE ANY NUMBER SO THAT
					LOOP WILL EXECUTE TO THAT NUMBER NO. OF TIMES*/
	{
		printf("Enter Name\n");
		scanf("%s",c[i].name);
		printf("Enter Sex:\n");
		printf("1-Male\n2-Female\n");
		scanf("%d",&c[i].sex);
		printf("Enter Age\n");
		scanf("%d",&c[i].age);
		printf("Enter Address\n");
		scanf("%s",&c[i].address);
		printf("Enter state\n1-Madhya pradesh\n2-Uttar pradesh\n3-Gujrat\n");
		scanf("%d",&c[i].state);
		printf("Enter Marrital status:\n");
		scanf("%s",&c[i].maritalstatus);
		printf("Enter Education:\n1-upto 4th std\n2-upto 7th std\n3-upto SSC\n4-upto 12th std\n");
		printf("5-graduate\n6-post graduate\n7-Ph.d\n");
		scanf("%d",&c[i].education);
		printf("Enter Religion:\n1- Hindus\n2- Muslims\n3- Christians\n9- others\n");
		scanf("%d",&c[i].religion);

	}
	
	printf("Enter the type by which you want to count:\n1-Religion wise\n2-State wise\n3-Sex wise\n");
	scanf("%d",&type);
	
	switch(type)		/*USING SWITCH FOR WHICH TYPE USING WE HAVE TO FIND*/
	{
	case 1:
	
	for(i=0;i<2;i++)
		{
		if(c[i].religion==1)
		{
			n++;
		}
		else if(c[i].religion==2)
		{
			p++;
		}
		else if(c[i].religion==3)
		{
			q++;
		}
		else if(c[i].religion==9)
		{
			r++;
		}
		else
		{
			printf("invalid input");
		}
		}
		printf("Hindus-%d\n",n);
		printf("muslim-%d\n",p);
		printf("christian-%d\n",q);
		printf("others-%d\n",r);
		

	case 2:
		
		for(i=0;i<2;i++)

		{
		if(c[i].state==1)
		{
			x++;
		}
		else if(c[i].state==2)
		{
			y++;
		}
		else if(c[i].state==3)
		{
			z++;
		}
		else
		{
			printf("invalid input");
		}

		}
		printf("madhya pradesh-%d\n",x);
		printf("uttar pradesh-%d\n",y);
		printf("gujrat-%d\n",z);
		
		

	case 3:
		
		for(i=0;i<2;i++)

		{
		if(c[i].sex==1)
		{
			l++;
		}
		else if(c[i].sex==2)
		{
			m++;
		}
		else
		{
			printf("invalid input\n");
		}
		}
			printf("male-%d\n",l);
		printf("female-%d\n",m);
	}
		
	getch();
}