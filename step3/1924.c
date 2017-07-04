#include <stdio.h>

int main(){
	int m, d;
	scanf("%d %d", &m, &d);
	
	int i, after = 0;
	int month[12] = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	
	for(i=0; i<m-1; i++)
		after = after + month[i];
	
	after += d-1;
	switch(after%7){
	case 0:
		printf("MON\n");
		break;
	case 1:
		printf("TUE\n");
		break;
	case 2:
		printf("WED\n");
		break;
	case 3:
		printf("THU\n");
		break;
	case 4:
		printf("FRI\n");
		break;
	case 5:
		printf("SAT\n");
		break;
	case 6:
		printf("SUN\n");
		break;
	}
	
}
