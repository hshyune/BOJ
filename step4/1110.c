#include <stdio.h>

int main(){
	int num;
	int cycle = 0;
	int init, front, end, tmp;
	scanf("%d", &num);
	init = num;
	
	while(1){
		front = num/10;
		end = num%10;
		tmp = (front+end)%10;
		
		front=end;
		end=tmp;
		num = front*10 + end;
		cycle++;
		if(num==init) break;
	}
	printf("%d\n", cycle);
}
