#include <stdio.h>
#include <stdlib.h>

int main(){
	char buffer[128] = {0, };
	int i, len=0;

	fgets(buffer, 128, stdin);
	while(1){
		if(buffer[len] == 0) break;
		else{
			printf("%c", buffer[len++]);
			if(len%10==0 && len/10!=0)
				printf("\n");
		}
	}
}
