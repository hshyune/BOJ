#include <stdio.h>

int main(){
	int arr[8]={0,};
	int i;
	char* as = "ascending";
	char* ds = "descending";
	char* mx = "mixed";
	
	for(i=0; i<8; i++){
		scanf("%d", &arr[i]);
	}
	
	int flag = 0;
	int init;

	if(arr[0]==1){
		//is ascending? flag 1
		for(i=0; i<7; i++){
			if(arr[i+1]-arr[i]==1) continue;
			else break;
		}
		if(i==7) flag=1;		
	}
	if(arr[0]==8){
		//is descending? flag 2
		for(i=0; i<7; i++){
			if(arr[i+1]-arr[i]==-1) continue;
			else break;
		}
		if(i==7) flag=2;
	}
	//mixed flag 3
	if(i==7){
		if(flag==1){
			printf("%s\n", as);
			return;
		}
		if(flag==2){
			printf("%s\n", ds);
			return;
		}
	}
	printf("%s\n", mx);
	return;	
}
