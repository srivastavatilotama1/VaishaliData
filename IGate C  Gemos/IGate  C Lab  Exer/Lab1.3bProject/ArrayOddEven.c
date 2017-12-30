#include <stdio.h>
#include <conio.h> 

int main() 
{
    int myarr[200], minimum, size, c;
	int k;
	int i=0;
	int j=0;
	int oddcount,evencount;	
	int evenarr[20];
	int oddarr[20];	
	oddcount=0;
	evencount=0;

    printf("Enter the number of elements in array\n");
	scanf("%d",&size);
	printf("Enter %d integers\n",size);

	for (c= 0;c<size;c++)
		scanf("%d",&myarr[c]);

	for (c= 0;c<size;c++)
		printf("\t%d",myarr[c]);
//9 7 1 10 5
	
	for (c=0;c<size;c++)
	{
		if((myarr[c]%2)==0)
		{
			evencount++;
		}
		else
		{
			oddcount++;
		}		
    } 
	printf("\t\nOdd Numbers %d",oddcount);
	printf("\t\nEven Numbers %d",evencount);

	
	
	for (c=0;c<size;c++)
	{
		if((myarr[c]%2)==0)
		{
			evenarr[i++]=myarr[c];			
		}
		else
		{
			oddarr[j++]=myarr[c];		
		}		
    } 
	printf("\n***************Even Numbers************");
	for (k=0;k<evencount;k++)
	{
		printf("\t%d",evenarr[k]);
    } 

	printf("\n***************Odd Numbers************");
	for (k=0;k<oddcount;k++)
	{
		printf("\t%d",oddarr[k]);
    } 
	getch();
	return 0;
}
