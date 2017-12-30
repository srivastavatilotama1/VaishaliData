/* Example- Entire structure as function arguments */
# include<stdio.h>
struct book
{
    char name[20];
    char author[10];
    int pages;
};


void display(struct book tech_book)
{
    printf("Name :%s\n Author :%s\nPages :%d\n", tech_book.name, 		tech_book.author,tech_book.pages);                                           				
}

void main(void)
{
   void display(struct book);//it can be outside
   struct book tech_book={"Programming in C","Stephen", 300};
   display(tech_book);
   getch();
   return 0;
}
