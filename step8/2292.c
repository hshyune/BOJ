#include <stdio.h>

int get_i(int num){
	int i;
	int res = 2;
	if(num==0) return 0;
	if(num==1) return 1;
	if(num==2) return 2;
	for(i=1; i<num-1; i++){
		res += 6*i;
	}
	return res;
}
int main(){
	long a;
	scanf("%ld", &a);
	
	int i=1, min, max;
	if(a==1){
		printf("1\n");
		return 0;
	}
	while(1){
		min = get_i(i);
		max = get_i(i+1);
		if(min<= a && a<max){
			break;
		}
		i++;
	}
	printf("%d\n", i);
}
