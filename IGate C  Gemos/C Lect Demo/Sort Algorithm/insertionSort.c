#include<conio.h>
#include<stdio.h>
int main()
{
  int noOfEle, numarray[1000], c, location, temp;
 
  printf("Enter number of elements\n");
  scanf("%d", &noOfEle);
 
  printf("Enter %d integers\n", noOfEle);
 
  for (c = 0; c < noOfEle; c++) 
  {
    scanf("%d", &numarray[c]);
  }
 //50 29 37 5 9
  //consider first is always sorted
  for (c = 1 ; c <= noOfEle - 1; c++) 
  {

    location = c;
 
    while ( location > 0 && numarray[location] < numarray[location-1]) 
	{
     temp          = numarray[location];
      numarray[location]   = numarray[location-1];
      numarray[location-1] = temp;
 
      location--;
    }
  }
 
  printf("Sorted list in ascending order:\n");
 
  for (c = 0; c <= noOfEle - 1; c++) {
    printf(" %d ", numarray[c]);
  }
 
getch();
return 0;
}