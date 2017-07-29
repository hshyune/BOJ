#include <stdio.h>
#define SIZE 9

int main(){
	int a,b;
	char buf[SIZE]={0, };
	fgets(buf, SIZE, stdin);
	
	a=(buf[0]-'0')+(buf[1]-'0')*10+(buf[2]-'0')*10*10;
	b=(buf[4]-'0')+(buf[5]-'0')*10+(buf[6]-'0')*10*10;
	
	if(a>b) printf("%d\n", a);
	if(a<=b) printf("%d\n", b);
}
