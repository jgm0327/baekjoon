#include <iostream>

using namespace std;

int tri[501][501], dp[501][501], n;

void input() {
	cin >> n;
	for (int i = 1; i <= n; i++) {
		for (int j = 1; j <= i; j++)cin >> tri[i][j];
	}
}

void solution() {
	int result = -1;
	dp[1][1] = tri[1][1];
	for (int i = 2; i <= n; i++) {
		for (int j = 1; j <= i; j++)dp[i][j] = max(dp[i - 1][j - 1], dp[i - 1][j]) + tri[i][j];
	}
	for (int i = 1; i <= n; i++) result = dp[n][i] > result ? dp[n][i] : result;
	cout << result;
}

int main() {
	ios_base::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);
	input();
	solution();
}