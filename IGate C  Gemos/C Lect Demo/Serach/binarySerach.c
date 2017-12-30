#include <stdio.h>
#include <conio.h>
 
int main()
{
   int c, first, last, middle, number, search, numArray[100];
 
   printf("\nEnter number of elements\n");
   scanf("%d",&number);
 
   printf("\nEnter %d Numbers\n",number);
 
   for ( c = 0 ; c < number ; c++ )
      scanf("%d",&numArray[c]);

   printf("\n ****************************UR Array Is **********************\n");
   for ( c = 0 ; c < number ; c++ )
     printf(" %d ",numArray[c]);
 
   printf("\nEnter value to find\n");
   scanf("%d",&search);

   printf(" U Have To search %d ",search);

    first = 0; 
	printf("  First : %d ",first);
   last = number- 1;

   printf("   Last : %d ",last);

   middle = (first+last)/2;
   printf("  Middle : %d ",middle);//middle=4

  //search 4
	while(first<=last)// 7 8 9 10 45 67 89 90 100// search 4  67  first=0  last=8 middle=4  midele=
	{
		if ( numArray[middle] < search )//67
		{
			 first = middle + 1;//5
		}
	    else if ( numArray[middle] == search ) 
		{
			  printf("\n %d Found at location %d.\n", search, middle+1);
			  break;
		}
		else
		{
			last = middle - 1;//last=3  for 4 
		}
		 middle = (first + last)/2; //for 4 middle =0+3/2=1 means 8 is middle// for 67 middle=7 //89 is middle
	}
	if ( first > last )
      printf(" \n Not found! %d is not present in the list.\n", search);
   getch();
   return 0;
}