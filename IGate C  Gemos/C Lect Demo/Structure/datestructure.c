/* Program to print the date using structure variable */
# include<stdio.h>
struct date
{
 	char month[15];
 	int day,year;
};
void main(void)
{
 	struct date today;
 	today.day=11;
 	printf("Enter Month : ");
 	//scanf("%[^\n]",today.month);//it takes white spaces
	scanf("%s",today.month);
 	today.year=2005;
 	printf("\nToday\'s date is %d-%s-%d \n", 	today.day,   today.month,today.year);
	getch();
	return 0;
}
