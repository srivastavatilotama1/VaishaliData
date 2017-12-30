#include <stdio.h>
#include <conio.h>
// r+  opens existing file for  reading and writing.
//w+  open  existing file  for reading  and writing but overright.
//a++  


int main()
{
	char  ch;
	char myBuffer[100];
	FILE *fp;//this is in stdio,h

	if((fp=fopen("abc.txt","w"))==NULL)
		printf("Not present");

	fscanf(stdin,"%[^\n]",myBuffer);//reda from keyboard
	fprintf(fp,"%s",myBuffer);//write in file


	printf("Reading from file");
	
	if((fp=fopen("abc.txt","r"))==NULL)
		printf("No t reading ");

	fscanf(fp,"%[^\n]",myBuffer);//reda from file
	fprintf(stdout,"%s",myBuffer);//write on console
	
	getch();
	return 0;
}