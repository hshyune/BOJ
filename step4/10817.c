#include <stdio.h>

int main(){
	int a,b,c;
	int result = 0;	
	scanf("%d %d %d", &a, &b, &c);
	
	if(a<=b){
		if(b<=c) result=b;
		else{
			if(a<=c) result=c;
			else result=a;
		}
	}else{
		if(a<=c) result=a;
		else{
			if(b<=c) result=c;
			else result=b;
		}
	}
	printf("%d\n", result);
}
