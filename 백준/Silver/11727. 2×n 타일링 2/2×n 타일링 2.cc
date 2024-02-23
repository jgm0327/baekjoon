#include <iostream>

using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int n;
	int result[1000];
	cin >> n;
	result[0] = 1; result[1] = 3;
	for (int i = 2; i < n; i++) {
		result[i] = 2 * result[i - 2] + result[i - 1];
		result[i] %= 10007;
	}

	cout << result[n - 1];
}