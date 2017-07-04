#include <stdio.h>
int getN(int degree){
	if(degree == 0) return 0;
	if(degree == 1) return 3;
	int result = 3;
	return result*(2<<(degree-2));
}

void printstar(int degree){
	int i, width = 5;
	for(i=0; i<degree; i++){
		width += getN(i)*2;
	}
	int height = getN(degree);	
}

void draw(int n, int** arr, int x, int y){
	if(n==3){
		
	}
}

int main(){
	int i;
	int arr[1536][3071];
	
}
