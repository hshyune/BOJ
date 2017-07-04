#include <stdio.h>

int func_d(int n){
	int result = n;
	if(n >= 10000){
		result += (n/10000);
		n %= 10000;
	}
	if(n >= 1000){
		result += (n/1000);
		n %= 1000;
	}
	if(n >= 100){
		result += (n/100);
		n %= 100;
	}
	if(n >= 10){
		result += (n/10);
		n %= 10;
	}

	return result + n;
}
int main(){
	int arr[20000];
	int i=1, tmp = func_d(33);

	for(i=0; i<10000; i++){
		arr[func_d(i)] = 1;
	}
	for(i=0; i<10000; i++){
		if(!arr[i])
		printf("%d\n", i);
	}
}
