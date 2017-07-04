#include <stdio.h>

int main(){
	int num;
	scanf("%d", &num);
	
	if(num >= 90) printf("A\n");
	else if(num >= 80 && num <90) printf("B\n");
	else if(num >= 70 && num <80) printf("C\n");
	else if(num >= 60 && num <70) printf("D\n");
	else printf("F\n");
}
