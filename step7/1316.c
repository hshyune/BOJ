#include <stdio.h>
#define SIZE 102

int is_gword(char* str, int len){
	int i,l;
	l=len;
	int alpha[26]={0,};
	char pivot=str[0];
		
	for(i=0; i<l-1; i++){
		if(str[i]!=str[i+1])
			alpha[str[i]-'a']++;
	}
	for(i=0; i<26; i++) if(alpha[i]>=2) return 0;
	return 1;
}
int main(){
	char buf[SIZE]={0,};
	int i, j, repeat, cnt=0, len;

	scanf("%d", &repeat);
	for(i=0; i<repeat; i++){
		if(i==0) fgets(buf, SIZE, stdin);
		fgets(buf, SIZE, stdin);
		
		for(j=0;j<SIZE;j++) if(buf[j]=='\0') break;
		len = j;
		
		cnt+=is_gword(buf, len);

		for(j=0; j<len; j++) buf[j]='\0';
	}
	printf("%d\n", cnt);
	
}
