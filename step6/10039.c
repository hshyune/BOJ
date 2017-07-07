#include <stdio.h>

int main(){
	int score[5] = {0, };
	int i;
	//ws-bc, sh, sg, se-bc, gs
	int size=5;
	double sum=0;
	for(i=0; i<size; i++){
		scanf("%d", &score[i]);
		if(score[i] < 40) score[i] = 40;
		sum += score[i];
	}
	
	printf("%d\n", (int)sum/size);
}
