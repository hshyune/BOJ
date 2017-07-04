#include <stdio.h>
#include <stdlib.h>

int main(){
	char buffer[100];
	int num, i, result=0;
	
	scanf("%d", &num);
	scanf("%s", buffer);
	
	for(i=0; i<num; i++)
		result += buffer[i] - '0';
	printf("%d\n", result);
}
