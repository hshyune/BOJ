#include <stdio.h>

int main(){
	int s;
	scanf("%d", &s);
	int five=0, three=0;
	
	five = s / 5;
	s = s % 5;
	while(five >= 0){
		if(s%3 == 0){
			three = s / 3;
			s = s % 3;
			break;		
		}
		five--;
		s = s + 5;
	}
	int result = s==0 ? five + three : -1;
	printf("%d\n", result);
}
