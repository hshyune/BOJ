#include <stdio.h>
#include <stdlib.h>

int main(){
	int i, j, num, tmp;
	int subject;
	int* arr = NULL;
	double* result = NULL;
	
	scanf("%d", &num);
	result = (double*)malloc(sizeof(double)*num);
	
	for(i=0; i<num; i++){
		tmp=0;
		scanf("%d", &subject);
		arr = (int*)malloc(sizeof(int)*subject);
		for(j=0; j<subject; j++){
			scanf("%d", &arr[j]);
			tmp+=arr[j];
		}
		result[i] = (double)tmp/subject;

		tmp=0;		
		for(j=0; j<subject; j++){
			if(result[i] < (double)arr[j]) tmp++;
		}
		result[i] = (double)tmp/subject;
	}
	for(i=0; i<num; i++)
		printf("%.3f%%\n", result[i]*100);
	free(arr);
	free(result);	
}
