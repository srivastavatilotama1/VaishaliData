
#include <conio.h>
#include <stdio.h>

int main()
{
	long int userId;
	char userName[20];
	int lastMeterReading;
	int currMonMeterReading;
	float  netAmt;
	int unitConsumed;
	int const fixedCharges=100;
	float temp;
	
	printf("Enter User Id:");
	scanf("%ld",&userId);

	printf("Enter User Name:");
	scanf("%s",userName);

	printf("Enter Last Reading:");
	scanf("%d",&lastMeterReading);

	printf("Enter Current  Reading:");
	scanf("%d",&currMonMeterReading);

	unitConsumed=currMonMeterReading-lastMeterReading;

	printf( "Total Unit Consumed : %d ",unitConsumed);
	temp=(float)unitConsumed;
	printf("yemp %f",temp);
	
	netAmt=((float)unitConsumed*1.15)+fixedCharges;

	printf("\nUser Id :%ld",userId);
	printf("\nUser Name :%s",userName);
	printf("\nUNIT Consumed %d",unitConsumed);
	printf("\nNet Amount %f",unitConsumed);

	getch();
	return 0;
}