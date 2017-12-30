#include <stdio.h>
#include <conio.h>
 
int main()
{
   int myarray[100], search, c, n;
 
   printf("Enter the number of elements in array\n");
   scanf("%d",&n);
 
   printf("Enter %d integer(s)\n", n);
 
   for (c = 0; c < n; c++)
      scanf("%d", &myarray[c]);
 
   printf("Enter the number to search\n");
   scanf("%d", &search);
 
   for (c = 0; c < n; c++)
   {
      if (myarray[c] == search)     /* if required element found */
      {
         printf("%d is present at location %d.\n", search, c+1);
         break;
      }
   }
   getch();
   return 0;
}
