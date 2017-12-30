# include <stdio.h>
# include "str2.h"
# define CURRENT_YEAR 2011


void increment(emprec *x)
{
	if(CURRENT_YEAR - x->birthday.year > 30)
		x->salary += 500;
}
void main(void)
{
	emprec per={"Khan",5500,27,10,62};
	printf(" *** Employee Details ***\n");
	printf("Name :%s \n",per.name);
	printf("Birthdate: %d:%d:%d \n", per.birthday.day,per.birthday.month,per.birthday.year);
      printf("Salary :%6.2f\n \n",per.salary);


   /* give increments to employees if age is greater than 30 */
	increment(&per);
	printf(" *** Employee Details ***\n");
	printf("Name :%s \n",per.name);
	printf("Birthdate: %d:%d:%d\n",per.birthday.day,per.birthday.month,per.birthday.year);
	printf("Salary :%6.2f\n",per.salary);
	getch();
}

	
