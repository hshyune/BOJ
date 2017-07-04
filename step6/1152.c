#include <stdio.h>

int main() {
	char buf[1000002];
	int i, flag=1, cnt=0, start, end;
	fgets(buf, 1000002, stdin);
	
	for(i=0; buf[i]!='\0'; i++){

	}
	int len = i;

	for(i=0; i<len; i++){
		if(buf[i]==' ' && flag==0){
		flag=1;
		}
		if(buf[i]!=' ' && flag==1) break;
	}
	
	start = i;

	for(i=len; i>0; i--){
		if(buf[i] != '\0' && buf[i] != '\n') break;
	}
	end = i;
	if(end==0){
		printf("0\n");
		return 0;
	}
	
	for(i=start ; i<end; i++){
		if(flag==0 && buf[i]==' '){
			cnt++;
			flag=1;
		}
		if(flag==1 && buf[i]!=' '){
			flag=0;
		}
	}
	if(buf[0]==' ' && len==2) cnt=0;
	else if(buf[0]=='\n' && len==1) cnt=0;
	else cnt++;
	//printf("start [%d]%c %d\n", start, buf[start], buf[start]);
	//printf("end   [%d]%c %d\n", end, buf[end], buf[end]);
	printf("%d\n", cnt);
}
