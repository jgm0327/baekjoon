#include <iostream>
#include <queue>
using namespace std;


void solution() {
	priority_queue<long long, vector<long long>, greater<long long>> pq;
	int n, data;
	long long sum = 0, result = 0;

	cin >> n;
	for (int i = 0; i < n; i++) {
		cin >> data;
		pq.push(data);
	}

	while (pq.size() > 1) {
		sum = 0;
		for (int i = 0; i < 2; i++) {
			if (pq.empty())break;
			sum += pq.top();
			pq.pop();
		}
		result += sum;
		pq.push(sum);
	}
	printf("%lld", result);
}

int main(void) {
	ios_base::sync_with_stdio(false); cin.tie(NULL);
	solution();
	return 0;
}