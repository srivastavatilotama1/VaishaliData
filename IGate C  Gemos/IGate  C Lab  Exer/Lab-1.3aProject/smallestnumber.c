#include <stdio.h>
#include <conio.h> 
int main() 
{
    int myarr[200], minimum, size, c, location = 1;
    printf("Enter the number of elements in array\n");
	scanf("%d",&size);
	printf("Enter %d integers\n",size);
	for (c= 0;c<size;c++)
		scanf("%d",&myarr[c]);


	minimum = myarr[0];
	for (c=1;c<size;c++)
	{
		if(myarr[c]<minimum)
		{
			minimum = myarr[c];
           location = c+1;
		}
    } 
    printf("Minimum element is present at location %d and it's value is %d.\n",location,minimum);
	getch();
	return 0;
}
