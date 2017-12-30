/* Example - To copy a structure to another structure */
# include <stdio.h>
# include <string.h>
struct date 
{
	char month[6];
	int day,year;
};


void main(void)
{
	struct date tomorrow={"March",1,2011},yesterday, today;
	 /* copying element by element basis */
	strcpy(today.month,tomorrow.month);
	today.day=tomorrow.day;
	today.year=tomorrow.year;
	 /* copying entire structure to another structure */
	yesterday=today;
	printf("\nYesterday\'s date is %d-%s-%d \n", 	yesterday.day,   yesterday.month,yesterday.year);


	getch();
	return 0;
}