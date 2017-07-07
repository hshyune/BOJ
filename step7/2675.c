#include <stdio.h>

int main(){
	int tcase;
	int repeat, i, j, k;
	char buf[30];
	char empty;
	
	scanf("%d", &tcase);
	for(i=0; i<tcase; i++){
		if(i==0) scanf("%c", &empty);
		fgets(buf, 30, stdin);
		repeat = buf[0]-'0';

		for(j=2; j<30; j++){
			if(buf[j+1]=='\0') break;
			for(k=0; k<repeat; k++){
				printf("%c", buf[j]);
			}
		}printf("\n");
	}
}
