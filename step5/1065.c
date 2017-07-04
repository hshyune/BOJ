#include <stdio.h>

int is_hansu(int n){
	if(100<=n && n<1000){
		int a = n/100;
		int b = (n/10)%10;
		int c = n%10;
		if((a-b) == (b-c)) return 1;
	}if(1<=n && n<100) return 1;
	
	return 0;
}

int main(){
	int cnt = 0;
	int i;
	int max;
	scanf("%d", &max);
	for(i=1; i<=max; i++){
		if(is_hansu(i)) cnt++;
	}
	printf("%d\n", cnt);
}
