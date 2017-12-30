# include <stdio.h>
 
# include <conio.h>
/* function declaration */
//double getAverage(int arr[], int size);
double getAverage(int *numArrPtr, int size);


int main ()
{
   /* an int array with 5 elements */
   int balance[5] = {1, 2, 3, 4, 5};
   double avg;

   /* pass pointer to the array as an argument */
  avg = getAverage( balance, 5 ) ;

 
   /* output the returned value */
   printf( "\nAverage value is: %f ", avg );
    getch();
	return 0;
}

/*double getAverage(int arr[], int size)
{
  int    i;
  double avg;
  double sum;
  sum=0;

  for (i = 0; i < size; ++i)
  {
    sum += arr[i];
  }

  avg = sum / size;

  return avg;
}*/

double getAverage(int *arr, int size)
{
  int    i;
  double avg;
  double sum;
  sum=0;

  for (i = 0; i < size; ++i)
  {
    sum += *arr++;
  }

  avg = sum / size;

  return avg;
}