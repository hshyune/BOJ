#include <stdio.h>
#include <stdlib.h>

int main(){
	int i, num, max;
	scanf("%d %d", &num, &max);
	int* arr = NULL;

	arr = (int*)malloc(sizeof(int)*num);
	for(i=0; i<num; i++)
		scanf("%d", &arr[i]);
	
	for(i=0; i<num; i++){
		if(arr[i] < max) printf("%d ", arr[i]);
	}
	printf("\n");
	free(arr);
}
