#include <iostream>

using namespace std;

long long n, target, ans;
bool fail = true;

void recur(long long a, long long result) {
	if (a == target) {
		fail = false;
		ans = result;
	}
	if (a * 2 <= target)recur(a * 2, result + 1);
	if (a * 10 + 1 <= target)recur(a * 10 + 1, result + 1);
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);
	cin >> n >> target;
	recur(n, 1);
	if (fail)cout << "-1";
	else cout << ans;
}