#include <stdio.h>
#include <conio.h>
// r+  opens existing file for  reading and writing.
//w+  open  existing file  for reading  and writing but overright.
//a++  
int main()
{
	char  ch;
	FILE *fpr,*fpw;//this is in stdio,h
	if((fpr=fopen("ab.txt","r"))==NULL)
	printf("File cannot be opened for read");
	fpw=fopen("xyz.txt","w");
do
{
	ch=getc(fpr);
	printf("%c",ch);
	putc(ch,fpw);
}while(ch!=EOF);
fclose(fpr);
fclose(fpw);
getch();
return 0;
}