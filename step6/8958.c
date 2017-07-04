#include <stdio.h>
#define MAX 82
int main(){
	char buf[MAX];
	int round, i, j, add;
	int score, len, now;
	
	scanf("%d", &round);
	fgets(buf, MAX, stdin);
	for(j=0; j<round; j++){
		//parsing
		fgets(buf, MAX, stdin);
		len=0;
		for(i=0; i<MAX; i++){
			if(buf[i]=='\0') break;
		}
		len = i;
		buf[len-1] = '\0';

		//scoring
		now=0;
		score=0;
		for(i=0; i<len; i++){
			if(buf[i]=='O'){
				now++;
				score+=now;
			}
			if(buf[i]=='X')
				now=0;
		}
		printf("%d\n", score);
	}
}
