#include <stdio.h>
#define SIZE 1000002
#define LOWER 32
#define ALPHA 26

int main(){
	int alpha[ALPHA]={0,};
	char buf[SIZE];
	int i, len;
	
	fgets(buf, SIZE, stdin);
	for(i=0; i<SIZE; i++){
		if(buf[i]=='\0') break;
	}
	len = i;

	for(i=0; i<len; i++){
		if(buf[i]>='a' && buf[i]<='z'){
			buf[i]-=LOWER;
		}
		alpha[buf[i]-'A']++;
	}
	
	int max=-1, index=0, flag=0;

	for(i=0; i<ALPHA; i++){
		if(alpha[i]>max) {
			max=alpha[i];
			index=i;
		}
	}
	for(i=0; i<ALPHA; i++){
		if(i!=index && max==alpha[i]) flag=1;
	}
	if(flag==0){
		printf("%c\n", 'A'+index);
		return 0;	
	}else{
		printf("?\n");
		return 0;	
	}
}
