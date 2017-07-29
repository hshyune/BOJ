#include <stdio.h>
#define SIZE 17

int main(){
	char buf[SIZE]={0, };
	int i, len, sec=0;
	int alpha[26]={2,2,2
			,3,3,3
			,4,4,4
			,5,5,5
			,6,6,6
			,7,7,7,7
			,8,8,8
			,9,9,9,9};
	//time = 1:2s 2:3s ..... 9:10s -> dial+1 = sec
	
	fgets(buf, SIZE, stdin);
	for(i=0; i<SIZE; i++) if(buf[i]=='\0') break;
	len = i;
	
	for(i=0; i<len-1; i++){
		sec += alpha[buf[i]-'A']+1;
	}
	printf("%d\n", sec);
}	
