#include<stdio.h>
#include<conio.h>
void main()
{
int cand,t1,t2,t3,avg,round1,round2;
int intr=0,rej=0,off=0,reject=0;
printf("Enter the number of candidates:\n");
scanf("%d",&cand);
while(cand!=0)
{
printf("Enter the marks for test1, test2 and test3:\n");
scanf("%d %d %d",&t1,&t2,&t3);
avg=(t1+t2+t3)/3;

if((t1>75)&&(t2>75)&&(t3>75)&&(avg>80))
{
	printf("Congrats! You are receiving the interview call letter\n");
	intr++;	
	printf("Enter the marks for interview round1 and round2:\n");
	scanf("%d %d",&round1,&round2);
		if(round1>5&&round2>7)
			{
			printf("Congrats! You are selected\n");
			off++;
			}
		else
			{
			printf("Sorry! You are not selected\n");
			reject++;
			}
	
}
else
{
	printf("Sorry! You have not cleared the test\n");
	rej++;
}
cand--;
}
	printf("The no. of candidates who received the interview call letters are %d\n",intr);
	printf("The no. of candidates who are sent the reject letters are %d\n",rej);
	printf("The no. of candidates who received the offer letters are %d\n",off);
	printf("The no. of candidates who could not clear the interview are %d\n",reject);
getch();
}