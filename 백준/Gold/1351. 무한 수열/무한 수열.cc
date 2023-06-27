#include <iostream>
#include <map>

using namespace std;

long long n, p, q;
map<long long, long long> numbers;

void input() {
	cin >> n >> p >> q;
	numbers[0] = 1;
}

long long dp(long long x) {
	if (x == 0)return 1;
	else if (numbers[x])return numbers[x];
	return numbers[x] = dp(x / p) + dp(x / q);
	
}

void solution() {
	cout << dp(n);
}

int main() {
	ios_base::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);
	input();
	solution();
}