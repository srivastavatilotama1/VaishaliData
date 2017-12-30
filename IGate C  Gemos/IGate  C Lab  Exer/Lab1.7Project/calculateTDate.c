#include <stdlib.h>
#include <stdio.h> 
#include <time.h> 
#include <conio.h>
int validateDate(int ,int ,int );
int checkLeapYear(int);
void calculateTomorrowsDate(int ,int,int);
/*int main(void)
{    
	time_t now = time(NULL);  
	struct tm *t = localtime(&now);
	printf( "%d  ", t->tm_mon+1 );
	printf( "%d  ", t->tm_mday ); 
	printf( "%d ", t->tm_year+1900 ); 
	printf( "%d ", t->tm_hour );
	printf( "%d ", t->tm_min );  
	printf( "%d ", t->tm_sec );  
	printf("***********************************************");
	getch();
	return 0; 
} */

int checkLeapYear(int year)
{
	int leapyear;
	leapyear=0;
	if ( year%400 == 0)
		leapyear=1;
	else if ( year%100 == 0)
		 leapyear=0;
	else if ( year%4 == 0 )
		leapyear=1;
	else
		leapyear=0;
	return leapyear;

}
int validateDate(int dd,int mm,int yy)
{
	int valid;
	if((dd>0)&&(dd<=31))
	{
		if((mm>0)&&(mm<=12))
		{
			valid=1;
		}
		else
		{
			printf("\n Mon is not valid Enter between 1-12 ");
			valid=0;
		}
	}
	else
	{
		printf("\n Day is not valid Enter between 1-31 ");
		valid=0;
	}	
return valid;
}

void calculateTomorrowsDate(int dd ,int mon,int year)
	{
		int nDay,nMon,nyear;
		switch(mon)
		{
			case 1:if(dd<31)
				   {
					   nDay=dd+1;
					   nMon=mon;
					   nyear=year;
				   }
				   else
				   {
					   nDay=1;
					   nMon=mon+1;
					   nyear=year;
				   }
				   break;
			 case 2:
				 if(checkLeapYear(dd,mon,year))
				 {
						if(dd<29)
						{
							 nDay=dd+1;
							 nMon=mon;
								nyear=year;

						}
						else
						{
							nDay=1;
							 nMon=mon+1;
							 nyear=year;
						}	
				 }
				 else
				 {
					 if(dd<28)
						{
							 nDay=dd+1;
							 nMon=mon;
							nyear=year;
						}
						else
						{
							nDay=1;
							 nMon=mon+1;
							 nyear=year;
						}	
				 }
				   break;
			 case 3:
						if(dd<31)
						{
							 nDay=dd+1;
							 nMon=mon;
							nyear=year;
						}
						 else
						{
							 nDay=1;
							 nMon=mon+1;
							 nyear=year;
						}
				   break;
			case 4:
					if(dd<30)
						{
							 nDay=dd+1;
							 nMon=mon;
							nyear=year;
						}
						 else
						{
							 nDay=1;
							 nMon=mon+1;
							 nyear=year;
						}
				   break;

			case 5:
					if(dd<31)
						{
							 nDay=dd+1;
							 nMon=mon;
							nyear=year;
						}
						 else
						{
							 nDay=1;
							 nMon=mon+1;
							 nyear=year;
						}
				   break;

			case 6:
					if(dd<30)
						{
							 nDay=dd+1;
							 nMon=mon;
							nyear=year;
						}
						 else
						{
							 nDay=1;
							 nMon=mon+1;
							 nyear=year;
						}
				   break;
			case 7:
				if(dd<31)
						{
							 nDay=dd+1;
							 nMon=mon;
							nyear=year;
						}
						 else
						{
							 nDay=1;
							 nMon=mon+1;
							 nyear=year;
						}
				   break;
			case 8:
						if(dd<31)
						{
							 nDay=dd+1;
							 nMon=mon;
							nyear=year;
						}
						 else
						{
							 nDay=1;
							 nMon=mon+1;
							 nyear=year;
						}
				   break;
			case 9:

					if(dd<30)
						{
							 nDay=dd+1;
							 nMon=mon;
							nyear=year;
						}
						 else
						{
							 nDay=1;
							 nMon=mon+1;
							 nyear=year;
						}
				   break;

			case 10:
				if(dd<31)
						{
							 nDay=dd+1;
							 nMon=mon;
							nyear=year;
						}
						 else
						{
							 nDay=1;
							 nMon=mon+1;
							 nyear=year;
						}
				   break;

			case 11:
					if(dd<30)
						{
							 nDay=dd+1;
							 nMon=mon;
							nyear=year;
						}
						 else
						{
							 nDay=1;
							 nMon=mon+1;
							 nyear=year;
						}
				   break;					
			case 12:
					if(dd<31)
						{
							 nDay=dd+1;
							 nMon=mon;
							nyear=year;
						}
						 else
						{
							 nDay=1;
							 nMon=1;
							 nyear=year+1;
						}
			default:printf("not a valid date");
		}

		printf("\nTomorrow 's Date : %d-%d-%d",nDay,nMon,nyear);
}
int main()
{
	int day,mon,year;
	printf("Enter Date\n dd:");
	scanf("%d",&day);
	printf(" mm : ");
	scanf("%d",&mon);
	printf(" yy : ");
	scanf("%d",&year);	
	if((validateDate(day,mon,year))==1)
	{
		printf(" Today 's Date  is %d-%d-%d",day,mon,year);
		calculateTomorrowsDate(day,mon,year);
	}

	getch();
	return 0;

}
