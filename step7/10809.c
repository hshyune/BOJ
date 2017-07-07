#include <stdio.h>
#define SIZE 103

int main(){
	int alpha[26] = {-1,-1,-1,-1,-1,-1
			,-1,-1,-1,-1,-1
			,-1,-1,-1,-1,-1
			,-1,-1,-1,-1,-1
			,-1,-1,-1,-1,-1};
	char buf[SIZE]={0, };
	int len=0, i;
	fgets(buf, SIZE, stdin);

	for(i=0; i<SIZE; i++){
		if(buf[i]=='\0') break;
	}
	len = i;

	
	for(i=0; i<len; i++){
		if(alpha[buf[i]-'a'] == -1){
			alpha[buf[i]-'a'] = i;
		}
	}
	for(i=0; i<26; i++){
		printf("%d", alpha[i]);
		if(i!=25) printf(" ");
	}
	printf("\n");
}
