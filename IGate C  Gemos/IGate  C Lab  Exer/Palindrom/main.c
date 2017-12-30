/*
Name: Program to check the palindrome string and count the number ofd vowels and consonants
Author: Aniket V Dandawate
Empid : 830165
Date:29-10-2014
*/

#include "fun_dec.h"

void main(){
	int palindrome = 0 , vowel_count = 0, consonant_count = 0; // declaring integers
	char *input_string = (char*) malloc(MAX * sizeof(char)); // declaring strings
	char *reverse = (char*) malloc(MAX * sizeof(char)); //initalizing
	printf("\n Enter the String: ");
	gets(input_string);
	strcpy(reverse,input_string);
	strrev(reverse); // reverse the string
	palindrome = udf_palindrome_check(input_string,reverse); // function call to palindrom
	vowel_count = udf_count_vowel(input_string,&consonant_count); // function call to vowel count
	
	if(palindrome)
		printf("\n %s is a palindrome string  aniket",input_string);
	else
		printf("\n %s is not a palindrome string aniket",input_string);
	printf("\n\n Number of Vowels in the String \t \"%s\" = %d",input_string,vowel_count);
	printf("\n\n Number of Consonants in the String \t \"%s\" = %d",input_string,consonant_count);
	getch();
}
int udf_palindrome_check(char *input_string, char*reverse){
	if(strcmp(input_string,reverse) == 0){ // check the qual strings
		return 1;
	}else{
		return 0;
	}
}

int udf_count_vowel(char* input_string,int *consonant){
	int vowel_count = 0 , counter = 0;
	char ch;
	counter = strlen(input_string); //library function to get the length of the string
	while(counter >= 0 ){
		ch = input_string[counter];
		
		//we check values of only charachers excluding whitespaces and special characters.
		
		if((ch >= 65 && ch <= 90) || (ch>=97 && ch<=122)){ 
			
			//if character is vowel{a,e,i,o,u} then increment the vowel count else it is consonant.
			
			if( ch == 'a' || ch == 'e' || ch == 'i'  || ch == 'o' || ch == 'u' ){
				vowel_count++;
			}else{
				(*consonant)++;
			}
		}
		counter--;
	}
	return vowel_count; //return the vowel count
}