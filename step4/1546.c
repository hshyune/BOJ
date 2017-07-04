#include <stdio.h>
#include <stdlib.h>

int main(){
	int num, i, max = 0;
	double result;
	int* arr = NULL;

	scanf("%d", &num);
	arr = (int*)malloc(sizeof(int)*num);

	for(i=0; i<num; i++)
		scanf("%d", &arr[i]);

	for(i=0; i<num; i++){
		if(max<arr[i]) max=arr[i];
	}
	for(i=0; i<num; i++)
		result += (double)(arr[i])/max*100;
	printf("%.2f\n", result/num);
	free(arr);
}
