/* Example- structures and functions */
# include<stdio.h>
#include <conio.h>
struct time
{ 
     int min,hr,sec; 

};
void main(void)
{
    struct time time_udt(struct time);

    struct time or_time,nx_time;

    printf("Enter time(hh:mm:ss):");
	
    scanf("%d:%d:%d",&or_time.hr,&or_time.min,&or_time.sec);

	 printf("\n***************Before  Return********************");
	printf("\n%d:%d:%d",or_time.hr,or_time.min,or_time.sec);

	printf("\n***************After Return********************");
	nx_time=time_udt(or_time);	
	 printf("\n%d:%d:%d",nx_time.hr,nx_time.min,nx_time.sec);
	getch();
	//return 0;
}

struct time time_udt(struct time  or_time)
{
	struct time nx_time;

	nx_time.hr=	++ or_time.hr;
	nx_time.min=++ or_time.min;
	nx_time.sec=++ or_time.sec;

	 printf("\n%d:%d:%d",nx_time.hr,nx_time.min,nx_time.sec);
	return nx_time;
}
