#pragma warning(disable:4996)
#include <stdio.h>

int main() {
	int money, cnt = 0, change[6] = { 500, 100, 50, 10, 5, 1 };
	scanf("%d", &money);
	money = 1000 - money;
	for (int i = 0; i < 6; i++) {
		if (money <= 0)break;
		cnt += money / change[i];
		money -= change[i] * (money / change[i]);
	}
	printf("%d", cnt);
	return 0;
}