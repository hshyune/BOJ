#include <stdio.h>

int main(){
	int a,b,c;
	scanf("%d", &a);
	scanf("%d", &b);
	scanf("%d", &c);
	int result = a*b*c;
	
	int i, buf[10] ={0, };
	int tmp;
	for(i=0; result>0; i++){
		tmp = result%10;
		buf[tmp]++;
		result /=10;
	}
	for(i=0; i<10; i++){
		printf("%d\n", buf[i]);
	}
}
