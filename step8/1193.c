#include <stdio.h>

int get_i(int index){
	int i, res=0;
	for(i=0; i<=index; i++){
		res+=i;
	}
	return res;
}
int main(){
	int a, phase=1, pos=0, index, max;
	int son, mother;
	scanf("%d", &a);
	
	while(1){
		if(a <= get_i(phase)) break;
		phase++;
	}
	max = get_i(phase);
	if(phase%2==0) pos=1;
	index=max-a;
	if(pos){
		son=phase-index;
		mother=1+index;
	}else{
		son=1+index;
		mother=phase-index;
	}	
	printf("%d/%d\n", son, mother);
}
