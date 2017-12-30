#include <conio.h>
#include <stdio.h>

int main()
{
	int exep;
	printf("Enter ur experience in years ");
	scanf("%d",&exep);//speces are not allowed.
	
	if((exep>=0)&&(exep<=3))
	{
		printf("BLUE");
	}
	else if((exep>3)&&(exep<=5))
	{
		printf("GREY");
	}
	else if((exep>5)&&(exep<10))
	{
		printf("YELLO");
	}
	else
	{
		printf("RED");
	}

	getch();
	return 0;
}
