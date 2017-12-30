#include <stdio.h>
 
int main()
{
  int numarray[50], numOfEle, c, d, swap,iteration,currElement; 
  printf("Enter number of elements\n");
  scanf("%d", &numOfEle);
  printf("Enter %d integers\n", numOfEle);
 
  for (c = 0; c < numOfEle; c++)
    scanf("%d", &numarray[c]); 

  iteration=numOfEle;

  //for (c = 0 ; c < ( numOfEle - 1 ); c++)  
  while(iteration>1)
  {
    for (currElement = 0; currElement< iteration-1; currElement++)
    {
      if (numarray[currElement] > numarray[currElement+1]) /* For decreasing order use < */
      {
        swap       = numarray[currElement];
        numarray[currElement]   = numarray[currElement+1];
        numarray[currElement+1] = swap;
      }
    }
	iteration=iteration-1;
  }
 
  printf("Sorted list in ascending order:\n");
 
  for ( c = 0 ; c < numOfEle ; c++ )
     printf( " %d  ", numarray[c]);

  getch(); 
  return 0;

}