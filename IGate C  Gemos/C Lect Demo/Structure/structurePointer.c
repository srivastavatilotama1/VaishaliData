#include <stdio.h>
#include <conio.h>
struct date
{
       int day;   
  
} ;
void dispDate(struct date *datePtr);

int main()
{   
   
     struct date today;
	 struct date *todayPtr;

	 todayPtr=&today;

     printf("Enter today's date: ");
     scanf("%d", &today.day);
	dispDate(todayPtr);
    
     getch();
}

void dispDate(todayPtr)
//void dispDate(struct date *datePtr)
{
	printf("Day :%d", datePtr->day);
}

