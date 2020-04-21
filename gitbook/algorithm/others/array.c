#include<stdio.h>
/**
 * endless loop 
 * 
**/
int main(int argc, char const *argv[])
{
    int i = 0;
    int *arrI=&i;
    printf("arrI \n",arrI);
    int arr[3] = {0};
    for(; i<=3; i++){
        arr[i] = 0;
        printf("hello world\n");
        int *arrP=&arr[i];
        printf("arrP ??????????????OX%p\n",arrP);

    }

}
