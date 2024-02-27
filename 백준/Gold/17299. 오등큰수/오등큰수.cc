#include <iostream>

using namespace std;
int cnt[1000001] = { 0 }, arr[1000000];

int main() {
	ios_base::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);
	int n, data, temp_num, Max = 0;
	bool flag;
	cin >> n;

	for (int i = 0; i < n; i++) {
		cin >> arr[i];
		Max = ++cnt[arr[i]] > Max ? cnt[arr[i]] : Max;
	}
	for (int i = 0; i < n; i++) {
		flag = true;
		if (cnt[arr[i]] == Max) {
			cout << -1 << ' ';
			continue;
		}
		for (int j = i + 1; j < n; j++) {
			if (cnt[arr[i]] < cnt[arr[j]]) {
				cout << arr[j] << ' ';
				flag = false;
				break;
			}
		}
		if (flag)cout << -1 << ' ';
	}
}