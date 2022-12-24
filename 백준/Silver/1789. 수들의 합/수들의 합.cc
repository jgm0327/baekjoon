#include <iostream>

using namespace std;

int main() {
	ios_base::sync_with_stdio(false); cin.tie(NULL);
	long long S, cnt = 0, num = 0;
	cin >> S;
	for (int i = 1; i <= S; i++) {
		if (num + i <= S) {
			num += i; cnt++;
		}
		else break;
	}
	cout << cnt;
}